<%@page import="controller.UserController"%>
<%@page import="controller.ReplyController"%>
<%@page import="connector.MySqlConnector"%>
<%@page import="connector.DBConnector"%>
<%@page import="model.ReplyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
		max-width: 700px;
		padding: 15px;
}

textarea {
		height: 200px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
  int id = Integer.parseInt(request.getParameter("id"));
  DBConnector connector = new MySqlConnector();
  ReplyController replyController = new ReplyController(connector);
  UserController userController = new UserController(connector);
  ArrayList<ReplyDTO> list = replyController.selectAll(id);
  %>
  <table class="table">
    <div class="container">
      <form action="/reply/write.jsp" method="post">
        <input type="hidden" value="<%=id%>" name="boardId"> <input
          type="text" class="form-control col" name="content">
        <button type="submit" class="btn btn-secondary col">댓글
          달기</button>
      </form>
    </div>
    <%
    for (ReplyDTO r : list) {
    	String name = userController.getOneUserName(r.getWriterId());
    %>
    <tr class="mb-3">
      <td class="col-1"><%=name%></td>
      <td class="col-6"><%=r.getContent()%></td>
    </tr>
    <%
    }
    %>
  </table>
</body>
</html>