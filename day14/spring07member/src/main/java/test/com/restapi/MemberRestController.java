package test.com.restapi;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import test.com.restapi.member.model.MemberVO;

@Controller
@Slf4j
public class MemberRestController {

	@RequestMapping(value = "/json_test.do", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String json_test(Locale locale) {
		log.info("/json_test.do");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		log.info(formattedDate);

		return formattedDate;
	}

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

	// 객체리턴시는 produces 설정 제거할것
	@RequestMapping(value = "/json_map.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<MemberVO>> json_map() {
		log.info("/json_map.do");

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

		// selectAll
		Map<String, List<MemberVO>> map = new HashMap<String, List<MemberVO>>();
		map.put("vos", vos);
		return map;
	}

	// 객체리턴시는 produces 설정 제거할것
	@RequestMapping(value = "/json_result.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> json_result() {
		log.info("/json_result.do");

		// insertOK,updateOK,deleteOK,idCheck

		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "OK");
		return map;
	}

}
