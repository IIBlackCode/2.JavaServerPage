<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<script>
		//해당 페이지에 접속한 모든 사용자들 강게 로그인화면으로 이동
		location.href = 'main.jsp'
	</script>
	<%
		System.out.println("Test");
		session.invalidate();
	%>
</body>
</html>