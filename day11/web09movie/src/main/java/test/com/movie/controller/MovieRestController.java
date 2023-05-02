package test.com.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import test.com.member.model.MemberVO;
import test.com.movie.model.MovieDAO;
import test.com.movie.model.MovieDAOimpl;
import test.com.movie.model.MovieVO;

/**
 * Servlet implementation class MovieRestController
 */
@WebServlet("/mv_selectAll.do")
public class MovieRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MovieDAO dao = new MovieDAOimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieRestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doGet()....");

		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		if (sPath.equals("/mv_selectAll.do")) {

			List<MovieVO> vos = dao.selectAll();
			System.out.println(vos);
			
			String rows = new Gson().toJson(vos);
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(rows);
		}
		
		
	}//end doGet()....

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
