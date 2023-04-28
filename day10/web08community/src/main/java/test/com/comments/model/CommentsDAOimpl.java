package test.com.comments.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_comments.UPDATE);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getCnum());
			
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
	public int delete(CommentsVO vo) {
		System.out.println("delete()..."+vo);
		
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_comments.DELETE);
			pstmt.setInt(1, vo.getCnum());
			
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
	public List<CommentsVO> selectAll(CommentsVO vo) {
		System.out.println("selectAll()..."+vo);
		
		List<CommentsVO> vos = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_comments.SELECT_ALL);
			pstmt.setInt(1, vo.getWnum());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentsVO vo2 = new CommentsVO();
				vo2.setCnum(rs.getInt("cnum"));
				vo2.setWnum(rs.getInt("wnum"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setContent(rs.getString("content"));
				vo2.setWdate(rs.getTimestamp("wdate"));
				
				vos.add(vo2);
			}
			
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
		
		return vos;
	}

}
