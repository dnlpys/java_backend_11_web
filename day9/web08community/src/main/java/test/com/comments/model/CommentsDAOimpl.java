package test.com.comments.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import test.com.board.model.OracleJDBC;
import test.com.board.model.OracleSQL_board;

public class CommentsDAOimpl implements CommentsDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CommentsDAOimpl() {
		System.out.println("CommentsDAOimpl()...");
		try {
			Class.forName(OracleJDBC.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(CommentsVO vo) {
		System.out.println("insert()..."+vo);
		
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_comments.INSERT);
			pstmt.setInt(1, vo.getWnum());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			flag = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//end finally
		return flag;
	}

	@Override
	public int update(CommentsVO vo) {
		System.out.println("update()..."+vo);
		
		return 0;
	}

	@Override
	public int delete(CommentsVO vo) {
		System.out.println("delete()..."+vo);
		
		return 0;
	}

	@Override
	public List<CommentsVO> selectAll(CommentsVO vo) {
		System.out.println("selectAll()..."+vo);
		
		return null;
	}

}
