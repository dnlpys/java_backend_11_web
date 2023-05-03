package test.com.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		logger.info("/b_insert.do");
		
		return "board/insert";
	}//end b_insert
	
	@RequestMapping(value = "/b_update.do", method = RequestMethod.GET)
	public String b_update() {
		logger.info("/b_update.do");
		
		return "board/update";
	}//end b_insert
	
	@RequestMapping(value = "/b_selectAll.do", method = RequestMethod.GET)
	public String b_selectAll() {
		logger.info("/b_selectAll.do");
		
		return "board/selectAll";
	}//end b_insert
	
	@RequestMapping(value = "/b_selectOne.do", method = RequestMethod.GET)
	public String b_selectOne() {
		logger.info("/b_selectOne.do");
		
		return "board/selectOne";
	}//end b_insert
	
}//end class
