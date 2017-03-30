CREATE TABLE tb_item_cat (
  id number(20) NOT NULL, -- '��ĿID'
  parent_id number(20) DEFAULT NULL, -- '����ĿID=0ʱ���������һ������Ŀ'
  name varchar(50) DEFAULT NULL, -- '��Ŀ����'
  status number(1) DEFAULT 1, -- '״̬����ѡֵ:1(����),2(ɾ��)'
  sort_order number(4) DEFAULT NULL, -- '������ţ���ʾͬ����Ŀ��չ�ִ�������ֵ��������ƴ������С�ȡֵ��Χ:�����������'
  is_parent number(1) DEFAULT 1, -- '����Ŀ�Ƿ�Ϊ����Ŀ��1Ϊtrue��0Ϊfalse'
  created date DEFAULT sysdate, -- '����ʱ��'
  updated date DEFAULT sysdate, -- '����ʱ��'
  PRIMARY KEY (id)
)

create sequence tb_item_cat_sequence
start with 14
increment by 1

drop sequence tb_item_cat_sequence

select tb_item_cat_sequence.currval from dual

select * from tb_item_cat

INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (1, 0, '�ճ�', 1, 1, 1);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (2, 1, '�ֱ�', 1, 1, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (3, 1, 'A4ֽ', 1, 2, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (4, 1, '��΢��', 1, 3, 0);

INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (5, 0, '����', 1, 1, 1);

INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (6, 5, '�������������е', 1, 1, 1);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (7, 6, '��������õ�', 1, 1, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (8, 6, '�����������', 1, 2, 0);

INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (9, 5, '���ο�������е', 1, 2, 1);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (10, 9, '���ο��õ�', 1, 1, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (11, 9, '���ο�����', 1, 2, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (12, 0, '����δ֪����', 1, 1, 1);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (13, 12, '����Ͱ', 1, 1, 0);

CREATE TABLE tb_item (
  id number(20) NOT NULL, -- '��Ʒid��ͬʱҲ����Ʒ���'
  title varchar(100) NOT NULL,-- '��Ʒ����'
  supplier varchar(500) NOT NULL, -- '��Ӧ��'
  price number(20) NOT NULL, -- '��Ʒ�۸񣬵�λΪ����'
  num number(10) NOT NULL, -- '�������'
  barcode varchar(30) DEFAULT NULL, -- '��Ʒ������'
  image varchar(500) DEFAULT NULL, -- '��ƷͼƬ'
  cid number(10) NOT NULL, -- '��Ʒ������Ŀ��Ҷ����Ŀ'
  status number(4) DEFAULT 1, -- '��Ʒ״̬��1-������2-�¼ܣ�3-ɾ��'
  created date default sysdate, -- '����ʱ��'
  updated date default sysdate, -- '����ʱ��'
  PRIMARY KEY (id)
)


commit

select * from tb_item


------------------------------------------------------------------------------------------------------


CREATE TABLE tb_position_cat (
  id number(20) NOT NULL, -- 'ְλ���߲���ID'
  parent_id number(20) DEFAULT NULL, -- 'parent_id=0ʱ���������һ���Ĳ���'
  name varchar(50) DEFAULT NULL, -- 'ְλ���߲�������'
  status number(1) DEFAULT 1, -- '״̬����ѡֵ:1(����),2(�ɹҺ�)'
  sort_order number(4) DEFAULT NULL, -- '������ţ���ʾͬ����Ŀ��չ�ִ�������ֵ��������ƴ������С�ȡֵ��Χ:�����������'
  is_parent number(1) DEFAULT 1, -- '����Ŀ�Ƿ�Ϊ����Ŀ��1Ϊtrue��0Ϊfalse'
  created date DEFAULT sysdate, -- '����ʱ��'
  updated date DEFAULT sysdate, -- '����ʱ��'
  PRIMARY KEY (id)
)

create sequence tb_position_cat_sequence
start with 12
increment by 1

drop table tb_position_cat

drop sequence tb_position_cat_sequence

select * from tb_position_cat



INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (1, 0, '�칫��', 1, 1, 1);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (2, 1, '����', 1, 1, 0);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (3, 1, '��Ʋ�', 1, 2, 0);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (4, 1, '��첿', 1, 3, 0);

INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (5, 0, '���ﲿ', 1, 1, 1);

INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (6, 5, 'ҽ������', 1, 1, 1);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (7, 6, '����', 1, 1, 0);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (8, 6, '������', 1, 2, 0);

INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (9, 5, '������������', 1, 2, 1);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (10, 9, '���β�', 1, 1, 0);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (11, 9, '���ݲ�', 1, 2, 0);

CREATE TABLE tb_employee (
  id number(20) NOT NULL, -- 'ְλ���߲���id��ͬʱҲ��Ա�����'
  name varchar(50) NOT NULL, -- 'Ա������'
  sex varchar(4) NOT NULL, --'Ա���Ա�'
  idCard varchar(20) NOT NULL, -- 'Ա�����֤'
  salary number(10,2) NOT NULL, --'Ա��нˮ'
  telephone varchar(18) NOT NULL, -- 'Ա���绰'
  image varchar(500) DEFAULT NULL, -- 'Ա����Ƭ'
  cid number(10) NOT NULL, -- 'Ա����������'
  status number(4) DEFAULT 1, -- 'Ա��״̬��1-��ְ��0-��ְ'
  dimissionReason varchar(88) DEFAULT NULL, --'��ְԭ��'
  created date default sysdate, -- '����ʱ��'
  updated date default sysdate, -- '����ʱ��'
  PRIMARY KEY (id)
)

drop table tb_employee

commit


select * from tb_employee
select * from tb_position_cat
select * from tb_item
select * from tb_item_cat



-------------------------------------------------------------------------------------------------------------------

create table tb_user(
id number(20) NOT NULL,    --�û�ID
loginname varchar(50) NOT NULL,   --��¼�����ֻ����ߵ�������
password varchar(50) NOT NULL,    --����
nickname varchar(50) NOT NULL,   --�û��ǳ�
telphone varchar(50) NOT NULL,  --�ֻ�����
status number(4) NOT NULL,  --�û�״̬����Ա����ͨ��ע��
created date default sysdate, -- '����ʱ��'
updated date default sysdate, -- '����ʱ��'
PRIMARY KEY (id)
)
insert into tb_user(id,loginname,password,nickname,telphone,status) values(1,'13631294979','828fd9255753432d51df95eb62d61722','chunhe','13631294979',1)
select * from tb_user


drop table tb_user
select * from tb_user

create table tb_pets(
id number(20) NOT NULL,    --����ID
name varchar(20) NOT NULL,   --��������
typename varchar(20) NOT NULL,   --��������
owner number(20) NOT NULL,   --����id
age number(3) NOT NULL, --��������
sex varchar(4) NOT NULL, --�����Ա�
status number(4) NOT NULL, --����״̬��1����,2����
image varchar(500) DEFAULT NULL, -- '������Ƭ'
created date default sysdate, -- '����ʱ��'
updated date default sysdate, -- '����ʱ��'
PRIMARY KEY (id)
)

select * from tb_pets


----------------------------------------------------------------------------------------------------------------------------------

commit

create table tb_article(
id number(20) NOT NULL,  --����id
title varchar(188) NOT NULL, --���±���
typename varchar(10) NOT NULL, --��������
source varchar(50) NOT NULL, --������Դ
content clob NOT NULL�� --��������
created varchar(20) NOT NULL, -- '����ʱ��'
updated varchar(20) NOT NULL, -- '����ʱ��'
PRIMARY KEY (id)
)
------------��ʱû��--------------------------------------------------------------------------------------------------------

select * from tb_article order by id desc

CREATE INDEX search_idx  
ON tb_article(content)  
INDEXTYPE IS ctxsys.CONTEXT�� 

select * from tb_article
                
SELECT COUNT(*)  
  FROM tb_article  
 WHERE contains(content, 'index', 1) > 0  
 
select dbms_lob.substr(content) from tb_article t;


------------------------------------------------------------------------------------------------------------------------------

create table tb_package(
id number(20) NOT NULL,    --�ײ�id
name varchar(188) NOT NULL,   --�ײ�����
price number(20) NOT NULL,   --�ײͼ۸�
normaldiscount number(3,1) DEFAULT 10.0,  --�����ۿ�
memberdiscount number(3,1) DEFAULT 10.0,  --��Ա�ۿ�
introduction varchar(88) DEFAULT NULL,  --�ײͼ��
status number(4) NOT NULL, --�ײ�״̬��1������0�¼�
image varchar(500) NOT NULL, -- '�ײ���Ƭ'
created date default sysdate, -- '����ʱ��'
updated date default sysdate, -- '����ʱ��'
PRIMARY KEY (id)
)


commit

select * from tb_package


-----------------------------------------------------------------------------------------------------------------------------------

create table tb_manager(
id number(8) NOT NULL,
username varchar(20) NOT NULL,
password varchar(50) NOT NULL,
created date default sysdate, -- '����ʱ��'
updated date default sysdate, -- '����ʱ��'
PRIMARY KEY (id)
)


insert into tb_manager(id,username,password) values('1','admin','828fd9255753432d51df95eb62d61722')

select * from tb_manager

---------------------------------------------------------------------------------------------------------------

create table tb_foster(
id number(20) NOT NULL,    --����id
petId number(20) NOT NULL,    --����ID
telePhone varchar(50) NOT NULL,  --�ֻ�����
address varchar(200) NOT NULL,  --������ַ
status number(4) NOT NULL, --�ײ�״̬��1�����У�0����������ȡ������
created date default sysdate, -- '����ʱ��'
updated date default sysdate, -- '����ʱ��'
PRIMARY KEY (id)
)

select * from tb_foster
select * from tb_pets
truncate table tb_foster

------------------------------------------------------------------------------------------------------------------

create table tb_order(
id number(20) NOT NULL,    --����id
userId number(20) NOT NULL,    --�û�id
package_Id number(20) NOT NULL,    --�ײ�id
price number(20,2) NOT NULL,
score number(4) Default NULL, --��������
words varchar(100) Default NULL, --����
status number(4) NOT NULL, --����״̬��1������0ȡ��,2����,3������
created date default sysdate, -- '����ʱ��'
updated date default sysdate, -- '����ʱ��'
PRIMARY KEY (id)
)


select * from tb_order

truncate table tb_order


--------------------------------------------------------------------------------------------------------------------------


create table tb_adopt(
id number(20) NOT NULL,    --����id
fosterUserId number(20) NOT NULL,    --�����û�id
adoptUserId number(20) NOT NULL,    --�����û�id
adoptPetId number(20) NOT NULL,    --��������id
telePhone varchar(50) NOT NULL,  --�������ֻ�����
address varchar(200) NOT NULL,  --������ַ
status number(4) NOT NULL, --�ײ�״̬��1�����У�0����ʧ�ܻ���ȡ��������2�����ɹ�
created date default sysdate, -- '����ʱ��'
updated date default sysdate, -- '����ʱ��'
PRIMARY KEY (id)
)

commit

select * from tb_adopt

truncate table tb_adopt



-----------------------------------------------------------------------------------------------------------------------

create table tb_medical(
id number(20) NOT NULL,    --����id
petId number(20) NOT NULL, --����id
officeId number(10) NOT NULL, --����id
registerTime date NOT NULL, --ԤԼʱ��
status number(4) NOT NULL, --�Һ�״̬ 1�Һ��� 2�Ѿ����� 0ȡ���ҺŻ��߲��������ƣ�3��������
recipe varchar(500) DEFAULT NULL, --����
price number(20,2) DEFAULT NULL,   --�ײͼ۸�
doctorId number(20) DEFAULT NULL, --����ҽ��
created date default sysdate, -- '�Һ�ʱ��'
updated date default NULL, -- '������ʱ��'
PRIMARY KEY (id)
)

drop table tb_medical



















