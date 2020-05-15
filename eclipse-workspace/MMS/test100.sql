create table account(
name varchar2(4) primary key,
balance number(4) default 0		// 값을 안넣으면 디폴트로 0이 입력
)

insert into account (name) values ('a')
insert into account (name, balance) values ('b',1000)
select * from ACCOUNT

update account set balance = 1000 where name ='a'