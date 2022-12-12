<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/header_footer.css">
  <link rel="stylesheet" href="css/job.css">
  <title>직업</title>
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
    <!-- 그리드 시작 -->
    <div id="mainStyle">
      <!-- 그리드 내용 시작 -->
      <div id="mainContent">
        <div class="title">
          <p >직업추천</p>
        </div>
        <div class="textarea">
          <form action="">
          <p class="subtitle">1. 적성 유형</p>
          <br>
          <fieldset class="fieldtype">
          <p class="subsubtitle">선호하는 직업 유형을 선택해주세요.</p>
          <br>
          <select  name="kindOfJob" id="kindOfJob">
            <option value="all">전체</option>

            <option value="">운동 관련직</option>
            
            <option value="">기능직</option>
            
            <option value="">기타 게임·오락·스포츠 관련직</option>
            
            <option value="">음악 관련직</option>
            
            <option value="">미술 및 공예 관련직</option>
            
            <option value="">이공계 교육 관련직</option>
            
            <option value="">인문 및 사회과학 관련직</option>
            
            <option value="">교육관련 서비스직</option>
            
            <option value="">사무 관련직</option>
            
            <option value="">영상 관련직</option>
            
            <option value="">환경관련 전문직</option>
            
            <option value="">무용 관련직</option>
            
            <option value="">의복제조 관련직</option>
            
            <option value="">고급 운전 관련직</option>
            
            <option value="">악기 관련직</option>
            
            <option value="">기타 특수 예술직</option>
            
            <option value="">의료관련 전문직</option>
            
            <option value="">회계 관련직</option>
            
            <option value="">기획서비스직</option>
            
            <option value="">영업관련 서비스직</option>
            
            <option value="">예술기획 관련직</option>
            
            <option value="">법률 및 사회활동 관련직</option>
            
            <option value="">안전 관련직</option>
            
            <option value="">조리 관련직</option>
            
            <option value="">공학 기술직</option>
            
            <option value="">연기 관련직</option>
            
            <option value="">사회서비스직</option>
            
            <option value="" selected>IT관련전문직</option>
            
            <option value="">언어 관련 전문직</option>
            
            <option value="">매니지먼트 관련직</option>
            
            <option value="">일반 서비스직</option>
            
            <option value="">자연친화 관련직</option>
            
            <option value="">이학 전문직</option>
            
            <option value="">일반운전 관련직</option>
            
            <option value="">미용 관련직</option>

            <option value="">공학 전문직</option>

            <option value="">웹·게임·애니메이션 관련직</option>

            <option value="">인문계 교육 관련직</option>

            <option value="">금융 및 경영 관련직</option>

            <option value="">작가 관련직</option>

            <option value="">보건의료 관련 서비스직</option>

            <option value="">디자인 관련직</option>

            <option value="">농생명산업 관련직</option>
          </select>

          </fieldset>
          <br>

          <p class="subtitle">2. 직업 조건</p>
          <br>
          <fieldset class="fieldtype">
          <p class="subsubtitle">위에서 선택한 적성 유형과 평균 연봉, 일자리 전망, 발전 가능성, 고용평등에 따른 결과를 보여 드립니다. </p>
          <br>
          <p class="texttitle">1. 평균 연봉</p>
          <ul class="jobAptitude">
            <li>
              <input type="radio" name="money" value="all"> 전체 선택
            </li>
            <li>
              <input type="radio" name="money" value="4up"> 4,000만원&uarr;
            </li>
            <li>
              <input type="radio" name="money" value="3up" checked> 3,000만원&uarr;
            </li>
            <li>
              <input type="radio"name="money" value="2up"> 2,000만원&uarr;
            </li>
            <li>
              <input type="radio" name="money" value="1up"> 1,000만원&uarr;
            </li>
          </ul>

          <p class="texttitle">2. 일자리 전망</p>
          <ul class="jobAptitude">
            <li>
              <input type="radio" name="prospect" value="veryGood"> 매우 좋음
            </li>
            <li>
              <input type="radio" name="prospect" value="good" checked> 좋음
            </li>
            <li>
              <input type="radio" name="prospect" value="soso"> 보통 이상
            </li>
            <li>
              <input type="radio"name="prospect" value="bad"> 보통 미만
            </li>
          </ul>
          <p class="texttitle">3. 발전 가능성</p>
          <ul class="jobAptitude">
            <li>
              <input type="radio" name="potential" value="veryGood"> 매우 좋음
            </li>
            <li>
              <input type="radio" name="potential" value="good" checked> 좋음
            </li>
            <li>
              <input type="radio" name="potential" value="soso"> 보통 이상
            </li>
            <li>
              <input type="radio"name="potential" value="bad"> 보통 미만
            </li>
          </ul>

          <p class="texttitle">4. 고용 평등</p>
          <ul class="jobAptitude">
            <li>
              <input type="radio" name="equality" value="veryGood"> 매우 좋음
            </li>
            <li>
              <input type="radio" name="equality" value="good" checked> 좋음
            </li>
            <li>
              <input type="radio" name="equality" value="soso"> 보통 이상
            </li>
            <li>
              <input type="radio"name="equality" value="bad"> 보통 미만
            </li>
          </ul>
          </fieldset>
          <div class="oncenter">
            <!-- 링크 a는 임시보 해놈 form처리해줄 jsp가 없으니 -->
            <button type="submit" class="submitbutton"><a href="jobtest.html" style="color: white;">결과보기</a></button>
          </div>
        </form>
        </div>

        <div class="title">
          <p >직업 정보</p>
        </div>
        <br>
        <!-- 데이터 끌어와서 리스트로 보여주는 화면 나중에 JSP로 직접 입력 말고 데이터 끌고오자 -->
        <ul>
          <!-- 직업 1줄 시작-->
          <li class="rowLine">
            <p class="listHeadLine">
              <span class="listJobName"><b><a href="">선장 및 항해사</a></b></span> 
              <span class="listJobEtc"><span class="listJobEtcColor">연봉:</span> <b>4000</b>만원 이상</span>
              <span class="listJobEtc"><span class="listJobEtcColor">발전가능성:</span> <b>보통미만</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">고용평등:</span> <b>보통미만</b></span>
            </p>
            <p class="listJobExplain">
              - 선장 및 항해사는 해양, 연안 및 내륙해안에서 승객 및 화물을 운송하기 위해 상선, 여객선, 어선 등의 선박을 운전하고 갑판원들의 활동을 감독, 조정한다.
              <br>
              <span class="listJobEtcColor"><b>유사직업 :</b></span> 일등항해사, 이등항해사
            </p>
          </li>

          <!-- 직업 1줄 끝 -->
          <!-- 직업 1줄 시작-->
          <li class="rowLine">
            <p class="listHeadLine">
              <span class="listJobName"><b><a href="">소설가</a></b></span> 
              <span class="listJobEtc"><span class="listJobEtcColor">연봉:</span> <b>2000</b>만원 미만</span>
              <span class="listJobEtc"><span class="listJobEtcColor">발전가능성:</span> <b>보통이상</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">고용평등:</span> <b>매우종음</b></span>
            </p>
            <p class="listJobExplain">
              - 소설가는 소설의 주제를 결정하고 그 주제를 가장 효과적으로 나타낼 수 있는 소재들을 찾아 적절하게 구성하여 예술적으로 표현한다.
            </p>
          </li>

          <!-- 직업 1줄 끝 -->
          <!-- 직업 1줄  시작-->
          <li class="rowLine">
            <p class="listHeadLine">
              <span class="listJobName"><b><a href="">작가</a></b></span> 
              <span class="listJobEtc"><span class="listJobEtcColor">연봉:</span> <b>3000</b>만원 이상</span>
              <span class="listJobEtc"><span class="listJobEtcColor">발전가능성:</span> <b>보통이상</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">고용평등:</span> <b>매우좋음</b></span>
            </p>
            <p class="listJobExplain">
              - 출판이나 연극, 영화, 방송을 위한 문학작품을 창작하거나 소설, 시, 동화, 수필, 영화시나리오, 연극대본, 드라마 극본을 창작한다.              <br>
              <span class="listJobEtcColor"><b>유사직업 :</b></span> 스크립터,게임시나리오 작가,테크니컬라이터,애니메이션 작가,시인,카피라이터,광고문 작성가,만화스토리 작가,코미디 작가,평론가,소설가,시나리오 작가,극작가,희곡 작가,외화번역 작가,구성 작가,드라마 작가
            </p>
          </li>

          <!-- 직업 1줄 끝 -->
          <!-- 직업 1줄 시작 -->
          <li class="rowLine">
            <p class="listHeadLine">
              <span class="listJobName"><b><a href="">웹프로듀서</a></b></span> 
              <span class="listJobEtc"><span class="listJobEtcColor">연봉:</span> <b>3000</b>만원 이상</span>
              <span class="listJobEtc"><span class="listJobEtcColor">발전가능성:</span> <b>매우좋음</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">고용평등:</span> <b>매우좋음</b></span>
            </p>
            <p class="listJobExplain">
              웹프로듀서는 웹사이트 기획, 구축 및 운영, 마케팅 등을 총괄한다.              
              <br>
              <span class="listJobEtcColor"><b>유사직업 :</b></span> 웹개발자,웹 기획자(웹PD)
            </p>
          </li>
          <!-- 직업 1줄 끝 -->
          <!-- 직업 1줄 시작 -->
          <li class="rowLine">
            <p class="listHeadLine">
              <span class="listJobName"><b><a href="">가상현실전문가</a></b></span> 
              <span class="listJobEtc"><span class="listJobEtcColor">연봉:</span> <b>3000</b>만원 이상</span>
              <span class="listJobEtc"><span class="listJobEtcColor">발전가능성:</span> <b>매우좋음</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">고용평등:</span> <b>좋음</b></span>
            </p>
            <p class="listJobExplain">
              - 가상현실전문가는 3차원모델링(3D) 및 가상현실모델링언어(VRML)등의 기술을 이용해 가상의 시공간에서 가상시스템을 개발한다.              
              <br>
              <span class="listJobEtcColor"><b>유사직업 :</b></span> 기업관리소프트웨어개발자,과학용소프트웨어개발자,산업용소프트웨어개발자,교육용소프트웨어개발자
            </p>
          </li>
          <!-- 직업 1줄 끝 -->
          <!-- 직업 1줄 시작 -->
          <li class="rowLine">
            <p class="listHeadLine">
              <span class="listJobName"><b><a href="jobresult.html">시스템소프트웨어개발자</a></b></span> 
              <span class="listJobEtc"><span class="listJobEtcColor">연봉:</span> <b>4000</b>만원 이상</span>
              <span class="listJobEtc"><span class="listJobEtcColor">발전가능성:</span> <b>매우좋음</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">고용평등:</span> <b>좋음</b></span>
            </p>
            <p class="listJobExplain">
              -시스템소프트웨어개발자는 컴퓨터를 작동시키고 컴퓨터의 활동을 조정, 통제, 관리하는 오퍼레이팅시스템소프트웨어를 연구, 개발, 설계하는 일을 담당한다.
              <br>
              <span class="listJobEtcColor"><b>유사직업 :</b></span> 기업관리소프트웨어개발자,과학용소프트웨어개발자,산업용소프트웨어개발자,교육용소프트웨어개발자
            </p>
          </li>
          <!-- 직업 1줄 끝 -->
          <!-- 직업 1줄 시작 -->
          <li class="rowLine">
            <p class="listHeadLine">
              <span class="listJobName"><b><a href="">네트워크엔지니어</a></b></span> 
              <span class="listJobEtc"><span class="listJobEtcColor">연봉:</span> <b>3000</b>만원 이상</span>
              <span class="listJobEtc"><span class="listJobEtcColor">발전가능성:</span> <b>매우좋음</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">고용평등:</span> <b>매우좋음</b></span>
            </p>
            <p class="listJobExplain">
              -네트워크엔지니어는 전산망과 관련된 각종 하드웨어 및 소프트웨어 등에 관한 네트워크시스템의 분석, 설계 및 구축에 관한 업무를 한다.
              <br>
              <span class="listJobEtcColor"><b>유사직업 :</b></span> 시스템 설계자,시스템 프로그래머,네트워크디자이너
            </p>
          </li>
          <!-- 직업 1줄 끝 -->
          <!-- 직업 1줄 시작 -->
          <li class="rowLine">
            <p class="listHeadLine">
              <span class="listJobName"><b><a href="">데이터베이스관리자</a></b></span> 
              <span class="listJobEtc"><span class="listJobEtcColor">연봉:</span> <b>3000</b>만원 이상</span>
              <span class="listJobEtc"><span class="listJobEtcColor">발전가능성:</span> <b>매우좋음</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">고용평등:</span> <b>매우좋음</b></span>
            </p>
            <p class="listJobExplain">
              -데이터베이스관리자는 컴퓨터를 사용하여 각종 데이터를 체계적으로 수집, 정리, 가공 및 입력하여 데이터베이스를 구축, 관리, 분석하는 일을 한다.
            </p>
          </li>
          <!-- 직업 1줄 끝 -->
        </ul>
        <!-- 아래 페이지 넘버 부분 -->
        <div class="oncenter">
        <ul id="pageNumber">
          <li><a href="pre">&larr;</a></li>
          <li><a href="job.html">1</a></li>
          <li><a href="job2">2</a></li>
          <li><a href="job3">3</a></li>
          <li><a href="job4">4</a></li>
          <li><a href="job5">5</a></li>
          <li>.</li>
          <li>.</li>
          <li>.</li>
          <li>.</li>
          <li><a href="next">10</a></li>
          <li><a href="">&rarr;</a></li>
        </ul>  
        <br>
        </div>
        <!-- 페이지 넘버부분 끝 -->
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