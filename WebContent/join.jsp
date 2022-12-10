<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/header_footer.css">
  <link rel="stylesheet" href="css/join.css"> 
  <title>회원가입 페이지</title>
</head>
<body>
<script src="js/JoinCheck.js"></script>
   <!-- 헤더 부분 -->
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
      <p class="subtitle">회원가입</p>
      

        <form action="joinOk.jsp" method="post" name="joinForm">
          <table id="login" border="1">
            <tr>
              <td class="textleft">아이디</td>
              <td><input type="text" name="userId" placeholder="5글자 이상 입력" autofocus required></td>
              <td >사용가능한 아이디 입니다.</td>
            </tr>
            <tr>
              <td class="textleft">비밀번호</td>
              <td><input type="password" name="pw" placeholder="8글자 이상 입력" required></td>
    		   <td></td>
            </tr>
            <tr>
              <td class="textleft">비밀번호 확인</td>
<!--               <td> -->
<!--               	<input type="password" name="pwCheck" placeholder="비밀번호 재입력" required > -->
<!--               </td> -->
<!-- 					여기서부터 퍼온 거 -->
				 <td><input type="password" name="pwCheck" id="pwCheck" placeholder="비밀번호 입력" onkeyup="passConfirm()"> </td>
                 <td><span id ="confirmMsg"></span></td>
<!--                  퍼온거끝 -->
            </tr>
            <tr>
              <td class="textleft">닉네임</td>
              <td><input type="text" name="nickName" placeholder="사이트에서 보여질 이름" required></td>
              <td ><button class="button" type="submit" value="idCheck">중복체크</button></td>
            </tr>
            <tr>
              <td class="textleft">이름</td>
              <td><input type="text" name="userName" placeholder="이름 입력" required></td>
            </tr>
            <tr>
              <td class="textleft">이메일주소</td>
              <td><input type="text" name="eMail" placeholder="이메일@.com" required></td>
            </tr>
            <tr>
              <td class="textleft">전화번호</td>
              <td><input type="tel" name="telNumber" placeholder="01X-1234-5678" required></td>
            </tr>
            <tr>
              <td colspan="3"><button class="button" type="button" onclick="pw_Check()" >완료</button></td>
            </tr>
          </table>
        </form>
    </div>
  </div>
</main>

   

<!-- 메인  끝-->
  <!-- 푸터 -->
  <footer id = "footer"> 
    
      <ul id="bottommenu">
        <li><a href="#">사이트 제작자</a></li>
        <li><a href="#">개인정보처리방침</a></li>
        <li><a href="#">API 정보</a></li>
        <li><a href="#">사이트맵</a></li>
      </ul>
      
      <p>서울특별시 마포구 신촌로 176 4층 402호 제작자 번호 010-5375-4131</p>
  </footer>

</body>
</html>