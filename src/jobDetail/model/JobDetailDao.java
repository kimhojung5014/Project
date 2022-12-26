package jobDetail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import jobList.model.JobListDto;

public class JobDetailDao {
	
	private static JobDetailDao instance = new JobDetailDao(); 
	
	private JobDetailDao() {}

	public static JobDetailDao getInstance() {
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
	
	public JobDetailDto getJobdetailData(String jobName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JobDetailDto jobDetailDto = null;
		
		String sql = "SELECT * FROM jobdetail WHERE job = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				jobDetailDto = new JobDetailDto(rs.getString("job"),
						   					    rs.getString("summary"),
												rs.getString("similarJob") ,
												rs.getString("empway") ,
												rs.getString("employment") ,
												rs.getString("salery") ,
												rs.getString("preparation") ,
												rs.getString("training") ,
												rs.getString("certification") ,
												rs.getString("capacity") ,
												rs.getString("ability") ,
												rs.getString("possibility") ,
												rs.getString("aptitude") ,
												rs.getString("reward") ,
												rs.getString("rewardValue") ,
												rs.getString("EMPLOYMENTSECURITY") ,
												rs.getString("EMPLOYMENTSECURITYVALUE") ,
												rs.getString("developmentPossibility") ,
												rs.getString("developmentPossibilityValue") ,
												rs.getString("workingConditions") ,
												rs.getString("workingConditionsValue") ,
												rs.getString("professional") ,
												rs.getString("professionalValue") , 
												rs.getString("equalEmployment") , 
												rs.getString("equalEmploymentValue"), 
												rs.getString("major"));
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
		System.out.println("잡 상세 정보 불러오기 완료");
		return jobDetailDto;
	}
	

}
