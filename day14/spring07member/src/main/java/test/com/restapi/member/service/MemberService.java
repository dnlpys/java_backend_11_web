package test.com.restapi.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import test.com.restapi.member.model.MemberDAO;
import test.com.restapi.member.model.MemberVO;

@Service
@Slf4j
public class MemberService {

	@Autowired
	MemberDAO dao;
	
	public MemberService() {
		log.info("MemberService()...");
	}

	public List<MemberVO> selectAll() {
		return dao.selectAll();
	}

	public MemberVO selectOne(MemberVO vo) {
		return dao.selectOne(vo);
	}

	public List<MemberVO> searchList(String searchKey, String searchWord) {
		return dao.searchList(searchKey, searchWord);
	}

	public int insert(MemberVO vo) {
		return dao.insert(vo);
	}

	public int update(MemberVO vo) {
		return dao.update(vo);
	}

	public int delete(MemberVO vo) {
		return dao.delete(vo);
	}

	public MemberVO login(MemberVO vo) {
		return dao.login(vo);
	}
	
	
	
}
