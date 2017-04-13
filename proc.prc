create or replace procedure proc(server_date in varchar)
is
 sql_stmt0 varchar(1000);
 sql_stmt1 varchar(1000);
 sql_stmt2 varchar(1000);
 sql_stmt3 varchar(1000);
 sql_stmt4 varchar(1000);
 sql_stmt5 varchar(1000);
 sql_stmt6 varchar(1000);
 sql_stmt7 varchar(4000);
begin
----------------------------------------------------------------------
  sql_stmt0 :=
'
 delete from tb_middleFlow 
 where serverDate = ' 
|| '''' 
|| server_date 
|| '''';
-----------------------------------------------------------------------
  sql_stmt1 :=  
'
insert into 
tb_middleFlow
(
uv
,pv
,serverDate
)
select 
count(1) as pv
,count(distinct sessionId) as uv 
,to_char(created,''YYYY-MM-DD'') as server_date
from tb_flow 
where url not like ''%/manager%'' 
and url not like ''%/doctor%'' 
and url not like ''%/report%''
and to_char(created,''YYYY-MM-DD'') = '
|| '''' 
|| server_date 
|| '''' 
|| 'group by to_char(created,''YYYY-MM-DD'')'; 
-----------------------------------------------------------------------------------
  sql_stmt2 :=
'
 delete from tb_middleMedical 
 where serverDate = ' 
|| '''' 
|| server_date 
|| '''';
-----------------------------------------------------------------------------------
  sql_stmt3 :=
'
insert into 
tb_middleMedical
(
statusZeroMedical 
,statusOneMedical 
,statusTwoMedical
,statusThreeMedical 
,RevenueOfMedical 
,serverDate
)
select 
count(case status when 0 then 1 end) as  statusZeroMedical
,count(case status when 1 then 1 end) as  statusOneMedical
,count(case status when 2 then 1 end) as  statusTwoMedical
,count(case status when 3 then 1 end) as  statusThreeMedical
,sum(case status when 3 then price else 0 end) as RevenueOfMedical
,to_char(created,''YYYY-MM-DD'') as serverDate
from tb_medical
where
to_char(created,''YYYY-MM-DD'') = '
|| '''' 
|| server_date 
|| '''' 
|| 'group by to_char(created,''YYYY-MM-DD'')'; 


-----------------------------------------------------------------------------------
sql_stmt4 :=
'
 delete from tb_middleOrder 
 where serverDate = ' 
|| '''' 
|| server_date 
|| '''';
------------------------------------------------------------------------------------
sql_stmt5 :=
'
insert into 
tb_middleOrder
(
statusOnePackage
,statusTwoPackage
,statusZeroPackage
,RevenueOfPackage
,serverDate
)
select 
count(case status when 0 then 1 end) as  statusZeroPackage
,count(case status when 1 then 1 end) as  statusOnePackage
,count(case status when 2 then 1 when 3 then 1 end) as  statusTwoPackage
,sum(case status when 2 then price when 3 then price end) as RevenueOfPackage
,to_char(created,''YYYY-MM-DD'') as serverDate
from tb_order
where
to_char(created,''YYYY-MM-DD'') = '
|| '''' 
|| server_date 
|| '''' 
|| 'group by to_char(created,''YYYY-MM-DD'')'; 

-------------------------------------------------------------------------------------
sql_stmt6 :=
'
 delete from tb_flow_achievement_Report 
 where serverDate = ' 
|| '''' 
|| server_date 
|| '''';
-------------------------------------------------------------------------------------
sql_stmt7 :=
'
insert into tb_flow_achievement_Report
(
pv 
,uv 
,statusOneMedical 
,statusTwoMedical 
,statusThreeMedical 
,statusZeroMedical 
,statusOnePackage 
,statusTwoPackage 
,statusZeroPackage 
,RevenueOfMedical 
,RevenueOfPackage 
,serverDate 
)
select 
sum(pv)
,sum(uv)
,sum(statusOneMedical) 
,sum(statusTwoMedical)
,sum(statusThreeMedical)
,sum(statusZeroMedical)
,sum(statusOnePackage)
,sum(statusTwoPackage)
,sum(statusZeroPackage)
,sum(RevenueOfMedical)
,sum(RevenueOfPackage)
,serverDate
from
(
select
pv as pv
,uv as uv
,0 as statusOneMedical
,0 as statusTwoMedical
,0 as statusThreeMedical
,0 as statusZeroMedical
,0 as statusOnePackage
,0 as statusTwoPackage
,0 as statusZeroPackage
,0.00 as RevenueOfMedical
,0.00 as RevenueOfPackage
,serverDate as serverDate
from 
tb_middleFlow
where serverDate = '
|| '''' 
|| server_date 
|| '''' 
|| '
union all
select 
0 as pv
,0 as uv
,statusOneMedical as statusOneMedical
,statusTwoMedical as statusTwoMedical
,statusThreeMedical as statusThreeMedical
,statusZeroMedical as statusZeroMedical
,0 as statusOnePackage
,0 as statusTwoPackage
,0 as statusZeroPackage
,RevenueOfMedical as RevenueOfMedical
,0.00 as RevenueOfPackage
,serverDate as serverDate
from 
tb_middleMedical 
where serverDate = '
|| '''' 
|| server_date 
|| '''' 
|| '
union all
select 
0 as pv
,0 as uv
,0 as statusOneMedical
,0 as statusTwoMedical
,0 as statusThreeMedical
,0 as statusZeroMedical
,statusOnePackage 
,statusTwoPackage 
,statusZeroPackage 
,0.00 as RevenueOfMedical
,RevenueOfPackage 
,serverDate 
from 
tb_middleOrder
where serverDate = '
|| '''' 
|| server_date 
|| '''' 
|| '
)
group by
serverDate
';
-------------------------------------------------------------------------------------
  dbms_output.put_line(sql_stmt0);
  dbms_output.put_line(sql_stmt1);  
  dbms_output.put_line(sql_stmt2);
  dbms_output.put_line(sql_stmt3);
  dbms_output.put_line(sql_stmt4);
  dbms_output.put_line(sql_stmt5);
  dbms_output.put_line(sql_stmt6);
  dbms_output.put_line(sql_stmt7);
  execute immediate sql_stmt0;
  execute immediate sql_stmt1;
  execute immediate sql_stmt2;
  execute immediate sql_stmt3;
  execute immediate sql_stmt4;
  execute immediate sql_stmt5;
  execute immediate sql_stmt6;
  execute immediate sql_stmt7;
end proc;
/
