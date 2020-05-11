drop table member
drop table dep

create table dep(
did varchar2(4),
dname varchar(9)
)

alter table dep add constraint pk_dep_did primary key(did)

insert into dep values('d001','영업')
insert into dep values('d002','경영')
insert into dep values('d003','홍보')


create table member (
id varchar2(4),
did varchar2(4),
name varchar(9)
)

alter table member add constraint fk_member_did foreign key(did) references dep(did)
alter table member add constraint pk_member_id primary key(id)

insert into member values('m001','d001','kim')
insert into member values('m002','d002','lee')
insert into member values('m003','d003','park')
insert into member values('m004','d001','kang')
insert into member values('m005','d003','choi')
commit
select * from member, dep

// 별칭을 이용하여 원하는 컬럼만 불러낼 수 있다.
select m.id, d.did, d.dname, m.name from member m, dep d

// 이퀴조인, 등가조인 가장 이해하기 쉬운 조인, = 
select m.id, d.did, d.dname, m.name from member m, dep d where m.did = d.did


// 이너조인
select m.id, d.did, d.dname, m.name from member m inner join dep d on m.did = d.did
inner join hometown h on e.hid = h.hid // 한 번 더 이너조인 가능 먼저 조인을 시키고 한 번 더 시키면 된다.

// 내추럴 조인
select * from member m natural join dep d
natural join hometown h

// 주키와 외래키의 컬럼명이 다를 경우
select m.id, d.did, m.name, d.dname from member m join dep d on (m.did = d.did)

// 키 끼리의 데이터의 크기가 다를 경우, using
select m.id, d.did, m.name, d.dname
from member m join dep d
using (did)

insert into member values ('m010',null,'jung')
insert into dep values ('d100','회계')
commit 


// 아우터 조인
// 레프트 아우터 조인(left outer join), 왼쪽에 있는 것은 매칭되지 않아도 다 나온다. 오른 쪽에 있는 건 매칭되는 것만
select m.id, m.name, d.did, d.dname
from member m left outer join dep d on m.did = d.did

// 라이트 아우터 조인(right outer join), 오른쪽에 있는 것은 매칭되지 않아도 다 나온다. 왼쪽에 있는 건 매칭되는 것만
select m.id, m.name, d.did, d.dname
from member m right outer join dep d on m.did = d.did

select m.id, m.name, d.did, d.dname from dep d left outer join member m on d.did = m.did

// 풀 아우터 조인(full outer join), 다 나온다.
select m.id, m.name, d.did, d.dname from dep d full outer join member m on d.did = m.did

// view, table을 감추고 view를 앞세워서 원래 table을 감추는 효과가 있음
create or replace view v_member
as
select * from member

select * from v_member

create or replace view view_member_notnulldid
as
select * from member where did is not null

select * from view_member_notnulldid

// 감추고 싶은 테이블의 컬럼을 넣어주면 된다.
create or replace view v_member_dname as select * from member m natural join dep d 
select * from v_member_dname

create or replace view v_member_notnulldid
as
select * from member
where did is not null
with check option // where절에 조건에 맞는 데이터만 C, U, D 가능

insert into v_member_notnulldid
(id, name, did)
values ('m200','heo',null) // null이 들어갔기 때문에 넣을 수 없다.

update v_member_notnulldid set name = 'seo'
where id = 'm200'

update v_member_notnulldid set did = null where id = 'm200'

// read only이기 때문에 C, U, D 불가능
create or replace view v_member_notnulldid as select * from member
where did is not null with read only






