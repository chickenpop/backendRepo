-- gallery.sql

--
DROP TABLE tblGallery;
DROP SEQUENCE gallerySeq; 
--

-- 테이블, 시퀀스 
CREATE TABLE tblGallery (
    seq number primary key,             -- 갤러리번호
    filename varchar2(300) not null,    -- 이미지명(저장되는 이름)
    content varchar2(1000) not null,    -- 이미지 내용
    regdate date default sysdate        -- 등록 날짜
);

CREATE SEQUENCE gallerySeq;


-- 이미지 등록
INSERT INTO tblGallery (seq, filename, content, regdate) values (GALLERYSEQ.nextval, 'test.png', '테스트업로드', default);

-- 이미지 조회
SELECT * FROM tblgallery;


-- 이미지 내용 수정
UPDATE tblgallery SET content = '수정 업로드' WHERE seq = 1;
    

-- 이미지 삭제
DELETE FROM tblgallery WHERE seq = 1;

