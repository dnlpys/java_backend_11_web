--member table
CREATE TABLE MEMBER 
(
  NUM NUMBER NOT NULL 
, ID VARCHAR2(20) NOT NULL 
, PW VARCHAR2(20) NOT NULL 
, NAME VARCHAR2(20) NOT NULL 
, TEL VARCHAR2(20) NOT NULL 
, CONSTRAINT MEMBER_PK PRIMARY KEY 
  (
    NUM 
  )
  ENABLE 
);

drop table MEMBER ;

-- ������ : ��ȣ �ڵ����� ��Ű��
CREATE SEQUENCE SEQ_MEMBER;
DROP SEQUENCE SEQ_MEMBER;

select * from member order by num desc;

insert into member(num,id,pw,name,tel) 
values(SEQ_MEMBER.nextval,'admin2'||SEQ_MEMBER.nextval,'hi2222','kim2','02');

truncate table member; -- ��� �� ����,rollback�Ұ���

commit;  --����,Ȯ��
rollback; --���,�ǵ�����

