<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/header_footer.css">
  <link rel="stylesheet" href="css/login.css"> 
  <title>로그인 페이지</title>
</head>
<body>
  <!-- 헤더 부분 -->

  <!-- 헤더 끝 -->


  <!-- 메인 부분 -->

    <div id="mainStyle">

      <div id="mainContent">
        
        <div class="textarea">
          
          <p class="title">나의 진로 추천 사이트를 방문해주셔서 감사합니다.</p><br>

          <p class="subtitle">나의 진로 추천 사이트 로그인</p>
      
          <form action="login.join">
            <table id="login">
              <tr>
                <td class="textleft"><p>아이디</p></td>
                <td><input type="text" name="userId" placeholder="아이디 입력" autofocus required></td>
                <td rowspan="2"><button class="button" type="submit" value="login">로그인</button></td>
              </tr>
              <tr>
                <td class="textleft"><p>비밀번호</p></td>
                <td><input type="password" name="pw" placeholder="비밀번호 입력" required></td>
              </tr>
              <tr>
                <td><button class="button"><a href=""></a>ID 찾기</button></td>
                <td><button class="button" ><a href="">PW 찾기</a></button></td>
                <td><button class="button"><a href="">회원가입</a></button></td>
              </tr>
            </table>
          </form>

        </div>
      
      </div>

    </div>


<!-- 메인  끝-->
  <!-- 푸터 -->

</body>
</html>