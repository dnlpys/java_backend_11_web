package test.com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet({  "/b_insert.do", "/b_insertOK.do", "/b_update.do", 
	"/b_updateOK.do", "/b_deleteOK.do", "/b_selectAll.do",
		"/b_selectOne.do", "/b_searchList.do" })
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

		if (sPath.compareTo("/b_selectAll.do") == 0) {

			List<BoardVO> vos = dao.selectAll();
			for (BoardVO x : vos) {
				System.out.println(x);
			}
			request.setAttribute("vos", vos);

			request.getRequestDispatcher("board/selectAll.jsp").forward(request, response);
		} else if (sPath.compareTo("/b_selectOne.do") == 0) {

			String wnum = request.getParameter("wnum");
			System.out.println("param.wnum:" + wnum);

			BoardVO vo = new BoardVO();
			vo.setWnum(Integer.parseInt(wnum));

			dao.vcountUp(vo);

			BoardVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);

			request.setAttribute("vo2", vo2);

			request.getRequestDispatcher("board/selectOne.jsp").forward(request, response);
		} else if (sPath.compareTo("/b_update.do") == 0) {

			String wnum = request.getParameter("wnum");
			System.out.println("param.wnum:" + wnum);

			BoardVO vo = new BoardVO();
			vo.setWnum(Integer.parseInt(wnum));

			BoardVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);

			request.setAttribute("vo2", vo2);

			request.getRequestDispatcher("board/update.jsp").forward(request, response);
		} else if (sPath.compareTo("/b_updateOK.do") == 0) {

			String wnum = request.getParameter("wnum");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println("param.wnum:" + wnum);
			System.out.println("param.title:" + title);
			System.out.println("param.content:" + content);

			BoardVO vo = new BoardVO();
			vo.setWnum(Integer.parseInt(wnum));
			vo.setTitle(title);
			vo.setContent(content);
			int result = dao.update(vo);
			System.out.println("result:" + result);
			if (result == 1)
				response.sendRedirect("b_selectOne.do?wnum=" + wnum);
			else
				response.sendRedirect("b_update.do?wnum=" + wnum);
		} else if (sPath.compareTo("/b_deleteOK.do") == 0) {

			String wnum = request.getParameter("wnum");
			System.out.println("param.wnum:" + wnum);

			BoardVO vo = new BoardVO();
			vo.setWnum(Integer.parseInt(wnum));
			int result = dao.delete(vo);
			System.out.println("result:" + result);
			if (result == 1)
				response.sendRedirect("b_selectAll.do");
			else
				response.sendRedirect("b_selectOne.do?wnum=" + wnum);
		} else if (sPath.compareTo("/b_insert.do") == 0) {
			request.getRequestDispatcher("board/insert.jsp").forward(request, response);
		} else if (sPath.compareTo("/b_insertOK.do") == 0) {

			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			System.out.println("param.title:" + title);
			System.out.println("param.content:" + content);
			System.out.println("param.writer:" + writer);

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);
			int result = dao.insert(vo);
			System.out.println("result:" + result);
			if (result == 1)
				response.sendRedirect("b_selectAll.do");
			else
				response.sendRedirect("b_insert.do");
		} else if (sPath.compareTo("/b_searchList.do") == 0) {

			
			String searchKey = request.getParameter("searchKey");
			String searchWord = request.getParameter("searchWord");
			
			System.out.println("param.searchKey:"+searchKey);
			System.out.println("param.searchWord:"+searchWord);
			
			List<BoardVO> vos = dao.searchList(searchKey,searchWord);
			for (BoardVO x : vos) {
				System.out.println(x);
			}
			request.setAttribute("vos", vos);

			request.getRequestDispatcher("board/selectAll.jsp").forward(request, response);
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
