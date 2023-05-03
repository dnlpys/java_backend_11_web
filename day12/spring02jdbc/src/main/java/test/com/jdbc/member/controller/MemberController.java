package test.com.jdbc.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.jdbc.member.model.MemberDAO;
import test.com.jdbc.member.model.MemberDAOimpl;
import test.com.jdbc.member.model.MemberVO;
import test.com.jdbc.member.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	//DI-Dependency Injection : IoC(Inversion of Controller)
	@Autowired
	MemberService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		logger.info("/m_insert.do");
		
		return "member/insert";
	}//end m_insert
	
	@RequestMapping(value = "/m_insertOK.do", method = RequestMethod.GET)
	public String m_insertOK() {
		logger.info("/m_insertOK.do");
		
		return "redirect:m_selectAll.do";
	}//end m_insertOK
	
	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update() {
		logger.info("/m_update.do");
		
		return "member/update";
	}//end m_update
	
	@RequestMapping(value = "/m_updateOK.do", method = RequestMethod.GET)
	public String m_updateOK() {
		logger.info("/m_updateOK.do");
		
		return "redirect:m_selectOne.do";
	}//end m_updateOK
	
	@RequestMapping(value = "/m_deleteOK.do", method = RequestMethod.GET)
	public String m_deleteOK() {
		logger.info("/m_deleteOK.do");
		
		return "redirect:m_selectAll.do";
	}//end b_deleteOK
	
	@RequestMapping(value = "/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll() {
		logger.info("/m_selectAll.do");
		
		List<MemberVO> vos = service.selectAll();
		for (MemberVO x : vos) {
			logger.info(x.toString());
		}
		
		return "member/selectAll";
	}//end m_selectAll
	
	@RequestMapping(value = "/m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(String searchKey,String searchWord) {
		logger.info("/m_searchList.do");
		logger.info("searchKey : {}",searchKey);
		logger.info("searchWord : {}",searchWord);
		
		
		
		return "member/selectAll";
	}//end m_searchList
	
	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo) {
		logger.info("/m_selectOne.do...vo:{}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		logger.info(vo2.toString());
		
		return "member/selectOne";
	}//end m_selectOne
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("/login.do");
		
		return "member/login";
	}//end login
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		logger.info("/logout.do");
		
		return "redirect:home.do";
	}//end logout
	
}//end class
