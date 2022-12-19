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
import board.service.BoardCategoryService;
import board.service.BoardCategoryServiceImpl;
import board.service.BoardDeleteService;
import board.service.BoardDeleteServiceImpl;
import board.service.BoardEditInsertService;
import board.service.BoardEditInsertServiceImpl;
import board.service.BoardGetService;
import board.service.BoardGetServiceImpl;
import board.service.BoardInsertService;
import board.service.BoardInsertServiceImpl;
import board.service.BoardListService;
import board.service.BoardListServiceImpl;
import board.service.BoardSearchSearvice;
import board.service.BoardSearchServiceImpl;
import board.service.BoardViewsPlusService;
import board.service.BoardViewsPlusServiceImpl;
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
import reply.service.ReReplyListService;
import reply.service.ReReplyListServiceImpl;
import reply.service.ReplyDeleteService;
import reply.service.ReplyDeleteServiceImpl;
import reply.service.ReplyEditService;
import reply.service.ReplyEditServiceImpl;
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
		
//**************************회원가입, 로그인 처리***************************************************************************************
		
		//회원가입 DB Insert
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
				response.sendRedirect("loginfalse.jsp");
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
//********************************게시판 관련 부분*********************************************************************************
		
		//게시판 화면들어오면 게시글 목록 전체 출력 정렬은 글번호 최신순
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
			boardDto.setCategory(category);
			boardDto.setTitle(title);
			boardDto.setContent(content);
			boardDto.setWriter(joinDto.getNickName());
			boardDto.setUserId(joinDto.getUserId());
			request.setAttribute("boardDto", boardDto);
			BoardInsertService boardInsertService = new BoardInsertServiceImpl();
			boardInsertService.execute(request, response);
			response.sendRedirect("/Project/list.do");
			
		}
		//글 내용 들어가면 글, 댓글 불러오는 부분
		if (commend.equals("/inToBoard.do")) {
			System.out.println("inToBoard 컨트롤러");
			//페이지 들어올 때 파라메터로 넘긴 페이지 번호 받고
			int writeNum = Integer.parseInt(request.getParameter("writeNum"));
			
			//세션에 페이지 번호  띄워서 다른 서비스 들에서 사용할 수 있게
			request.getSession().setAttribute("writeNum", writeNum);;
			
			//조회수 업하는 서비스

			BoardViewsPlusService boardViewsPlusService = new BoardViewsPlusServiceImpl();
			boardViewsPlusService.execute(request, response);
			
			//글 내용 불러오는 서비스
			BoardGetService boardGetService = new BoardGetServiceImpl();
			BoardDto boardDto =  boardGetService.execute(request, response);
			request.setAttribute("boardDto", boardDto); //글 내용 셋
			
			//댓글 불러오는 서비스 
			ReplyListService replyListService = new ReplyListServiceImpl();
			ArrayList<ReplyDto>replyList = replyListService.execute(request, response);
			request.setAttribute("replyList", replyList);
		
			//대댓글 불러오는 서비스 
			ReReplyListService reReplyListService = new ReReplyListServiceImpl();
			ArrayList<ReplyDto>rereplyList = reReplyListService .execute(request, response);
			request.setAttribute("rereplyList", rereplyList); 
			
			//리퀘스트에 set한 정보들 가지고 글 내용 jsp로 forward
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("inToBoard.jsp");
			requestDispatcher.forward(request, response);
		}

		// 댓글 삽입
		if (commend.equals("/replyInsert.do")) {
			System.out.println("댓글 컨트롤러");
			int writeNum = (int)request.getSession().getAttribute("writeNum");
			int parentNum = Integer.parseInt(request.getParameter("parentNum"));
			String userId = request.getParameter("userId"); //요건 그냥 세션으로 받아도 될거 같다
			String nickName = request.getParameter("nickName");//요건 그냥 세션으로 받아도 될거 같다
			String content = request.getParameter("content");
			
			ReplyDto replyDto = new ReplyDto(writeNum, parentNum, parentNum, userId, nickName, content);
			
			request.setAttribute("replyDto", replyDto);
			
			ReplyInsertService replyInsertService = new ReplyInsertServiceImpl();
			replyInsertService.execute(request, response);
			response.sendRedirect("/Project/inToBoard.do?writeNum="+writeNum);
		}
		//댓글 수정 일단 보류
		if (commend.equals("/replyEdit.do")) {
			int writeNum = (int)request.getSession().getAttribute("writeNum");

			int commentNum = Integer.parseInt(request.getParameter("commentNum"));
			String replyContent = request.getParameter("replyContent");
			
			System.out.println(writeNum);
			System.out.println(commentNum);
			System.out.println(replyContent);
			
			request.setAttribute("commentNum", commentNum);
			request.setAttribute("replyContent", replyContent);

			ReplyEditService replyEditService = new ReplyEditServiceImpl();
			replyEditService.execute(request, response);
			response.sendRedirect("/Project/inToBoard.do?writeNum="+writeNum);
		}
		
		//댓글 삭제
		if (commend.equals("/replyDelete.do")) {
			int writeNum = (int)request.getSession().getAttribute("writeNum");
			int commentNum = Integer.parseInt(request.getParameter("commentNum"));
			request.setAttribute("commentNum", commentNum);
			ReplyDeleteService replyDeleteService = new ReplyDeleteServiceImpl();
			replyDeleteService.execute(request, response);
			response.sendRedirect("/Project/inToBoard.do?writeNum="+writeNum);
			
		}
		
		//카테고리 분류 
		if (commend.equals("/category.do")) {
			System.out.println("카테고리 분류");
			String category = (String)request.getParameter("category");
			System.out.println("파라메터: "+category);
			request.setAttribute("category", category);
			BoardCategoryService boardCategoryService = new BoardCategoryServiceImpl();
			ArrayList<BoardDto>arrayList = boardCategoryService.execute(request, response);
			request.setAttribute("arrayList", arrayList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("board.jsp");
			dispatcher.forward(request, response);
			
		}
		//게시판 검색 기능
		if (commend.equals("/boardSearch.do")) {
			
			String chooseSearch = request.getParameter("chooseSearch");
			String search = request.getParameter("search");
			
			System.out.println("검색주제"+chooseSearch);
			System.out.println("검색어"+search);
			request.setAttribute("chooseSearch", chooseSearch);
			request.setAttribute("search", search);
			BoardSearchSearvice boardSearchSearvice = new BoardSearchServiceImpl();
			ArrayList<BoardDto>arrayList = boardSearchSearvice.execute(request, response);
			request.setAttribute("arrayList", arrayList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("board.jsp");
			dispatcher.forward(request, response);
			
		}
		
		//게시글 삭제
		if (commend.equals("/deleteBoard.do")) {
			
			int writeNum = Integer.parseInt(request.getParameter("writeNum"));
			request.setAttribute("writeNum", writeNum);
			BoardDeleteService boardDeleteService = new BoardDeleteServiceImpl();
			boardDeleteService.execute(request, response);
			
			response.sendRedirect("list.do");
		}
		
		//게시글 수정 화면 전환
		if (commend.equals("/boardEdit.do")) {
			//inToBoard에서 정보 받아서 boardEdit로 넘긴다.
			request.setAttribute("category", request.getParameter("category"));
			request.setAttribute("title", request.getParameter("title"));
			request.setAttribute("content", request.getParameter("content"));
			request.setAttribute("writeNum", request.getParameter("writeNum"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("boardEdit.jsp");
			dispatcher.forward(request, response);
		}
		//게시글 수정 저장
		if (commend.equals("/boardEditInsert.do")) {
			int writeNum = Integer.parseInt(request.getParameter("writeNum"));
			BoardDto boardDto = new BoardDto( request.getParameter("category"),
											  request.getParameter("title"),
											  writeNum,	
											  request.getParameter("content"));
			request.setAttribute("boardDto", boardDto);
			BoardEditInsertService boardEditInsertService = new BoardEditInsertServiceImpl();
			boardEditInsertService.execute(request, response);
			response.sendRedirect("inToBoard.do?writeNum="+writeNum);
			
		}

	}

}
