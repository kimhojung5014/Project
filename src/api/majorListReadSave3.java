package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class majorListReadSave3 {
  static	Connection con = connection();
  static	PreparedStatement pstmt = null;
public static Connection connection() {

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
	return con;
}	
	
public static void main(String[] args) throws IOException, ParseException {
		    // 학과 상세
			ArrayList<String>seq = new ArrayList<String>();
			try {
				pstmt = con.prepareStatement("select MAJORSEQ from majorlist");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					seq.add(rs.getString("MAJORSEQ"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(seq.size());
			
	}
	

}
