create table account(
name varchar2(4) primary key,
balance number(4) default 0		// ���� �ȳ����� ����Ʈ�� 0�� �Է�
)

insert into account (name) values ('a')
insert into account (name, balance) values ('b',1000)
select * from ACCOUNT

update account set balance = 1000 where name ='a'