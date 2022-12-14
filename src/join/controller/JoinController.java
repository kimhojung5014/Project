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
import join.service.SearchIdService;
import join.service.SearchIdServiceImpl;
import join.service.SearchPwService;
import join.service.SearchPwServiceImpl;
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
			JoinDto joinDto = new JoinDto(
										  (String)request.getParameter("userId"),
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
				request.setAttribute("idCheck", "ok");
				
				//세션으로 값 띄우는 건 수정 하기
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
			String page = request.getParameter("page");
			System.out.println("컨트롤러에서 받은 페이지 정보 "+page);
			String nickName =  request.getParameter("nickName");
			request.setAttribute("nickName", nickName);
			NickNameCheckService  nickNameCheckService = new NickNameCheckServiceImpl();		
			
			if (nickNameCheckService.execute(request, response)) {
				System.out.println("사용가능한 닉네임");
				request.setAttribute("nickCheck", "ok");
				
				if (page != null) {
					System.out.println("닉네임 분기"+page);
					request.getSession().setAttribute("nickName",nickName );
					RequestDispatcher dispatcher = request.getRequestDispatcher("nickCheckMyPage.jsp");
					dispatcher.forward(request, response);	
				} else {
					System.out.println("닉네임 분기 회원가입");
					request.getSession().setAttribute("nickName",nickName );
					RequestDispatcher dispatcher = request.getRequestDispatcher("nickCheck.jsp");
					dispatcher.forward(request, response);			
				}
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
				//out 객체 사용하지 말고 서블릿에서 뷰를 구현하면 안된다. 요건 따로 창 만들기
				out.println("<html><head><title>확인창</title>");
				out.println("<script>alert('아이디 비밀번호를 확인해주세요');history.go(-1);</script>");
				out.println("</head><body</body><html>");
			}
			
		}
		//마이페이지 수정화면
		if (commend.equals("/edit.join")) {
			System.out.println("마이페이지 업데이트 시작");
			int numId = Integer.parseInt(request.getParameter("numId"));
			JoinDto joinDto = new JoinDto(numId,
										  (String)request.getParameter("userId"),
										  (String)request.getParameter("pw"), 
										  (String)request.getParameter("nickName"),
										  (String)request.getParameter("userName"),
										  (String)request.getParameter("eMail"),
										  (String)request.getParameter("telNumber"));
			
			request.setAttribute("numId", numId);
			request.setAttribute("joinDto", joinDto);
			editService editService = new editServiceImpl();
			editService.execute(request, response);
			request.getSession().setAttribute("userData", joinDto);
			response.sendRedirect("newindex.jsp");
		}
		//아이디 찾기 이름
		if (commend.equals("/search_Id.join")) {
			System.out.println("아이디 찾기 시작");
			String userName = request.getParameter("userName");
			String eMail = request.getParameter("eMail");
			String telNumber =request.getParameter("telNumber");
			System.out.println("userName="+userName);
			System.out.println("eMail="+eMail);
			System.out.println("tel="+telNumber);
			if(telNumber.equals("")) {
				System.out.println("컨트롤러 이메일 세팅");
				request.setAttribute("userName", userName);
				request.setAttribute("data", eMail);
			}
			else {
				System.out.println("컨트롤러 전화번호 세팅");
				request.setAttribute("userName", userName);				
				request.setAttribute("data", telNumber);
			}
			SearchIdService searchIdService = new SearchIdServiceImpl();
			String search = searchIdService.execute(request, response);
			System.out.println("반환된 id:"+search);
			if(search != null) {
				request.setAttribute("id", search);
				RequestDispatcher dispatcher = request.getRequestDispatcher("searchId.jsp");
				dispatcher.forward(request, response);
				
			}else {
				response.sendRedirect("searchId.jsp");				
			}

		}
		if (commend.equals("/search_Pw.join")) {
			System.out.println("비밀번호 찾기 시작");
			String userId = request.getParameter("userId");
			String eMail = request.getParameter("eMail");
			String telNumber =request.getParameter("telNumber");
			System.out.println("id="+userId);
			System.out.println("eMail="+eMail);
			System.out.println("tel="+telNumber);
			if(telNumber.equals("")) {
				System.out.println("컨트롤러 이메일로 찾기");
				request.setAttribute("userId", userId);
				request.setAttribute("data", eMail);
			}
				else if(telNumber != null) {
				System.out.println("컨트롤러 폰 번호로 찾기");
				request.setAttribute("userId", userId);				
				request.setAttribute("data", telNumber);
			}
			SearchPwService searchPwService = new SearchPwServiceImpl();
			String search = searchPwService.execute(request, response);	
			System.out.println("반환된 pw:"+search);
			if(search != null) {
				request.setAttribute("pw", search);
				RequestDispatcher dispatcher = request.getRequestDispatcher("searchPw.jsp");
				dispatcher.forward(request, response);
				
			}else {
				response.sendRedirect("searchPw.jsp");				
			}

		}
		
		
	}

}
