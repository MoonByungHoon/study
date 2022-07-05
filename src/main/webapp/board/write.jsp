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
textarea{
  height: 200px;
}
</style>
<title>Insert title here</title>
</head>
<body>
  <main class="form-signin w-100 m-auto">
    <h1 class="h3 mb-3 fw-normal">글 작성</h1>
    <form action="/board/writeLogic.jsp" method="post">
      <div class="mb-3">
        글 제목: <input type="text" class="form-control" name="title" />
      </div>
      <div class="mb-3">
        글 내용: <textarea class="form-control
        " row3 name="content"></textarea>
      </div>

      <button type="submit" class="btn btn-secondary col-4">글 작성하기</button>
    </form>
  </main>
</body>
</html>