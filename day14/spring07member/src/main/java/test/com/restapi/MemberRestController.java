package test.com.restapi;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import test.com.restapi.member.model.MemberVO;
import test.com.restapi.member.service.MemberService;

@Controller
@Slf4j
public class MemberRestController {


	@Autowired
	private MemberService service;


	// 객체리턴시는 produces 설정 제거할것
	@RequestMapping(value = "/json_vo.do", method = RequestMethod.GET)
	@ResponseBody
	public MemberVO json_vo() {
		log.info("/json_vo.do");

		// selectOne
		MemberVO vo = new MemberVO();
		vo.setNum(11);
		vo.setId("admin");
		vo.setPw("hi1111");
		vo.setName("kim");
		vo.setTel("02");
		log.info("{}", vo);

		return vo;
	}
	
	// 객체리턴시는 produces 설정 제거할것
	@RequestMapping(value = "/json_selectOne.do", method = RequestMethod.GET)
	@ResponseBody
	public MemberVO json_selectOne(MemberVO vo) {
		log.info("/json_selectOne.do");
		log.info("{}",vo);
		
		// selectOne
		MemberVO vo2 = service.selectOne(vo);
		log.info("{}", vo2);
		
		return vo2;
	}

	// 객체리턴시는 produces 설정 제거할것
	@RequestMapping(value = "/json_vos.do", method = RequestMethod.GET)
	@ResponseBody
	public List<MemberVO> json_vos() {
		log.info("/json_vos.do");
		// selectAll,searchList
		List<MemberVO> vos = new ArrayList<MemberVO>();

		for (int i = 0; i < 5; i++) {
			MemberVO vo = new MemberVO();
			vo.setNum(11 + i);
			vo.setId("admin" + i);
			vo.setPw("hi1111" + i);
			vo.setName("kim" + i);
			vo.setTel("02" + i);

			vos.add(vo);
		}
		return vos;
	}

	
	@RequestMapping(value = "/json_selectAll.do", method = RequestMethod.GET)
	@ResponseBody
	public List<MemberVO> json_selectAll() {
		log.info("/json_selectAll.do");
		// selectAll,searchList
		List<MemberVO> vos = service.selectAll();
		log.info("vos.size():{}",vos.size());
		return vos;
	}


	@RequestMapping(value = "/json_result.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> json_result() {
		log.info("/json_result.do");

		// insertOK,updateOK,deleteOK,idCheck

		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "OK");
		return map;
	}
	
	
	@RequestMapping(value = "/json_idCheck.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> json_idCheck(MemberVO vo) {
		log.info("/json_idCheck.do");
		log.info("{}",vo);//id
		
		MemberVO vo2 = service.idCheck(vo);
		log.info("{}",vo2);//null or not null
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "OK");
		return map;
	}

}
