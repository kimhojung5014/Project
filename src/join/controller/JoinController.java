package join.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.websocket.Session;

import join.model.JoinDto;
import join.service.IdCheckImpl;
import join.service.IdCheckService;
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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String commend = uri.substring(conPath.length());
		
		if (commend.equals("/insert.join")) {
			System.out.println("insert 시작");
			JoinDto joinDto = new JoinDto((String)request.getParameter("userId"),
										  (String)request.getParameter("pw"), 
										  (String)request.getParameter("nickName"),
										  (String)request.getParameter("userName"),
										  (String)request.getParameter("eMail"),
										  (String)request.getParameter("telNumber"));
	
			request.setAttribute("joinData", joinDto);
			JoinService joinService = new JoinServiceImpl();
			joinService.excute(request, response);
			response.sendRedirect("login.jsp");
			
		}
		if (commend.equals("/idCheck.join")) {
			System.out.println("idCheck 시작");
			System.out.println("컨트롤러에서 받는 아이디 "+request.getParameter("id"));
			String userId =  request.getParameter("id");
			request.setAttribute("userId", userId);
			IdCheckService  idCheckService = new IdCheckImpl();
			
			if (idCheckService.execute(request, response)) {
				System.out.println("사용가능한 아이디");
				System.out.println("중복된 아이디");
				out.println("<html><head><title>확인창</title>");
				out.println("<script>alert('사용가능한 ID입니다.');history.go(-1);</script>");
				out.println("</head><body></body><html>");
			
			}else {
				System.out.println("중복된 아이디");
				out.println("<html><head><title>확인창</title>");
				out.println("<script>alert('이미 존재하는 ID입니다.');history.go(-1);</script>");
				out.println("</head><body></body><html>");
			}
		}
	}

}
