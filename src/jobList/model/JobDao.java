package jobList.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JobDao {
	
	private static JobDao instance = new JobDao();
	
	private JobDao() {}
	
	public static JobDao getInstance() {
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
	
	public ArrayList<JobListDto> getJobList() {
		//잡 상세 불러올 때는 주석
//		Connection conn = null;
//		PreparedStatement pstmt = null;
		//
		
		//임시 데이터 읽을때만 쓰는 커넥션 
		Connection conn = null;
		PreparedStatement pstmt = null;
		String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			//드라이버 로드
			Class.forName(jdbc_driver);
			//데이터베이스 연결 정보를 이용해 Connection 인스턴스 확보
			conn = DriverManager.getConnection(jdbc_url,"scott","tiger");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//임시 데이터 읽기용 끝
		ResultSet rs = null;
		JobListDto jobListDto = null;
		ArrayList<JobListDto>apiList = new ArrayList<JobListDto>();
		String sql = "select * from joblist";
		try {
//			conn = getConnection(); //직업 상세 정보 불러올때는 주석 처리하고 위에 임시데이터 읽기용으로 커넥션 연결
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			StringTokenizer summary = null;
			
			while (rs.next()) {
				summary = new StringTokenizer(rs.getString("summary"), "-");
//				String[] summary = rs.getString("summary").split("-");
				jobListDto = new JobListDto(rs.getString("job"),
												  rs.getString("jobdicseg"),
												  rs.getString("profrssion") ,
												  rs.getString("similarJob") ,
												  summary.nextToken(),
												  rs.getString("equalemployment") ,
												  rs.getString("possibility") ,
												  rs.getString("prospect") ,
												  rs.getString("salery"),
												  rs.getString("job_Code"),
												  rs.getString("job_Ctg_Code"),
												  rs.getString("Aptd_Type_Code"));
			apiList.add(jobListDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return apiList;
	}

}
