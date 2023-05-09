package test.com.restapi.member.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemberDAOimpl implements MemberDAO {

	@Autowired
	SqlSession sqlSession;

	public MemberDAOimpl() {
		log.info("MemberDAOimpl()...");
	}

	@Override
	public int insert(MemberVO vo) {
		log.info("insert()..." + vo);
		int flag = sqlSession.insert("INSERT", vo);

		return flag;
	}

	@Override
	public int update(MemberVO vo) {
		log.info("update()..." + vo);
		int flag = sqlSession.update("UPDATE", vo);

		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		log.info("delete()..." + vo);
		int flag = sqlSession.delete("DELETE", vo);

		return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		log.info("selectOne()..." + vo);

		MemberVO vo2 = sqlSession.selectOne("SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info("selectAll()...");
		List<MemberVO> vos = sqlSession.selectList("SELECT_ALL");

		return vos;

	}// end selectAll

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey : " + searchKey);
		log.info("searchWord : " + searchWord);

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
		log.info("idCheck()..." + vo);

		MemberVO vo2 = null;

		return vo2;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		log.info("login()..." + vo);

		MemberVO vo2 = sqlSession.selectOne("LOGIN", vo);

		return vo2;
	}

}
