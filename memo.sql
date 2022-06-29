--
drop table tblMemo;
drop sequence seqMemo;

--


create table tblMemo(
    seq number primary key,
    id varchar(30) not null,
    pw varchar(30) not null,
    title varchar(100) not null,
    content varchar(1000) not null,
    regdate date default sysdate not null
);

create sequence seqMemo;


-- 업무 쿼리
-- 등록
insert into tblMemo(seq, id, pw, title, content, regdate) values(seqMemo.nextVal, 'hong', 'java1234', '메모제목', '메모내용', sysdate);

-- 조회
-- 전체
select * from tblMemo;

-- seq로 조회
select * from tblMemo where seq = 1;

-- seq와 pw를 이용하여 회원이 맞는 지 조회
select count(*) from tblMemo where seq = 1 and pw = 'java1234';


-- 수정
update tblMemo set id='lee', title='운동하기', content='1. 아침운동은 공원에서 1시간 2. 저녁운동은 체육관에서 2시간' where seq = 1;


-- 삭제
delete from tblMemo where seq = 1;

commit;




