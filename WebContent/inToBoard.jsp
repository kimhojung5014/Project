<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내부 화면</title>
  <link rel="stylesheet" href="css/header_footer.css?s2d">
  <link rel="stylesheet" href="css/inToBoard.css?sdsfsasdasdsaf1"> 
</head>
<body>
<script src="js/write.js?1113"></script>
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
          
          <p class="submitbutton" id="category">${boardDto.category }</p>
           
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
        <c:if test="${boardDto.userId eq userData.userId }">
	        <div class="oncenter">
	        <form action="boardEdit.do">
	          <input type="hidden" name="category" value="${boardDto.category}">	
	          <input type="hidden" name="title" value="${boardDto.title}">	
	          <input type="hidden" name="content" value="${boardDto.content}">	
	          <input type="hidden" name="writeNum" value="${boardDto.writeNum}">	
	     
	      	  <button class="editButton">수정</button>               
	        </form>
	        </div>
       	</c:if>
       	<br>
	 	  <p class="subsubtitle">댓글</p>
	        <div class="intextarea">
<!-- 	        댓글 인서트 폼 -->
	        	<form action="replyInsert.do" method="post" id ="replyForm">
				<!-- 글번호를 보내줘야 처리가 가능하다.  -->
	        	<input type="hidden" name="writeNum" value="${writeNum }">
<!-- 	        	일단 댓글은 부모 외래키가 없으니 기본값 0보내기 -->
     			<input type="hidden" name="parentNum" value="0">
<!--      			작성자 아이디 닉네임도 보내준다 -->
	        	<input type="hidden" name="userId" value="${userData.userId }">
	        	<input type="hidden" name="nickName" value="${userData.nickName }">
	        	<!--로그인 해야만 답글달기 버튼 활성화 -->
	        	<c:if test="${userData ne null }">
		       	<table>
		       		<tr>
		       			<td>
		       				<b>${userData.nickName}</b>
		       			</td>
		       			<td>
		       				<textarea name="content" id="replyContent" rows="2" cols="83" required="required"></textarea>		
		       			</td>
		       			<td>
		       				<button type="button" onclick = "replyInsert()">댓글달기</button>
		       			</td>
		       		</tr>
		       	</table>
		       	</c:if>
		       	
		       	</form>
				<!--댓글 반복문 페이지번호에 있는 댓글 전부 출력  -->
    		    <c:forEach var="reply" items="${replyList}" varStatus="status">
				<!--대댓글 인서트 폼에서 값들을 히든으로 날려보낸다. -->
			       	<form action="replyInsert.do" method="post" class ="reReplyForm" >
						<input type="hidden" name="writeNum" value="${writeNum }">
				<!-- 대대댓글은 댓글의 댓글번호롤 parentNum에 넣어서 보내준다. -->
						<input type="hidden" name="parentNum" value="${reply.commentNum }">
			    <!--      			작성자 아이디 닉네임도 보내준다 -->
			        	<input type="hidden" name="userId" value="${userData.userId }">
	        			<input type="hidden" name="nickName" value="${userData.nickName }">
			        	<table class="comment">
			           		<tr>
			           			<th>${reply.nickName}</th> <td>${reply.content}</td>
			           			<td>${reply.commentDate}</td>
						<!--로그인 해야만 답글달기 버튼 활성화 -->
			           		<c:if test="${userData ne null }">
			           		 	<td><button type="button" class="insertButton"  onclick="choose(${status.index})">답글달기</button></td>
							</c:if>
							</tr>
						</table>
						<!-- 대댓글 작성 부분 버튼 누르면 활성화, 현재 name 배열 설정 안잡아서 맨 위에 글로 날아감 -->
<!-- 				           		<ul class="reply"> -->
<%-- 				               		<li ><b style="line-height: 30px">${userData.nickName}</b> <textarea name="content" id="rereplyContent" rows="2" cols="83"></textarea> --%>
<!-- 				               		<button type="submit"  style="line-height: 30px">댓글달기</button></li> -->
<!-- 				           		</ul> -->
				           		<table class="reply">
				               		<tr >
				               			<td><b>${userData.nickName}</b></td>
				               			<td><textarea name="content" class="rereplyContent"   required="required" maxlength="300" rows="2" cols="83"></textarea></td>
<%-- 				               			<td><button type="button" onclick="rereplyInsert(${status.index})">완료</button></td> --%>
				               			<td><button  >완료</button></td>
				               		</tr>
				           		</table>
						<!-- 대댓글 반복문 페이지 번호가 같은 대댓글을 전부 불러오고 그중 댓글의 번호를 참조하는 대댓글만 불러온다. -->
			           		 <c:forEach var ="rereply" items="${rereplyList}">
				           		 <c:if test="${reply.commentNum == rereply.parentNum }">
					           		 <table style="padding-left: 20px; border-spacing: 10px 10px" >
					           		 	<tr >
					           		 		<th>ㄴ${rereply.nickName}</th><td> ${rereply.content}</td><td> ${rereply.commentDate}</td>
					           		 	</tr>
					           		 </table>
				           		 </c:if>
			           		 </c:forEach>
		        	</form>
		       </c:forEach>
	        </div>
      </div>
    </div>
    
  </div>
  <script type="text/javascript">
  function rereplyInsert(i) {
		const rereplyContent = document.getElementsByClassName("rereplyContent");				
		const form = document.getElementsByTagName('reReplyForm');
		if(rereplyContent[i].length > 1000){
			alert("댓글은 1000자 안으로 입력해주세요")
		
		}else if (rereplyContent[i].length == 0) {
			alert("댓글은 내용을 입력해주세요")
		}
		else {
		form[i].submit();
		}
	}
  </script>
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