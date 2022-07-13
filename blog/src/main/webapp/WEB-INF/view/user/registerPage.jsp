<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
  crossorigin="anonymous">
<link href="../css/loginPageStyle.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
  <main class="form-signin w-100 m-auto">
    <h1 class="h3 fw-normal">회원가입</h1>
    <form action="/user/register" method="post">
      <div class="mb-3">
        아이디<input type="text" class="form-control mt-1 mb-1"
          name="username" placeholder="아이디를 입력해주세요.">
      </div>
      <div class="mb-3">
        비밀번호<input type="text" class="form-control mt-1 mb-1"
          name="password" placeholder="비밀번호를 입력해주세요.">
      </div>
      <div class="mb-3">
        이름<input type="text" class="form-control mt-1 mb-1"
          name="nickname" placeholder="이름을 입력해주세요.">
      </div>
      <div class="row justify-content-center">
        <button type="submit" class="btn btn-secondary col-4">회원가입</button>
      </div>
    </form>
  </main>
</body>
</html>