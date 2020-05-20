create table tbl_product (
pid varchar2(4) primary key,
pname varchar2(30),
amount number(3),
price number(10),
discount number(2),
sid varchar2(4) references tbl_storage(sid)
)

create table tbl_storage (
sid varchar2(4) primary key,
location varchar2(30),
stype varchar2(15),
mid varchar2(4) references tbl_manager(mid)
)

create table tbl_manager(
mid varchar2(4) primary key,
mname varchar2(30),
dept varchar2(15)
)

insert into tbl_manager (mid, mname, dept) values ('m001', 'kim', '인사');
insert into tbl_manager (sid, location, stype, mid) values ('s001','서울','전자기기','m001');
select * from tbl_storage
select * from tbl_manager
select * from tbl_product

select * from tbl_manager m , tbl_storage s , tbl_product p WHERE m.mid='m002' and s.mid = m.mid

select m.mid, m.mname,m.dept, s.sid, s.location,s.stype, p.pid, p.pname, p.amount, p.price, p.discount 
from tbl_manager m , tbl_storage s , tbl_product p 
WHERE m.mid = 'm001' and m.mid =  s.mid and s.sid = p.sid;
