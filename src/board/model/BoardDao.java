package board.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.jasper.tagplugins.jstl.core.If;


public class BoardDao {
	
	private static BoardDao instance = new BoardDao();
	
	private BoardDao() {}
	
	public static BoardDao getInstance() {
		return instance;
	}

//********************게시판 더미 데이터 넣기 메소드******************************************************************/
	public void insertTest() {
		
		System.out.println("게시판 더미 데이터 시작");
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO BOARD (CATEGORY,TITLE,WRITER, USERID, CONTENT,VIEWS, WRITENUM, WRITINGTIME)"
					 + "VALUES('직업정보', 'test', 'test','gytrt0130' ,'test' , 0, LISTSE.nextval,TO_CHAR (SYSDATE,'\"\"YYYY\"년 \"MM\"월 \"DD\"일 \"hh24\"시 \"mi\"분 \"ss\"초\"'))";
						//조회수는 초기값 0으로 주자
		try {
			conn = getConnection();
			for (int i = 0; i < 10; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			}
		
			
			System.out.println("게시판 더미 데이터 넣기 완료");
		} catch (SQLException e) {
			System.out.println("insertList()예외 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}
	}
	public void deleteTest() {
		
		System.out.println("게시판 더미 데이터 시작");
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "DELETE BOARD ";
						//조회수는 초기값 0으로 주자
		try {
			conn = getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				
			System.out.println("게시판 더미 데이터 넣기 완료");
		} catch (SQLException e) {
			System.out.println("insertList()예외 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}
	}
//********************게시판 더미 데이터 넣기, 삭제 메소드******************************************************************/

	
	
	//커넥션 연결 메소드
	public Connection getConnection() {
		System.out.println("커넥션 시작");
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		
		try {
			context = new InitialContext();			
			dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/oracle");
			connection = dataSource.getConnection();
			System.out.println("getConnection 성공!");
			
		} catch (Exception e) {
			System.out.println("getConnedtion() 예외 발생!");
			e.printStackTrace();
		}
		return connection;
	}
	
	public ArrayList<BoardDto>getList(){
		
		ArrayList<BoardDto>arrayList = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM BOARD ORDER BY WRITENUM DESC");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
		
				String category = (rs.getString("category"));
				String title = (rs.getString("title"));
				String writer = (rs.getString("writer"));
				String writingTime = (rs.getString("writingTime"));
				String userId = (rs.getString("userId"));
				int writeNum = (rs.getInt("writeNum"));
				int views = (rs.getInt("views"));
				String content = (rs.getString("content"));
				
				arrayList.add(new BoardDto(category, title, writer,userId ,writingTime, writeNum, views,content));
			}
			
		} catch (SQLException e) {
			System.out.println("getList()예외 발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("리스트 불러오기 성공");
		return arrayList;
	}

//	
	public void insertList(BoardDto boardDto) {
		
		System.out.println("게시판 인서트 시작");
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO BOARD (CATEGORY,TITLE,WRITER, USERID, CONTENT,VIEWS, WRITENUM, WRITINGTIME)"
					 + "VALUES(?, ?, ?, ?, ?, 0, LISTSE.nextval,TO_CHAR (SYSDATE,'\"\"YYYY\"년 \"MM\"월 \"DD\"일 \"hh24\"시 \"mi\"분 \"ss\"초\"'))";
						//조회수는 초기값 0으로 주자
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getCategory());
			pstmt.setString(2, boardDto.getTitle());
			pstmt.setString(3, boardDto.getWriter());
			pstmt.setString(4, boardDto.getUserId());
			pstmt.setString(5, boardDto.getContent()); // 조회수는 일단 0으로
			pstmt.executeUpdate();
			System.out.println("게시판 인서트 완료");
		} catch (SQLException e) {
			System.out.println("insertList()예외 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}
	}


	//게시글 1개의 데이터를 가져온다.
	public BoardDto getBoard(int writeNum) {
		System.out.println("getBoard 시작");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto boardDto = null;
		String sql = "SELECT * FROM BOARD WHERE writenum = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writeNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String category = rs.getString("category");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String userId = (rs.getString("userId"));
				String writingTime = rs.getString("writingTime");
				String content = rs.getString("content");
				int views = rs. getInt("views");
				boardDto = new BoardDto(category, title, writer,userId, writingTime, writeNum, views, content);
				System.out.println("게시판 내부 글 불러오기 성공");
			}
			
		} catch (SQLException e) {
			System.out.println("login()예외 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
		    } catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardDto;
	}
	//카테고리 선택시 선택한 카테고리의 글만 출력
	public ArrayList<BoardDto>category(String categoryName){
		
		ArrayList<BoardDto>categoryList = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM BOARD WHERE category = ? ORDER BY WRITENUM DESC");
			pstmt.setString(1, categoryName);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
		
				String category = (rs.getString("category"));
				String title = (rs.getString("title"));
				String writer = (rs.getString("writer"));
				String userId = (rs.getString("userId"));
				String writingTime = (rs.getString("writingTime"));
				int writeNum = (rs.getInt("writeNum"));
				int views = (rs.getInt("views"));
				String content = (rs.getString("content"));
				
				categoryList.add(new BoardDto(category, title, writer,userId, writingTime, writeNum, views,content));
			}
			
		} catch (SQLException e) {
			System.out.println("category()예외 발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("카테고리리스트 불러오기 성공");
		return categoryList;
	}
	
	//게시판 내용검색 
	public ArrayList<BoardDto>searchList(String chooseSearch,String search){
		
		ArrayList<BoardDto>searchList = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if (chooseSearch.equals("title")) {
			sql = "SELECT * FROM BOARD WHERE TITLE LIKE '%"+search+"%'";
		}else if (chooseSearch.equals("content")) {
			sql = "SELECT * FROM BOARD WHERE CONTENT LIKE '%"+search+"%'";
		}else {
			sql = "SELECT * FROM BOARD WHERE WRITER LIKE '%"+search+"%'";
		}
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
		
				String category = (rs.getString("category"));
				String title = (rs.getString("title"));
				String writer = (rs.getString("writer"));
				String userId = (rs.getString("userId"));
				String writingTime = (rs.getString("writingTime"));
				int writeNum = (rs.getInt("writeNum"));
				int views = (rs.getInt("views"));
				String content = (rs.getString("content"));
				
				searchList.add(new BoardDto(category, title, writer, userId,writingTime, writeNum, views,content));
			}
			
		} catch (SQLException e) {
			System.out.println("category()예외 발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("검색리스트 불러오기 ");
		return searchList;
	}
	
	public void boardViews(int writeNum) {
		System.out.println("조회수 업 기능");
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		String sql =  "UPDATE board SET views =views+1 where writeNum ="+writeNum;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("BoardViewsup()예외 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}System.out.println("조회수 끝");
	}
	
	public void boardDelete(int writeNum) {
		System.out.println("글 삭제 실행 삭제할 글 번호: "+ writeNum);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE BOARD WHERE WRITENUM = "+writeNum;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("boardDelete()예외 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}System.out.println("삭제 끝");
	}
	
	public void boardEdit(BoardDto boardDto) {
		System.out.println("수정할 글 번호: "+boardDto.getWriteNum());
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET CATEGORY = ?, TITLE = ?, CONTENT = ? WHERE WRITENUM = "+boardDto.getWriteNum();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getCategory());
			pstmt.setString(2, boardDto.getTitle());
			pstmt.setString(3, boardDto.getContent());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("boardEditInsert()예외 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}System.out.println("게시글 수정 끝");
	}
}
