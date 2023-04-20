package test.com.model;

import java.util.List;

public class BoardMain {

	public static void main(String[] args) {
		System.out.println("Board Main...");
		
		BoardDAO dao = new BoardDAOimpl();
		
		List<BoardVO> vos = dao.selectAll();
		for (BoardVO x : vos) {
			System.out.println(x);
		}
		
	}//end main

}//end class
