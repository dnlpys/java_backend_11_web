package test.com.reservation.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.board.model.OracleJDBC;

public class ReservationDAOimpl implements ReservationDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ReservationDAOimpl() {
		System.out.println("ReservationDAOimpl()....");
		try {
			Class.forName(OracleJDBC.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(ReservationVO vo) {
		System.out.println("insert()...." + vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(OracleJDBC.URL, OracleJDBC.USER, OracleJDBC.PASSWORD);
			System.out.println("conn successed......");

			pstmt = conn.prepareStatement(OracleSQL_reservation.INSERT);
			pstmt.setString(1, vo.getUser_id());
			pstmt.setInt(2, vo.getMovie_num());
			pstmt.setString(3, vo.getMovie_date());
			pstmt.setInt(4, vo.getMcount());

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally
		return flag;
	}

	@Override
	public int update(ReservationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ReservationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReservationVO selectOne(ReservationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservationVO> selectAll(ReservationVO vo) {
		System.out.println("selectAll()...."+vo);

		List<ReservationVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(OracleJDBC.URL, OracleJDBC.USER, OracleJDBC.PASSWORD);
			System.out.println("conn successed......");

			pstmt = conn.prepareStatement(OracleSQL_reservation.SELECT_ALL);
			pstmt.setString(1, vo.getUser_id());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReservationVO vo2 = new ReservationVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setMovie_num(rs.getInt("movie_num"));
				vo2.setMovie_date(rs.getTimestamp("movie_date").toString());
				vo2.setRegdate(rs.getTimestamp("regdate"));
				vo2.setMcount(rs.getInt("mcount"));
				vo2.setTitle(rs.getString("title"));
				vo2.setUser_id(rs.getString("user_id"));

				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
	}

}
