package reply.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReplyDao {

	private static ReplyDao instance = new ReplyDao();
	
	private ReplyDao() {}
	
	public static ReplyDao getInstance() {
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
	
	public void replyInsert(int writeNum, int commentNum,String replyContent, String userId, String nickName) {
		System.out.println("대댓글 인서트 메소드");
		System.out.println("해당 글 번호 "+writeNum);
		System.out.println("상위 댓글 번호 "+commentNum );
		System.out.println("유저id "+userId);
		System.out.println("닉네임 "+nickName);
		System.out.println("댓글 내용 "+replyContent);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO REREPLY(writeNum,commentnum,userId, nickname,content,commentDate)" + 
					"values(?,?,?,?,?,TO_CHAR(SYSDATE,'YYYY\"년\" MM\"월 \"DD\"일 \"hh24\"시 \"mi\"분 '))";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writeNum);
			pstmt.setInt(2, commentNum);
			pstmt.setString(3, userId);
			pstmt.setString(4, nickName);
			pstmt.setString(5, replyContent);
			pstmt.executeUpdate();
			System.out.println("대댓글 저장 완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<ReplyDto> reCommentList(int writeNum) {
		
		ArrayList<ReplyDto>arrayList = new ArrayList<ReplyDto>();
		ReplyDto replyDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		//
		String sql =  "SELECT NICKNAME , CONTENT, COMMENTDATE, COMMENTNUM "
					+ "FROM REREPLY WHERE WRITENUM =? "
					+ "ORDER by COMMENTDATE"; // 대댓글은 먼저 작성 한 순서대로 보이게 한다. 댓글과 반대
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writeNum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int commentNum = rs.getInt("commentNum"); // 상위 댓글 번호
				String nickName = rs.getString("nickname");
				String content = rs.getString("content");
				String commentDate = rs.getString("commentdate");
				replyDto = new ReplyDto(commentNum, nickName, content, commentDate);
				arrayList.add(replyDto);
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
