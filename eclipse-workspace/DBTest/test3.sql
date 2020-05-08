create table member(
id varchar2(6),
name varchar2(21) not null,
age number(3) check(age<200)
)

insert into member (id, name, age)
values ('m001','a',150)
insert into member (id, name, age)
values ('m002','b',15)
insert into member (id, name, age)
values ('m003','c',150)
insert into member (id, name, age) values ('m004','d',15)
insert into member (id, name, age) values ('m005','e',17)
insert into member (id, name, age) values ('m006','f',125)
insert into member (id, name, age) values ('m007','g',115)
insert into member (id, name, age) values ('m008','h',152)
insert into member (id, name, age) values ('m009','i',195)
insert into member (id, name, age) values ('m010','j',25)
insert into member (id, name, age) values ('m011','k',1)
insert into member (id, name, age) values ('m012','l',12)
insert into member (id, name, age) values ('m013','m',122)
insert into member (id, name, age) values ('m014','n',22)
insert into member (id, name, age) values ('m015','o',123)
insert into member (id, name, age) values ('m016','p',13)
insert into member (id, name, age) values ('m017','q',166)
insert into member (id, name, age) values ('m018','r',16)
insert into member (id, name, age) values ('m019','s',127)
insert into member (id, name, age) values ('m020','t',19)
insert into member (id, name, age) values ('m021','u',21)
insert into member (id, name, age) values ('m022','v',81)
insert into member (id, name, age) values ('m023','w',10)
insert into member (id, name, age) values ('m024','x',12)
insert into member (id, name, age) values ('m025','y',14)
insert into member (id, name, age) values ('m026','z',122)

select * from member

select id from member

select id, name from member 

select id, name as 이름, age+1 as 한국나이 from member // 별명을 줄 수 있다.

select id, name, id||name 비밀번호 from member // 값을 불러올 때 수정 가능 ||는 문자열을 합치는 기능을 한다.
select id, name, id||':'||name from member

select distinct id from member // 중복 제거

select * from member order by id asc
select * from member order by id desc

select * from member order by name asc

create table ex (
id varchar2(3),
name varchar2(21),
age number(3)
)
alter table ex add constraint pk_ex_id primary key(id)

insert into ex (id, name, age) values (1, 'a', 3)
insert into ex (id, name, age) values (2, 'b', 2)
insert into ex (id, name, age) values (3, 'c', 4)
insert into ex (id, name, age) values (4, 'd', 2)
insert into ex (id, name, age) values (5, 'e', 1)
insert into ex (id, name, age) values (6, 'f', 4)
insert into ex (id, name, age) values (7, 'g', 5)
insert into ex (id, name, age) values (8, 'g', 4)
insert into ex (id, name, age) values (9, 'a', 5)
select * from ex

select * from ex order by name desc, age desc // 조건을 여러개 줄 수 있다. 먼저 정렬한 컬럼 순으로 다시 재정렬한다.







