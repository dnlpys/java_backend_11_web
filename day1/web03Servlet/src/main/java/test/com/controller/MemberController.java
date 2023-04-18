package test.com.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/index.do", "/insert.do", "/selectAll.do", "/selectOne.do" ,
	"/insertOK.do","/updateOK.do","/deleteOK.do",
	"/result.do","/result2.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		if(sPath.equals("/index.do")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(sPath.equals("/insert.do")) {
			request.getRequestDispatcher("member/insert.jsp").forward(request, response);
		}else if(sPath.equals("/selectAll.do")) {
			
			List<MemberVO> vos = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				MemberVO vo = new MemberVO();
				vo.setNum(1+i);
				vo.setId("admin"+(1+i));
				vo.setPw("hi111"+(1+i));
				vo.setName("kim11"+(1+i));
				vo.setTel("011"+(1+i));
				
				vos.add(vo);
			}
			
			System.out.println(vos);
			request.setAttribute("vos", vos);
			
			request.getRequestDispatcher("member/selectAll.jsp").forward(request, response);
		}else if(sPath.equals("/selectOne.do")) {
			
			String num = request.getParameter("num");
			System.out.println("param.num:"+num);
			
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(num));
			
			MemberVO vo2 = new MemberVO();
			vo2.setNum(1);
			vo2.setId("admin");
			vo2.setPw("hi111");
			vo2.setName("kim11");
			vo2.setTel("011");
			
			request.setAttribute("vo2", vo2);
			
			request.getRequestDispatcher("member/selectOne.jsp").forward(request, response);
		}else if(sPath.equals("/insertOK.do")) {
			
			
			//response.sendRedirect("selectAll.do");
		}else if(sPath.equals("/updateOK.do")) {
			response.sendRedirect("selectOne.do");
		}else if(sPath.equals("/deleteOK.do")) {
			response.sendRedirect("selectAll.do");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
