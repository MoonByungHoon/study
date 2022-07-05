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
		max-width: 330px;
		padding: 15px;
}
</style>
<title>회원가입 페이지</title>
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
  <main class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">회원가입</h1>
    <form action="/member/register_Logic.jsp" method="post">
      <div class="mb-3">
        아이디 : <input type="text" class="form-control" name="loginId" placeholder="아이디를 입력해주세요.">
      </div>
      <div class="mb-3">
        비밀번호 : <input type="text" class="form-control" name="password" placeholder="비밀번호를 입력해주세요.">
      </div>
      <div class="mb-3">
        이름 : <input type="text" class="form-control" name="name" placeholder="이름을 입력해주세요.">
      </div>
      <div class="row justify-content-center">
        <button type="submit" class="btn btn-secondary col-4">회원가입</button>
      </div>
    </form>
  </main>
</body>
</html>