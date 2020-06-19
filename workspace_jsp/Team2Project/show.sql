create table member (
id varchar2(30) primary key,
name varchar2(30) not null,
pw varchar2(30) not null,
property varchar2(30) default 'customer'

)

insert into MEMBER values ('m001', 'lee','1','customer')

drop table member

create table review(
num number(10) primary key,
title varchar2(30),
content varchar2(1000),
id varchar2(30) references member (id) ,
category varchar2(30),
writeday date default sysdate,  
readcnt number(10) default 0,
starpoint number(2) check (starpoint<=10)

)

SELECT * FROM (SELECT * FROM review WHERE id = 'admin' ORDER BY num desc) WHERE ROWNUM = 1

insert into REVIEW values (1, 'title1','content1','m001','category1', sysdate,1,1)
commit
select * from member

update member set property = 'admin' where id = 'admin'
commit
SELECT * FROM review WHERE (title = '%?%') or (content like '%?%')

create table upload(
num number(10) primary key,
fileName varchar2(30),
orgFileName varchar2(30)
)

select * from upload

delete from review where num = 31
ALTER TABLE review MODIFY (title VARCHAR2(300))
ALTER TABLE review MODIFY (content VARCHAR2(4000))

create table free(
fnum number(10) primary key,
ftitle varchar2(300),
fcontent varchar2(4000),
id varchar2(30) references member(id),
fwriteday date default sysdate,
freadcnt number(10) default 0,
repRoot number(4),
repStep number(4),
repIndent number(4)
)

insert into free (fnum, ftitle, fcontent, id, repRoot, repStep, repIndent) values (1,'test', 'test', 'm111', 1, 0 ,0)
delete from free where fnum = 5
select * from free

