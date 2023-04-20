package test.com.model;

public interface OracleSQL_board {

	
	String SELECT_ALL = "select * from board order by wnum desc";
	
	String SELECT_ONE = "select * from board where wnum = ?";
	
	String SEARCH_LIST_TITLE = "select * from board where title like ?";
	
	String SEARCH_LIST_CONTENT =  "select * from board where content  like ?";
	
	String INSERT = "insert into board(wnum,title,content,writer) "
			+ " values(seq_board.nextval,?,?,?)";
	
	String UPDATE = "update board set title=?,content=?,wdate=sysdate "
			+ "where wnum=?";
	
	String DELETE = "delete from board where wnum=?";
}
