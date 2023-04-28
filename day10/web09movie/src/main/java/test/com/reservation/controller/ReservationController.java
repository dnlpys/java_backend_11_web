package test.com.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.board.model.BoardVO;
import test.com.reservation.model.ReservationDAO;
import test.com.reservation.model.ReservationDAOimpl;
import test.com.reservation.model.ReservationVO;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet({"/re_selectAll.do", "/re_insert.do", "/re_insertOK.do", "/re_update.do", 
	"/re_updateOK.do", "/re_deleteOK.do", "/re_selectOne.do" })
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ReservationDAO dao = new ReservationDAOimpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);

		if (sPath.compareTo("/re_selectAll.do") == 0) {

			String user_id = request.getParameter("user_id");
			System.out.println("param.user_id:"+user_id);
			
			ReservationVO vo = new ReservationVO();
			vo.setUser_id(user_id);
			
			List<ReservationVO> vos = dao.selectAll(vo);
			for (ReservationVO x : vos) {
				System.out.println(x);
			}
			request.setAttribute("vos", vos);

//			request.getRequestDispatcher("reservation/selectAll.jsp").forward(request, response);
		}else if (sPath.compareTo("/re_insert.do") == 0) {

			request.getRequestDispatcher("reservation/insert.jsp").forward(request, response);
		}else if (sPath.compareTo("/re_insertOK.do") == 0) {

			String user_id = request.getParameter("user_id");
			String movie_num = request.getParameter("movie_num");
			String movie_date = request.getParameter("movie_date");
			String mcount = request.getParameter("mcount");
			System.out.println("param.user_id:" + user_id);
			System.out.println("param.movie_num:" + movie_num);
			System.out.println("param.movie_date:" + movie_date);
			System.out.println("param.mcount:" + mcount);

			ReservationVO vo = new ReservationVO();
			vo.setUser_id(user_id);
			vo.setMovie_num(Integer.parseInt(movie_num));
			vo.setMovie_date(movie_date);
			vo.setMcount(Integer.parseInt(mcount));
			int result = dao.insert(vo);
			System.out.println("result:" + result);
			if (result == 1)
				response.sendRedirect("re_selectAll.do");
			else
				response.sendRedirect("re_insert.do");
		}  
		
		
		
	}//end doGet()...

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
