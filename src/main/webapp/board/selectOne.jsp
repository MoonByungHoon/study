<%@page import="controller.UserController"%>
<%@page import="model.UserDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<title>Insert title here</title>
<body>
  <%
  DBConnector connector = new MySqlConnector();
  BoardController boardController = new BoardController(connector);
  BoardDTO b = boardController.selectOne(Integer.parseInt(request.getParameter("id")));
  SimpleDateFormat sdf = new SimpleDateFormat("y년 M월 d일 H시 m분 s초");

  UserController userController = new UserController(connector);

  String name = userController.getOneUserName(b.getWriterId());
  %>
  <main class="form-signin w-100 m-auto">
    <table class="tabel">
      <h1 class="h3 mb-3 fw.nomal row justify-content-center">글 열람</h1>
      <tr class="mb-3">
        <td>글 번호 : <%=b.getId()%></td>
      </tr>
      <tr class="mb-3">
        <td>글 제목 : <%=b.getTitle()%></td>
      </tr>
      <tr class="mb-3">
        <td>작성자 : <%=name%></td>
      </tr>
      <tr class="border border-secondary">
        <td><%=b.getContent()%></td>
      </tr>
      <tr class="mb-3">
        <td>작성일 : <%=sdf.format(b.getWrittenDate().getTime())%></td>
        <td>수정일 : <%=sdf.format(b.getUpdateDate().getTime())%></td>
      </tr>
    </table>
    <%
    UserDTO login = (UserDTO) session.getAttribute("login");

    if (b.getWriterId() == login.getId()) {
    %>
    <div class="justify-content-md-center">
      <div class="container form-signin w-100 m-auto">
        <div class="mb-3 btn btn-primary col-3"
          onclick="location.href='/board/update.jsp?id=<%=b.getId()%>'">수정하기</div>
        <div class="mb-3 btn btn-primary col-3"
          onclick="location.href='/board/delete.jsp?id=<%=b.getId()%>'">삭제하게</div>
        <div class="mb-3 btn btn-primary col-3"
          onclick="location.href='/board/list.jsp'">목록으로</div>
      </div>
    </div>
    <%
    }
    %>
    <div>
      <jsp:include page="/reply/list.jsp">
        <jsp:param value="<%=b.getId()%>" name="id"></jsp:param>
      </jsp:include>
    </div>
  </main>
</body>
</html>