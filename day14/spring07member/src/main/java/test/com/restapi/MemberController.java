package test.com.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import test.com.restapi.member.model.MemberVO;
import test.com.restapi.member.service.MemberService;

@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService service;

	@RequestMapping(value = "/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll() {
		log.info("/m_selectAll.do");

		return "member/selectAll";
	}
	
	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo) {
		log.info("/m_selectOne.do");
		log.info("{}",vo);
		
		return "member/selectOne";
	}
	
	
	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		log.info("/m_insert.do");
		
		return "member/insert";
	}
	
	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update() {
		log.info("/m_update.do");
		
		return "member/update";
	}
	
	
	@RequestMapping(value = "/m_insertOK.do", 
			method = RequestMethod.POST)
	public String m_insertOK(MemberVO vo) {
		log.info("/m_insertOK.do");
		log.info("{}",vo);
		
		int result = service.insert(vo);
		log.info("result:{}",result);
		
		if(result==1)
			return "redirect:m_selectAll.do";
		else
			return "redirect:m_insert.do";
	}
	
	@RequestMapping(value = "/m_updateOK.do", 
			method = RequestMethod.POST)
	public String m_updateOK(MemberVO vo) {
		log.info("/m_updateOK.do");
		log.info("{}",vo);
		
		int result = service.update(vo);
		log.info("result:{}",result);
		
		if(result==1)
			return "redirect:m_selectOne.do?num="+vo.getNum();
		else
			return "redirect:m_update.do?num="+vo.getNum();
	}
	
	@RequestMapping(value = "/m_deleteOK.do", 
			method = RequestMethod.GET)
	public String m_deleteOK(MemberVO vo) {
		log.info("/m_deleteOK.do");
		log.info("{}",vo);
		
		int result = service.delete(vo);
		log.info("result:{}",result);
		
		if(result==1)
			return "redirect:m_selectAll.do";
		else
			return "redirect:m_selectOne.do?num="+vo.getNum();
	}

}
