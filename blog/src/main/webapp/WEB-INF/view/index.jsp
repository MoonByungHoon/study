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
<link href="./css/mainPageStyle.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>응애하고 우는 코린이의 블로그</title>
</head>
<body>
  <header class=".container row ">
    <img src="./imgs/wahwah.png" onclick="location.href = '/'" class="main-img btn btn-warning rounded float-end"></a>
    <a class="col text-center fs-1 fw-bolder align-self-center">응애하고 우는 코린이의 블로그</a>
    <img src="./imgs/wahwah.png" onclick="location.href = '/'" class="main-img btn btn-warning rounded float-start"></a>
  </header>
  <main>
    <div class=".container">
      <ul class="row">
        <li class="col text-center fs-5 fw-bolder"><a
          href="/board/studyLogPage">학습일지</a></li>
        <li class="col text-center fs-5 fw-bolder"><a
          href="/board/boardPage">게시판</a></li>
        <li class="col text-center fs-5 fw-bolder"><a
          href="/board/supportPage">후원</a></li>
        <li class="col text-center fs-5 fw-bolder"><a
          href="/user/loginPage">로그인/회원가입</a></li>
      </ul>
    </div>
  </main>
</body>
</html>