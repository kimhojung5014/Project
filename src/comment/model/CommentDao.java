package comment.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentDao {
	
	private static CommentDao instance = new CommentDao();
	
	private CommentDao() {}
	
	public static CommentDao getInsetance() {
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
	
	public void commentInsert(int writeNum,String commentContent, String userId, String nickName) {
		System.out.println("댓글 인서트 메소드");
		System.out.println("해당 글 번호 "+writeNum);
		System.out.println("유저id "+userId);
		System.out.println("닉네임 "+nickName);
		System.out.println("댓글 내용 "+commentContent);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO REPLY(writeNum,commentnum,userId, nickname,content,commentDate)" + 
					"values(?,commentNum.nextval,?,?,?,TO_CHAR(SYSDATE,'YYYY\"년\" MM\"월 \"DD\"일 \"hh24\"시 \"mi\"분 '))";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writeNum);
			pstmt.setString(2, userId);
			pstmt.setString(3, nickName);
			pstmt.setString(4, commentContent);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println("댓글 저장 완료");
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<CommentDto> commentList(int writeNum) {
		
		ArrayList<CommentDto>arrayList = new ArrayList<CommentDto>();
		CommentDto commentDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		//
		String sql =  "SELECT NICKNAME , CONTENT, COMMENTDATE, COMMENTNUM FROM REPLY WHERE WRITENUM =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writeNum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int commentNum = rs.getInt("commentNum");
				String nickName = rs.getString("nickname");
				String content = rs.getString("content");
				String commentDate = rs.getString("commentdate");
				commentDto = new CommentDto(commentNum, nickName, content, commentDate);
				arrayList.add(commentDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				System.out.println("댓글 저장 완료");
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return arrayList;
	}
}
