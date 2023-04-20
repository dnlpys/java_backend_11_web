package test.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.BoardDAO;
import test.com.model.BoardDAOimpl;
import test.com.model.BoardVO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet({ "/index.do", "/insert.do", "/insertOK.do", "/update.do", "/updateOK.do", "/deleteOK.do", "/selectAll.do",
		"/selectOne.do", "/searchList.do" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardDAO dao = new BoardDAOimpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		// sPath >> sysout
		String sPath = request.getServletPath();
		System.out.println(sPath);

		// if >> index.do
		if (sPath.compareTo("/index.do") == 0) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (sPath.compareTo("/selectAll.do") == 0) {
			
			List<BoardVO> vos = dao.selectAll();
			for (BoardVO x : vos) {
				System.out.println(x);
			}
			request.setAttribute("vos", vos);
			
			request.getRequestDispatcher("board/selectAll.jsp").forward(request, response);
		}else if (sPath.compareTo("/selectOne.do") == 0) {
			
			String wnum = request.getParameter("wnum");
			System.out.println("param.wnum:"+wnum);
			
			BoardVO vo = new BoardVO();
			vo.setWnum(Integer.parseInt(wnum));
			
			BoardVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);
			
			request.setAttribute("vo2", vo2);
			
			request.getRequestDispatcher("board/selectOne.jsp").forward(request, response);
		}else if (sPath.compareTo("/update.do") == 0) {
			
			String wnum = request.getParameter("wnum");
			System.out.println("param.wnum:"+wnum);
			
			BoardVO vo = new BoardVO();
			vo.setWnum(Integer.parseInt(wnum));
			
			BoardVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);
			
			request.setAttribute("vo2", vo2);
			
			request.getRequestDispatcher("board/update.jsp").forward(request, response);
		}else if (sPath.compareTo("/updateOK.do") == 0) {
			
			String wnum = request.getParameter("wnum");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println("param.wnum:"+wnum);
			System.out.println("param.title:"+title);
			System.out.println("param.content:"+content);
			
		}

	}// end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
