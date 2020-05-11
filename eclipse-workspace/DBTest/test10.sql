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

insert into  dep (did, dname) values ('d001', '����')
insert into  dep (did, dname) values ('d002', '�濵')
insert into  dep (did, dname) values ('d003', 'ȫ��')

insert into member (id, did, name) values ('m001', 'd001','kim')
insert into member (id, did, name) values ('m002', 'd002','lee')
insert into member (id, did, name) values ('m003', 'd003','park')
insert into member (id, did, name) values ('m004', 'd001','kang')
insert into member (id, did, name) values ('m005', 'd003','choi')
commit
select * from dep
select * from member
select * from dep, member
select m.id, d.did, d.dname, m.name from member m, dep d	// ��Ī�� �̿��ؼ� 


// Equi join(� ����)
select m.id, d.did, d.dname, m.name 
from member m, dep d 
where m.did = d.did

// inner join
select m.id, d.did, d.dname, m.name 
from member m inner join  dep d
on m.did = d.did
inner join hometown h 	// Ȥ�� member���̺� �ܷ�Ű�� �ϳ��� ������� �̷���.. �ѹ��� inner join �Ѵ�.
on e.hid = h.hid

// natural join	 ���ο� �̿�Ǵ� �÷��� ������� �ʾƵ� �ڵ����� ���ο� ���ȴ�.
select * from member m natural join dep d
natural join hometown h	// Ȥ�� member���̺� �ܷ�Ű�� �ϳ��� ������� �̷���.. �ѹ��� natural join �Ѵ�.

//join �� �ΰ��� �÷���(��Ű, �ܷ�Ű) �� �ٸ��� on (m.did = d.did) 
select m.id, d.did, m.name, d.dname
from member m join dep d
on (m.did = d.did)

// join �� �ΰ��� �÷� ũ�Ⱑ �ٸ���  using(did)
select m.id, d.did, m.name, d.dname
from member m join dep d
using (did)

insert into member values ('m010', null,'jung')
insert into dep values ('d100', 'ȸ��')
select * from dep

commit
select * from member m natural join dep d

// outer join	��Ī�� ���� �ʾƵ� ���� ���̰�
// ���ʿ��� member �÷��� �� ������ �������� dep �÷��� ��ġ�� �͸� ���´�. 
select m.id, m.name, d.did, d.dname
from member m left outer join dep d
on m.did = d.did

// right outer join �����ʿ��� dep �� �� ������ ��ġ�ϴ� member �� ���´�
select m.id, m.name, d.did, d.dname
from member m right outer join dep d
on m.did = d.did


// left outer join �� �̿��ؼ� 
// dep ���̺��ִ� ��� �����͸� ��ȸ�ϵ� �����ʹ� dep�� ��ġ�Ұ�쿡�� ��ȸ
select d.did, d.dname, m.id, m.name 
from dep d left outer join member m
on d.did = m.did

// full outer join  �� ���´�.
select d.did, d.dname, m.id, m.name 
from dep d full outer join member m
on d.did = m.did

// view (create or replace ���θ������ ������ �̰����� ��ü)
// view �� ���� ���̺�, select ���� �̸��� ������.
// create view ��ɾ� ������ as ���� ����� ���� ���� ��ü�� �����ϰ��ִٰ� 
// view �� ȣ���ϴ� ���� �̸� �����Ѵ�.
create or replace view v_member
as
select * from member


select * from v_member

// did�� null �� �ƴ� ���ڵ�θ� �̷���� member ���̺��� �ڷḦ �̿��Ͽ�
// view_member_notnulldid �並 �����Ͻÿ�.
create or replace view view_member_notnulldid
as
select * from member where did is not null

select * from view_member_notnulldid


create or replace view v_member_dname
as
select * from member m natural join dep d

select * from v_member_dname



// did null �ΰ�� ������ �ȵȴ�...(with check option)
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
where did is not null		// �б� �������� �����...insert, update, delete �Ҽ� ����.	




