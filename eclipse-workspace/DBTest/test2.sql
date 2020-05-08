프라이머리 키 선언 방법
1. 테이블 선언 시 해당 컬럼 옆에 선언
2. 마지막에 정리해서 제약 조건 선언
3. 테이블 선언 뒤 제약 조건을 추가하여 선언, 주로 사용할 예정

create table test2(
id number(3) primary key,
name varchar2(21)
)

create table test3(
id number(3),
name varchar2(21),
constraint pk_test3_id primary key(id)
);

create table test4(
id number(3),
name varchar2(21)
)

alter table test4 add constraint pk_test4_id primary key(id)

drop table test2
drop table test3
drop table test4

create table test2 (
id number(3) primary key,
name varchar2(21)
)

create table test3 (
id number(3),
name varchar2(21),
constraint pk_test3_id primary key(id)
)

create table test4(
id number(3),
name varchar2(21)
)

alter table test4 add constraint pk_test4_id primary key (id)


insert into test2(id, name) values (1, 'kim')
insert into test2(name, id) values ('lee',2)
insert into test2 (id) values (3)
insert into test2 (name) values ('choi') // not null 제약 조건 위배
insert into test2 values (3, 'kang') // unique 제약 조건 위배


create table depart(
did number(3),
dname varchar2(20) not null
)

alter table depart add constraint pk_depart_did primary key (did)

insert into depart (did, dname) values (1,'영문학과')
insert into depart (did, dname) values(2, '국문학과')
insert into depart values (3, '서문학과')
commit
select * from depart


foreign 키 선언 방법
1. 테이블 선언 시 선언 참조한다는 형식
2. 마지막에 제약 조건을 모아서 선언 참조한다는 형식
3. 이미 테이블을 선언했다면 alter table을 이용하여 선언


create table student1(
sid varchar2(3) primary key,
did number(3) references depart(did), // 다른 컬럼 값을 참조한다는 뜻
sname varchar2(12) not null
)

create table student2(
sid varchar2(3),
did number(3),
sname varchar2(12) not null,
constraint pk_student2_sid primary key(sid),
constraint fk_student2_did foreign key(did) references depart (did)
)

create table student3 (
sid varchar2(3),
did number(3),
sname varchar2(12) not null
)
alter table student3 add constraint pk_student3_sid primary key(sid)
alter table student3 add constraint fk_student3_did foreign key(did) references depart(did)

create table student1(
sid varchar2(3) primary key,
did number(3) references depart,
sname varchar2(12) not null
)

create table student2(
sid varchar2(3),
did number(3),
sname varchar2(12) not null,
constraint pk_student2_sid primary key(sid),
constraint fk_student2_did foreign key(did) references depart (did)
)

create table student3(
sid varchar2(3),
did number(3),
sname varchar2(12) not null
)
alter table student3 add constraint pk_student3_sid primary key(sid)
alter table student3 add constraint fk_student3_did foreign key(did) references depart(did)

insert into student3 (sid, did, sname) 
values 
('s01',1,'a')

insert into student3 (sid, did, sname)
values
('s02', 1, 'b')

insert into student3 (sid, did, sname)
values
('s03',100,'c')

insert into student3
values
('s04',null, 'a')






