<%@page import="model.UserDTO"%>
<%@page import="connector.MySqlConnector"%>
<%@page import="connector.DBConnector"%>
<%@page import="controller.UserController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인이 성공했는지 확인해보자</title>
</head>
<body>
  <%
  String loginId = request.getParameter("loginId");
  String password = request.getParameter("password");

  DBConnector connector = new MySqlConnector();
  UserController userController = new UserController(connector);
  UserDTO userDTO = userController.login(loginId, password);

  if (userDTO != null) {
  	session.setAttribute("login", userDTO);
  	session.setAttribute("errorMessage", null);
  	response.sendRedirect("/board/list.jsp");
  } else {
  	session.setAttribute("errorMEssage", "아이디와 비밀번호를 다시 확인해주세요.");
  	response.sendRedirect("/index.jsp");
  }
  %>
</body>
</html>