package test.com.singleton;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.singleton.bean.TestBean;
import test.com.singleton.bean.TestBean2;
import test.com.singleton.bean.TestBean3;
import test.com.singleton.bean.TestBean4;
import test.com.singleton.bean.TestBean5;
import test.com.singleton.bean.TestBean6;
import test.com.singleton.bean.TestBean7;
import test.com.singleton.component.TestComponent;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	TestComponent tc;
	
	@Autowired
	TestBean tb01;
	
	@Autowired
	TestBean tb02;
	
	@Autowired
	TestBean tb03;
	
	@Autowired
	TestBean2 test02;
	
	@Autowired
	TestBean3 test03;
	
	@Autowired
	TestBean4 test04;
	
	@Autowired
	TestBean5 test05;
	
	@Autowired
	TestBean6 test0601;
	
	@Autowired
	TestBean6 test0602;
	
	@Autowired
	TestBean7 test07;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		logger.info(tc.name);
		tc.test();
		
		logger.info(tb01.name);
		tb01.test2();
		
		logger.info(tb02.name);
		tb02.test2();
		
		logger.info("{} , {}",tb03.name,tb03.age);
		tb03.test2();
		
		
		logger.info("{}",test02);
		
		logger.info("{}",test03);
		
		logger.info("{}",test04);

		logger.info("{}",test05);
		
		logger.info("{}",test0601);
		logger.info("{}",test0602);
		
		logger.info("{}",test07);
		
		
		
		return "home";
	}
	
}
