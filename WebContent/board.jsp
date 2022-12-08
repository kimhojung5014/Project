<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/board.css"> 
  <link rel="stylesheet" href="css/header_footer.css">
  <title>게시판</title>
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
      <!-- 상단 메뉴 카테고리 -->
      <p class="subtitle">게시판</p>
      <br>
      <table class="memuTable">
        <tr>
          <th>공지사항</th>
          <th>직업정보</th>
          <th>학과정보</th>
          <th>고민상담</th>
        </tr>
      </table>
      <!-- 상단 메뉴 카테고리 끝 -->

      <!-- 테이블로 만든 게시판 형식 -->
      <table id="board">
        <thead>
          <th>카테고리</th>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성시간</th>
          <th>조회수</th>
        </thead>
        <tbody>
          <tr>
            <td>공지사항</td>
            <td>4</td>
            <td>게시판 공지사항</td>
            <td>관리자</td>
            <td>2022년11월4일15:43</td>
            <td>8</td>
          </tr>
          <tr>
            <td>공지사항</td>
            <td>4</td>
            <td>게시판 공지사항</td>
            <td>관리자</td>
            <td>2022년11월4일15:43</td>
            <td>8</td>
          </tr>
          <tr>
            <td>공지사항</td>
            <td>4</td>
            <td>게시판 공지사항</td>
            <td>관리자</td>
            <td>2022년11월4일15:43</td>
            <td>8</td>
          </tr>
          <tr>
            <td>공지사항</td>
            <td>4</td>
            <td>게시판 공지사항</td>
            <td>관리자</td>
            <td>2022년11월4일15:43</td>
            <td>8</td>
          </tr>
          <tr>
            <td>공지사항</td>
            <td>4</td>
            <td>게시판 공지사항</td>
            <td>관리자</td>
            <td>2022년11월4일15:43</td>
            <td>8</td>
          </tr>
          <tr>
            <td>공지사항</td>
            <td>4</td>
            <td>게시판 공지사항</td>
            <td>관리자</td>
            <td>2022년11월4일15:43</td>
            <td>8</td>
          </tr>
          <tr>
            <td>공지사항</td>
            <td>4</td>
            <td>게시판 공지사항</td>
            <td>관리자</td>
            <td>2022년11월4일15:43</td>
            <td>8</td>
          </tr>
          <tr>
            <td>공지사항</td>
            <td>4</td>
            <td>게시판 공지사항</td>
            <td>관리자</td>
            <td>2022년11월4일15:43</td>
            <td>8</td>
            <tr>
              <td>공지사항</td>
              <td>4</td>
              <td>게시판 공지사항</td>
              <td>관리자</td>
              <td>2022년11월4일15:43</td>
              <td>8</td>
            </tr>
            <tr>
              <td>공지사항</td>
              <td>4</td>
              <td>게시판 공지사항</td>
              <td>관리자</td>
              <td>2022년11월4일15:43</td>
              <td>8</td>
            </tr>
            <tr>
              <td>공지사항</td>
              <td>4</td>
              <td>게시판 공지사항</td>
              <td>관리자</td>
              <td>2022년11월4일15:43</td>
              <td>8</td>
            </tr>
            <tr>
              <td>공지사항</td>
              <td>4</td>
              <td>게시판 공지사항</td>
              <td>관리자</td>
              <td>2022년11월4일15:43</td>
              <td>8</td>
          </tr>
        </tbody>
      </table>
      <!-- 게시판 끝 -->
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
          <li><a href="next">10</a></li>
          <li><a href="">&rarr;</a></li>
        </ul>  
        <!-- 페이지 넘버부분 끝 -->

        <!-- 검색창 -->
        <table style="width: 100%; padding-left: 30%;" >
          <tr>
            <td>
              <form action="">
                <label id="labelSearch">검색 <input type="search"></label>
              </form>
            </td>
            <td>
              <button class="submitbutton"><a href="">글 작성</a></button>
            </td>
          
        </table>
       
      </div>
      <br>

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