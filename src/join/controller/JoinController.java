package join.controller;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import join.model.JoinDto;
import join.service.JoinService;
import join.service.JoinServiceImpl;

/**
 * Servlet implementation class Join_Controller
 */
@WebServlet("*.join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public JoinController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionJoin(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionJoin(request, response);
	}
	
	protected void actionJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String commend = uri.substring(conPath.length());
		
		if (commend.equals("/insert.join")) {
			System.out.println("insert 시작");
			JoinDto joinDto = new JoinDto((String)request.getParameter("pw"), 
										  (String)request.getParameter("nickName"),
										  (String)request.getParameter("userName"),
										  (String)request.getParameter("eMail"),
										  (String)request.getParameter("telNumber"));
			
			request.setAttribute("joinData", joinDto);
			JoinService joinService = new JoinServiceImpl();
			joinService.excute(request, response);
			HttpSession session = request.getSession();
			//세션에 유저 이름을 띄우면 회원가입시 모든 화면에서 했다면 볼수있게 테스트
			session.setAttribute("userData", joinDto.getUserName());
			response.sendRedirect("newindex.jsp");
			
		}
	}

}
