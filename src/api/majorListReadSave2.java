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



public class majorListReadSave2 {
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
			for (int i = 0; i < seq.size(); i++) {
				System.out.println(i+"개 완료");
			
			String carrer = "http://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=2b2b83ebb07ddeb4974d23fccd956dba&svcType=api&svcCode=MAJOR_VIEW&contentType=json&gubun=univ_list&majorSeq="+seq.get(i);
			
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

			try {

					JSONObject content = (JSONObject)contentList.get(0);
					String sql = "INSERT INTO MAJORDETAIL values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
															 +"?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
															 +"?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
															 +"?, ?, ?, ?)";
							
				
					pstmt = con.prepareStatement(sql);
					
					
//					major CLOB, -- 과이름
					pstmt.setString(1, (String)content.get("major"));
//					salary CLOB, -- 취업 후 임금
					pstmt.setString(2, (String)content.get("salary"));
//					employment CLOB, -- 취업률
					pstmt.setString(3, (String)content.get("employment"));
//					department CLOB, -- 비슷한 과
					pstmt.setString(4, (String)content.get("department"));
//					summary clob, -- 설명
					pstmt.setString(5, (String)content.get("summary"));
//					과목이름, 과목 종류 배열 relate_subject
					JSONArray relate_subjectList = (JSONArray)content.get("relate_subject");
					String subject_descriptionTmp = "";
					String subject_nameTmp = "";
					for (int j = 0; j < relate_subjectList.size(); j++) {
						JSONObject relate_subject = (JSONObject)relate_subjectList.get(j);
						subject_descriptionTmp += (String) relate_subject.get("subject_description");
						subject_nameTmp += (String) relate_subject.get("subject_name");
					

					}
//					subject_description clob, --과목명
					pstmt.setString(6, subject_descriptionTmp);
//					subject_name clob, --과목
					pstmt.setString(7, subject_nameTmp);
					
//					career_act 배열
					JSONArray career_actList = (JSONArray)content.get("career_act");
					String act_name = "";
					String act_description = "";
					
					for (int j = 0; j < career_actList.size(); j++) {
						JSONObject career_act = (JSONObject)career_actList.get(j);
						act_name = (String)career_act.get("act_name");
						act_description = (String)career_act.get("act_description");
					}
//					act_name clob, -- 진로탐색활동 이름
					pstmt.setString(8, act_name);
//					act_description clob, -- 진로탐색 활동 내용
					pstmt.setString(9, act_description);
					
					
					
//					job clob, -- 관련 직업
					pstmt.setString(10, (String)content.get("job"));
//					qualifications clob, -- 관련자격
					pstmt.setString(11, (String)content.get("qualifications"));
//					interest clob, -- 흥미와 적성 없을 수 도 있음
					pstmt.setString(12, (String)content.get("interest"));
//					property clob, -- 학과 특성
					pstmt.setString(13, (String)content.get("property"));
					
//					기업 및 산업체 배열 enter_field
					JSONArray enter_fieldList = (JSONArray)content.get("enter_field");
					String gradeuate = "";
					String description = "";
					for (int j = 0; j < enter_fieldList.size(); j++) {
						JSONObject enter_field = (JSONObject)enter_fieldList.get(j);
						gradeuate += (String)enter_field.get("gradeuate");
						description += (String)enter_field.get("description");
					}
//					gradeuate clob, -- 기업 및 산업체
					pstmt.setString(14, gradeuate);
//					description clob, -- 기업 및 산업체 내용
					pstmt.setString(15, description);
					
					
//					main_subject 배열 대학 과목
					JSONArray main_subjectList = (JSONArray)content.get("main_subject");
					String SBJECT_NM = "";
					String SBJECT_SUMRY = "";
					for (int j = 0; j < main_subjectList.size(); j++) {
						JSONObject main_subject = (JSONObject)main_subjectList.get(j);
						SBJECT_NM += (String)main_subject.get("SBJECT_NM");
						SBJECT_SUMRY += (String)main_subject.get("SBJECT_SUMRY");
					}
//					SBJECT_NM clob, -- 대학 주 교과목
					pstmt.setString(16, SBJECT_NM);
//					SBJECT_SUMRY clob, -- 교과목 내용
					pstmt.setString(17, SBJECT_SUMRY);
					
//					university 학교 정보
					JSONArray universityList = (JSONArray)content.get("university");
					String area = "";
					String schoolURL = "";
					String campus_nm = "";
					String majorName = "";
					String schoolName = "";
					for (int j = 0; j < universityList.size(); j++) {
						JSONObject university = (JSONObject)universityList.get(j);
						area += (String)university.get("area");
						schoolURL += (String)university.get("schoolURL");
						campus_nm += (String)university.get("campus_nm");
						majorName += (String)university.get("majorName");
						schoolName += (String)university.get("schoolName");
					}
//					area clob, -- 학교 위치
					pstmt.setString(18, area);
//					schoolURL clob, -- 학교 url
					pstmt.setString(19, schoolURL);
//					campus_nm clob, --캠퍼스 본교, 분교
					pstmt.setString(20, campus_nm);
//					majorName clob, -- 과 이름
					pstmt.setString(21, majorName);
//					schoolName clob, -- 학교 이름
					pstmt.setString(22, schoolName);
					
					
//					졸업 후 내용 chartData
					JSONArray chartDataList = (JSONArray)content.get("chartData");
					

					JSONObject fieldList = (JSONObject)chartDataList.get(0); //졸업 후 취업 분야
					JSONArray fieldTmp = (JSONArray)fieldList.get("field");
					String fieldItem = "";
					String fieldData = "";
					for (int j = 0; j < fieldTmp.size(); j++) {
						JSONObject field = (JSONObject)fieldTmp.get(j);
						fieldItem += (String)field.get("item");
						fieldData += (String)field.get("data");
	
					}
//					fieldItem clob, -- 졸업 후 취업분야
					pstmt.setString(23, fieldItem);
//					fieldData clob, -- 졸업 후 취업 분야 퍼센트			
					pstmt.setString(24, fieldData);
					
//					JSONObject after_graduationList = (JSONObject)chartDataList.get(0); //졸업 후 진학, 취업 비율
					JSONArray after_graduationTmp = (JSONArray)fieldList.get("after_graduation");
					String after_graduationItem = "";
					String after_graduationData = "";
					for (int j = 0; j < after_graduationTmp.size(); j++) {
						JSONObject after_graduation = (JSONObject)after_graduationTmp.get(j);
						after_graduationItem += (String)after_graduation.get("item");
						after_graduationData += (String)after_graduation.get("data");
	
					}
//					afterItem clob, -- 졸업 후 진학, 취업, 기타
					pstmt.setString(25, after_graduationItem);
//					afterData clob, -- 졸업 후 진학 취업 기타 퍼센트					
					pstmt.setString(26, after_graduationData);
					
//					JSONObject avg_salaryList = (JSONObject)chartDataList.get(0); //첫 직장 월급
					JSONArray avg_salaryTmp = (JSONArray)fieldList.get("avg_salary");
					String avg_salaryItem = "";
					String avg_salaryData = "";
					for (int j = 0; j < avg_salaryTmp.size(); j++) {
						JSONObject avg_salary = (JSONObject)avg_salaryTmp.get(j);
						avg_salaryItem += (String)avg_salary.get("item");
						avg_salaryData += (String)avg_salary.get("data");
	
					}
//					salaryItem clob, -- 첫직장 임금
					pstmt.setString(27, avg_salaryItem);
//					salaryData clob, -- 첫직장 임금 평균값
					pstmt.setString(28, avg_salaryData);
					
//					JSONObject satisfactionList = (JSONObject)chartDataList.get(0); //첫 직장 만족도
					JSONArray satisfactionTmp = (JSONArray)fieldList.get("satisfaction");
					String satisfactionItem = "";
					String satisfactionData = "";
					for (int j = 0; j < satisfactionTmp.size(); j++) {
						JSONObject satisfaction = (JSONObject)satisfactionTmp.get(j);
						satisfactionItem += (String)satisfaction.get("item");
						satisfactionData += (String)satisfaction.get("data");
	
					}
//					satisfactionItem clob, -- 첫직장 만족도 매우 불만족,불만족, 보통, 만족,매우 만족
					pstmt.setString(29, satisfactionItem);
//					satisfactionData clob, -- 퍼센트
					pstmt.setString(30, satisfactionData);
					
//					JSONObject employment_rateList = (JSONObject)chartDataList.get(0); //취업률
					JSONArray employment_rateTmp = (JSONArray)fieldList.get("employment_rate");
					String employment_rateItem = "";
					String employment_rateData = "";
					for (int j = 0; j < employment_rateTmp.size(); j++) {
						JSONObject employment_rate = (JSONObject)employment_rateTmp.get(j);
						employment_rateItem += (String)employment_rate.get("item");
						employment_rateData += (String)employment_rate.get("data");
	
					}
//					employmentItem clob, -- 취업률 전체 남 여
					pstmt.setString(31, employment_rateItem);
//					employmentData clob, -- 취업률 퍼센트
					pstmt.setString(32, employment_rateData);
					
					
//					JSONObject applicantList = (JSONObject)chartDataList.get(6); //지원자, 입학자
					JSONArray applicantTmp = (JSONArray)fieldList.get("applicant");
					String applicantItem = "";
					String applicantData = "";
					for (int j = 0; j < applicantTmp.size(); j++) {
						JSONObject applicant = (JSONObject)applicantTmp.get(j);
						applicantItem += (String)applicant.get("item");
						applicantData += (String)applicant.get("data");
	
					}
//					applicantItem clob, -- 지원자 , 입학자
					pstmt.setString(33, applicantItem);
//					applicantData clob -- 값
					pstmt.setString(34, applicantData);
					
				
					pstmt.executeUpdate();
					System.out.println((String)content.get("major")+": 완료");

				
					
					
				System.out.println("상세정보 데이터 넣기 완료");
			} catch (SQLException e) {
				System.out.println("insertList()예외 발생");
				e.printStackTrace();
			} 


		
			}
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
	}
	

}
