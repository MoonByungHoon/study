<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp 테스트중</title>
</head>
<body>
	<h2>Hello World</h2>
	<hr>
	현재 날짜와 시간은
	<%=java.time.LocalDateTime.now()%>
</body>
</html>