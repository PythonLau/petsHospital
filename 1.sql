CREATE TABLE tb_item_cat (
  id number(20) NOT NULL, -- '类目ID'
  parent_id number(20) DEFAULT NULL, -- '父类目ID=0时，代表的是一级的类目'
  name varchar(50) DEFAULT NULL, -- '类目名称'
  status number(1) DEFAULT 1, -- '状态。可选值:1(正常),2(删除)'
  sort_order number(4) DEFAULT NULL, -- '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数'
  is_parent number(1) DEFAULT 1, -- '该类目是否为父类目，1为true，0为false'
  created date DEFAULT sysdate, -- '创建时间'
  updated date DEFAULT sysdate, -- '创建时间'
  PRIMARY KEY (id)
)

create sequence tb_item_cat_sequence
start with 14
increment by 1

drop sequence tb_item_cat_sequence

select tb_item_cat_sequence.currval from dual

select * from tb_item_cat

INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (1, 0, '日常', 1, 1, 1);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (2, 1, '钢笔', 1, 1, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (3, 1, 'A4纸', 1, 2, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (4, 1, '显微镜', 1, 3, 0);

INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (5, 0, '手术', 1, 1, 1);

INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (6, 5, '基础外科手术器械', 1, 1, 1);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (7, 6, '基础外科用刀', 1, 1, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (8, 6, '基础外科用针', 1, 2, 0);

INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (9, 5, '整形科手术器械', 1, 2, 1);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (10, 9, '整形科用刀', 1, 1, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (11, 9, '整形科用针', 1, 2, 0);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (12, 0, '其他未知分类', 1, 1, 1);
INSERT INTO tb_item_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (13, 12, '垃圾桶', 1, 1, 0);

CREATE TABLE tb_item (
  id number(20) NOT NULL, -- '物品id，同时也是物品编号'
  title varchar(100) NOT NULL,-- '物品名称'
  supplier varchar(500) NOT NULL, -- '供应商'
  price number(20) NOT NULL, -- '物品价格，单位为：分'
  num number(10) NOT NULL, -- '库存数量'
  barcode varchar(30) DEFAULT NULL, -- '物品条形码'
  image varchar(500) DEFAULT NULL, -- '物品图片'
  cid number(10) NOT NULL, -- '物品所属类目，叶子类目'
  status number(4) DEFAULT 1, -- '物品状态，1-正常，2-下架，3-删除'
  created date default sysdate, -- '创建时间'
  updated date default sysdate, -- '更新时间'
  PRIMARY KEY (id)
)


commit

select * from tb_item


------------------------------------------------------------------------------------------------------


CREATE TABLE tb_position_cat (
  id number(20) NOT NULL, -- '职位或者部门ID'
  parent_id number(20) DEFAULT NULL, -- 'parent_id=0时，代表的是一级的部门'
  name varchar(50) DEFAULT NULL, -- '职位或者部门名称'
  status number(1) DEFAULT 1, -- '状态。可选值:1(正常),2(可挂号)'
  sort_order number(4) DEFAULT NULL, -- '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数'
  is_parent number(1) DEFAULT 1, -- '该类目是否为父类目，1为true，0为false'
  created date DEFAULT sysdate, -- '创建时间'
  updated date DEFAULT sysdate, -- '创建时间'
  PRIMARY KEY (id)
)

create sequence tb_position_cat_sequence
start with 12
increment by 1

drop table tb_position_cat

drop sequence tb_position_cat_sequence

select * from tb_position_cat



INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (1, 0, '办公室', 1, 1, 1);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (2, 1, '财务部', 1, 1, 0);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (3, 1, '审计部', 1, 2, 0);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (4, 1, '监察部', 1, 3, 0);

INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (5, 0, '门诊部', 1, 1, 1);

INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (6, 5, '医疗中心', 1, 1, 1);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (7, 6, '护理处', 1, 1, 0);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (8, 6, '消毒处', 1, 2, 0);

INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (9, 5, '整形美容中心', 1, 2, 1);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (10, 9, '整形部', 1, 1, 0);
INSERT INTO tb_position_cat(id,parent_id,name,status,sort_order,is_parent) VALUES (11, 9, '美容部', 1, 2, 0);

CREATE TABLE tb_employee (
  id number(20) NOT NULL, -- '职位或者部门id，同时也是员工编号'
  name varchar(50) NOT NULL, -- '员工姓名'
  sex varchar(4) NOT NULL, --'员工性别'
  idCard varchar(20) NOT NULL, -- '员工身份证'
  salary number(10,2) NOT NULL, --'员工薪水'
  telephone varchar(18) NOT NULL, -- '员工电话'
  image varchar(500) DEFAULT NULL, -- '员工照片'
  cid number(10) NOT NULL, -- '员工所属部门'
  status number(4) DEFAULT 1, -- '员工状态，1-在职，0-离职'
  dimissionReason varchar(88) DEFAULT NULL, --'离职原因'
  created date default sysdate, -- '创建时间'
  updated date default sysdate, -- '更新时间'
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
id number(20) NOT NULL,    --用户ID
loginname varchar(50) NOT NULL,   --登录名，手机或者电子邮箱
password varchar(50) NOT NULL,    --密码
nickname varchar(50) NOT NULL,   --用户昵称
telphone varchar(50) NOT NULL,  --手机号码
status number(4) NOT NULL,  --用户状态，会员，普通，注销
created date default sysdate, -- '创建时间'
updated date default sysdate, -- '更新时间'
PRIMARY KEY (id)
)
insert into tb_user(id,loginname,password,nickname,telphone,status) values(1,'13631294979','828fd9255753432d51df95eb62d61722','chunhe','13631294979',1)
select * from tb_user


drop table tb_user
select * from tb_user

create table tb_pets(
id number(20) NOT NULL,    --宠物ID
name varchar(20) NOT NULL,   --宠物名字
typename varchar(20) NOT NULL,   --宠物类型
owner number(20) NOT NULL,   --主人id
age number(3) NOT NULL, --宠物年龄
sex varchar(4) NOT NULL, --宠物性别
status number(4) NOT NULL, --宠物状态，1正常,2寄养
image varchar(500) DEFAULT NULL, -- '宠物照片'
created date default sysdate, -- '创建时间'
updated date default sysdate, -- '更新时间'
PRIMARY KEY (id)
)

select * from tb_pets


----------------------------------------------------------------------------------------------------------------------------------

commit

create table tb_article(
id number(20) NOT NULL,  --文章id
title varchar(188) NOT NULL, --文章标题
typename varchar(10) NOT NULL, --文章类型
source varchar(50) NOT NULL, --文章来源
content clob NOT NULL， --文章内容
created varchar(20) NOT NULL, -- '创建时间'
updated varchar(20) NOT NULL, -- '更新时间'
PRIMARY KEY (id)
)

create table tb_slider(
id number(20) NOT NULL,  --轮播图片id
href varchar(500) DEFAULT NULL,  --图片点击链接
alt varchar(50) DEFAULT NULL, --图片alt
title varchar(50) DEFAULT NULL, --图片title
src varchar(100) NOT NULL, --图片地址
sort_order number(2) NOT NULL, --页面排列序号
created date default sysdate, -- '创建时间'
updated date default sysdate, -- '更新时间'
primary key(id)
)

insert into tb_slider(id,href,alt,title,src,sort_order) values(1,'https://www.baidu.com','宠物医院轮播图测试1','宠物医院轮播图测试1','/image/1.jpg',1);
insert into tb_slider(id,href,alt,title,src,sort_order) values(2,'http://www.zhbit.com','宠物医院轮播图测试2','宠物医院轮播图测试2','/image/2.jpg',2);
insert into tb_slider(id,href,alt,title,src,sort_order) values(3,'http://www.zhbit.com','宠物医院轮播图测试3','宠物医院轮播图测试3','/image/3.jpg',3);
insert into tb_slider(id,href,alt,title,src,sort_order) values(4,'https://www.baidu.com','宠物医院轮播图测试4','宠物医院轮播图测试4','/image/4.jpg',4);
insert into tb_slider(id,href,alt,title,src,sort_order) values(5,'https://www.baidu.com','宠物医院轮播图测试5','宠物医院轮播图测试5','/image/background.jpg',5);



------------暂时没用--------------------------------------------------------------------------------------------------------

select * from tb_article order by id desc

CREATE INDEX search_idx  
ON tb_article(content)  
INDEXTYPE IS ctxsys.CONTEXT； 

select * from tb_article
                
SELECT COUNT(*)  
  FROM tb_article  
 WHERE contains(content, 'index', 1) > 0  
 
select dbms_lob.substr(content) from tb_article t;


------------------------------------------------------------------------------------------------------------------------------

create table tb_package(
id number(20) NOT NULL,    --套餐id
name varchar(188) NOT NULL,   --套餐名字
price number(20) NOT NULL,   --套餐价格
normaldiscount number(3,1) DEFAULT 10.0,  --正常折扣
memberdiscount number(3,1) DEFAULT 10.0,  --会员折扣
introduction varchar(88) DEFAULT NULL,  --套餐简介
status number(4) NOT NULL, --套餐状态，1正常，0下架
image varchar(500) NOT NULL, -- '套餐照片'
created date default sysdate, -- '创建时间'
updated date default sysdate, -- '更新时间'
PRIMARY KEY (id)
)


commit

select * from tb_package


-----------------------------------------------------------------------------------------------------------------------------------

create table tb_manager(
id number(8) NOT NULL,
username varchar(20) NOT NULL,
password varchar(50) NOT NULL,
created date default sysdate, -- '创建时间'
updated date default sysdate, -- '更新时间'
PRIMARY KEY (id)
)


insert into tb_manager(id,username,password) values('1','admin','828fd9255753432d51df95eb62d61722')

select * from tb_manager

---------------------------------------------------------------------------------------------------------------

create table tb_foster(
id number(20) NOT NULL,    --寄养id
petId number(20) NOT NULL,    --宠物ID
telePhone varchar(50) NOT NULL,  --手机号码
address varchar(200) NOT NULL,  --寄养地址
status number(4) NOT NULL, --套餐状态，1寄养中，0被领养或者取消寄养
created date default sysdate, -- '创建时间'
updated date default sysdate, -- '更新时间'
PRIMARY KEY (id)
)

select * from tb_foster
select * from tb_pets
truncate table tb_foster

------------------------------------------------------------------------------------------------------------------

create table tb_order(
id number(20) NOT NULL,    --订单id
userId number(20) NOT NULL,    --用户id
package_Id number(20) NOT NULL,    --套餐id
price number(20,2) NOT NULL,
score number(4) Default NULL, --服务评分
words varchar(100) Default NULL, --留言
status number(4) NOT NULL, --订单状态，1正常，0取消,2结束,3已评价
created date default sysdate, -- '创建时间'
updated date default sysdate, -- '更新时间'
PRIMARY KEY (id)
)


select * from tb_order

truncate table tb_order


--------------------------------------------------------------------------------------------------------------------------


create table tb_adopt(
id number(20) NOT NULL,    --领养id
fosterUserId number(20) NOT NULL,    --寄养用户id
adoptUserId number(20) NOT NULL,    --领养用户id
adoptPetId number(20) NOT NULL,    --领养宠物id
telePhone varchar(50) NOT NULL,  --领养人手机号码
address varchar(200) NOT NULL,  --领养地址
status number(4) NOT NULL, --套餐状态，1申请中，0领养失败或者取消领养，2领养成功
created date default sysdate, -- '创建时间'
updated date default sysdate, -- '更新时间'
PRIMARY KEY (id)
)

commit

select * from tb_adopt

truncate table tb_adopt



-----------------------------------------------------------------------------------------------------------------------

create table tb_medical(
id number(20) NOT NULL,    --病历id
petId number(20) NOT NULL, --宠物id
officeId number(10) NOT NULL, --科室id
registerTime date NOT NULL, --预约时间
status number(4) NOT NULL, --挂号状态 1挂号中 2已经处理 0取消挂号或者不接受治疗，3正常结束
recipe varchar(500) DEFAULT NULL, --处方
price number(20,2) DEFAULT NULL,   --套餐价格
doctorId number(20) DEFAULT NULL, --主治医生
created date default sysdate, -- '挂号时间'
updated date default NULL, -- '开处方时间'
PRIMARY KEY (id)
)

select * from tb_medical

drop table tb_medical

---------------------------------------------------------------------------------------------------

create table tb_doctor(
id number(20) NOT NULL,  ---医生工号，关联员工表的id
username varchar(20) NOT NULL,    --医生登陆名
password varchar(50) NOT NULL,   ---医生密码
created date default sysdate, -- '创建时间'
updated date default sysdate, -- '更新时间'
PRIMARY KEY (id)
)

insert into tb_doctor(id,username,password) values(149088330544902,'doctor','828fd9255753432d51df95eb62d61722')



select * from tb_doctor

commit

select * from tb_employee where id = 149088330544902


-------------------------------------------------------------------------------------

--报表系统

create table tb_login
(
  id number(20) not null,   --用户ID关联员工表
  username varchar(20) not null,   --用户名，登录名
  password varchar(50) not null,  --登录密码
  status number(4) not null,  --状态1普通员工 2管理员
  created date default sysdate, -- '创建时间'
  updated date default sysdate, -- '更新时间'
  PRIMARY KEY (id)
)

insert into tb_login(id,username,password,status) values(1,'admin','828fd9255753432d51df95eb62d61722',2);
insert into tb_login(id,username,password,status) values(2,'user','828fd9255753432d51df95eb62d61722',1);


create table tb_module
(
  id number(20) not null,   --报表ID
  parent_id number(20) DEFAULT NULL, --报表父节点
  name VARCHAR(200),  --报表名称
  url VARCHAR(800), --报表url
  status number(1) DEFAULT 1, -- '状态。可选值:1(正常),2(待检验)'
  sort_order number(4) DEFAULT NULL, -- '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数'
  is_parent number(1) DEFAULT 1, -- '该类目是否为父类目，1为true，0为false'
  created date DEFAULT sysdate, -- '创建时间'
  updated date DEFAULT sysdate, -- '创建时间'
  PRIMARY KEY (id)
)


INSERT INTO tb_module(id,parent_id,name,url,status,sort_order,is_parent) VALUES (1, 0, '办公室报表','/index', 1, 1, 1);
INSERT INTO tb_module(id,parent_id,name,url,status,sort_order,is_parent) VALUES (2, 1, '财务部报表','/login',1, 1, 0);
INSERT INTO tb_module(id,parent_id,name,url,status,sort_order,is_parent) VALUES (3, 1, '审计部报表','/index', 1, 2, 0);
INSERT INTO tb_module(id,parent_id,name,url,status,sort_order,is_parent) VALUES (4, 1, '监察部报表','/login',1, 3, 0);

INSERT INTO tb_module(id,parent_id,name,url,status,sort_order,is_parent) VALUES (5, 0, '医疗中心报表','/index', 1, 1, 1);
INSERT INTO tb_module(id,parent_id,name,url,status,sort_order,is_parent) VALUES (6, 5, '护理处报表','/login', 1, 1, 0);
INSERT INTO tb_module(id,parent_id,name,url,status,sort_order,is_parent) VALUES (7, 5, '消毒处报表','/login', 1, 2, 0);

select * from tb_module

commit

create table tb_authority(
id number(20) not null,   --权限ID
userId number(20) not null,   --用户ID,关联tb_login表
module_id number(20) not null, --报表id,关联tb_module
created date DEFAULT sysdate, -- '创建时间'
updated date DEFAULT sysdate, -- '创建时间'
PRIMARY KEY (id)
)

insert into tb_authority(id,userId,module_id) values(1,2,1);
insert into tb_authority(id,userId,module_id) values(2,2,2);
insert into tb_authority(id,userId,module_id) values(3,2,3);
insert into tb_authority(id,userId,module_id) values(4,2,5);
insert into tb_authority(id,userId,module_id) values(5,2,7)

select * from tb_authority

truncate table tb_authority



