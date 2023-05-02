package test.com.movie.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.com.board.model.OracleJDBC;

public class MovieDAOimpl implements MovieDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MovieDAOimpl() {
		System.out.println("MovieDAOimpl()....");
		try {
			Class.forName(OracleJDBC.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MovieVO> selectAll() {
		System.out.println("selectAll()....");
		List<MovieVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(OracleJDBC.URL, OracleJDBC.USER, OracleJDBC.PASSWORD);
			System.out.println("conn successed......");

			pstmt = conn.prepareStatement(OracleSQL_movie.SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getInt("price"));
				vo.setProducer(rs.getString("producer"));
				vos.add(vo);
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
