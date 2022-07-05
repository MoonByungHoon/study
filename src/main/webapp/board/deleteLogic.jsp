<%@page import="connector.MySqlConnector"%>
<%@page import="model.UserDTO"%>
<%@page import="model.BoardDTO"%>
<%@page import="controller.BoardController"%>
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
  DBConnector connector = new MySqlConnector();
  BoardController boardController = new BoardController(connector);

  BoardDTO b = boardController.selectOne(id);

  UserDTO login = (UserDTO) session.getAttribute("login");

  if (b == null || b.getWriterId() != login.getId()) {
  	response.sendRedirect("/board/selectOne.jsp?id=" + id);
  }

  boardController.delete(id);

  response.sendRedirect("/board/list.jsp");
  %>
</body>
</html>