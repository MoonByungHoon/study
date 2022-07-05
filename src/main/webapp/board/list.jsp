<%@page import="org.apache.tomcat.util.descriptor.web.LoginConfig"%>
<%@page import="controller.UserController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.BoardController"%>
<%@page import="model.UserDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.BoardDTO"%>
<%@page import="connector.MySqlConnector"%>
<%@page import="connector.DBConnector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
  crossorigin="anonymous">
<style>
html, body {
		height: 100%;
}

body {
		display: flex;
		align-items: center;
		padding-top: 40px;
		padding-bottom: 40px;
		background-color: #f5f5f5;
}

.form-signin {
		padding: 15px;
}
</style>
<title>게시판</title>
<body>
  <%
  UserDTO userDTO = (UserDTO) session.getAttribute("login");

  if (userDTO == null) {
  	response.sendRedirect("/index.jsp");
  }

  DBConnector connector = new MySqlConnector();
  BoardController boardController = new BoardController(connector);
  UserController userController = new UserController(connector);

  ArrayList<BoardDTO> list = boardController.selectAll();

  SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
  %>
  <main class="form-signin w-100 m-auto">
    <header><h1 class="h3 mb-3 fw.nomal row justify-content-center">게시판</h1></header>
    <table class="table">
      <thead>
        <tr>
          <th>글 번호</th>
          <th>작성자</th>
          <th>글 제목</th>
          <th>작성일</th>
          <th>수정일</th>
        </tr>
      </thead>
      <%
      for (BoardDTO b : list) {
      %>
      <tr>
        <td><%=b.getId()%></td>
        <td><%=userController.getOneUserName(b.getWriterId())%>
        <td><a href="/board/selectOne.jsp?id=<%=b.getId()%>"><%=b.getTitle()%></a></td>
        <td><%=sdf.format(b.getWrittenDate().getTime())%></td>
        <td><%=sdf.format(b.getUpdateDate().getTime())%></td>
      </tr>
      <%
      }
      %>
    </table>
    <div class="row justify-content-center">
    <div class="mb-3 btn btn-primary col-4"
      onclick="location.href='/board/write.jsp'">글 작성하기</div>
      </div>
</body>
</html>