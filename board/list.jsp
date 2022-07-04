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
<title>Insert title here</title>
<!-- CSS only -->
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
  crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
  crossorigin="anonymous"></script>
</head>
<body>
  <%
  UserDTO userDTO = (UserDTO) session.getAttribute("login");

  if (userDTO == null) {
  	response.sendRedirect("/index.jsp");
  }

  DBConnector connector = new MySqlConnector();
  BoardController boardController = new BoardController(connector);

  ArrayList<BoardDTO> list = boardController.selectAll();

  SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
  %>
  <div class="container">
    <table class="table">
      <thead>
        <tr>
          <th>글 번호</th>
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
        <td><a href="/board/selectOne.jsp?id=<%=b.getId()%>"><%=b.getTitle()%></a></td>
        <td><%=sdf.format(b.getWrittenDate().getTime())%></td>
        <td><%=sdf.format(b.getUpdateDate().getTime())%></td>
      </tr>
      <%
      }
      %>
    </table>
  </div>

</body>
</html>