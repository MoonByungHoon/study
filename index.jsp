<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
  String errorMessage = (String)session.getAttribute("errorMessage");

if(errorMessage != null){
 %>
 <%=errorMessage %>
 <% 
}
%>
  <header>
    <h1>로그인</h1>
  </header>
  <main>
    <div>
      <form action="/member/auth.jsp" method="post">
        <scan>아이디 : <input type="text" name="loginId"
          placeholder="아이디를 입력해주세요."></scan>
        <br>
        <scan>비밀번호 : <input type="text" name="password"
          placeholder="비밀번호를 입력해주세요."></scan>
        <br>

        <button type="submit">로그인</button>
      </form>
      
      <a href="/member/register.jsp">회원가입</a>
    </div>
  </main>
</body>
</html>
