<%@page import="model.UserDTO"%>
<%@page import="controller.UserController"%>
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
  String loginId = request.getParameter("loginId");
  String password = request.getParameter("password");
  String name = request.getParameter("name");

  DBConnector connector = new MySqlConnector();
  UserController userController = new UserController(connector);
  UserDTO userDTO = new UserDTO();

  userDTO.setLoginId(loginId);
  userDTO.setPassword(password);
  userDTO.setName(name);

  userController.register(userDTO);

  boolean success = userController.register(userDTO);

  if (success) {
  %>
  <jsp:forward page="../index.jsp" />
  <%
  } else {
  session.setAttribute("errorMessage", "중복된 아이디 입니다.");
  %>
  <jsp:forward page="/member/register.jsp" />
  <%
  }
  %>
</body>
</html>