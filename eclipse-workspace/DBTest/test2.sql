create table test2(
id number(3) primary key,
name varchar2(21)
)

create table test3(
id number(3),
name varchar2(21),
constraint pk_test3_id primary key(id)
)

create table test4(
id number(3),
name varchar2(21)
)

alter table test4 add constraint pk_test4_id primary key(id)

select * from test4
drop table test2
drop table test3
drop table test4


create table test2(
id number(3) primary key,
name varchar2(21)
)

create table test3(
id number(3),
name varchar2(21),
constraint pk_test3_id primary key(id)
)
// 제약사항: 테이블3의 id를 pk로한다.constraint pk_test3_id
// primary key(id) id를 pk로...



create table test4(
id number(3),
name varchar2(21)
)
// 테이블을 먼저 만들고 제약사항으로 primary key 설정했다.
alter table test4 add constraint pk_test4_id primary key(id)

insert into test2(id,name) values(1,'kim')
insert into test2(name,id) values('lee',2)
insert into test2(id) values(3)
insert into test2(name) values('choi')
insert into test2 values (3,'kang')

select * from test2


// not null -> null값만 아니면 상관없다. 중복도 가능
create table depart(
did number(3),
dname varchar2(20) not null
)

alter table depart add constraint pk_depart_did primary key(did)

insert into depart (did, dname) values (1, '영문학과')
insert into depart (did,dname) values (2, '국문학과')
insert into depart values (3, '서문학과')

commit
select * from depart

// foreign key 설정법 3가지
// 1. 컬럼 뒤에 바로 references 테이블명(컬럼명)
// 2. constraint 으로 foreign key(컬럼명) references 테이블명(컬럼명)
// 3. 테이블 먼저 생성하고 alter로 변경하기
//    alter table student3 add constraint pk_student3_sid primary key(sid)
//    alter table student3 add constraint fk_student3_did foreign key(did) references depart(did)

create table student1(
sid varchar2(3) primary key,
did number(3) references depart(did),
sname varchar2(12) not null
)

create table student2(
sid varchar2(3),
did number(3),
sname varchar2(12) not null,
constraint pk_student2_sid primary key(sid),
constraint fk_student2_did foreign key(did) references depart(did)
)

create table student3(
sid varchar2(3),
did number(3),
sname varchar2(12) not null
)

alter table student3 add constraint pk_student3_sid primary key(sid)
alter table student3 add constraint fk_student3_did foreign key(did) references depart(did)
commit

drop table student1
drop table student2
drop table student3

create table student1(
sid varchar2(3) primary key,
did number(3) references depart(did),
sname varchar2(12) not null
)

create table student2(
sid varchar2(3),
did number(3),
sname varchar2(12) not null,
constraint pk_student2_sid primary key(sid),
constraint fk_student2_did foreign key(did) references depart(did)
)

create table student3(
sid varchar2(3),
did number(3),
sname varchar2(12) not null
)

alter table student3 add constraint pk_student3_sid primary key(sid)
alter table student3 add constraint fk_student3_did foreign key(did) references depart(did)

select * from student1

insert into student3 (sid, did, sname) 
values
('s01',1, 'a')

insert into student3 (sid, did, sname)
values ('s02',1,'b')

insert into stuedent3 (sid, did, sname)
values ('s03',100, 'c')

insert into student3
values ('s04',null,'a')

select * from student3

insert into student3 values('s05', 1,'k')
insert into student3 values('s06', 1,'f')
insert into student3 values('s07', 1,'z')

commit
select * from depart
delete from student3 where sid = 's07'
delete from student3 where sid = 's06'
delete from student3 where sname = 'k'
delete from depart where did = '3'
delete from depart where did='1'

select sid from student3

// did=1 이 외래키로 사용되고있어서 삭제가 되질 않는다.
delete from depart where did='1'

// did=1 을 변경하고 나서 삭제를한다.
update student3 set did=2 where did=1
delete from depart where did='1'





