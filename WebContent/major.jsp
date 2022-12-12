<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/major.css"> 
  <link rel="stylesheet" href="css/header_footer.css">
  <title>학과 추천</title>
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
  <div id="mainStyle">
    <div id="mainContent">
      <div class="title">
      <p >학과 추천</p>
      </div>
      <div class="textarea">
        <p class="subtitle">나에게 맞는 학과, 학위 알아보기</p>
        <div class="intextarea" >
          <form action="" method="">
            
            <p class="texttitle">1. 학교 유형을 선택해주세요.</p>
            <ul  class="testlist">
                <li>  
                    <input type="radio" name="college" id="all" value="all" checked> 전체
                </li>  
                <li>   
                    <input type="radio" name="college" id="four" value="four"> 4년제 대학교
                </li>
                <li>  
                    <input type="radio" name="college" id="two" value="two"> 전문대학교
                </li>
              </ul>

              <p class="texttitle">2. 전공계열</p>
              <ul class="testlist">
                <li>  
                    <input type="radio" name="major" id="all" value="all" checked> 전체
                </li>  
                <li>   
                    <input type="radio" name="major" id="major1" value="major1"> 인문계열
                </li>
                <li>  
                    <input type="radio" name="major" id="major2" value="major2"> 사회계열
                </li>
                <li>  
                    <input type="radio" name="major" id="major4" value="major3"> 교육계열
                </li>
                <br>
                <li>   
                  <input type="radio" name="major" id="major5" value="major4"> 공학계열
                </li>
                <li>  
                    <input type="radio" name="major" id="major6" value="major5"> 자연계열
                </li>
                <li>   
                  <input type="radio" name="major" id="major7" value="major6"> 의약계열
                </li>
                <li>  
                <input type="radio" name="major" id="major8" value="major7"> 예체능계열
                </li>
              </ul>

            <p class="texttitle">3. 제일 우선 시 하는 조건을 선택해주세요.</p>
            <ul  class="testlist">
                <li>  
                    <input type="radio" name="dep" id="work" value="work" checked> 취업률
                </li>  
                <li>   
                    <input type="radio" name="dep" id="money" value="money"> 임금
                </li>
                <li>  
                    <input type="radio" name="dep" id="happy" value="happy"> 직업 만족도
                </li>
                <li>  
                  <input type="radio" name="dep" id="happy" value="major"> 학과와 관련된 곳으로 취업하는 비율
                </li>
              </ul>
            
            
          
              <p class="texttitle">4. 재정 상황</p>
              <ul  class="testlist">
                <li>
                  <input type="radio" id="hard" value="hard" name="money" checked> 경제적으로 힘든 상황
                </li>
                &nbsp;
                <li>
                  <input type="radio" id="soso" value="soso" name="money" > 보통
                </li>
                &nbsp;
                <li>
                  <input type="radio" id="good" value="good" name="money"> 경제적으로 여유로움
                </li>
              </ul>
          
            
              <p class="texttitle">5.시간적 여유</p>
              <ul  class="testlist">
                <li>
                  <input type="radio" id="many" value="many" name="time" checked> 시간 무관
                </li>
                &nbsp;
                <li>
                  <input type="radio" id="online" value="online" name="time"> 온라인만 가능
                </li>
                &nbsp;
                <li>
                  <input type="radio" id="offline" value="offline" name="time"> 수업 시간을 내기 어려움
                </li>
              </ul>     

            <div class="oncenter">
              <!-- 링크 a는 임시보 해놈 form처리해줄 jsp가 없으니 -->
              <br>
              <button type="submit" class="submitbutton"><a href="majortest.html" style="color:white ;">결과보기</a></button>
            </div>
          </form>
        </div>
      </div>
      <!-- 추천 끝 -->
      <!-- 대학정보 시작 -->
      <div class="title">
        <p>학과 정보</p>
      </div>
      <br>
      <!-- 데이터 끌어와서 리스트로 보여주는 화면 나중에 JSP로 직접 입력 말고 데이터 끌고오자 -->
      <ul>
        <!-- 직업 1줄 시작-->
        <li class="rowLine">
          <p class="listHeadLine">
            <span class="listJobName"><b><a href="">소프트웨어공학과</a></b></span> 
            <span class="listJobEtc"><span class="listJobEtcColor">취업률:</span> <b>60%</b> 이상</span>
            <span class="listJobEtc"><span class="listJobEtcColor">첫 직장 임금</span> <b>200만원 이상</b></span>
           
          </p>
          <p class="listJobExplain">
            스마트폰으로 터치 한번으로 쉽게 음식 주문을 하고, 클릭 한 번으로 인터넷으로 물건을 살수 있는 것은 바로 소프트웨어 공학 기술이 있었기 때문입니다. 소프트웨어공학은 소프트웨어의 개발과 운용 그리고 유지운영에 필요한 체계적이고 정량화된 개발방법이나 운영방법을 적용하고 이러한 접근 방법들에 관하여 배우는 학과입니다. 소프트웨어 산업과 첨단 과학기술 개발에 주도적 역할을 할 수 있는 창의적이고 우수한 인재를 양성하는 것에 교육목표를 두고 있습니다.
          </p>
        </li>

        <!-- 직업 1줄 끝 -->
        <!-- 직업 1줄 시작-->
        <li class="rowLine">
          <p class="listHeadLine">
            <span class="listJobName"><b><a href="">멀티미디어과</a></b></span> 
            <span class="listJobEtc"><span class="listJobEtcColor">취업률:</span> <b>60%</b> 이상</span>
            <span class="listJobEtc"><span class="listJobEtcColor">첫 직장 임금</span> <b>150만원 이상</b></span>
          </p>
          <p class="listJobExplain">
            멀티미디어(multimedia)라는 말을 한 번쯤 들어본 적이 있죠? 이때 멀티는 ‘다수의’, 미디어는 ‘매체’를 뜻하는데요. 영상, 음성, 문자와 같은 다양한 정보 매체를 복합적으로 만든 장치나 소프트웨어의 형태를 의미하는 것입니다. 예를 들어 우리는 동영상을 볼 때, 움직이는 화면과 소리, 글자를 동시에 볼 수 있지요. 멀티미디어과에서는 컴퓨터 관련 기본 교육을 바탕으로 2차원 및 3차원 그래픽, 애니메이션, 홈페이지 디자인, 웹 콘텐츠, 사용자 인터페이스 디자인과 모바일 콘텐츠 개발, 멀티미디어 콘텐츠 제작 등을 실습합니다. 이에 따라 멀티미디어과는 향후 차세대 디지털 콘텐츠 산업을 이끌어갈 전문인 양성을 교육 목표로 합니다.
          </p>
        </li>

        <!-- 직업 1줄 끝 -->
        <!-- 직업 1줄  시작-->
        <li class="rowLine">
          <p class="listHeadLine">
            <span class="listJobName"><b><a href="">게임공학과</a></b></span> 
            <span class="listJobEtc"><span class="listJobEtcColor">취업률:</span> <b>60%</b> 이상</span>
            <span class="listJobEtc"><span class="listJobEtcColor">첫 직장 임금</span> <b>200만원 이상</b></span>
          </p>
          <p class="listJobExplain">
            모바일 게임이나 컴퓨터 게임을 해본 적이 있나요? 게임공학과는 게임을 만들기 위해 필요한 게임 기획 및 시나리오 설계, 게임 프로그래밍, 게임 그래픽 디자인, 게임 애니메이션 개발, 게임 음악 및 음향, 게임 시스템 구성 및 운영방법 등 게임 제작에 필요한 전반적인 이론을 배우고 실습을 통해 실무 능력을 갖추는데 교육목표를 두고 있습니다.
          </p>
        </li>

        <!-- 직업 1줄 끝 -->
        <!-- 직업 1줄 시작 -->
        <li class="rowLine">
          <p class="listHeadLine">
            <span class="listJobName"><b><a href="">게임콘텐츠과</a></b></span> 
            <span class="listJobEtc"><span class="listJobEtcColor">취업률:</span> <b>60%</b> 이상</span>
            <span class="listJobEtc"><span class="listJobEtcColor">첫 직장 임금</span> <b>150만원 이상</b></span>
          </p>
          <p class="listJobExplain">
            컴퓨터게임이나 모바일 게임을 해본 경험이 있죠? 게임은 간단히 조작할 수 있는 아케이드 게임부터 마치 소설 속을 들여다보듯 웅장한 세계관을 가진 RPG게임 등 다양합니다. 게임콘텐츠과는 컴퓨터게임제작의 다양한 분야 중 하나를 선택할 수 있도록 게임기획, 게임 프로그래밍, 게임 운영, 스마트폰 앱 개발 등의 과정과 더불어 소프트웨어 개발 방법론을 학습합니다. 이에 따라 게임콘텐츠과는 인터넷의 폭발적인 성장, 개인 이동통신 서비스의 일반화 등 새로운 기술 흐름을 통하여 첨단 문화산업으로서 게임 분야의 전문 인력 양성을 교육 목표로 합니다.
          </p>
        </li>
        <!-- 직업 1줄 끝 -->
        <!-- 직업 1줄 시작 -->
        <li class="rowLine">
          <p class="listHeadLine">
            <span class="listJobName"><b><a href="">모바일시스템공학과</a></b></span> 
            <span class="listJobEtc"><span class="listJobEtcColor">취업률:</span> <b>60%</b> 이상</span>
            <span class="listJobEtc"><span class="listJobEtcColor">첫 직장 임금</span> <b>200만원 이상</b></span>
          </p>
          <p class="listJobExplain">
            스마트폰, 스마트워치, 태블릿PC 쉽게 들고 다닐수 있는 장치가 바로 모바일 기기라 할 수 있습니다. 우리나라 스마트폰 보급률은 95%로 거의 모든 사람이 사용할 정도로 이용을 많이 하고 그만큼 관심도 높습니다. 모바일시스템공학과는 5G인터넷, 5G 단말기 등 차세대 인터넷 및 네트워크 통신기기와 관련된 시스템이나 기술 개발에 대해 공부하는 학과입니다. 이론과 실습을 통해 실무에서 바로 활약할 수 있는 인력을 양성하는데 교육 목표를 두고 있습니다.  
          </p>
        </li>
        <!-- 직업 1줄 끝 -->
        <!-- 직업 1줄 시작 -->
        <li class="rowLine">
          <p class="listHeadLine">
            <span class="listJobName"><b><a href="majorresult.html">컴퓨터공학과</a></b></span> 
            <span class="listJobEtc"><span class="listJobEtcColor">취업률:</span> <b>60%</b> 이상</span>
            <span class="listJobEtc"><span class="listJobEtcColor">첫 직장 임금</span> <b>200만원 이상</b></span>
          </p>
          <p class="listJobExplain">
            어느날 갑자기 지구상의 모든 컴퓨터가 사라진다면 모든 것이 정지될지도 모릅니다. 컴퓨터공학은 IT와 정보통신 기술을 기반으로 정보화 시대를 이끄는 첨단 공학 분야라 할 수 있습니다. 모든 산업 분야에 컴퓨터 공학 기술은 깊은 관련이 있습니다. 컴퓨터 공학은 컴퓨터 시스템, 프로그래밍 기법, 알고리즘 설계, 응용소프트웨어 개발, 정보화사업 관리방법론 등 다양한 이론과 실습을 통해 유능한 인재를 키우는데 목표를 두고 있는 학과입니다.
          </p>
        </li>
        <!-- 직업 1줄 끝 -->
        <!-- 직업 1줄 시작 -->
        <li class="rowLine">
          <p class="listHeadLine">
            <span class="listJobName"><b><a href="">전기과</a></b></span> 
            <span class="listJobEtc"><span class="listJobEtcColor">취업률:</span> <b>60%</b> 이상</span>
            <span class="listJobEtc"><span class="listJobEtcColor">첫 직장 임금</span> <b>200만원 이상</b></span>
          </p>
          <p class="listJobExplain">
            우리의 일상생활을 밝혀주는 전기란 무엇일까요? 전기는 물질 안에 있는 전자 또는 공간에 있는 자유 전자나 이온들의 움직임 때문에 생기는 에너지의 한 형태입니다. 우리 생활에 있어서 가장 기본적인 에너지이기에 시공과 작동에 있어서 전문성이 요구됩니다. 이에 따라 전기과는 전기를 생산하기 위해 화석연료, 수력, 원자력, 지열, 풍력, 태양열, 조력 등의 에너지원에 대한 지식과 기술을 습득하여 생산, 설계, 개발 및 감리 등의 전문 전기 기술인 양성을 교육목표로 합니다.
          </p>
        </li>
        <!-- 직업 1줄 끝 -->
        <!-- 직업 1줄 시작 -->
        <li class="rowLine">
          <p class="listHeadLine">
            <span class="listJobName"><b><a href="">신소재응용과</a></b></span> 
            <span class="listJobEtc"><span class="listJobEtcColor">취업률:</span> <b>60%</b> 이상</span>
            <span class="listJobEtc"><span class="listJobEtcColor">첫 직장 임금</span> <b>150만원 이상</b></span>
          </p>
          <p class="listJobExplain">
            컴퓨터를 만들기 위해서는 반도체가 필요하고, 자동차는 합금재료, 골프채는 복합 재료, 휴대전화를 만들기 위해서는 전파를 감지할 수 있는 재료가 꼭 필요합니다. 이에 따라 신소재응용과는 바이오기술, 환경기술, 나노기술, 정밀화학기술의 세계화에 능동적으로 대처하기 위하여 신소재의 개발을 위하여 금속, 세라믹스, 전자 및 고분자 소재에 대한 이론적인 교과과정을 기반으로 현실적인 문제점을 해결하고 개발하는 것을 교육목표로 합니다.
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

      
      <!-- 대학정보끝 -->
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