package test.com.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAOimpl() {
		System.out.println("BoardDAOimpl()....");
		try {
			Class.forName(OracleJDBC.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(BoardVO vo) {
		System.out.println("insert()...." + vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_board.INSERT);
			pstmt.setString(1, vo.getTitle());
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
	public int update(BoardVO vo) {
		System.out.println("update()...." + vo);
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_board.UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getWnum());
			
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
	public int delete(BoardVO vo) {
		System.out.println("delete()...." + vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_board.DELETE);
			pstmt.setInt(1, vo.getWnum());
			
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
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("selectOne()...." + vo);
		
		BoardVO vo2 = new BoardVO();
		
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_board.SELECT_ONE);
			pstmt.setInt(1, vo.getWnum());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo2.setWnum(rs.getInt("wnum"));
				vo2.setTitle(rs.getString("title"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setWdate(rs.getTimestamp("wdate"));
				vo2.setVcount(rs.getInt("vcount"));
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
		
		return vo2;
	}

	@Override
	public List<BoardVO> selectAll() {
		System.out.println("selectAll()....");
		
		List<BoardVO> vos = new ArrayList<>();
		
		
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_board.SELECT_ALL);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setWnum(rs.getInt("wnum"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getTimestamp("wdate"));
				vo.setVcount(rs.getInt("vcount"));
				
				vos.add(vo);
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

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList()....");
		System.out.println("searchKey : " + searchKey);
		System.out.println("searchWord : " + searchWord);
		
		List<BoardVO> vos = new ArrayList<>();
		
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			if(searchKey.equals("title")) {
				pstmt = conn.prepareStatement(OracleSQL_board.SEARCH_LIST_TITLE);
			}else {
				pstmt = conn.prepareStatement(OracleSQL_board.SEARCH_LIST_CONTENT);
			}
			
			pstmt.setString(1, "%"+searchWord+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setWnum(rs.getInt("wnum"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getTimestamp("wdate"));
				vo.setVcount(rs.getInt("vcount"));
				
				vos.add(vo);
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

	@Override
	public void vcountUp(BoardVO vo) {
		System.out.println("vcountUp()...." + vo);
		
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_board.UPDATE_VCOUNT);
			pstmt.setInt(1, vo.getWnum());
			
			pstmt.executeUpdate();
			
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
	}

}
