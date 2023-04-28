package test.com.reservation.model;

public interface OracleSQL_reservation {

	
	String SELECT_ALL = "select r.num,r.user_id,r.movie_num,m.title,r.regdate,r.movie_date,r.mcount from reservation r join movie m on (r.movie_num = m.num) where user_id=? order by num";
	
	String SELECT_ONE = "select * from reservation where num = ?";
	
	
	String INSERT = "insert into reservation(num,user_id,movie_num,movie_date,mcount) "
			+ " values(seq_reservation.nextval,?,?,TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),?)";
	
	String UPDATE = "update reservation set movie_num=?,movie_date=TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),regdate=sysdate "
			+ "where num=?";
	
	String DELETE = "delete from reservation where num=?";
}
