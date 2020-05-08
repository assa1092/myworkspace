create table member(
id varchar2(6),
name varchar2(21) not null,
age number(3) check(age<200)		
)
// check(age<200) age�� 200 ���ϸ� ����...

insert into member(id, name, age) values ('m001', 'a',150)
insert into member(id, name, age) values ('m002', 'b',151)
insert into member(id, name, age) values ('m003', 'c',152)
insert into member(id, name, age) values ('m004', 'd',153)
insert into member(id, name, age) values ('m005', 'e',154)
insert into member(id, name, age) values ('m006', 'f',155)
insert into member(id, name, age) values ('m007', 'g',156)
insert into member(id, name, age) values ('m008', 'h',157)
insert into member(id, name, age) values ('m009', 'i',158)
insert into member(id, name, age) values ('m010', 'j',159)
insert into member(id, name, age) values ('m011', 'k',160)
insert into member(id, name, age) values ('m012', 'l',161)
insert into member(id, name, age) values ('m013', 'm',162)
insert into member(id, name, age) values ('m014', 'n',163)
insert into member(id, name, age) values ('m015', 'o',164)
insert into member(id, name, age) values ('m016', 'p',165)
insert into member(id, name, age) values ('m017', 'q',166)
insert into member(id, name, age) values ('m018', 'r',167)
insert into member(id, name, age) values ('m019', 's',168)
insert into member(id, name, age) values ('m020', 't',169)
insert into member(id, name, age) values ('m021', 'u',170)
insert into member(id, name, age) values ('m022', 'v',171)
insert into member(id, name, age) values ('m023', 'w',172)
insert into member(id, name, age) values ('m024', 'x',173)
insert into member(id, name, age) values ('m025', 'y',174)
insert into member(id, name, age) values ('m026', 'z',175)

select * from member where id='m020'
select id from member

// member���̺� �ִ� ��� ���ڵ带 ��ȸ�ϴµ� id�� name�÷� �����͸� �������ÿ�
select id,name from member

// member���̺� �ִ� ��� ���ڵ带 ��ȸ�ϴµ� ��� �÷� ������ �� �����ɴϴ�. 
// �׷��� age�� +1�� �ؼ� ����������
select id, name, age+1 from member

// id �� name �� �ٿ��� �����ֱ�
select id, name, id||name from member

// id �� name ���̿� : �����ֱ�
select id, name, id||':'|| name from member

// name �÷��� �̸����� ���̰�...��Ī (as ������ '' ������. )
select id, name as �̸�, age+1 as �ѱ����� from member


select id, name, id||name ��й�ȣ from member

// JDBC������ �÷���, ��Ī �߿��� ��Ī�� �� �߿��ϴ�
// ��Ī�� �־����� �÷����� �ǹ̰� ������.

select distinct id from member		// distinct �ߺ�����.


// �������� : ���� ���� �پ��� ���� desc
// �������� : ���� ���� Ŀ���� ���� asc (����Ʈ�� �������� )

// order by

select * from member order by id asc
select * from member order by id desc

// member ���̺��� ��� ���ڵ带 ��ȸ�ϴµ� name�� �������� �������� ����
select * from member order by name asc


// name���� �������� �����ϰ� ���� name�� ������ age�� �������� �����Ѵ�
create table test10(
id varchar2(6),
name varchar2(21),
age number(3)
)

insert into test10(id, name, age) values(1, 'a', 3)
insert into test10(id, name, age) values(2, 'b', 2)
insert into test10(id, name, age) values(3, 'c', 3)
insert into test10(id, name, age) values(4, 'd', 2)
insert into test10(id, name, age) values(5, 'e', 1)
insert into test10(id, name, age) values(6, 'f', 4)
insert into test10(id, name, age) values(7, 'g', 5)
insert into test10(id, name, age) values(8, 'g', 4)
insert into test10(id, name, age) values(9, 'a', 5)
select * from test10
select * from test10 order by name desc ,age desc









