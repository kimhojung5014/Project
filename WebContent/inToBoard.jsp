<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내부 화면</title>
  <link rel="stylesheet" href="css/header_footer.css?sd">
  <link rel="stylesheet" href="css/inToBoard.css?11"> 
</head>
<body>
<script src="js/write.js?123"></script>
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

<div id="mainStyle">

    <div id="mainContent">

      <div class="textarea">
        
		  <!--작성자, 작성일시, 댓글 미구현          -->
        
          <!-- 카테고리 드랍다운 -->
          
          <p class="submitbutton" id="category">${boardDto.catagory }</p>
           
          <br>
          <!-- 제목  제목 밑에 작성자 작성일시  -->
          <span id="title" class="title" >${boardDto.title }</span>
         
          <ul id="titleList">
          	<li>${boardDto.writer}</li>
          
          	<li>${boardDto.writingTime }</li>
          
          	<li><span>조회수: </span>${boardDto.views }</li>
          </ul>

          <!-- 글 내용 적을 곳 -->
		<div class="textareaContent" >
            <p>${boardDto.content }</p>
        </div>        
       	<br>
	 	  <p class="subsubtitle">댓글</p>
	        <div class="intextarea">
	        	<form action="commentInsert.do" method="post" id ="conmentForm">
	        	<input type="hidden" name="userId" value="${userData.userId }">
	        	<input type="hidden" name="nickName" value="${userData.nickName }">
				<!-- 글번호를 보내줘야 처리가 가능하다.  -->
	        	<input type="hidden" name="writeNum" value="${writeNum }">
		       	<table>
		       		<tr>
		       			<td>
		       				${userData.nickName}
		       			</td>
		       			<td>
		       				<textarea name="commentContent" id ="commentContent" rows="2" cols="83"></textarea>		
		       			</td>
		       			<td>
		       				<button type="button" onclick = "commentInsert()">댓글달기</button>
		       			</td>
		       		</tr>
		       	</table>
		       	</form>
		       	<form action="replyInsert.do" method="post" id ="replyInsertForm" >

       		        <c:forEach var="comment" items="${commentList}">
		        	<ul class="comment">
		           		<li><p><b>${comment.nickName}</b> ${comment.content}</p>작성시간: ${comment.commentDate} <button type="button">답글달기</button>
			           		<ul class="reply">
			               		<li>ㄴ<b>작성자</b> 내용</li>
			           		</ul>
		          		</li>
		        	</ul>
		        	</c:forEach>

	        	</form>
		        </div>
<!-- 		   	  <li>댓글만들 곳</li> -->
      </div>
    </div>
    
  </div>
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