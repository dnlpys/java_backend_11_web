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
	public String m_insertOK(MemberVO vo) {
		logger.info("/m_insertOK.do...{}",vo);
		
		int result = service.insert(vo);
		logger.info("result : {}",result);
		if(result==1) {
			return "redirect:m_selectAll.do";
		}else {
			return "redirect:m_insert.do";
		}
		
	}//end m_insertOK
	
	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo,Model model) {
		logger.info("/m_update.do...vo:{}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		logger.info(vo2.toString());
		
		model.addAttribute("vo2", vo2);
		
		return "member/update";
	}//end m_update
	
	@RequestMapping(value = "/m_updateOK.do", method = RequestMethod.POST)
	public String m_updateOK(MemberVO vo) {
		logger.info("/m_updateOK.do...{}",vo);
		
		int result = service.update(vo);
		logger.info("result : {}",result);
		if(result==1) {
			return "redirect:m_selectOne.do?num="+vo.getNum();
		}else {
			return "redirect:m_update.do"+vo.getNum();
		}
		
	}//end m_updateOK
	
	@RequestMapping(value = "/m_deleteOK.do", method = RequestMethod.GET)
	public String m_deleteOK(MemberVO vo) {
		logger.info("/m_deleteOK.do....{}",vo);
		
		int result = service.delete(vo);
		logger.info("result : {}",result);
		if(result==1) {
			return "redirect:m_selectAll.do";
		}else {
			return "redirect:m_selectOne.do?num="+vo.getNum();
		}
		
	}//end m_deleteOK
	
	@RequestMapping(value = "/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll(Model model) {
		logger.info("/m_selectAll.do");
		
		List<MemberVO> vos = service.selectAll();
		for (MemberVO x : vos) {
			logger.info(x.toString());
		}
		
		model.addAttribute("vos", vos);
		
		return "member/selectAll";
	}//end m_selectAll
	
	@RequestMapping(value = "/m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(String searchKey,String searchWord,Model model) {
		logger.info("/m_searchList.do");
		logger.info("searchKey : {}",searchKey);
		logger.info("searchWord : {}",searchWord);
		
		List<MemberVO> vos = service.searchList(searchKey,searchWord);
		for (MemberVO x : vos) {
			logger.info(x.toString());
		}
		
		model.addAttribute("vos", vos);
		
		return "member/selectAll";
	}//end m_searchList
	
	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo,Model model) {
		logger.info("/m_selectOne.do...vo:{}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		logger.info(vo2.toString());
		
		model.addAttribute("vo2", vo2);
		
		return "member/selectOne";
	}//end m_selectOne
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("/login.do");
		
		return "member/login";
	}//end login
	
	@RequestMapping(value = "/loginOK.do", method = RequestMethod.GET)
	public String loginOK(MemberVO vo) {
		logger.info("/loginOK.do...{}",vo);
		
		MemberVO vo2 = service.login(vo);
		
		if(vo2 == null) {
			return "redirect:login.do";
		}else {
			return "redirect:home.do";
		}
		
	}//end loginOK
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		logger.info("/logout.do");
		
		return "redirect:home.do";
	}//end logout
	
}//end class
