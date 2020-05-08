create table test1(
id number(3),
name varchar2(21)
)

insert into test1(id, name) values(1, 'kim')
insert into test1(id, name) values(2, 'lee')
insert into test1(name, id) values('park', 3)
insert into test1(name) values('choi')
insert into test1(id) values(5)
insert into test1 values (6,'kang')
insert into test1 values (7, 'jung')
commit

select * from test1

update test1 set id=4 where name='choi'
update test1 set name = 'anh' where id=5