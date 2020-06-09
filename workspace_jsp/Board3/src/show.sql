select * from board order by repRoot desc, repStep asc

select rownum rnum, num, title, writer,writeday, readcnt from(select * from board order by repRoot desc, repStep asc)

쿼리 값을 그대로 테이블 처럼 사용...

명시적으로 rownum 을 만들어서 사용한다...별칭으로 사용 (rnum)

select * from (select rownum rnum, num, title, writer,writeday, readcnt from(select * from board order by repRoot desc, repStep asc)) where rnum>=1 and rnum <=10

앞에 ? startNum 뒤에 ? endNum
where rnum>=? and rnum <=?  
