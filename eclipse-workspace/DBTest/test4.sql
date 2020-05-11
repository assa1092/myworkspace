c:insert
r:select : 정렬(asc, desc)
u:update
d:delete

특정 조건을 만족하는 레코드 조회하기.
where절 : ~인지,...조건절이라고 생각하시면 됨..

select * from member
select * from member where id ='m001'
select * from member where id = 'm007'
select * from member where name = 'g'
select * from member where age = 8

비교연산자..(>, >=, <, <=, = , !=)
_(언더바) : 모르는 글자 한글자...
% : 모르는 글자인데 글자수 도 모를때...(없을수도...)
like : ~ 처럼...
is :  where id is null	// id가 null 값인 id 를 찾는다.

select * from member where age > 18
select * from member where age >=19
select * from member where name = '서울34차12__'       // 서울34차12__ 인 차량을 찾는다.
select * from member where name like '서울34차12__'    // 서울34차1200~서울34차1299 까지의 차량을 찾는다.
select * from member where id like 'm00_'		      // id가 m000 ~ m009 까지의 id를 찾는다...
select * from member where id like '%34차%'			  // %34차% : 사이에 34차 가 들어가는것을 찾는다.
select * from member where id like '%7%' 			  // %7& : 사이에 7이 들어가는것을 찾는다.

create table test5(
id varchar2(6),
name varchar2(18)
)

insert into test5 (id, name) values ('t001','john')
insert into test5 values ('t002','sam')
insert into test5 (id) values ('t003')
insert into test5 (name) values ('tom')
commit

select * from test5

// id 정보가 없는 사람 조회
select * from test5 where id is null
// where id = 'null' ->id가 'null'인 사람 찾기


// name 정보가 있는 사람을 조회 = name 정보가 없는 사람이 아닌 사람을 조회
select * from test5 where name is not null
select * from test5 where id is not null
select * from test5 where name like 'j___'
select * from test5 where name like '%m%'
select * from test5 where name is null


