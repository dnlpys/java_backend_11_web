create table board(
wnum number primary key,
writer varchar2(20) not null,
title varchar2(100) not null,
content varchar2(4000) not null,
wdate date default sysdate not null,
vcount number default 0
);

DROP TABLE BOARD;

create sequence seq_board;
drop sequence seq_board;

--BEGIN
--  for i in 1..10 loop
--    insert into board(wnum,writer,title,content) 
--    values(SEQ_BOARD.nextval,
--    'kim'||SEQ_BOARD.nextval,
--    'title'||SEQ_BOARD.nextval,
--    'content'||SEQ_BOARD.nextval);
--  end loop;
--  commit;
--END;


select * from board order by wnum desc;










