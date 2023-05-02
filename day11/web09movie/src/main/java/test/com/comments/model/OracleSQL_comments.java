package test.com.comments.model;

public interface OracleSQL_comments {

	
	String SELECT_ALL = "select * from comments where wnum=? order by cnum desc";
	
	
	String INSERT = "insert into comments(cnum,wnum,content,writer) "
			+ " values(seq_comments.nextval,?,?,?)";
	
	String UPDATE = "update comments set content=?,wdate=sysdate "
			+ "where cnum=?";
	
	String DELETE = "delete from comments where cnum=?";
}
