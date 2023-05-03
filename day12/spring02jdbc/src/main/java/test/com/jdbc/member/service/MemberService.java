package test.com.jdbc.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import test.com.jdbc.member.controller.MemberController;
import test.com.jdbc.member.model.MemberDAO;
import test.com.jdbc.member.model.MemberVO;

//@Component
@Service
public class MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	MemberDAO dao;
	
	public MemberService() {
		logger.info("MemberService()...");
	}

	public List<MemberVO> selectAll() {
		return dao.selectAll();
	}

	public MemberVO selectOne(MemberVO vo) {
		return dao.selectOne(vo);
	}
	
	
	
}
