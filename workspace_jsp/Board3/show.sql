
rnum을 명시적으로 나오게 한다.
그리고 그 rnum의 값을 특정지어 원하는 값을 출력시킨다.
select * from (select rownum rnum, num, title, writer, writeday, readcnt from (select * from BOARD order by repRoot desc, repStep asc)) where rnum>=? and rnum<=?

