<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/majorresult.css"> 
  <link rel="stylesheet" href="css/header_footer.css">
  <title>학과 정보 화면</title>
</head>
<body>
  <!-- 헤더 부분 -->
  <header id="headerstyle">
    <div id="titleHome">
      <a href="newindex.jsp" >나의 진로 추천 서비스</a>
    </div>
    <div id="searchStyle">
      <!--검색 기능 폼  -->
      <form action="">
      
        <label for="totalSearch"><span>통합검색</span></label>
        <input type="search" name="totalSearch" class="searchSize" placeholder="Search...">
      </form>

    </div> 
    <nav id ="nav1">                
      <ul id="loginmenu">
	      <li>
	        <c:choose>
	        	
		        <c:when test="${userData ne null}"> ${userData.nickName}</c:when>
		        <c:otherwise><a href ="join.jsp"> 회원가입 </a></c:otherwise>
		      
	        </c:choose>
	      </li>
        
        <li>
        	<c:choose>
	        	<c:when  test="${userData ne null}"><a href ="logout.jsp">로그아웃</a></c:when>
	        	<c:otherwise><a href ="login.jsp">로그인</a></c:otherwise>
       		</c:choose>
        </li>
        <li>
        	<c:choose>
        		<c:when test="${userData ne null}"><a href ="mypage.jsp">마이페이지</a></c:when>
    		    <c:otherwise></c:otherwise>
        	</c:choose>
        </li>
      </ul>
    </nav>
    <!--네비2 시작  -->
    <nav id="nav2">
      <div id="menu">

        <ul class="main1" >
    <!-- 1번째 메뉴 -->
            <li><a href="job.jsp">직업 추천</a></li>
    <!-- 1번째 메뉴 끝 -->

    <!-- 2번째 메뉴 시작 -->
            <li><a id="main1_2" href="major.jsp" >학과 추천</a>   
             
            </li>
    <!-- 2번째 메뉴 끝 -->
    
    <!-- 3번째 메뉴 시작 -->
            <li><a href="test.jsp" id="main1_3" href="#">진로 가치관 검사</a>
    
            </li>
    <!--3번째 메뉴 끝  -->

    <!-- 4번째 메뉴 시작 -->
            <li><a id="main" href="#">온라인 학위 정보</a>
              <ul class="main2">
    
                <li><a href=""> 원격대학교</a>
                  <ul class="main3">

                    <li><a href="cuinfo.jsp">사이버 대학교 소개</a></li>

                    <li><a href="knou.jsp">방송통신 대학교 소개</a></li>

                    <li><a href="difference.jsp">사이버,방통대 차이점</a></li>

                 </ul>
                </li>
                 <li><a id="main1_2" href="#" >독학학위제</a>
                    <ul class="main3">
                      <li><a href="self.jsp" >독학학위제 개요</a></li>
                  
                      <li><a href="TestDate.jsp" >시험일정</a></li>
                    </ul>
                </li>
                  <li><a href="">학점은행제</a>
                    <ul class="main3">
                      <li><a href="bank.html">학점은행제 개요</a></li>
    
                      <li><a href="bankrequest.jsp">신청</a>
                    </ul>
                  </li>

           	 </ul>
          </li>       
          
    <!-- 4번째 메뉴 끝 -->
    
    <!-- 5번째 메뉴 -->
            <li><a href="list.do">커뮤니티</a>
            
  
          </li>
    
        </ul>
    
    </div>
    </nav>
<!-- 네비2끝 -->
  </header>
  <!-- 헤더 끝 -->

  <!-- 메인 부분 -->
  <main>
  <div id="mainStyle">
    <div id="mainContent">
      <div class="textarea">
      <p class="title">대학교: <span style="color:rgb(54, 82, 168);">컴퓨터공학과</span></p>
      <br>
      <p class="subtitle">학과 정보</p>
        <div class="intextarea">
          <p class="subsubtitle">학과 개요</p>
          <div class="inintextarea">
          <p>
            어느날 갑자기 지구상의 모든 컴퓨터가 사라진다면 모든 것이 정지될지도 모릅니다. 컴퓨터공학은 IT와 정보통신 기술을 기반으로 정보화 시대를 이끄는 첨단 공학 분야라 할 수 있습니다. 모든 산업 분야에 컴퓨터 공학 기술은 깊은 관련이 있습니다. 컴퓨터 공학은 컴퓨터 시스템, 프로그래밍 기법, 알고리즘 설계, 응용소프트웨어 개발, 정보화사업 관리방법론 등 다양한 이론과 실습을 통해 유능한 인재를 키우는데 목표를 두고 있는 학과입니다.
          </p>
          </div>  

          <p class="subsubtitle">학과 특성</p>
          <div class="inintextarea">
          <p>
            컴퓨터 공학과 관련된 IT와 정보기술 들이 빠르게 발전하고 있습니다. 빅데이터, 클라우드 컴퓨팅, 5G인터넷, 사물인터넷, 인공지능, 블록체인 기술, 핀테크, 무인자동차 등은 모두 컴퓨터 공학과 깊은 관련이 있습니다. 앞으로도 컴퓨터 공학 분야의 산업과 기술은 계속 확대 될 것으로 전망됩니다.
          </p>
          </div>

          <p class="subsubtitle">흥미와 적성</p>
          <div class="inintextarea">
          <p>
            컴퓨터나 인터넷 웹서핑을 좋아하고 IT분야, IT기술과 컴퓨터를 이용한 새로운 제품 등에 관심이 많은 사람에게 유리합니다. 컴퓨터 소프트웨어를 개발하기 위해서는 프로그래밍 개발 언어를 배워야 하는데 이에 필요한 논리적인 사고능력과 개발 언어와 소스를 이해할 수 있는 지식이 필요합니다.
          </p>
          </div>

          <p class="subsubtitle">관련 고교 교과목</p>
          <ul class="jobExplainList">
            <li>
              <p class="texttitle">공통과목</p>
              수학, 과학, 기술ㆍ가정
            </li>
            <li>
              <p class="texttitle">진로선택과목</p>
              수학교과 : 수학ⅠㆍⅡ, 미적분, 확률과 통계<br>
              과학교과 : 물리학Ⅰ, 화학Ⅰ<br>
              기술ㆍ가정교과 : 기술ㆍ가정, 정보
            </li>
            <li>
              <p class="texttitle">전문교과Ⅰ</p>
              심화수학ⅠㆍⅡ, 고급 수학ⅠㆍⅡ, 고급 물리학, 물리학 실험, 고급 화학, 화학 실험, 정보과학, 융합과학탐구, 과학과제 연구
            </li>
            <li>
              <p class="texttitle">전문교과Ⅱ
              </p>
              디지털 논리 회로, 프로그래밍, 자료구조, 사물 인터넷 서비스 기획, 로봇 지능 개발
            </li>
          </ul>
          <p class="subsubtitle">진로 탐색 활동</p>
          <ul class="jobExplainList">
            <li>
              컴퓨터부품확인 - 컴퓨터 본체를 열어 각종 부품을 직접 확인해 보고 컴퓨터의 구성 및 구조에 대해 이해할 수 있다.
            </li>
            <li>
              웹진구독 - 컴퓨터나 IT분야에 대한 웹진이나 잡지를 구독하고 관심 내용을 읽어보는 활동을 통해 컴퓨터 공학 및 관련 기술에 대한 지식을 쌓을 수 있습니다.
            </li>
            <li>
              뉴스구독 - 전자신문 웹사이트 방문, IT관련 기사검색을 통해 뉴스를 읽고 컴퓨터와 IT 분야에 대한 최신 동향 파악 및 새로운 기술에 대해 빠르게 정보를 얻을 수 있습니다.
            </li>
            <li>
              동영상시청 - IT 컴퓨터, 클라우드컴퓨팅 빅데이터, 인공지능, 5G, 사물인터넷 등 관련된 영상 시청을 통해 지식을 얻을 수 있습니다.
            </li>
          </ul>
          <p class="subsubtitle">대학 주요 교과목</p>
          <ul class="jobExplainList">
            <li>
              <p class="texttitle">운영체제</p>
              각종 운영체제에 대해서 구체적인 구조와 구성, 작동원리, 각종 문제를 해결하기 위한 방법을 배웁니다.
            </li>
            <li>
              <p class="texttitle">소프트웨어 공학</p>
              소프트웨어 개발의 일반적 과정 및 개발 방법론, 프로젝트 관리와 계획, 요구사항 분석, 각종 개발 모델링 및 소프트웨어 설계 등 전반적인 이론을 배우고 실습을 합니다.
            </li>
            <li>
              <p class="texttitle">자료구조와 실험</p>
              여러 가지 자료 구조를 살펴보고 이를 실제적으로 구현하는 방법과 기본적인 알고리즘에 대해서 배웁니다.
            </li>
            <li>
              <p class="texttitle">임베디드시스템</p>
              임베디드시스템에 많이 사용되는 마이크로프로세서의 구조를 살펴보고 임베디드용 운영체제를 배웁니다.
            </li>
            <li>
              <p class="texttitle">데이터베이스</p>
              데이터를 저장하는 데이터베이스와 이를 중앙 관리하는 데이터베이스 관리 시스템 등 관련 이론을 배웁니다.
            </li>
          </ul>
          
          <p class="subsubtitle">관련 자격</p>
          <div class="inintextarea">
            e-TestProfessional, IEQ(인터넷윤리자격), RFID기술자격검정, SQL, SW테스트전문가(CSTS), 네트워크관리사, 데이터분석, 데이터아키텍처, 디지털정보활용능력(DIAT), 디지털포렌식전문가, 리눅스마스터, 소프트웨어자산관리사(C-SAM), 정보기술자격(ITQ)시험, 정보기술프로젝트관리전문가(IT-PMP), 정보시스템감리사, 정보처리기사, 정보통신기사, 컴퓨터활용능력
          </div>
          <p class="subsubtitle">관련 직업</p>
      
          <div class="inintextarea">
            3D프린팅전문가, 가상현실전문가 , 네트워크엔지니어 , 데이터베이스개발자, 디지털포렌식수사관, 모바일애플리케이션개발자, 무인자동차엔지니어, 무인항공기시스템개발자, 반도체공학기술자 , 블록체인전문가, 빅데이터전문가, 사물인터넷전문가, 사이버교육운영자 , 생체인식전문가, 스마트팜구축가, 시스템소프트웨어개발자 , 신경회로망연구원 , 아이티(IT)교육강사 , 응용소프트웨어개발자, 의료정보시스템개발자 , 인공지능전문가, 정밀농업기사, 정보보호전문가 , 컴퓨터시스템감리전문가, 컴퓨터프로그래머, 컴퓨터하드웨어기술자및연구원, 클라우드시스템엔지니어, 통신공학기술자및연구원, 홀로그램전문가
          </div>

          <p class="subsubtitle">졸업 후 진출 분야</p>
          <ul class="jobExplainList">
            <li>
              <p class="texttitle">기업 및 산업체</p>
              시스템 소프트웨어 개발 회사, 게임 개발 회사, 모바일 웹 및 앱 개발 회사, 홈페이지 제작 및 기획 운영 회사, 정보 시스템 운영 및 개발 회사, 정보 통신 및 네트워크 관련 회사, 무인 자동차 개발 회사, 컴퓨터 및 IT 분야 회사
            </li>
            <li>
              <p class="texttitle">학계 및 연구기관</p>
              한국전자통신연구원, 정보통신정책연구원 등 공공 및 민간 연구기관
            </li>
            <li>
              <p class="texttitle">정부 및 공공기관</p>
              과학기술정보통신부 등 정부 및 지방자치단체 공무원, 한국정보화진흥원, 한국인터넷진흥원, 정보통신산업진흥원 등 공공기관
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>

  </main>
<!-- 메인  끝-->

  <!-- 푸터 -->
  <footer id = "footer" > 
    
    <ul  id="bottomenu">
      <li><a href="">사이트제작자</a></li>
      <li><a href="">개인정보처리방침</a></li>
      <li><a href="">API 정보</a></li>
      <li><a href="">사이트맵</a></li>
    </ul>

    <p>서울특별시 마포구 신촌로 176 4층 402호 제작자 번호 010-5375-4131</p>
    
</footer>

</body>
</html>