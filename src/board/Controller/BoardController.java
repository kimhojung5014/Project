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
import board.service.BoardGetService;
import board.service.BoardGetServiceImpl;
import board.service.BoardInsertService;
import board.service.BoardInsertServiceImpl;
import board.service.BoardListService;
import board.service.BoardListServiceImpl;
import join.model.JoinDto;


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
		if (commend.equals("/insert.board")) {
			String category = request.getParameter("category");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			JoinDto joinDto = (JoinDto)request.getSession().getAttribute("userData");
			System.out.println(category);
			System.out.println(title);
			System.out.println(content);
			System.out.println(joinDto.getNickName());
			//Dto 객체에 값 4개 담아서 전달하면 구현클래스에서 값 받아서 Dao 메소드 아규먼트에 값 넣는다.
			BoardDto boardDto = new BoardDto();
			boardDto.setCatagory(category);
			boardDto.setTitle(title);
			boardDto.setContent(content);
			boardDto.setWriter(joinDto.getNickName());
			request.setAttribute("boardDto", boardDto);
			BoardInsertService boardInsertService = new BoardInsertServiceImpl();
			boardInsertService.execute(request, response);
			response.sendRedirect("/Project/list.board");
			
		}
		if (commend.equals("/inToBoard.board")) {
			System.out.println("inToBoard 컨트롤러");
			int writeNum = Integer.parseInt(request.getParameter("writeNum"));
			request.setAttribute("writeNum", writeNum);
			BoardGetService boardGetService = new BoardGetServiceImpl();
			BoardDto boardDto =  boardGetService.execute(request, response);
			
			request.setAttribute("boardDto", boardDto);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("inToBoard.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}
}
