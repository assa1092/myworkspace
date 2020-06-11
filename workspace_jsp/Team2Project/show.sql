create table member (
id varchar2(30) primary key,
name varchar2(30) not null,
pw varchar2(30) not null,
property varchar2(30) default 'customer'

)

insert into MEMBER values ('m001', 'lee','1','customer')



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
select * from review

select * from (select rownum rnum, num, title, id, category, writeday, readcnt, starpoint from (select * from review order by num desc)) where rnum>=1 and rnum<=10

SELECT * FROM review WHERE (title like '%4%') or (content like '%9%') 
SELECT * FROM review WHERE (content like '%5%')
