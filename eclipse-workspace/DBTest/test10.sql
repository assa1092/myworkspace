drop table member
drop table dep

create table dep(
did varchar2(4) ,
dname varchar2(12),
constraint pk_dep_did primary key(did)
)
alter table dep add constraint pk_dep_did primary key(did)

create table member(
id varchar2(4),
did varchar2(12),
name varchar2(21),
constraint pk_member_id primary key(id),
constraint fk_member_did foreign key(did) references dep(did)
)
alter table member add pk_member_id primary key(id)
alter table member add fk_member_did foreign key(did) references dep(did)

insert into  dep (did, dname) values ('d001', '영업')
insert into  dep (did, dname) values ('d002', '경영')
insert into  dep (did, dname) values ('d003', '홍보')

insert into member (id, did, name) values ('m001', 'd001','kim')
insert into member (id, did, name) values ('m002', 'd002','lee')
insert into member (id, did, name) values ('m003', 'd003','park')
insert into member (id, did, name) values ('m004', 'd001','kang')
insert into member (id, did, name) values ('m005', 'd003','choi')
commit
select * from dep
select * from member
select * from dep, member
select m.id, d.did, d.dname, m.name from member m, dep d	// 별칭을 이용해서 


// Equi join(등가 조인)
select m.id, d.did, d.dname, m.name 
from member m, dep d 
where m.did = d.did

// inner join
select m.id, d.did, d.dname, m.name 
from member m inner join  dep d
on m.did = d.did
inner join hometown h 	// 혹시 member테이블에 외래키가 하나더 있을경우 이렇게.. 한번더 inner join 한다.
on e.hid = h.hid

// natural join	 조인에 이용되는 컬럼은 명시하지 않아도 자동으로 조인에 사용된다.
select * from member m natural join dep d
natural join hometown h	// 혹시 member테이블에 외래키가 하나더 있을경우 이렇게.. 한번더 natural join 한다.

//join 시 두개의 컬럼명(주키, 외래키) 이 다를때 on (m.did = d.did) 
select m.id, d.did, m.name, d.dname
from member m join dep d
on (m.did = d.did)

// join 시 두개의 컬럼 크기가 다를때  using(did)
select m.id, d.did, m.name, d.dname
from member m join dep d
using (did)

insert into member values ('m010', null,'jung')
insert into dep values ('d100', '회계')
select * from dep

commit
select * from member m natural join dep d

// outer join	매칭이 되지 않아도 내용 보이게
// 왼쪽에것 member 컬럼은 다 나오고 오른쪽의 dep 컬럼은 겹치는 것만 나온다. 
select m.id, m.name, d.did, d.dname
from member m left outer join dep d
on m.did = d.did

// right outer join 오른쪽에것 dep 는 다 나오고 일치하는 member 만 나온다
select m.id, m.name, d.did, d.dname
from member m right outer join dep d
on m.did = d.did


// left outer join 을 이용해서 
// dep 테이블에있는 모든 데이터를 조회하되 데이터는 dep와 일치할경우에만 조회
select d.did, d.dname, m.id, m.name 
from dep d left outer join member m
on d.did = m.did

// full outer join  다 나온다.
select d.did, d.dname, m.id, m.name 
from dep d full outer join member m
on d.did = m.did

// view (create or replace 새로만들던가 있으면 이것으로 대체)
// view 는 가상 테이블, select 문에 이름을 붙은것.
// create view 명령어 다음의 as 절에 기술한 쿼리 문장 자체를 저장하고있다가 
// view 를 호출하는 순간 이를 실행한다.
create or replace view v_member
as
select * from member


select * from v_member

// did가 null 이 아닌 레코드로만 이루어진 member 테이블의 자료를 이용하여
// view_member_notnulldid 뷰를 생성하시오.
create or replace view view_member_notnulldid
as
select * from member where did is not null

select * from view_member_notnulldid


create or replace view v_member_dname
as
select * from member m natural join dep d

select * from v_member_dname



// did null 인경우 삽입이 안된다...(with check option)
create or replace view v_member_notnulldid
as
select * from member
where
did is not null
with check option

select * from v_member_notnulldid


insert into v_member_notnulldid (id, name, did)
values ('m200', 'heo', null)

insert into v_member_notnulldid (id, name, did)
values ('m200', 'heo', 'd001')

update v_member_notnulldid set name = 'seo'
where id = 'm200'

update v_member_notnulldid set did = null
where id = 'm200'



create or replace view v_member_notnulldid
as
select * from member
where did is not null		// 읽기 전용으로 만든다...insert, update, delete 할수 없다.	




