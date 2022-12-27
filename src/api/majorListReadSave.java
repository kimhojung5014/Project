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

public class majorListReadSave {

public static void main(String[] args) throws IOException, ParseException {
		    // 학과 리스트 불러오는 용도
	
			//전문대학 198개
//			String carrer = "http://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=2b2b83ebb07ddeb4974d23fccd956dba&svcType=api&svcCode=MAJOR&contentType=json&gubun=univ_list&univSe=college&perPage=200";
			//4년제 304개
			String carrer = "http://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=2b2b83ebb07ddeb4974d23fccd956dba&svcType=api&svcCode=MAJOR&contentType=json&gubun=univ_list&univSe=univ&perPage=500";
			
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
			JSONArray contentList = (JSONArray)dataSearch.get("content");
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			
			String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
			String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
				for (int i = 0; i <contentList.size(); i++) {

					
						//드라이버 로드
					
						//데이터베이스 연결 정보를 이용해 Connection 인스턴스 확보
						
						JSONObject content = (JSONObject)contentList.get(i);
						String sql = "INSERT INTO MAJORLIST (mClass, lClass , facilName , majorSeq, uni )"
								+ "values(?,?,?,?,?)";
						try {
						con = DriverManager.getConnection(jdbc_url,"scott","tiger");
						Class.forName(jdbc_driver);
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, (String)content.get("mClass"));
						
						pstmt.setString(2, (String)content.get("lClass"));
						
						pstmt.setString(3, (String)content.get("facilName"));
						
						pstmt.setString(4, (String)content.get("majorSeq"));
						
						pstmt.setString(5, "4년제 대학교");
						System.out.println(i+(String)content.get("mClass")+": 완료");
						pstmt.executeUpdate();

						
					
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							pstmt.close();
							con.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
					
		
				
					
				System.out.println("상세정보 데이터 넣기 완료");
			

		
		
				}
	
}

}
