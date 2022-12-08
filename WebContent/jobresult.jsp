<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/jobresult.css"> 
  <link rel="stylesheet" href="css/header_footer.css">
  <title>직업 상세 정보 화면</title>
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
        <li ><a href ="join.jsp">회원가입</a></li>
        <li><a href ="login.jsp">로그인</a></li>
        <li><a href ="mypage.jsp">마이페이지</a></li>
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
            <LI><a id="main" href="#">온라인 학위 정보</a>
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
                
                  <li><a href="">학점은행제</a>
                    <ul class="main3">
                      <li><a href="bank.html">학점은행제 개요</a></li>
    
                      <li><a href="bankrequest.jsp">신청</a>
                    </ul>
                  </li>

                </li>

              </ul>

            </LI>
    <!-- 4번째 메뉴 끝 -->
    
    <!-- 5번째 메뉴 -->
            <li><a href="board.jsp">커뮤니티</a>
            
  
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
      <p class="title">직업정보: <span style="color:rgb(54, 82, 168);">시스템소프트웨어개발자</span></p>
      <br>
      <p class="subtitle">직업개요</p>
        <div class="intextarea">
          <p class="subsubtitle">핵심능력</p>
          <div class="inintextarea">
          <p>창의력, 수리논리력</p>
          </div>  

          <p class="subsubtitle">유사 직업명</p>
          <div class="inintextarea">
          <p>시스템프로그래머</p>
          </div>

          <p class="subsubtitle">관련학과</p>
          <div class="inintextarea">
          <p>시스템공학과, 컴퓨터 공학과, 컴퓨터응용기계과</p>
          </div>

          <p class="subsubtitle">하는일</p>
          <ul class="jobExplainList">
            <li>
              시스템소프트웨어개발자는 컴퓨터를 작동시키고 컴퓨터의 활동을 조정, 통제, 관리하는 오퍼레이팅시스템소프트웨어를 연구, 개발, 설계하는 일을 담당한다.
            </li>
            <li>
              시장조사와 경쟁업체의 제품 및 세계 소프트웨어업계의 기술변화 등을 분석하여 새로운 기능과 성능을 갖춘 시스템소프트웨어를 기획하고 개발한다.
            </li>
            <li>
              개발된 시스템소프트웨어를 컴퓨터에 설치, 시험 운영하여 시스템소프트웨어의 기능과 성능을 평가하고 분석한다.
            </li>
            <li>
              시스템소프트웨어의 사용자 교육과 기술자문을 지원하기도 하며, 새로운 시스템소프트웨어 관련 기술을 조사하고 연구한다.
            </li>
          </ul>
          <p class="subsubtitle">적성 및 흥미</p>
          <ul class="jobExplainList">
            <li>
              논리적이고 분석적인 사고능력과 창의력이 요구되며, 컴퓨터시스템에 대한 전문적 지식과 프로그래밍 능력이 필요하다.
            </li>
            <li>
              새로운 아이디어를 낼 수 있는 혁신적 사고능력과 기획능력이 요구된다.
            </li>
            <li>
              응용소프트웨어개발자, 웹개발자 등과 협조하여 작업을 수행하기 때문에 원만한 인간관계능력과 의사소통능력이 요구된다.
            </li>
            <li>
              탐구형과 진취형의 흥미를 가진 사람에게 적합하며, 분석적 사고, 책임감, 리더십, 협조심 등의 성격을 가진 사람들에게 유리하다.
            </li>
          </ul>
          <p class="subsubtitle">준비방법</p>
          <p class="texttitle">정규 교육과정</p>
          <ul class="jobExplainList">
            <li>
              시스템소프트웨어개발자가 되기 위해서는 대학교의 컴퓨터공학 관련 학과를 졸업하는 것이 유리하다.
            </li>
            <li>
              관련학과에서는 시스템소프트웨어 설계에 필요한 C언어, JAVA 와 같은 프로그래밍 언어, 데이터베이스, 소프트웨어공학이론 등을 공부하고 실제 소프트웨어 개발 실습을 하기도 한다.
            </li>
          </ul>
          
          <p class="texttitle">관련 자격증</p>
          <div class="inintextarea">
          관련 국가자격증으로는 한국산업인력공단에서 시행하는 전자계산기기술사 및 기능사, 전자계산기기사, 정보처리기능사 및 기사, 정보처리산업기사, 정보관리기술사가 있다.
          </div>
          <p class="subsubtitle">취업현황</p>
          <p class="texttitle">입직 및 취업방법</p>
          <div class="inintextarea">
          공채나 특채를 통해 시스템소프트웨어개발업체, 미들웨어업체, 전산 및 통신장비업체 등에 취업하며 전문대졸 이상에 한해 채용하는 경우가 많다.
          </div>

          <p class="texttitle">고용현황</p>
          <div class="inintextarea">
          향후 5년간 시스템소프트웨어개발자의 고용은 다소 증가할 것으로 전망된다. 「중장기 인력수급 수정전망 2015~2025」(한국고용정보원, 2016)에 따르면, 시스템소프트웨어개발자는 2015년 약 78천명에서 2025년 약 89천 명으로 향후 10년간 약 11천 1백 명(연평균 1.3%) 증가할 것으로 전망된다. 통계청의 전국사업체조사 자료에 의하면, 2014년 기준으로 시스템소프트웨어개발자가 근무할 것으로 예상되는 컴퓨터프로그래밍 서비스업 사업체는 4,658개소로 2008년 1,601개소에 비해 190.9% 증가하였고, 관련 산업의 종사자는 2008년 14,623명에서 2014년 32,582명으로 122.8% 정도 증가한 것으로 나타났다. 정보통신산업진흥원(2016)에 따르면 2016년 현재 국내 시스템소프트웨어 시장 규모는 약 2조 3,564억 원 정도이고, 지속적인 성장을 통해 2019년 3조 4,037억 원 수준으로 4.4% 증가할 것으로 전망된다. 시스템소프트웨어는 정보기술의 핵심이 되는 고부가가치성 소프트웨어로서 고도의 기술 집약적 특성을 가지며, 향후 정보기술의 중추적인 역할을 담당해 나갈 것으로 기대된다. 최근 금융권을 중심으로 고객관계관리(CRM)에 빅데이터를 결합하여 실시간 고객 분류 세분화와 시간·위치에 따른 표적 설정 등을 통해 고객 충성도 향상과 매출 증대에 활용하고 있다. 또한 클라우드 컴퓨팅, 스마트폰 대중화, 사회관계망(SNS)이 CRM 환경을 변화시키고 빅데이터 결합을 촉진하는 주요 요인으로 작용하고 있다. 최근 모바일 기기의 다양화, 오픈 소프트웨어의 보급 확대, 방송과 통신이 결합한 IPTV 시장 활성화, 기기와 장비의 디지털화 등 급속한 변화로 운영 프로그램 등을 개발하는 시스템소프트웨어 프로그래머에 대한 인력수요가 증가하고 있다. IT와 비IT 업종 간 융합이 활발해지면서 임베디드 소프트웨어 관련 투자와 인력 수요가 늘고 있다. 최근 PDA, 휴대폰단말기, 자동차, 항공기,가전제품에 등에 요구되는 다양한 임베디드 OS가 늘면서 임베디드 소프트웨어 대한 수요가 지속적으로 늘고 있다. 국내 시스템소프트웨어는 지속적으로 발전할 것으로 보이며 향후 10년간 임베디드 및 펌웨어 부문을 중심으로 시스템소프트웨어기술자의 고용은 다소 증가할 것으로 전망된다. (자료: 워크넷 직업정보)
          </div>

          <p class="texttitle">임금수준</p>
          <div class="inintextarea">
          시스템소프트웨어개발자의 임금수준은 하위(25%) 3545만원, 평균(50%) 4146.025만원, 상위(25%) 5402만원이다. (자료:워크넷 직업정보)
          </div>

          <p class="texttitle">학력 분포</p>
          <div class="inintextarea">
          시스템소프트웨어개발자의 학력분포는 고등학교 졸업 13%, 전문대학교 졸업 6%, 대학교 졸업 68%, 대학원 졸업 10%, 박사과정 졸업 3% 이다. (자료: 워크넷 직업정보)
          </div>

          <p class="texttitle">직업 만족도</p>
          <div class="inintextarea">
          시스템소프트웨어개발자에 대한 직업 만족도는 67.8%(백점기준) 이다. (자료: 워크넷 직업정보)
          </div>
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