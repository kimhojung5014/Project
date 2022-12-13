package board.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDto;
import board.service.BoardListService;
import board.service.BoardListServiceImpl;


/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String commend = uri.substring(conPath.length());
		
		if (commend.equals("/list.board")) {
			
			ArrayList<BoardDto>arrayList = new ArrayList<BoardDto>();
			BoardListService boardListService = new BoardListServiceImpl();
			arrayList =  boardListService.execute(request, response);
			request.setAttribute("arrayList", arrayList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("board.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}
