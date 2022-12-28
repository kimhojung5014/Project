package major.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MajorDao {

	private static MajorDao instance = new MajorDao();
	
	private MajorDao() {}
	
	public static MajorDao getInstance() {
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
	
	public ArrayList<MajorDto> majorList() {
		ArrayList<MajorDto>majorList = new ArrayList<MajorDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MAJORDETAIL");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MajorDto majorDto = new MajorDto(rs.getString("lClass"),
												rs.getString("majorSeq"),
												rs.getString("uni"),
												rs.getString("major"),
												rs.getString("salary"),
												rs.getString("employment"),
												rs.getString("department"),
												rs.getString("summary"),
												rs.getString("subject_description"),
												rs.getString("subject_name"),
												rs.getString("act_name"),
												rs.getString("act_description"),
												rs.getString("job"),
												rs.getString("qualifications"),
												rs.getString("interest"),
												rs.getString("property"),
												rs.getString("gradeuate"),
												rs.getString("description"),
												rs.getString("SBJECT_NM"),
												rs.getString("SBJECT_SUMRY"),
												rs.getString("area"),
												rs.getString("schoolURL"),
												rs.getString("campus_nm"),
												rs.getString("majorName"),
												rs.getString("schoolName"),
												rs.getString("fieldItem"),
												rs.getString("fieldData"),
												rs.getString("afterItem"),
												rs.getString("afterData"),
												rs.getString("salaryItem"),
												rs.getString("salaryData"),
												rs.getString("satisfactionItem"),
												rs.getString("satisfactionData"),
												rs.getString("employmentItem"),
												rs.getString("employmentData"),
												rs.getString("applicantItem"),
												rs.getString("applicantData"));
				majorList.add(majorDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				rs.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return majorList;
	}
	
	public MajorDto majordetail(String major) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MajorDto majorDto = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM MAJORDETAIL WHERE major = ?");
			pstmt.setString(1, major);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				 majorDto = new MajorDto(rs.getString("lClass"),
										 rs.getString("majorSeq"),
										 rs.getString("uni"),
										 rs.getString("major"),
										 rs.getString("salary"),
										 rs.getString("employment"),
										 rs.getString("department"),
										 rs.getString("summary"),
										 rs.getString("subject_description"),
										 rs.getString("subject_name"),
										 rs.getString("act_name"),
										 rs.getString("act_description"),
										 rs.getString("job"),
										 rs.getString("qualifications"),
										 rs.getString("interest"),
										 rs.getString("property"),
										 rs.getString("gradeuate"),
										 rs.getString("description"),
										 rs.getString("SBJECT_NM"),
										 rs.getString("SBJECT_SUMRY"),
										 rs.getString("area"),
										 rs.getString("schoolURL"),
										 rs.getString("campus_nm"),
										 rs.getString("majorName"),
										 rs.getString("schoolName"),
										 rs.getString("fieldItem"),
										 rs.getString("fieldData"),
										 rs.getString("afterItem"),
										 rs.getString("afterData"),
										 rs.getString("salaryItem"),
										 rs.getString("salaryData"),
										 rs.getString("satisfactionItem"),
										 rs.getString("satisfactionData"),
										 rs.getString("employmentItem"),
										 rs.getString("employmentData"),
										 rs.getString("applicantItem"),
										 rs.getString("applicantData"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				rs.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return majorDto;
	}
}
