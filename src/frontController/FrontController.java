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

import board.model.BoardDao;
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
import jobDetail.model.JobDetailDto;
import jobDetail.service.JobDetailService;
import jobDetail.service.JobDetailServiceImpl;
import jobDetail.service.JobRecommendService;
import jobDetail.service.JobRecommendServiceImpl;
import jobList.model.JobListDto;
import jobList.service.JobListService;
import jobList.service.JobListServiceImpl;
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
import major.model.MajorDto;
import major.service.MajorDetailService;
import major.service.MajorDetailServiceImpl;
import major.service.MajorListService;
import major.service.MajorListServiceImpl;
import reply.model.ReplyDto;
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
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String commend = uri.substring(conPath.length());
		
		//**************************//????????? ?????? ????????? 10??? ??????, ?????? ????????? ?????????***************************************************************************************
	
		
		if (commend.equals("/test.do")) {
			BoardDao boardDao = BoardDao.getInstance();
			boardDao.insertTest();
			response.sendRedirect("list.do");
		}
		if (commend.equals("/testdelete.do")) {
			BoardDao boardDao = BoardDao.getInstance();
			boardDao.deleteTest();
			response.sendRedirect("list.do");
		}
		//**************************//????????? ?????? ????????? ??????, ?????? ????????? ?????????***************************************************************************************

//**************************????????????, ????????? ??????***************************************************************************************
		
		//???????????? DB Insert
		if (commend.equals("/insertJoin.do")) {
			System.out.println("insert ??????");
			JoinDto joinDto = new JoinDto(
										  (String)request.getParameter("userId"),
										  (String)request.getParameter("pw"), 
										  (String)request.getParameter("nickName"),
										  (String)request.getParameter("userName"),
										  (String)request.getParameter("eMail"),
										  (String)request.getParameter("telNumber"));
	
			request.setAttribute("joinData", joinDto);
			JoinService joinService = new JoinServiceImpl();
			joinService.execute(request, response);
			response.sendRedirect("login.jsp");
			
		}
		//????????? ?????? ??????
		if (commend.equals("/idCheck.do")) {
			System.out.println("idCheck ??????");
			System.out.println("?????????????????? ?????? ????????? "+request.getParameter("id"));
			String userId =  request.getParameter("id");
			request.setAttribute("userId", userId);
			IdCheckService  idCheckService = new IdCheckServiceImpl();
			
			if (idCheckService.execute(request, response)) {
				System.out.println("??????????????? ?????????");
				request.setAttribute("idCheck", "ok");
				
				//???????????? ??? ????????? ??? ?????? ??????
				request.getSession().setAttribute("userId", userId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("idCheck.jsp");
				dispatcher.forward(request, response);
			}else {
				System.out.println("????????? ?????????");
				
				response.sendRedirect("idCheck.jsp");
			}
		}
		//????????? ?????? ??????
		if (commend.equals("/nickNameCheck.do")) {
			System.out.println("nickNameCheck ??????");
			System.out.println("?????????????????? ?????? ????????? "+request.getParameter("nickName"));
			String page = request.getParameter("page");
			System.out.println("?????????????????? ?????? ????????? ?????? "+page);
			String nickName =  request.getParameter("nickName");
			request.setAttribute("nickName", nickName);
			NickNameCheckService  nickNameCheckService = new NickNameCheckServiceImpl();		
			
			if (nickNameCheckService.execute(request, response)) {
				System.out.println("??????????????? ?????????");
				request.setAttribute("nickCheck", "ok");
				
				if (page != null) {
					System.out.println("????????? ??????"+page);
					request.getSession().setAttribute("nickName",nickName );
					RequestDispatcher dispatcher = request.getRequestDispatcher("nickCheckMyPage.jsp");
					dispatcher.forward(request, response);	
				} else {
					System.out.println("????????? ?????? ????????????");
					request.getSession().setAttribute("nickName",nickName );
					RequestDispatcher dispatcher = request.getRequestDispatcher("nickCheck.jsp");
					dispatcher.forward(request, response);			
				}
			}else {
				System.out.println("????????? ?????????");

				response.sendRedirect("nickCheck.jsp");

			}
		}
		//????????? 
		if (commend.equals("/login.do")) {
			System.out.println("????????? ??????");
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
				System.out.println("????????????");
				//out ?????? ???????????? ?????? ??????????????? ?????? ???????????? ?????????. ?????? ?????? ??? ?????????
				response.sendRedirect("loginfalse.jsp");
			}
			
		}
		//??????????????? ????????????
		if (commend.equals("/edit.do")) {
			System.out.println("??????????????? ???????????? ??????");
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
		//????????? ?????? ??????
		if (commend.equals("/search_Id.do")) {

			String userName = request.getParameter("userName");
			String eMail = request.getParameter("eMail");
			String telNumber =request.getParameter("telNumber");

			if(telNumber.equals("")) {
				System.out.println("???????????? ????????? ??????");
				request.setAttribute("userName", userName);
				request.setAttribute("data", eMail);
			}
			else {
				System.out.println("???????????? ???????????? ??????");
				request.setAttribute("userName", userName);				
				request.setAttribute("data", telNumber);
			}
			SearchIdService searchIdService = new SearchIdServiceImpl();
			String search = searchIdService.execute(request, response);
			System.out.println("????????? id:"+search);
			if(search != null) {
				request.setAttribute("id", search);
				RequestDispatcher dispatcher = request.getRequestDispatcher("searchId.jsp");
				dispatcher.forward(request, response);
				
			}else {
				response.sendRedirect("searchId.jsp");				
			}

		}
		if (commend.equals("/search_Pw.do")) {

			String userId = request.getParameter("userId");
			String eMail = request.getParameter("eMail");
			String telNumber =request.getParameter("telNumber");

			if(telNumber.equals("")) {
				System.out.println("???????????? ???????????? ??????");
				request.setAttribute("userId", userId);
				request.setAttribute("data", eMail);
			}
				else if(telNumber != null) {
				System.out.println("???????????? ??? ????????? ??????");
				request.setAttribute("userId", userId);				
				request.setAttribute("data", telNumber);
			}
			SearchPwService searchPwService = new SearchPwServiceImpl();
			String search = searchPwService.execute(request, response);	
			System.out.println("????????? pw:"+search);
			if(search != null) {
				request.setAttribute("pw", search);
				RequestDispatcher dispatcher = request.getRequestDispatcher("searchPw.jsp");
				dispatcher.forward(request, response);
				
			}else {
				response.sendRedirect("searchPw.jsp");				
			}

		}
//********************************????????? ?????? ??????*********************************************************************************
		
		//????????? ?????????????????? ????????? ?????? ?????? ?????? ????????? ????????? ?????????
		if (commend.equals("/list.do")) {
			
			if (request.getParameter("min") != null && request.getParameter("max") != null) {
				request.setAttribute("min", request.getParameter("min"));
				request.setAttribute("max", request.getParameter("max"));
			}
			
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
			//Dto ????????? ??? 4??? ????????? ???????????? ????????????????????? ??? ????????? Dao ????????? ??????????????? ??? ?????????.
			BoardDto boardDto = new BoardDto();
			boardDto.setCategory(category);
			boardDto.setTitle(title);
			boardDto.setContent(content);
			boardDto.setWriter(joinDto.getNickName());
			boardDto.setUserId(joinDto.getUserId());
			request.setAttribute("boardDto", boardDto);
			BoardInsertService boardInsertService = new BoardInsertServiceImpl();
			boardInsertService.execute(request, response);
			response.sendRedirect("list.do");
			
		}
		//??? ?????? ???????????? ???, ?????? ???????????? ??????
		if (commend.equals("/inToBoard.do")) {
			System.out.println("inToBoard ????????????");
			//????????? ????????? ??? ??????????????? ?????? ????????? ?????? ??????
			int writeNum = Integer.parseInt(request.getParameter("writeNum"));
			
			//????????? ????????? ??????  ????????? ?????? ????????? ????????? ????????? ??? ??????
			request.getSession().setAttribute("writeNum", writeNum);
			
			//????????? ????????? ?????????
			BoardViewsPlusService boardViewsPlusService = new BoardViewsPlusServiceImpl();
			boardViewsPlusService.execute(request, response);
			
			//??? ?????? ???????????? ?????????
			BoardGetService boardGetService = new BoardGetServiceImpl();
			BoardDto boardDto =  boardGetService.execute(request, response);
			request.setAttribute("boardDto", boardDto); //??? ?????? ???
			
			//?????? ???????????? ????????? 
			ReplyListService replyListService = new ReplyListServiceImpl();
			ArrayList<ReplyDto>replyList = replyListService.execute(request, response);
			request.setAttribute("replyList", replyList);
		
			//??????????????? set??? ????????? ????????? ??? ?????? jsp??? forward
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("inToBoard.jsp");
			requestDispatcher.forward(request, response);
		}

		// ?????? ??????
		if (commend.equals("/replyInsert.do")) {
			System.out.println("?????? ??????");
			int writeNum = (int)request.getSession().getAttribute("writeNum");
			int parentNum = Integer.parseInt(request.getParameter("parentNum"));
			
			String userId = request.getParameter("userId"); //?????? ?????? ???????????? ????????? ?????? ??????
			String nickName = request.getParameter("nickName");//?????? ?????? ???????????? ????????? ?????? ??????
			String content = request.getParameter("content");
			
			ReplyDto replyDto = new ReplyDto(writeNum, parentNum, parentNum, userId, nickName, content);
			
			request.setAttribute("replyDto", replyDto);
			
			ReplyInsertService replyInsertService = new ReplyInsertServiceImpl();
			replyInsertService.execute(request, response);
			response.sendRedirect("/Project/inToBoard.do?writeNum="+writeNum);
		}
		//?????? ??????
		if (commend.equals("/replyEdit.do")) {
			
			System.out.println("?????? ??????");
			int writeNum = (int)request.getSession().getAttribute("writeNum");

			int commentNum = Integer.parseInt(request.getParameter("commentNum"));
			String replyContent = request.getParameter("replyContent");
			
			request.setAttribute("commentNum", commentNum);
			request.setAttribute("replyContent", replyContent);

			ReplyEditService replyEditService = new ReplyEditServiceImpl();
			replyEditService.execute(request, response);
			response.sendRedirect("inToBoard.do?writeNum="+writeNum);
		}
		
		//?????? ??????
		if (commend.equals("/replyDelete.do")) {
			System.out.println("?????? ??????");
			int writeNum = (int)request.getSession().getAttribute("writeNum");
			int commentNum = Integer.parseInt(request.getParameter("commentNum"));
			request.setAttribute("commentNum", commentNum);
			ReplyDeleteService replyDeleteService = new ReplyDeleteServiceImpl();
			replyDeleteService.execute(request, response);
			response.sendRedirect("inToBoard.do?writeNum="+writeNum);
			
		}
		
		//???????????? ?????? 
		if (commend.equals("/category.do")) {
			System.out.println("???????????? ??????");
			String category = (String)request.getParameter("category");
			request.setAttribute("category", category);
			BoardCategoryService boardCategoryService = new BoardCategoryServiceImpl();
			ArrayList<BoardDto>arrayList = boardCategoryService.execute(request, response);
			request.setAttribute("arrayList", arrayList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("board.jsp");
			dispatcher.forward(request, response);
			
		}
		//????????? ?????? ??????
		if (commend.equals("/boardSearch.do")) {
			System.out.println("?????? ?????? ");
			String chooseSearch = request.getParameter("chooseSearch");
			String search = request.getParameter("search");
			

			request.setAttribute("chooseSearch", chooseSearch);
			request.setAttribute("search", search);
			BoardSearchSearvice boardSearchSearvice = new BoardSearchServiceImpl();
			ArrayList<BoardDto>arrayList = boardSearchSearvice.execute(request, response);
			request.setAttribute("arrayList", arrayList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("board.jsp");
			dispatcher.forward(request, response);
			
		}
		
		//????????? ??????
		if (commend.equals("/deleteBoard.do")) {
			System.out.println("????????? ??????");
			int writeNum = Integer.parseInt(request.getParameter("writeNum"));
			request.setAttribute("writeNum", writeNum);
			BoardDeleteService boardDeleteService = new BoardDeleteServiceImpl();
			boardDeleteService.execute(request, response);
			
			response.sendRedirect("list.do");
		}
		
		//????????? ?????? ?????? ??????
		if (commend.equals("/boardEdit.do")) {
			//inToBoard?????? ?????? ????????? boardEdit??? ?????????.
			System.out.println("????????? ??????");
			request.setAttribute("category", request.getParameter("category"));
			request.setAttribute("title", request.getParameter("title"));
			request.setAttribute("content", request.getParameter("content"));
			request.setAttribute("writeNum", request.getParameter("writeNum"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("boardEdit.jsp");
			dispatcher.forward(request, response);
		}
		//????????? ?????? ??????
		if (commend.equals("/boardEditInsert.do")) {
			System.out.println("????????? ?????? ??? ??????");
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
//********************************?????? ?????? ??????******************************************************************************************
		//?????? ?????? ????????? ??????
		if (commend.equals("/jobList.do")) {
			System.out.println("joblist.do");
			JobListService jobListService = new JobListServiceImpl();
			ArrayList<JobListDto>jobList = jobListService.execute(request, response);
			request.setAttribute("jobList", jobList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("job.jsp");
			dispatcher.forward(request, response);
		}
		//?????? ?????? ?????? ??????
		if (commend.equals("/jobDetail.do")) {
			System.out.println("?????? ?????? ??????");
			String job = request.getParameter("job");
			request.setAttribute("job", job);
			
			JobDetailService jobDetailService = new JobDetailServiceImpl();
			JobDetailDto jobData =  jobDetailService.execute(request, response);
		
			request.setAttribute("jobData", jobData);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jobdetail.jsp");
			dispatcher.forward(request, response);
		}
		//?????? ??????
		if (commend.equals("/jobRecommend.do")) {
			System.out.println("?????? ?????? ??????");
			String ability = request.getParameter("ability");
			String kindOfJob = request.getParameter("kindOfJob");
			String possibility = request.getParameter("possibility");

			request.setAttribute("ability",ability);
			request.setAttribute("kindOfJob",kindOfJob);
			request.setAttribute("possibility",possibility);
			
			JobRecommendService jobRecommendService = new JobRecommendServiceImpl();
			ArrayList<JobDetailDto>jobList = jobRecommendService.execute(request, response);
			request.setAttribute("jobList", jobList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jobresult.jsp");
			dispatcher.forward(request, response);
		}
//********************************?????? ?????? ??????******************************************************************************************
		
		//?????? ????????? ????????????
		if (commend.equals("/major.do")) {
			System.out.println("???????????????");
			MajorListService majorListService = new MajorListServiceImpl();
			ArrayList<MajorDto>majorList = majorListService.execute(request, response);
			request.setAttribute("majorList", majorList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("major.jsp");
			dispatcher.forward(request, response);
		}
		if (commend.equals("/majorDetail.do")) {
			System.out.println("?????? ??????");
			request.setAttribute("major", request.getParameter("major"));
			MajorDetailService majorDetailService = new MajorDetailServiceImpl();
			MajorDto majorDto = majorDetailService.execute(request, response);
			request.setAttribute("majorDto", majorDto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("majordetail.jsp");
			dispatcher.forward(request, response);
			
		}

	}

}
