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

public class JobDetailData2 {

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
			String sql = "update jobdetail set major = ? where job =?";
			try {
				
				
					pstmt = con.prepareStatement(sql);
				
					String major = "";
		
					JSONArray capacity_majorlist = (JSONArray)content.get("capacity_major");
					JSONObject major1 = (JSONObject)capacity_majorlist.get(1);
					JSONArray major2 = (JSONArray)major1.get("major");
					
					for (int j = 0; j < major2.size(); j++) {
						JSONObject tmp = (JSONObject)major2.get(j);
						major += (String)tmp.get("MAJOR_NM");
						
					}
					pstmt.setString(1, major);
					pstmt.setString(2, list.get(i).getJob());
					pstmt.executeUpdate();
					
					System.out.println(list.get(i).getJob() + "완료");
					
					
					
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
