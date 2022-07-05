<%@page import="model.BoardDTO"%>
<%@page import="controller.BoardController"%>
<%@page import="connector.MySqlConnector"%>
<%@page import="com.mysql.cj.MysqlConnection"%>
<%@page import="connector.DBConnector"%>
<%@page import="model.UserDTO"%>
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
  String title = request.getParameter("title");
  String content = request.getParameter("content");
  UserDTO login = (UserDTO) session.getAttribute("login");

  DBConnector connector = new MySqlConnector();
  BoardController controller = new BoardController(connector);

  BoardDTO b = new BoardDTO();

  b.setWriterId(login.getId());
  b.setTitle(title);
  b.setContent(content);

  int lastId = controller.insert(b);

  response.sendRedirect("/board/selectOne.jsp?id=" + lastId);
  %>
</body>
</html>