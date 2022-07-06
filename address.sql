-- tblAddress
-- tblAddress 테이블(번호, 이름, 나이, 주소, 성별, 연락처)

-- 성별 m, f
-- 연락처 010-0000-0000 형식

-- 테이블, 시퀀스 삭제
DROP TABLE tblAddress;
DROP SEQUENCE seqAddress;
--

CREATE TABLE tblAddress(
    seq number primary key,
    name varchar2(30) not null,
    age number(3) not null,
    address varchar2(300) not null,
    gender varchar2(10) not null,
    tel varchar2(15) not null
);

CREATE SEQUENCE seqAddress;

-- 입력
INSERT INTO tblAddress (seq, name, age, address, gender, tel) values (seqAddress.nextVal, '홍길동', 20, '서울시 강남구 역삼동', 'm', '010-1234-5678');

COMMIT;

-- 조회
-- 전체
SELECT seq, name, age, address, gender, tel FROM tblAddress;


-- 단건
SELECT seq, name, age, address, gender, tel FROM tblAddress WHERE seq = 1;


-- 성별로 조회
SELECT seq, name, age, address, gender, tel FROM tblAddress WHERE gender = 'm';


-- 삭제
DELETE FROM tblAddress WHERE seq = 1;







