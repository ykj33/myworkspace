create table test8 (
eid number(5),
ename varchar2(21),
dname varchar2(21),
salary number,
hometown varchar2(21)
)

insert into test8 values (1, '홍길동', '인사부', 2000, '경기')
insert into test8 values (3, '박길동', '인사부', 2000, '인천')
insert into test8 values (4, '고길동', '인사부', 3000, '대구')
insert into test8 values (4, 'john', '인사부', 5000, '대구')
insert into test8 values (4, 'tom', '인사부', 7000, '대구')
insert into test8 values (5, '이길동', '인사부', 4000, '경주')
insert into test8 values (2, '김길동', '홍보부', 4000, '서울')
insert into test8 values (6, '강길동', '홍보부', 3000, '경기')
insert into test8 values (7, '각길동', '홍보부', 2000, '서울')
insert into test8 values (8, '곽길동', '홍보부', 4000, '인천')
insert into test8 values (9, '구길동', '홍보부', 6000, '광주')
insert into test8 values (10, '맹길동', '홍보부', 7000, '대전')
insert into test8 values (11, '이순실', '비서실', 7000, '대전')
insert into test8 values (12, null, '관리부', 5000, '제주')
commit

집계함수 = 통계함수

select count(*) from test8
select count(eid) from test8

select count(ename) from test8 // null값이 있을 경우 count되지 않는다.

select sum(salary)*10000 as 총인건비 from test8 // sum(컬럼명) 총합 계산 가능

select avg(salary) from test8 // avg(컬럼명) 평균 계산 가능

select max(salary) from test8 // max(컬럼명) 최대값 계산 가능
 
select min(salary) from test8 // min(컬럼명) 최소값 계산 가능

select hometown from test8 group by hometown // group by 사용 시 select엔 group by 조건만 사용 가능

select hometown, max(salary) from test8 group by hometown // 해당 그룹 내에서 연봉이 가장 많은 사람, select에 집계 함수 사용 가능

select dname, count(*) from test8 group by dname // dname 별로 그룹, 각 그룹별 인원

select dname from test8 group by dname having max(salary) > 5000 // group by에 조건을 넣고 싶을 시 having사용 

select hometown from test8 group by hometown having max(salary) >= 5000

select hometown,count(*) from test8 group by hometown having count(*) >= 2

// where 절에도 논리 연산자 사용 가능
select * from test8 where salary > 3000 and salary <5000

select * from test8 where salary>=3000 and salary <= 5000 // 가독성이 떨어진다.

select * from test8 where salary between 3000 and 5000 // between을 더 선호함

select * from test8 where hometown = '서울' or hometown  = '경기'

select * from test8 where hometown = '서울' or hometown  = '경기' or hometown  = '대전' or hometown  = '대구' // 권장 X

select * from test8 where hometown in ('경기','서울','대전','대구') // in() 괄호 안의 내용과 일치 할 시 출력

// select는 반환형이 table=relation 이므로 이걸 from 절에 사용 할 수 있다. - 서브쿼리 subquery
select dname from(select dname, eid from test8)


select * from test8 where dname in(select dname from test8 group by dname)

// 최고 연봉이 5천만원 이상인 부서의 모든 사원들의 정보를 조회하세요.
select * from test8 where dname in(select dname from test8 group by dname having max(salary)>=5000)

// 최고 연봉이 5천만원 이상인 부서의 최고 연봉을 받고 있는 사원의 정보를 조회하세요.
select * from test8 where salary in(select max(salary) from test8 group by dname having max(salary) >=5000) // in으로 넣을 때는 반드시 컬럼이 1개여야 한다.

 // in으로 비교할 것이 2개 이상일 경우 where절을 ()로 묶어야 한다. 값을 2개를 조회했으므로 받는 것도 2개 받아야 함
select * from test8 where (dname, salary) in (select dname, max(salary) from test8 group by dname having max(salary)>=5000)

select e.eid from test8 e // test8을 e에 넣어서 e.eid가 가능하다. join을 배울 때 별칭을 붙여서 자주 사용함
select e.ename from test8 e where e.eid = 1

