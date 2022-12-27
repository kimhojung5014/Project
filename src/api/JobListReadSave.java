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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import board.model.BoardDao;


public class JobListReadSave {

	public static void main(String[] args) throws IOException, ParseException {
		

		String carrer = "http://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=2b2b83ebb07ddeb4974d23fccd956dba&svcType=api&svcCode=JOB&contentType=json&gubun=job_dic_list&perPage=500";
		
		
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
		JSONArray content = (JSONArray)dataSearch.get("content");
		
	
		///////
		System.out.println("게시판 더미 데이터 시작");
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
		String sql = "INSERT INTO joblist (job,JOBDICSEG,profrssion, similarJob, summary,equalemployment, possibility, prospect,salery,job_Code,job_Ctg_Code,Aptd_Type_Code)"
					 + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
						//조회수는 초기값 0으로 주자
		try {
			
			
				pstmt = con.prepareStatement(sql);
			for (int i = 0; i <= content.size(); i++) {
				
				
				JSONObject key = (JSONObject)content.get(300);
				String a = (String) key.get("job");
			
				pstmt.setString(1,(String) key.get("job") );
				pstmt.setString(2,(String) key.get("jobdicSeq") );
				pstmt.setString(3,(String) key.get("profession") );
				pstmt.setString(4,(String) key.get("similarJob") );
				pstmt.setString(5,(String) key.get("summary") );
				pstmt.setString(6, (String) key.get("equalemployment"));
				pstmt.setString(7,(String) key.get("possibility") );
				pstmt.setString(8,(String) key.get("prospect") );
				pstmt.setString(9,(String) key.get("salery") );
				pstmt.setString(10,(String) key.get("job_code") );
				pstmt.setString(11,(String) key.get("job_ctg_code") );
				pstmt.setString(12,(String) key.get("aptd_type_code") );
				pstmt.executeUpdate();
			
			}
			
			System.out.println("게시판 더미 데이터 넣기 완료");
		} catch (Exception e) {
			System.out.println("insertList()예외 발생");
			e.printStackTrace();
		} finally {
			try {
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}
		///////
		
		conn.disconnect();

	}

	

}
