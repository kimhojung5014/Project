package frontController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDto;
import board.service.BoardGetService;
import board.service.BoardGetServiceImpl;
import board.service.BoardInsertService;
import board.service.BoardInsertServiceImpl;
import board.service.BoardListService;
import board.service.BoardListServiceImpl;
import comment.model.CommentDto;
import comment.service.CommentInsertService;
import comment.service.CommentInsertServiceImpl;
import comment.service.CommentListService;
import comment.service.CommentListServiceImpl;
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
import reply.model.ReplyDto;
import reply.service.ReplyInsertService;
import reply.service.ReplyInsertServiceImpl;
import reply.service.ReplyListService;
import reply.service.ReplyListServiceImpl;

/**
 * Servlet implementation class Join_Controller
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FrontController() {
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
		
		if (commend.equals("/insertJoin.do")) {
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
		if (commend.equals("/idCheck.do")) {
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
		if (commend.equals("/nickNameCheck.do")) {
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
		if (commend.equals("/login.do")) {
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
		if (commend.equals("/edit.do")) {
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
		if (commend.equals("/search_Id.do")) {
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
		if (commend.equals("/search_Pw.do")) {
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
		//여기서부터 게시판 컨트롤
		if (commend.equals("/list.do")) {
			
			ArrayList<BoardDto>arrayList = new ArrayList<BoardDto>();
			BoardListService boardListService = new BoardListServiceImpl();
			arrayList =  boardListService.execute(request, response);
			request.setAttribute("arrayList", arrayList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("board.jsp");
			dispatcher.forward(request, response);
		}
		if (commend.equals("/insertBoard.do")) {
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
			response.sendRedirect("/Project/list.do");
			
		}
		if (commend.equals("/inToBoard.do")) {
			System.out.println("inToBoard 컨트롤러");
			int writeNum = Integer.parseInt(request.getParameter("writeNum"));
			
			//글 내용 불러오는 서비스
			request.setAttribute("writeNum", writeNum);
			BoardGetService boardGetService = new BoardGetServiceImpl();
			BoardDto boardDto =  boardGetService.execute(request, response);
			request.setAttribute("boardDto", boardDto); //글 내용 셋
			
			//댓글 불러오는 서비스
			request.setAttribute("writeNum", writeNum);
			CommentListService commentListService = new CommentListServiceImpl();
			ArrayList<CommentDto>commentList = commentListService.execute(request, response);
			request.setAttribute("commentList", commentList); //댓글 내용 셋
			
			//대댓글 불러오는 서비스 
			request.setAttribute("writeNum", writeNum);
			ReplyListService replyListService = new ReplyListServiceImpl();
			ArrayList<ReplyDto>reCommentList = replyListService.execute(request, response);
			request.setAttribute("reCommentList", reCommentList); //댓글 내용 셋
			
			//리퀘스트에 셋한 정보들 가지고 글 내용 jsp로 forward
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("inToBoard.jsp");
			requestDispatcher.forward(request, response);
		}
		//여기서부터 댓글 삽입
		if (commend.equals("/commentInsert.do")) {
			int writeNum = Integer.parseInt(request.getParameter("writeNum"));
			System.out.println(request.getParameter("writeNum"));
			String commentContent = request.getParameter("commentContent");
			String userId = request.getParameter("userId");
			String nickName = request.getParameter("nickName");
			//개체 넘기는 걸로 변환 예정
			request.setAttribute("writeNum", writeNum);
			request.setAttribute("commentContent", commentContent);
			request.setAttribute("userId", userId);
			request.setAttribute("nickName", nickName);
			
			CommentInsertService commentInsertService = new CommentInsertServiceImpl();
			commentInsertService.execute(request, response);
			response.sendRedirect("/Project/inToBoard.do?writeNum="+writeNum);
			
		}
		// 대댓글 삽입
		if (commend.equals("/replyInsert.do")) {
			System.out.println("대댓글 컨트럴러");
			int writeNum = Integer.parseInt(request.getParameter("writeNum"));
			int commentNum = Integer.parseInt(request.getParameter("commentNum"));
			String replyContent = request.getParameter("replyContent");
			String userId = request.getParameter("userId");
			String nickName = request.getParameter("nickName");
			//개체 넘기는 걸로 변환 예정
			request.setAttribute("writeNum", writeNum);
			request.setAttribute("commentNum", commentNum);
			request.setAttribute("replyContent", replyContent);
			request.setAttribute("userId", userId);
			request.setAttribute("nickName", nickName);
			
			ReplyInsertService replyInsertService = new ReplyInsertServiceImpl();
			replyInsertService.execute(request, response);
			response.sendRedirect("/Project/inToBoard.do?writeNum="+writeNum);
			
		}
		//대댓글 출력 기능
//		if (commend.equals("/replyList.do")) {
//			System.out.println("대댓글 리스트");
//			
//		}
	}

}
