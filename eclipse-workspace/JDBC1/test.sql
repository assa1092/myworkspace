create table tbl_member(
id varchar2(6) primary key,
name varchar2(12),
age number(3) check(age<200)
)

select * from tbl_member
update tbl_member set id='k001' where name='lee'
