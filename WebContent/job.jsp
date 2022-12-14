<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/header_footer.css">
  <link rel="stylesheet" href="css/job.css?123">
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
            <li><a href="jobList.do">직업 추천</a></li>
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

    <!-- 그리드 시작 -->
    <div id="mainStyle">
      <!-- 그리드 내용 시작 -->
      <div id="mainContent">
        <div class="title">
          <p >직업추천</p>
        </div>
        <div class="textarea">
          <p class="subtitle">직업 조건</p>
          <form action="jobRecommend.do" method="post" id="jobForm">
          <div class="intextarea">
          	
	          <p class="subsubtitle">1.선호하는 직업 유형을 선택해주세요.</p>
	          <br>
	          <select  name="kindOfJob" id="kindOfJob" >
	            <option value="all">전체</option>
	
	            <option value="운동 관련직">운동 관련직</option>
	            
	            <option value="기능직">기능직</option>
	            
	            <option value="기타 게임·오락·스포츠 관련직">기타 게임·오락·스포츠 관련직</option>
	            
	            <option value="음악 관련직">음악 관련직</option>
	            
	            <option value="미술 및 공예 관련직">미술 및 공예 관련직</option>
	            
	            <option value="이공계 교육 관련직">이공계 교육 관련직</option>
	            
	            <option value="인문 및 사회과학 관련직">인문 및 사회과학 관련직</option>
	            
	            <option value="교육관련 서비스직">교육관련 서비스직</option>
	            
	            <option value="사무 관련직">사무 관련직</option>
	            
	            <option value="영상 관련직">영상 관련직</option>
	            
	            <option value="환경관련 전문직">환경관련 전문직</option>
	            
	            <option value="무용 관련직">무용 관련직</option>
	            
	            <option value="의복제조 관련직">의복제조 관련직</option>
	            
	            <option value="고급 운전 관련직">고급 운전 관련직</option>
	            
	            <option value="악기 관련직">악기 관련직</option>
	            
	            <option value="기타 특수 예술직">기타 특수 예술직</option>
	            
	            <option value="의료관련 전문직">의료관련 전문직</option>
	            
	            <option value="회계 관련직">회계 관련직</option>
	            
	            <option value="기획서비스직">기획서비스직</option>
	            
	            <option value="영업관련 서비스직">영업관련 서비스직</option>
	            
	            <option value="예술기획 관련직">예술기획 관련직</option>
	            
	            <option value="법률 및 사회활동 관련직">법률 및 사회활동 관련직</option>
	            
	            <option value="안전 관련직">안전 관련직</option>
	            
	            <option value="조리 관련직">조리 관련직</option>
	            
	            <option value="공학 기술직">공학 기술직</option>
	            
	            <option value="연기 관련직">연기 관련직</option>
	            
	            <option value="사회서비스직">사회서비스직</option>
	            
	            <option value="IT관련전문직" selected>IT관련전문직</option>
	            
	            <option value="언어 관련 전문직">언어 관련 전문직</option>
	            
	            <option value="매니지먼트 관련직">매니지먼트 관련직</option>
	            
	            <option value="일반 서비스직">일반 서비스직</option>
	            
	            <option value="자연친화 관련직">자연친화 관련직</option>
	            
	            <option value="이학 전문직">이학 전문직</option>
	            
	            <option value="일반운전 관련직">일반운전 관련직</option>
	            
	            <option value="미용 관련직">미용 관련직</option>
	
	            <option value="공학 전문직">공학 전문직</option>
	
	            <option value="웹·게임·애니메이션 관련직">웹·게임·애니메이션 관련직</option>
	
	            <option value="인문계 교육 관련직">인문계 교육 관련직</option>
	
	            <option value="금융 및 경영 관련직">금융 및 경영 관련직</option>
	
	            <option value="작가 관련직">작가 관련직</option>
	
	            <option value="보건의료 관련 서비스직">보건의료 관련 서비스직</option>
	
	            <option value="디자인 관련직">디자인 관련직</option>
	
	            <option value="농생명산업 관련직">농생명산업 관련직</option>
	          </select>
              <br><br>
          	  <p class="subsubtitle">2.본인이 자신있는 장점을 1개 선택해주세요.</p>
          	  <br>
          		<label><input name="ability" type="radio" value="신체운동">신체운동</label>
          		<label><input name="ability" type="radio" value="손재능">손재능</label>
          		<label><input name="ability" type="radio" value="공간시각">공간시각</label>
          		<label><input name="ability" type="radio" value="음악">음악</label>
          		<label><input name="ability" type="radio" value="창의">창의</label>
          		<label><input name="ability" type="radio" value="언어">언어</label>
          		<label><input name="ability" type="radio" value="수리논리">수리논리</label>
          		<label><input name="ability" type="radio" value="자기성찰">자기성찰</label>
          		<label><input name="ability" type="radio" value="대인관계">대인관계</label>
          		<label><input name="ability" type="radio" value="자연친화">자연친화</label>
          		<label><input name="ability" type="radio" value="예술시각">예술시각</label>
          	  <br><br>
	          <p class="subsubtitle">3.직업 선택 시 우선시 하는 조건 1개를 선택해주세요.</p>
	          <br>
	          <ul class="jobAptitude">
	            <li>
	              <input type="radio" name="possibility" value="REWARDVALUE"> 보상
	            </li>
	            <li>
	              <input type="radio" name="possibility" value="EMPLOYMENTSECURITYVALUE"> 고용안정률
	            </li>
	            <li>
	              <input type="radio"name="possibility" value="DEVELOPMENTPOSSIBILITYVALUE"> 발전가능성
	            </li>
	            <li>
	              <input type="radio" name="possibility" value="WORKINGCONDITIONSVALUE"> 근무여건
	            </li>
	            <li>
	              <input type="radio" name="possibility" value="PROFESSIONALVALUE"> 직업전문성
	            </li>
	            <li>
	              <input type="radio" name="possibility" value="EQUALEMPLOYMENTVALUE"> 평등한 고용
	            </li>
	          </ul>
         </div>
    
          <div class="oncenter">
            <!-- 링크 a는 임시보 해놈 form처리해줄 jsp가 없으니 -->
            <button type="button" class="submitbutton" onclick="check()">결과보기</button>
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
          <c:forEach var="list" items="${jobList }" varStatus="status">
          <li class="rowLine">
            <p class="listHeadLine">
              <span class="listJobName"><b><a href="jobDetail.do?job=${list.job }"> ${list.job }</a></b></span> 
              <span class="listJobEtc"><span class="listJobEtcColor">연봉:</span> <b>${list.salery}</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">발전가능성:</span> <b>${list.possibility }</b></span>
              <span class="listJobEtc"><span class="listJobEtcColor">고용평등:</span> <b>${list.equalemployment }</b></span>
            </p>
            <p class="listJobExplain" >-${ list.summary}</p>
             <p class="listJobExplain">
              <c:choose>
              	<c:when test="${not empty list.similarJob  }">
              	  <span class="listJobEtcColor"><b>유사직업 :</b></span>${list.similarJob }
              	</c:when>
              </c:choose>
            </p>
          </li>
		  </c:forEach>
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

<!-- 메인  끝-->

  <!-- 푸터 -->
  <footer id = "footer" > 
    
    <ul  id="bottomenu">
      <li><a href="">사이트제작자</a></li>
      <li><a href="">개인정보처리방침</a></li>
      <li><a href="">API 정보</a></li>
      <li><a href="">사이트맵</a></li>
    </ul>

    <p>서울특별시 마포구 신촌로 176 4층 401호 제작자 번호 010-5375-4131</p>
    
</footer>
<script type="text/javascript">
	function check() {
		let possibilityNum = 0;
		let abilityNum = 0;
 		let possibility = document.getElementsByName("possibility");
 		let ability = document.getElementsByName("ability");
 		
		for (let i = 0; i < possibility.length; i++) {
			if (possibility[i].checked) {
				possibilityNum += 1;
			}
		}
		
		for (let i = 0; i < ability.length; i++) {
			if (ability[i].checked) {
				abilityNum += 1;
			}
		}
		if (possibilityNum != 1 ) {
			alert("우선 조건 1개를 선택 바랍니다.")	
		}else if (abilityNum != 1) {
			alert("능력 1개를 선택 바랍니다.")	
		}
		
		else {
			document.getElementById("jobForm").submit();
		}
		
	}
</script>
</body>
</html>