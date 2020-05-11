create table test8(
eid number(5),
ename varchar2(21),
dname varchar2(21),
salary number,			// number에 사이즈를 정하지 않기도 한다.
hometown varchar2(21)
)

insert into test8 values (1, '홍길동', '인사부', 2000, '경기')
insert into test8 values (3, '박길동', '인사부', 2000, '인천')
insert into test8 values (4, '고길동', '인사부', 3000, '대구')
insert into test8 values (4, 'john' , '인사부', 5000, '대구')
insert into test8 values (4, 'tom'  , '인사부', 7000, '대구')
insert into test8 values (5, '이길동', '인사부', 4000, '경주')
insert into test8 values (2, '김길동', '홍보부', 4000, '서울')
insert into test8 values (6, '강길동', '홍보부', 4000, '경기')
insert into test8 values (7, '각길동', '홍보부', 2000, '서울')
insert into test8 values (8, '곽길동', '홍보부', 4000, '인천')
insert into test8 values (9, '구길동', '홍보부', 6000, '광주')
insert into test8 values (10, '맹길동', '홍보부',7000, '대전')
insert into test8 values (11, '이순실','비서실', 7000, '대전')
insert into test8 values (12, null,'관리부', 5000, '제주')
commit
select * from test8


집계함수 = 통계함수

select count(*) from test8
select count(eid) from test8		// 보통 primary key 를 사용하는 것으로 count 한다.

select count(ename) from test8		// null 값이 입력되있으면 count 되지를 않는다...

select sum(salary) as 총인건비 from test8		// 사원들의 인건비 총합을 알고 싶다면
select sum(salary)*10000 총인건비 from test8

select avg(salary) from test8 		// avg 평균 
select max(salary) from test8		// max 최대값
select min(salary) from test8		// min 최소값

select * from test8 group by hometown	// * 안되고  group by 목록만 들어갈수 있다.
select hometown from test8 group by hometown
select hometown, max(salary) from test8 group by hometown	// 그룹 안에서 연봉이 젤 많은 사람

// dname 별로 그룹을 짓고 각 그룹에 몇명이 있는지를 조회
select dname from test8 group by dname
select dname, count(*) from test8 group by dname

// 최고 연봉이 5천이상인 사원이 있는 부서 조회
select dname, max(salary) from test8 group by dname having max(salary)>=5000 	 // 그룹에 대한 조건절...having 

// 최고 연봉이 5천 이상의 사원이 있는 hometown 조회
select hometown from test8 group by hometown having max(salary)>=5000

// 사원 수가 2명 이상이 있는 hometown 조회
select hometown, count(eid) from test8 group by hometown having count(eid)>=2


// 조건절에 논리 연산자를 넣을수있다.
// and, or
select * from test8 where salary > 3000 and salary <5000

select * from test8 where salary >=3000 and salary <=5000


// where salary >=3000 and salary <=5000
// where salary between 3000 and 5000
select * from test8 where salary between 3000 and 5000		// salary 가 3천이상, 5천이하...

// hometown 이 경기 또는 서울
select * from test8 where hometown = '서울'  or hometown = '경기'


// hometown 이 경기 또는 서울 또는 대전 또는 대구
select * from test8 where hometown = '서울'  or hometown = '경기' or hometown = '대전' or hometown = '대구'
select * from test8 where hometown in ('경기', '서울', '대전', '대구')		// OR 연산자로 풀어쓰는 것도 가능

// where 컬럼명 in (A,B,C,D) 컬럼 조건이 A,B,C,D중 하나라도 만족하면 참...

// select 문에 table, relation 을 사용할수 있다. 서브쿼리(subquery)
select dname from (select dname, eid from test8)

select * from test8 where dname in(select dname from test8 group by dname)

// 최고 연봉이 5천만원 이상의 부서의 모든 사원들의 정보를 조회하시오.
select * from test8 where dname in (select dname from test8 group by dname having max(salary)>=5000)

// 최고 연봉이 5천만원 이상의 부서의 최고 연봉을 받고 있는 사원의 정보를 조회..
select * from test8 where salary in (select max(salary) from test8 group by dname having max(salary)>=5000)

select * from test8
where
(dname, salary)
in (select dname, max(salary) from test8 group by dname having max(salary)>=5000)

select e.eid from test8 e	//test8에 e를 넣는다...그래서 e.eid가 사용가능
select e.ename from test8 e where e.eid = 1		







