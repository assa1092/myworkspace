c:insert
r:select : ����(asc, desc)
u:update
d:delete

Ư�� ������ �����ϴ� ���ڵ� ��ȸ�ϱ�.
where�� : ~����,...�������̶�� �����Ͻø� ��..

select * from member
select * from member where id ='m001'
select * from member where id = 'm007'
select * from member where name = 'g'
select * from member where age = 8

�񱳿�����..(>, >=, <, <=, = , !=)
_(�����) : �𸣴� ���� �ѱ���...
% : �𸣴� �����ε� ���ڼ� �� �𸦶�...(��������...)
like : ~ ó��...
is :  where id is null	// id�� null ���� id �� ã�´�.

select * from member where age > 18
select * from member where age >=19
select * from member where name = '����34��12__'       // ����34��12__ �� ������ ã�´�.
select * from member where name like '����34��12__'    // ����34��1200~����34��1299 ������ ������ ã�´�.
select * from member where id like 'm00_'		      // id�� m000 ~ m009 ������ id�� ã�´�...
select * from member where id like '%34��%'			  // %34��% : ���̿� 34�� �� ���°��� ã�´�.
select * from member where id like '%7%' 			  // %7& : ���̿� 7�� ���°��� ã�´�.

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

// id ������ ���� ��� ��ȸ
select * from test5 where id is null
// where id = 'null' ->id�� 'null'�� ��� ã��


// name ������ �ִ� ����� ��ȸ = name ������ ���� ����� �ƴ� ����� ��ȸ
select * from test5 where name is not null
select * from test5 where id is not null
select * from test5 where name like 'j___'
select * from test5 where name like '%m%'
select * from test5 where name is null


