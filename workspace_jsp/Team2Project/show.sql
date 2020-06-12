create table member (
id varchar2(30) primary key,
name varchar2(30) not null,
pw varchar2(30) not null,
property varchar2(30) default 'customer'

)

insert into MEMBER values ('m001', 'lee','1','customer')

drop table member

create table review(
num number(10) primary key,
title varchar2(30),
content varchar2(1000),
id varchar2(30) references member (id) ,
category varchar2(30),
writeday date default sysdate,  
readcnt number(10) default 0,
starpoint number(2) check (starpoint<=10)

)



insert into REVIEW values (1, 'title1','content1','m001','category1', sysdate,1,1)
commit
select * from member

update member set property = 'admin' where id = 'admin'
commit
SELECT * FROM review WHERE (title = '%?%') or (content like '%?%')