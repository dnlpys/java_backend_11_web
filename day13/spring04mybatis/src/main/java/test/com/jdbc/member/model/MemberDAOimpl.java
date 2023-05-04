package test.com.jdbc.member.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MemberDAOimpl implements MemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOimpl.class);

	@Autowired
	SqlSession sqlSession;

	public MemberDAOimpl() {
		logger.info("MemberDAOimpl()...");
	}

	@Override
	public int insert(MemberVO vo) {
		logger.info("insert()..." + vo);
		int flag = sqlSession.insert("INSERT", vo);

		return flag;
	}

	@Override
	public int update(MemberVO vo) {
		logger.info("update()..." + vo);
		int flag = sqlSession.update("UPDATE", vo);

		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		logger.info("delete()..." + vo);
		int flag = sqlSession.delete("DELETE", vo);

		return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		logger.info("selectOne()..." + vo);

		MemberVO vo2 = sqlSession.selectOne("SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		logger.info("selectAll()...");
		List<MemberVO> vos = sqlSession.selectList("SELECT_ALL");

		return vos;

	}// end selectAll

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		logger.info("searchList()...");
		logger.info("searchKey : " + searchKey);
		logger.info("searchWord : " + searchWord);

		List<MemberVO> vos = null;
		if (searchKey.equals("name")) {
			vos = sqlSession.selectList("SEARCH_LIST_NAME", "%" + searchWord + "%");
		} else {
			vos = sqlSession.selectList("SEARCH_LIST_TEL", "%" + searchWord + "%");
		}
		return vos;
	}

	@Override
	public MemberVO idCheck(MemberVO vo) {
		logger.info("idCheck()..." + vo);

		MemberVO vo2 = null;

		return vo2;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		logger.info("login()..." + vo);

		MemberVO vo2 = sqlSession.selectOne("LOGIN", vo);

		return vo2;
	}

}
