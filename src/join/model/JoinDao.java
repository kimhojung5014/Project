package join.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
		
		
		String sql = "INSERT into join(numId,userId,pw,nickName,userName,eMail,telNumber)"
				+ " values(ADDR_SEQ.nextval,?,?,?,?,?,?)";
		try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, joinDto.getUserId());
				pstmt.setString(2, joinDto.getPw());
				pstmt.setString(3, joinDto.getNickName());
				pstmt.setString(4, joinDto.getUserName());
				pstmt.setString(5, joinDto.geteMail());
				pstmt.setString(6, joinDto.getTelNumber());
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
	
	public boolean idCheck(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userId = null;
		String sql = "SELECT USERID FROM JOIN WHERE USERID =  ?";
		
		System.out.println("idcheck에 들어온 id = "+id);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userId = rs.getString("USERID");
				System.out.println("rs.next에 userId 는 "+userId);
			}
			
			
		} catch (SQLException e) {
			System.out.println("idCheck()예외 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
		    } catch (Exception e2) {
				e2.printStackTrace();
			}
		} if (userId != null) {
			System.out.println("id체크() 존재하는 id");
			return false;
		}else {
			System.out.println("id체크() 중복없는 id");
			return true;
		}
	}

	//닉네임 중복 체크 메소드
	public boolean nickNameCheck(String nick) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String nickName = null;
		String sql = "SELECT NICKNAME FROM JOIN WHERE NICKNAME =  ?";
		
		System.out.println("nickNameCheck에 들어온 nickName = "+nick);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				nickName = rs.getString("nickName");
				System.out.println("rs.next에 NICKNAME 는 "+nickName);
			}
			
			
		} catch (SQLException e) {
			System.out.println("nickNameCheck()예외 발생");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
		    } catch (Exception e2) {
				e2.printStackTrace();
			}
		} if (nickName != null) {
			System.out.println("nick 체크() 존재하는 nick");
			return false;
		}else {
			System.out.println("nick 체크() 중복없는 nick");
			return true;
		}
	}
	
	//로그인 메소드
	public JoinDto login(String id, String pw) {
		
		JoinDto joinDto = null;	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from join where userId=? and pw=?";
		System.out.println("로그인에 들어온 아이디: "+id+"비밀번호: "+pw);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				joinDto = new JoinDto();
				joinDto.setNumId(rs.getInt("numId"));
				joinDto.setUserId(rs.getString("userId"));
				joinDto.setPw(rs.getString("pw"));
				joinDto.setNickName(rs.getString("nickName"));
				joinDto.seteMail(rs.getString("eMail"));
				joinDto.setUserName(rs.getString("userName"));
				joinDto.setTelNumber(rs.getString("telNumber"));
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
		return joinDto;
	}
	
	public void edit(int id, JoinDto joinDto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE  JOIN SET numId ="+id +", userId = ?, pw = ?, nickName = ?, userName = ?, eMail = ?, telNumber = ?";
				
		try {

			conn  = getConnection();
			pstmt = conn.prepareStatement(sql);				
			pstmt.setString(1, joinDto.getUserId());
			pstmt.setString(2, joinDto.getPw());
			pstmt.setString(3, joinDto.getNickName());
			pstmt.setString(4, joinDto.getUserName());
			pstmt.setString(5, joinDto.geteMail());
			pstmt.setString(6, joinDto.getTelNumber());
			
			pstmt.executeUpdate();
			System.out.println("수정완료");
		} catch (SQLException e) {
			System.out.println("edit()예외 발생");
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
