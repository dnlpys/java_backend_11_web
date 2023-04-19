package test.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAOimpl() {
		System.out.println("MemberDAOimpl()...");
		try {
			Class.forName(OracleJDBC.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(MemberVO vo) {
		System.out.println("insert()..." + vo);
		int flag = 0;

		return flag;
	}

	@Override
	public int update(MemberVO vo) {
		System.out.println("update()..." + vo);
		int flag = 0;

		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		System.out.println("delete()..." + vo);
		int flag = 0;

		return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("selectOne()..." + vo);

		MemberVO vo2 = new MemberVO();

		return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		System.out.println("selectAll()...");
		List<MemberVO> vos = new ArrayList<>();
				
		try {
			conn = DriverManager.getConnection(
					OracleJDBC.URL,OracleJDBC.USER,OracleJDBC.PASSWORD);
			System.out.println("conn successed......");
			
			pstmt = conn.prepareStatement(OracleSQL_member.SELECT_ALL);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				
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
		
	}//end selectAll

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList()...");
		System.out.println("searchKey : "+searchKey);
		System.out.println("searchWord : "+searchWord);
		
		List<MemberVO> vos = new ArrayList<>();

		return vos;
	}

}
