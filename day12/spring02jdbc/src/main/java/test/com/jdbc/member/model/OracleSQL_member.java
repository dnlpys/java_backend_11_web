package test.com.jdbc.member.model;

public interface OracleSQL_member {

	
	String SELECT_ALL = "select * from member order by num desc";
	
	String SELECT_ONE = "select * from member where num = ?";
	
	String ID_CHECK = "select * from member where id = ?";
	
	String LOGIN = "select * from member where id = ? and pw = ?";
	
	String SEARCH_LIST_NAME = "select * from member where name like ?";
	
	String SEARCH_LIST_TEL =  "select * from member where tel  like ?";
	
	String INSERT = "insert into member(num,id,pw,name,tel) "
			+ " values(seq_member.nextval,?,?,?,?)";
	
	String UPDATE = "update member set pw=?,name=?,tel=? "
			+ "where num=?";
	
	String DELETE = "delete from member where num=?";
}
