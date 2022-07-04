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
  String errorMessage = (String) session.getAttribute("errorMessage");

  if (errorMessage != null) {
  %>
  <%=errorMessage%><br />
  <%
  }
  %>
  <form action="/member/register_Logic.jsp" method="post">
    아이디 : <input type="text" name="loginId"><br> 비밀번호 : <input
      type="text" name="password"><br> 닉네임 : <input
      type="text" name="name"><br>

    <button type="submit">회원가입</button>
  </form>
</body>
</html>