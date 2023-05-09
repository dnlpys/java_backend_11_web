package test.com.lombok;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * https://projectlombok.org/  >> download >>Download 1.18.26
 * C:\\MULTI_EDU\\utils 에 저장 >> cmd >> java -jar lombok.jar
 * sts.exe 경로설정하고 install >> sts실행
 * 
 */
@Controller
@Slf4j
public class HomeController {
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		TestVO vo1 = new TestVO(22,"lee",44);
		TestVO vo2 = new TestVO(22,"lee",44);
//		vo.setNum(11);
//		vo.setName("kim");
//		vo.setAge(33);
		log.info(vo1.toString());
		log.info(vo2.toString());
		log.info("{}",vo1.equals(vo2));//속성비교
		log.info("{}",vo1 == vo2);//주소비교
		
		
		return "home";
	}
	
}
