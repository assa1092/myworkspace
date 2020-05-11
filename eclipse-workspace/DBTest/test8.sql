create table test8(
eid number(5),
ename varchar2(21),
dname varchar2(21),
salary number,			// number�� ����� ������ �ʱ⵵ �Ѵ�.
hometown varchar2(21)
)

insert into test8 values (1, 'ȫ�浿', '�λ��', 2000, '���')
insert into test8 values (3, '�ڱ浿', '�λ��', 2000, '��õ')
insert into test8 values (4, '��浿', '�λ��', 3000, '�뱸')
insert into test8 values (4, 'john' , '�λ��', 5000, '�뱸')
insert into test8 values (4, 'tom'  , '�λ��', 7000, '�뱸')
insert into test8 values (5, '�̱浿', '�λ��', 4000, '����')
insert into test8 values (2, '��浿', 'ȫ����', 4000, '����')
insert into test8 values (6, '���浿', 'ȫ����', 4000, '���')
insert into test8 values (7, '���浿', 'ȫ����', 2000, '����')
insert into test8 values (8, '���浿', 'ȫ����', 4000, '��õ')
insert into test8 values (9, '���浿', 'ȫ����', 6000, '����')
insert into test8 values (10, '�ͱ浿', 'ȫ����',7000, '����')
insert into test8 values (11, '�̼���','�񼭽�', 7000, '����')
insert into test8 values (12, null,'������', 5000, '����')
commit
select * from test8


�����Լ� = ����Լ�

select count(*) from test8
select count(eid) from test8		// ���� primary key �� ����ϴ� ������ count �Ѵ�.

select count(ename) from test8		// null ���� �Էµ������� count ������ �ʴ´�...

select sum(salary) as ���ΰǺ� from test8		// ������� �ΰǺ� ������ �˰� �ʹٸ�
select sum(salary)*10000 ���ΰǺ� from test8

select avg(salary) from test8 		// avg ��� 
select max(salary) from test8		// max �ִ밪
select min(salary) from test8		// min �ּҰ�

select * from test8 group by hometown	// * �ȵǰ�  group by ��ϸ� ���� �ִ�.
select hometown from test8 group by hometown
select hometown, max(salary) from test8 group by hometown	// �׷� �ȿ��� ������ �� ���� ���

// dname ���� �׷��� ���� �� �׷쿡 ����� �ִ����� ��ȸ
select dname from test8 group by dname
select dname, count(*) from test8 group by dname

// �ְ� ������ 5õ�̻��� ����� �ִ� �μ� ��ȸ
select dname, max(salary) from test8 group by dname having max(salary)>=5000 	 // �׷쿡 ���� ������...having 

// �ְ� ������ 5õ �̻��� ����� �ִ� hometown ��ȸ
select hometown from test8 group by hometown having max(salary)>=5000

// ��� ���� 2�� �̻��� �ִ� hometown ��ȸ
select hometown, count(eid) from test8 group by hometown having count(eid)>=2


// �������� �� �����ڸ� �������ִ�.
// and, or
select * from test8 where salary > 3000 and salary <5000

select * from test8 where salary >=3000 and salary <=5000


// where salary >=3000 and salary <=5000
// where salary between 3000 and 5000
select * from test8 where salary between 3000 and 5000		// salary �� 3õ�̻�, 5õ����...

// hometown �� ��� �Ǵ� ����
select * from test8 where hometown = '����'  or hometown = '���'


// hometown �� ��� �Ǵ� ���� �Ǵ� ���� �Ǵ� �뱸
select * from test8 where hometown = '����'  or hometown = '���' or hometown = '����' or hometown = '�뱸'
select * from test8 where hometown in ('���', '����', '����', '�뱸')		// OR �����ڷ� Ǯ��� �͵� ����

// where �÷��� in (A,B,C,D) �÷� ������ A,B,C,D�� �ϳ��� �����ϸ� ��...

// select ���� table, relation �� ����Ҽ� �ִ�. ��������(subquery)
select dname from (select dname, eid from test8)

select * from test8 where dname in(select dname from test8 group by dname)

// �ְ� ������ 5õ���� �̻��� �μ��� ��� ������� ������ ��ȸ�Ͻÿ�.
select * from test8 where dname in (select dname from test8 group by dname having max(salary)>=5000)

// �ְ� ������ 5õ���� �̻��� �μ��� �ְ� ������ �ް� �ִ� ����� ������ ��ȸ..
select * from test8 where salary in (select max(salary) from test8 group by dname having max(salary)>=5000)

select * from test8
where
(dname, salary)
in (select dname, max(salary) from test8 group by dname having max(salary)>=5000)

select e.eid from test8 e	//test8�� e�� �ִ´�...�׷��� e.eid�� ��밡��
select e.ename from test8 e where e.eid = 1		







