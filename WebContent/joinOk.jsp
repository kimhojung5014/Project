<%@ page language="java" contentType="text/html; charset=UTF-16"
    pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getParameter("pw").equals(request.getParameter("pwCheck"))){
			pageContext.forward("insert.do");
		}else{
			response.sendRedirect("join.jsp");
		}
	%>
</body>
</html>