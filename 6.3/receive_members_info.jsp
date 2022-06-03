<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	int age = Integer.parseInt(request.getParameter("age"));
	String date = request.getParameter("date");
%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="receive_members_info.css">
  <title>회원가입 성공</title>
</head>

<body>
  <header><h1>회원가입을 축하드립니다.</h1></header>
  <hr>
	<main>
		<table>
			<tr>
			<td>아이디</td>
			<td class="border_line"><%=id %></td>
			</tr>
			<tr>
			<td id="border_top">이름</td>
			<td class="border_line" id="border_top"><%=name %></td>
			</tr>
			<tr>
			<td id="border_top">주소</td>
			<td class="border_line" id="border_top"><%=addr %></td>
			</tr>
			<tr>
			<td id="border_top">나이</td>
			<td class="border_line" id="border_top"><%=age %></td>
			</tr>
			<tr>
			<td id="border_top">가입날짜</td>
			<td class="border_line" id="border_top"><%=date %></td>
			</tr>
		</table>
	</main>
</body>

</html>