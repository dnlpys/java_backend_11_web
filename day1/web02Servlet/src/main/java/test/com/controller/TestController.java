package test.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestController
 */
//servletPath 들을(를) 등록하는 어노테이션
@WebServlet({"/index.do","/test.do",
	"/insert.do","/selectAll.do","/insertOK.do",
	"/selectOne.do","/updateOK.do","/deleteOK.do",
	"/result.do","/result2.do"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter()
//		.append("Served at: ")
//		.append(request.getContextPath())
//		.append(request.getServletPath());//서블릿 경로확인
		
		//서블릿을 사용하면 
		//1.프론트앤드와 백앤드를 컨트롤 가능
		//2.view page 보여지는 파일의 확장자와 경로를 숨길수 있다.
		 
		
		System.out.println(request.getServletPath());
		String sPath = request.getServletPath();
		if(sPath.equals("/index.do")) {
			//요청한 url에 원하는 페이지를 화면에 보여주기
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(sPath.equals("/test.do")) {
			request.getRequestDispatcher("test/test.jsp").forward(request, response);
		}else if(sPath.equals("/insert.do")) {
			request.getRequestDispatcher("test/insert.jsp").forward(request, response);
		}else if(sPath.equals("/selectAll.do")) {
			request.getRequestDispatcher("member/selectAll.jsp").forward(request, response);
		}else if(sPath.equals("/selectOne.do")) {
			request.getRequestDispatcher("member/selectOne.jsp").forward(request, response);
		}else if(sPath.equals("/insertOK.do")) {
			//요청한 url에 해당하는 로직처리 후 기존에 있는 서블릿패스로 전환
			response.sendRedirect("selectAll.do");
		}else if(sPath.equals("/updateOK.do")) {
			response.sendRedirect("selectOne.do");
		}else if(sPath.equals("/deleteOK.do")) {
			response.sendRedirect("selectAll.do");
		}else if(sPath.equals("/result.do")) {
			response.getWriter()
			.append(request.getContextPath())
			.append(request.getServletPath());//서블릿 경로확인
		}else if(sPath.equals("/result2.do")) {
			response.getWriter()
			.append("{\"id\":\"admin\",\"name\":\"lee\"}");//{"id":"admin","name":"lee"}
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
