package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import jobList.model.JobDao;
import jobList.model.JobListDto;

public class JobDetailData {

public static void main(String[] args) throws IOException, ParseException {
		
		ArrayList<JobListDto>list =  JobDao.getInstance().getJobList();
		String num;
		for (int i = 0; i < list.size(); i++) {
			num = list.get(i).getJobdicseg();
			String carrer = "http://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=2b2b83ebb07ddeb4974d23fccd956dba&svcType=api&svcCode=JOB_VIEW&contentType=json&gubun=job_dic_list&jobdicSeq="+num;
			
			URL url = new URL(carrer);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("dataType", "json");
			conn.setDoOutput(true);
			System.out.println("Response code:"+conn.getResponseCode());
			
			BufferedReader br;
			StringBuilder sb = new StringBuilder();

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			JSONParser jsonpar = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonpar.parse(sb.toString());
			JSONObject dataSearch = (JSONObject)jsonObject.get("dataSearch");
			JSONArray content1 = (JSONArray)dataSearch.get("content");
			JSONObject content = (JSONObject)content1.get(0);

			Connection con = null;
			PreparedStatement pstmt = null;
			String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
			String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
			try {
				//드라이버 로드
				Class.forName(jdbc_driver);
				//데이터베이스 연결 정보를 이용해 Connection 인스턴스 확보
				con = DriverManager.getConnection(jdbc_url,"scott","tiger");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "INSERT INTO jobdetail (summary, similarJob, empway, employment, salery ,preparation ,training ,certification, capacity ,ability ,job ,"
												+ "possibility ,aptitude ,reward, rewardValue ,employmentsecurity ,employmentsecurityvalue, "
												+ "developmentPossibility ,developmentPossibilityValue ,workingConditions ,workingConditionsValue,"
												+ "professional , professionalValue , EQUALEMPLOYMENT ,EQUALEMPLOYMENTValue   )"
												+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				
				
					System.err.println("?");
					pstmt = con.prepareStatement(sql);
				
					pstmt.setString(1, (String)content.get("summary"));
					pstmt.setString(2, (String)content.get("similarJob"));
					
					//state of emp 밑에 있는 값 3개
					JSONArray stateofemparray = (JSONArray)content.get("stateofemp");
					JSONObject stateofemp= (JSONObject)stateofemparray.get(0);
					JSONObject stateofemp1= (JSONObject)stateofemparray.get(1);
					JSONObject stateofemp2= (JSONObject)stateofemparray.get(2);
					
					pstmt.setString(3, (String)stateofemp.get("empway"));
					pstmt.setString(4, (String)stateofemp1.get("employment"));
					pstmt.setString(5, (String)stateofemp2.get("salery"));
					//
					
					//prepareway 밑에 3개
					JSONArray preparewaylist = (JSONArray) content.get("prepareway");
					JSONObject prepareway = (JSONObject)preparewaylist.get(0);
					JSONObject prepareway1 = (JSONObject)preparewaylist.get(1);
					JSONObject prepareway2 = (JSONObject)preparewaylist.get(2);
					
					pstmt.setString(6, (String)prepareway.get("preparation"));
					pstmt.setString(7, (String)prepareway1.get("training"));
					pstmt.setString(8, (String)prepareway2.get("certification"));
					//
					
					//capacity_major
					JSONArray capacity_majorlist = (JSONArray)content.get("capacity_major");
					JSONObject capacity_major = (JSONObject)capacity_majorlist.get(0);
					pstmt.setString(9, (String)capacity_major.get("capacity"));
					//
					pstmt.setString(10, (String)content.get("ability"));
					pstmt.setString(11, (String)content.get("job"));
					
					//job_possibility
					JSONArray job_possibilitylist = (JSONArray)content.get("job_possibility");
					JSONObject job_possibility = (JSONObject)job_possibilitylist.get(0);
					pstmt.setString(12, (String)job_possibility.get("possibility"));
					
					pstmt.setString(13, (String)content.get("aptitude"));
					System.out.println("여기까진오나?1");
					if ((String)job_possibility.get("possibility") != null) {
						JSONArray chart_item_list = (JSONArray)job_possibility.get("chart_item_list");
						
						JSONObject rewar = (JSONObject)chart_item_list.get(0);
						
						pstmt.setString(14, (String)rewar.get("chart_key"));
						pstmt.setString(15, String.valueOf(rewar.get("chart_value")) );
						
						JSONObject employment = (JSONObject)chart_item_list.get(1);
						pstmt.setString(16, (String)employment.get("chart_key"));
						pstmt.setString(17, String.valueOf(employment.get("chart_value")));
						System.out.println("여기까진오나?2");
						JSONObject development  = (JSONObject)chart_item_list.get(2);
						pstmt.setString(18, (String)development.get("chart_key"));
						pstmt.setString(19, String.valueOf(development.get("chart_value")));
						
						JSONObject working  = (JSONObject)chart_item_list.get(3);
						pstmt.setString(20, (String)working.get("chart_key"));
						pstmt.setString(21, String.valueOf(working.get("chart_value")));
						System.out.println("여기까진오나?3");
						JSONObject professional  = (JSONObject)chart_item_list.get(4);
						pstmt.setString(22, (String)professional.get("chart_key"));
						pstmt.setString(23, String.valueOf(professional.get("chart_value")));
						
						JSONObject equalEmployment = (JSONObject)chart_item_list.get(5);
						pstmt.setString(24, (String)equalEmployment.get("chart_key"));
						pstmt.setString(25, String.valueOf(equalEmployment.get("chart_value")));
						System.out.println("여기까진오나?4");
						pstmt.executeUpdate();
						System.out.println("왜안넘어가");
						
						System.out.println("완료");
					
					} else {
						pstmt.setString(14, null);
						pstmt.setString(15, null );
						
						pstmt.setString(16, null);
						pstmt.setString(17, null);
						
						pstmt.setString(18, null);
						pstmt.setString(19, null);
						
						pstmt.setString(20, null);
						pstmt.setString(21,null);
						
						pstmt.setString(22, null);
						pstmt.setString(23, null);
						
						pstmt.setString(24, null);
						pstmt.setString(25, null);
						
						pstmt.executeUpdate();
						
						
						System.out.println("완료");
					}
					
				System.out.println("상세정보 데이터 넣기 완료");
			} catch (SQLException e) {
				System.out.println("insertList()예외 발생");
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			
			}


		
		}
			
	}
	

}
