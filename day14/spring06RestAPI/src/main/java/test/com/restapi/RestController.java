package test.com.restapi;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class RestController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//한글처리 : html텍스트 text/html; charset=UTF-8  or 일반텍스트 text/plain; charset=UTF-8
	//한글처리 : json text/json; charset=UTF-8
	//한글처리 : xml text/xml; charset=UTF-8
	@RequestMapping(value = "/json_test.do", method = RequestMethod.GET,produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String json_test(Locale locale) {
		log.info("/json_test.do");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		log.info(formattedDate);
		
		return formattedDate;
	}
	
	//객체리턴시는 produces 설정 제거할것
	@RequestMapping(value = "/json_vo.do", method = RequestMethod.GET)
	@ResponseBody
	public TestVO json_vo() {
		log.info("/json_vo.do");
		
		TestVO vo = new TestVO(10, "lee10양", 100);
		log.info("{}",vo);
		
		return vo;
	}
	
	//객체리턴시는 produces 설정 제거할것
	@RequestMapping(value = "/json_vos.do", method = RequestMethod.GET)
	@ResponseBody
	public List<TestVO> json_vos() {
		log.info("/json_vos.do");
		
		List<TestVO> vos = new ArrayList<TestVO>();
		
		for (int i = 0; i < 5; i++) {
			TestVO vo = new TestVO(10+i, "lee10양"+i, 100+i);
			vos.add(vo);
		}
		return vos;
	}
	
	//객체리턴시는 produces 설정 제거할것
	@RequestMapping(value = "/json_map.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<TestVO>> json_map() {
		log.info("/json_map.do");
		
		List<TestVO> vos = new ArrayList<TestVO>();
		
		for (int i = 0; i < 5; i++) {
			TestVO vo = new TestVO(10+i, "lee10양"+i, 100+i);
			vos.add(vo);
		}
		
		Map<String, List<TestVO>> map = new HashMap<String, List<TestVO>>();
		map.put("vos", vos);
		return map;
	}
	
	
	
	
}
