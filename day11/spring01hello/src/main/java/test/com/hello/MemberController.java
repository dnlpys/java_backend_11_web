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
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		logger.info("/m_insert.do");
		
		return "member/insert";
	}//end m_insert
	
	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update() {
		logger.info("/m_update.do");
		
		return "member/update";
	}//end m_insert
	
}//end class
