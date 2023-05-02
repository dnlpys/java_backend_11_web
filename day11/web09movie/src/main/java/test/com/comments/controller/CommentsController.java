package test.com.comments.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import test.com.comments.model.CommentsDAO;
import test.com.comments.model.CommentsDAOimpl;
import test.com.comments.model.CommentsVO;
import test.com.member.model.MemberVO;

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
			
		}else if (sPath.equals("/c_selectAll.do")) {

			String wnum = request.getParameter("wnum")==null?"0":request.getParameter("wnum");
			System.out.println("param.wnum:"+wnum);
			
			CommentsVO vo = new CommentsVO();
			vo.setWnum(Integer.parseInt(wnum));
			
			List<CommentsVO> vos = dao.selectAll(vo);
			System.out.println(vos);
			
			String rows = new Gson().toJson(vos);
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(rows);
		}else if(sPath.equals("/c_deleteOK.do")) {
			String cnum = request.getParameter("cnum")==null?"0":request.getParameter("cnum");
			System.out.println("param.cnum:"+cnum);
			
			CommentsVO vo = new CommentsVO();
			vo.setCnum(Integer.parseInt(cnum));
			
			int result = dao.delete(vo);
			System.out.println("result:"+result);
			
			String msg = "";
			if(result==1) {
				msg = "{\"result\":1}"; //{"result":1}
			}else {
				msg = "{\"result\":0}"; //{"result":0}
			}
			
			response.getWriter().append(msg);
			
		}else if(sPath.equals("/c_updateOK.do")) {
			String cnum = request.getParameter("cnum")==null?"0":request.getParameter("cnum");
			String content = request.getParameter("content");
			System.out.println("param.cnum:"+cnum);
			System.out.println("param.content:"+content);
			
			CommentsVO vo = new CommentsVO();
			vo.setCnum(Integer.parseInt(cnum));
			vo.setContent(content);
			
			int result = dao.update(vo);
			System.out.println("result:"+result);
			
			String msg = "";
			if(result==1) {
				msg = "{\"result\":1}"; //{"result":1}
			}else {
				msg = "{\"result\":0}"; //{"result":0}
			}
			
			response.getWriter().append(msg);
			
		}
		
	}//end doGet...

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
