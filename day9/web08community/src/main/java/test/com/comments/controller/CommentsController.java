package test.com.comments.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.comments.model.CommentsDAO;
import test.com.comments.model.CommentsDAOimpl;
import test.com.comments.model.CommentsVO;

/**
 * Servlet implementation class CommentsController
 */
@WebServlet({ "/c_selectAll.do", "/c_insertOK.do", "/c_updateOK.do", "/c_deleteOK.do" })
public class CommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CommentsDAO dao = new CommentsDAOimpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		if(sPath.equals("/c_insertOK.do")) {
			String wnum = request.getParameter("wnum");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			System.out.println("param.wnum:"+wnum);
			System.out.println("param.content:"+content);
			System.out.println("param.writer:"+writer);
			
			CommentsVO vo = new CommentsVO();
			vo.setWnum(Integer.parseInt(wnum));
			vo.setContent(content);
			vo.setWriter(writer);
			
			int result = dao.insert(vo);
			System.out.println("result:"+result);
			
			String msg = "";
			if(result==1) {
				msg = "{\"result\":1}"; //{"result":1}
			}else {
				msg = "{\"result\":0}"; //{"result":0}
			}
			
			response.getWriter().append(msg);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
