<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>
  <div>
    <form action="/board/write_Page_Logic.jsp" method="post"
      style="text-align: center;">
      <span>제목</span> <input type="text" name="title"><br>
      <span>글 작성</span>
      <input type="textarea" name="content"><br>
      <button type="submit">글 등록</button>
    </form>
  </div>
</body>
</html>