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
}
