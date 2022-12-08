package join.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JoinDao {

	private static JoinDao instance = new JoinDao();
	private JoinDao() {}
	
	//인스턴스 반환 메소드
	public static JoinDao getInstance() { 
		return instance;
	}
	
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
	
	public void insertJoin(JoinDto joinDto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		
		
		String sql = "INSERT into join(userId,pw,nickName,userName,eMail,telNumber)"
				+ " values(ADDR_SEQ.nextval,?,?,?,?,?)";
		try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);				
				pstmt.setString(1, joinDto.getPw());
				pstmt.setString(2, joinDto.getNickName());
				pstmt.setString(3, joinDto.getUserName());
				pstmt.setString(4, joinDto.geteMail());
				pstmt.setString(5, joinDto.getTelNumber());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("insertJoin()예외 발생");
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
}
