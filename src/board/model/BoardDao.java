package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	
	private static BoardDao instance = new BoardDao();
	
	private BoardDao() {}
	
	public static BoardDao getInstance() {
		return instance;
	}
	
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
		
				String catagory = (rs.getString("catagory"));
				String title = (rs.getString("title"));
				String writer = (rs.getString("writer"));
				String writingTime = (rs.getString("writingTime"));
				int writeNum = (rs.getInt("writeNum"));
				int views = (rs.getInt("views"));
				String content = (rs.getString("content"));
				
				arrayList.add(new BoardDto(catagory, title, writer, writingTime, writeNum, views,content));
			}
			
		} catch (SQLException e) {
			System.out.println("getList()예외 발생");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
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

		String sql = "INSERT INTO BOARD (CATAGORY,WRITENUM,TITLE,WRITER,WRITINGTIME,VIEWS,CONTENT)"
					 + "VALUES(?, LISTSE.nextval, ?, ?, TO_CHAR (SYSDATE,'\"\"YYYY\"년 \"MM\"월 \"DD\"일 \"hh24\"시 \"mi\"분 \"ss\"초\"'), 0,?)";
						//조회수는 초기값 0으로 주자
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getCatagory());
			pstmt.setString(2, boardDto.getTitle());
			pstmt.setString(3, boardDto.getWriter());
			pstmt.setString(4, boardDto.getContent()); // 조회수는 일단 0으로
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
				String catagory = rs.getString("catagory");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writingTime = rs.getString("writingTime");
				String content = rs.getString("content");
				int views = rs. getInt("views");
				boardDto = new BoardDto(catagory, title, writer, writingTime, writeNum, views, content);
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
}
