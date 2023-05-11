package test.com.interceptor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class TestController {

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {
		log.info("/insert.do");

		return "insert";
	}

	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		log.info("/selectAll.do");

		return "selectAll";
	}
	
	@RequestMapping(value = "/selectOne.do", method = RequestMethod.GET)
	public String selectOne(Model model) {
		log.info("/selectOne.do");
		
		return "selectOne";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		log.info("/login.do");

		return "login";
	}

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		log.info("/logout.do");

//		session.removeAttribute("user_id");
		session.invalidate();

		return "redirect:login.do";
	}

	@RequestMapping(value = "/loginOK.do", method = RequestMethod.POST)
	public String loginOK(String id, String pw) {
		log.info("/loginOK.do....{},{}", id, pw);

		// 로그인 아이디 비번이 맞다고 가정하고 Session 에 저장
		session.setAttribute("user_id", id);
//		session.setMaxInactiveInterval(5);

		return "redirect:selectAll.do";
	}

}
