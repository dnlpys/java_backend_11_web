package test.com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.MemberDAO;
import test.com.model.MemberDAOimpl;
import test.com.model.MemberVO;
/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/index.do", "/insert.do","/update.do", 
	"/selectAll.do", "/selectOne.do" ,
	"/insertOK.do","/updateOK.do","/deleteOK.do",
	"/result.do","/result2.do","/searchList.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO dao =  new MemberDAOimpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()....");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		if(sPath.equals("/index.do")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(sPath.equals("/insert.do")) {
			request.getRequestDispatcher("member/insert.jsp").forward(request, response);
		}else if(sPath.equals("/update.do")) {
			
			String num = request.getParameter("num")==null?"0":request.getParameter("num");
			System.out.println("param.num:"+num);
			
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(num));
			
			MemberVO vo2 = dao.selectOne(vo);
			
			
			request.setAttribute("vo2", vo2);
			
			
			request.getRequestDispatcher("member/update.jsp").forward(request, response);
		}else if(sPath.equals("/selectAll.do")) {
			
						
			
			List<MemberVO> vos = dao.selectAll();

			
			System.out.println(vos);
			request.setAttribute("vos", vos);
			
			request.getRequestDispatcher("member/selectAll.jsp").forward(request, response);
		}else if(sPath.equals("/searchList.do")) {
			
			String searchKey = request.getParameter("searchKey");
			String searchWord = request.getParameter("searchWord");
			
			System.out.println("searchKey:"+searchKey);
			System.out.println("searchWord:"+searchWord);
			
			List<MemberVO> vos = dao.searchList(searchKey,searchWord);
			
			
			System.out.println(vos);
			request.setAttribute("vos", vos);
			
			request.getRequestDispatcher("member/selectAll.jsp").forward(request, response);
		}else if(sPath.equals("/selectOne.do")) {
			
			String num = request.getParameter("num")==null?"0":request.getParameter("num");
			System.out.println("param.num:"+num);
			
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(num));
			
			
			MemberVO vo2 = dao.selectOne(vo);
			
			System.out.println(vo2);
			
			request.setAttribute("vo2", vo2);
			
			request.getRequestDispatcher("member/selectOne.jsp").forward(request, response);
		}else if(sPath.equals("/insertOK.do")) {
			
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			
			
			System.out.println("param.id:"+id);
			System.out.println("param.pw:"+pw);
			System.out.println("param.name:"+name);
			System.out.println("param.tel:"+tel);
			
			MemberVO vo = new MemberVO();
			
			vo.setId(id);
			vo.setPw(pw);
			vo.setName(name);
			vo.setTel(tel);
			
			int result = dao.insert(vo);
			System.out.println("result:"+result);
			if(result==1)	
				response.sendRedirect("selectAll.do");
			else
				response.sendRedirect("index.do");
				
		}else if(sPath.equals("/updateOK.do")) {
			String num = request.getParameter("num")==null?"0":request.getParameter("num");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			
			System.out.println("param.num:"+num);
			System.out.println("param.id:"+id);
			System.out.println("param.pw:"+pw);
			System.out.println("param.name:"+name);
			System.out.println("param.tel:"+tel);
			
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(num));
			vo.setId(id);
			vo.setPw(pw);
			vo.setName(name);
			vo.setTel(tel);
			
			int result = dao.update(vo);
			System.out.println("result:"+result);
			if(result==1)	
				response.sendRedirect("selectOne.do?num="+num);
			else
				response.sendRedirect("update.do?num="+num);
			
		}else if(sPath.equals("/deleteOK.do")) {
			
			String num = request.getParameter("num")==null?"0":request.getParameter("num");
			System.out.println("param.num:"+num);
			
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(num));
			
			int result = dao.delete(vo);
			System.out.println("result:"+result);
			if(result==1)
				response.sendRedirect("selectAll.do");
			else
				response.sendRedirect("selectOne.do?num="+num);
		}else if(sPath.equals("/result.do")) {
			response.getWriter()
			.append(request.getContextPath())
			.append(request.getServletPath());
		}else if(sPath.equals("/result2.do")) {
			response.getWriter()
			.append("{\"name\":\"kim\",\"age\":33}");//{"name":"kim","age":33}
		}
		
		
	}//end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()....");
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}//end doPost

}
