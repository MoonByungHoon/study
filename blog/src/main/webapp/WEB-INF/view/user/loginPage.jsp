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
<link href="../css/loginPageStyle.css" rel="stylesheet"
  type="text/css">
<title>Insert title here</title>
</head>
<body>
  <main class="form-signin w-100 m-auto">
    <h1 class="h3 fw-normal">로그인</h1>
    <form action="/user/login" method="post">
      <div class="">
        아이디<input type="text" class="form-control mt-1 mb-1" name="username"
          placeholder="아이디를 입력해주세요.">
      </div>
      <div class="">
        비밀번호<input type="text" class="form-control mt-1 mb-1" name="password"
          placeholder="비밀번호를 입력해주세요.">
      </div>
      <div class="mt-3 row justify-content-around">
        <button type="submit" class="btn btn-secondary col-4">로그인</button>
        <!-- location.href로 보내면 url경로를 지정하는 것으로 컨트롤러 내부에 있는 자료중에
              해당 url경로의 이름을 가지고 있는 메소드로 이동한다. -->
        <div class="btn btn-warning col-4"
          onclick="location.href = '/user/registerPage'">회원가입</div>
      </div>
    </form>
  </main>
</body>
</html>