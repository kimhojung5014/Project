<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
//   세션 연결 끊어서 정보 없앤다.
   	session.invalidate();
   response.sendRedirect("newindex.jsp");
   %>
