<%@page import="model.UserDTO"%>
<%@page import="model.BoardDTO"%>
<%@page import="controller.BoardController"%>
<%@page import="connector.MySqlConnector"%>
<%@page import="connector.DBConnector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  int id = Integer.parseInt(request.getParameter("id"));
%>
  정말로 삭제하시겠습니까?
  <div onclick="location.href='/board/deleteLogic.jsp?id=<%=id%>'">예</div>
  <div onclick="location.href='/board/selectOne.jsp?id=<%=id%>'">아니오</div>
</body>
</html>