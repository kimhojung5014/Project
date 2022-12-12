package join.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import join.model.JoinDto;
import join.service.IdCheckServiceImpl;
import join.service.IdCheckService;
import join.service.JoinService;
import join.service.JoinServiceImpl;
import join.service.LoginService;
import join.service.LoginServiceImpl;
import join.service.NickNameCheckService;
import join.service.NickNameCheckServiceImpl;
import join.service.editService;
import join.service.editServiceImpl;

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
		//아이디 중복 체크
		if (commend.equals("/idCheck.join")) {
			System.out.println("idCheck 시작");
			System.out.println("컨트롤러에서 받는 아이디 "+request.getParameter("id"));
			String userId =  request.getParameter("id");
			request.setAttribute("userId", userId);
			IdCheckService  idCheckService = new IdCheckServiceImpl();
			
			if (idCheckService.execute(request, response)) {
				System.out.println("사용가능한 아이디");
				request.setAttribute("idCheck", "1");
				request.getSession().setAttribute("userId", userId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("idCheck.jsp");
				dispatcher.forward(request, response);
			}else {
				System.out.println("중복된 아이디");
				
				response.sendRedirect("idCheck.jsp");
			}
		}
		//닉네임 중복 체크
		if (commend.equals("/nickNameCheck.join")) {
			System.out.println("nickNameCheck 시작");
			System.out.println("컨트롤러에서 받는 닉네임 "+request.getParameter("nickName"));
			String nickName =  request.getParameter("nickName");
			request.setAttribute("nickName", nickName);
			NickNameCheckService  nickNameCheckService = new NickNameCheckServiceImpl();		
			
			if (nickNameCheckService.execute(request, response)) {
				System.out.println("사용가능한 닉네임");
				request.setAttribute("nickCheck", "1");
				request.getSession().setAttribute("nickName",nickName );
				RequestDispatcher dispatcher = request.getRequestDispatcher("nickCheck.jsp");
				dispatcher.forward(request, response);

				
			
			}else {
				System.out.println("중복된 닉네임");

				response.sendRedirect("nickCheck.jsp");

			}
		}
		//로그인 
		if (commend.equals("/login.join")) {
			System.out.println("로그인 시작");
		    String userId = request.getParameter("userId");
			String pw = request.getParameter("pw");
			
			request.setAttribute("userId", userId);
			request.setAttribute("pw", pw);
			
			LoginService loginService = new LoginServiceImpl();
			JoinDto joinDto = loginService.execute(request, response);
			if (joinDto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userData", joinDto);
				response.sendRedirect("newindex.jsp");
			}else {
				System.out.println("정보없음");
				//out 객체 사용하지 말고 서블릿에서 뷰를 구현하면 안된다.
				out.println("<html><head><title>확인창</title>");
				out.println("<script>alert('아이디 비밀번호를 확인해주세요');history.go(-1);</script>");
				out.println("</head><body</body><html>");
			}
			
		}
		//마이페이지 수정화면
		if (commend.equals("/edit.join")) {
			System.out.println("마이페이지 업데이트 시작");
			JoinDto joinDto = new JoinDto((String)request.getParameter("userId"),
										  (String)request.getParameter("pw"), 
										  (String)request.getParameter("nickName"),
										  (String)request.getParameter("userName"),
										  (String)request.getParameter("eMail"),
										  (String)request.getParameter("telNumber"));
			int numId = Integer.parseInt(request.getParameter("numId"));
			request.setAttribute("numId", numId);
			request.setAttribute("joinDto", joinDto);
			editService editService = new editServiceImpl();
			editService.execute(request, response);
			request.getSession().setAttribute("userData", joinDto);
			response.sendRedirect("newindex.jsp");
		}
		//아이디 찾기 이름 이메일
		if (commend.equals("/search_Name_Email.join")) {
			System.out.println("아이디 찾기: 이름, 이메일");
			String userId = request.getParameter("userName");
			String eMail = request.getParameter("eMail");
			
			request.setAttribute("userId", userId);
			request.setAttribute("eMail", eMail);
			
			
		}
		
		
	}

}
