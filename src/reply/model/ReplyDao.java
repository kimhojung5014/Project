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
	
	public void replyInsert(ReplyDto replyDto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO REPLY(writeNum,commentnum,parentNum,userId, nickname,content,commentDate)" + 
					"values(?,commentNum.nextval,?,?,?,?,TO_CHAR(SYSDATE,'YYYY\"년\" MM\"월 \"DD\"일 \"hh24\"시 \"mi\"분 \"ss\"초\"'))";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyDto.getWriteNum());
			pstmt.setInt(2, replyDto.getParentNum());
			pstmt.setString(3, replyDto.getUserId());
			pstmt.setString(4, replyDto.getNickName());
			pstmt.setString(5, replyDto.getContent());
			pstmt.executeUpdate();
			System.out.println("댓글 저장 완료");
			
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
	//댓글 전체 부르기
	public ArrayList<ReplyDto> replyList(int writeNum) {
		
		ArrayList<ReplyDto>replyList = new ArrayList<ReplyDto>();
		ReplyDto replyDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		//
		String sql =  "SELECT NICKNAME , CONTENT, COMMENTDATE, COMMENTNUM, PARENTNUM, USERID "
					+ "FROM REPLY WHERE WRITENUM =?"
					+ "ORDER by COMMENTDATE ASC"; // 댓글은 최신 순서대로 보이게 한다.
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writeNum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String nickName = rs.getString("nickname");
				int parentNum = rs.getInt("PARENTNUM"); // 상위 댓글 번호
				String content = rs.getString("content");
				String commentDate = rs.getString("commentdate");
				int commentNum = rs.getInt("commentNum"); 
				String userId = rs.getString("USERID");
				replyDto = new ReplyDto( nickName, userId ,parentNum, commentNum, content, commentDate);
				
				replyList.add(replyDto);
			}
		} catch (SQLException e) {
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
		System.out.println("댓글 불러오기 작동");
		return replyList;
	}

	//댓글, 대댓글 삭제
	
	public void replyDelete(int commentNum) {
		System.out.println("댓글 삭제 시작");
		Connection conn  = null;
		PreparedStatement pstmt = null;
	
		String sql = "DELETE reply WHERE COMMENTNUM ="+commentNum; //요거하면 밑에 대댓글들이 버려지니 보류
//		String sql = "UㅊDATE reply SET content = '삭제된 댓글 입니다.' WHERE commentnum="+commentNum; // 삭제하진 말고 내용만 삭제되었다고 변경하기
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
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
		System.out.println("댓글 삭제 완료");
	}
	
	public void replyEdit(int num, String content) {
		System.out.println("댓글 수정");
		Connection conn  = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE REPLY SET content = ? WHERE commentnum = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
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
		System.out.println("댓글 수정 완료");
	}
}
