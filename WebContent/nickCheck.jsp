<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Insert title here</title>
</head>
<body>
<c:choose>
		<c:when test="${ nickCheck ne null }">
<%-- 			<c:set var="nickValue" value="ok" scope="request"></c:set> --%>
			<script type="text/javascript">
				alert("사용가능한 닉네임 입니다.")
				document.location.href = "join.jsp?nickValue=ok";
			</script>
		</c:when>
		<c:otherwise>
<%-- 			<c:set var="nickValue" value="no"  scope="request"></c:set> --%>
			<script type="text/javascript">
				alert("중복된 닉네임 입니다.")
				document.location.href = "join.jsp?nickValue=false";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>