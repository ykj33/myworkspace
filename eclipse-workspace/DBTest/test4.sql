c : insert
r : select - 정렬
u : update
d : delete

특정 조건을 만족하는 레코드 조회하기

where절 : ~인지... 조건절이라고 생각

select * from member

select * from member where id = 'm001'

select * from member where id  = 'm010'

select * from member where name = 'g'

select * from member where age = 8

select * from member where age >= 19


// 정확한 데이터의 값을 모를 때 like와 _, %를 통해 검색 가능
select * from member where name like '서울34차12__' // _는 모르는 글자 1글자를 뜻함. %는 모르는 글자인데 글자 수도 모를 때

select * from member where id like 'm00_'

select * from member where name like '%34차%'

select * from member where id like '%7%'


create table test5 (
id varchar2(6),
name  varchar2(18)
)

insert into test5 (id, name) values ('t001','john')
insert into test5 values ('t002','sam')
insert into test5 (id) values ('t003')
insert into test5 (name) values ('tom')
commit

select * from test5

// null 값을 다룰 때는 is와 is not으로 조회
select * from test5 where id is null

select * from test5 where id is not null

select * from test5 where name is null

select * from test5 where name is not null















