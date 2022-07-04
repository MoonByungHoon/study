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
  DBConnector connector = new MySqlConnector();
  BoardController boardController = new BoardController(connector);
  BoardDTO b = boardController.selectOne(Integer.parseInt(request.getParameter("id")));
  %>
  <table class="tabel">
    <tr>
      <td>글 번호 : <%=b.getId()%>
      </th>
    </tr>
    <tr>
      <td>글 제목 : <%=b.getTitle()%>
      </th>
    </tr>
    <tr>
      <td>글 내용 : <%=b.getContent()%>
      </th>
    </tr>
  </table>
</body>
</html>