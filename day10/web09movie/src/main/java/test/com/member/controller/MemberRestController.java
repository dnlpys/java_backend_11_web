package test.com.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/json_idCheck.do", "/json_selectAll.do" ,
	"/json_selectOne.do","/json_searchList.do"})
public class MemberRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao = new MemberDAOimpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberRestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()....");

		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		response.setHeader("Access-Control-Allow-Origin", "*");

		if (sPath.equals("/json_idCheck.do")) {

			String id = request.getParameter("id");
			System.out.println("param.id:" + id);
			MemberVO vo = new MemberVO();
			vo.setId(id);

			MemberVO vo2 = dao.idCheck(vo);
			System.out.println(vo2);
			
			//{"result":"OK"}
			Map<String, String> map = new HashMap<>();
			if (vo2 == null) {
				map.put("result", "OK");
			} else {
				map.put("result", "Not OK");
			}
			
			String txt = new Gson().toJson(map);
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(txt);

		} else if (sPath.equals("/json_selectAll.do")) {

			List<MemberVO> vos = dao.selectAll();
			System.out.println(vos);
			
			String rows = new Gson().toJson(vos);
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(rows);
		}else if (sPath.equals("/json_selectOne.do")) {

			String num = request.getParameter("num")==null?"0":request.getParameter("num");
			System.out.println("param.num:"+num);
			
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(num));
			
			MemberVO vo2 = dao.selectOne(vo);
			
			System.out.println(vo2);
			
			String row = new Gson().toJson(vo2);
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(row);
		}else if (sPath.equals("/json_searchList.do")) {

			String searchKey = request.getParameter("searchKey");
			String searchWord = request.getParameter("searchWord");
			System.out.println("param.searchKey : "+searchKey);
			System.out.println("param.searchWord : "+searchWord);
			
			List<MemberVO> vos = dao.searchList(searchKey,searchWord);
			System.out.println(vos);
			
			String rows = new Gson().toJson(vos);
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(rows);
		}

	}// end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()....");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}// end doPost

}
