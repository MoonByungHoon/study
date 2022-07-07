<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- <script>
			location.href = '/student/list.do';
		</script> -->

  <%
  String str = "abc";
  String str2 = "123";
  String str3 = "a123";
  String str4 = "12bc";
  String str5 = "la3";

  //정규 표현식은 ^로 시작해서 $로 끝난다. 숫자를 나타내는 정규 표현식은
  //\\d 또는 [0-9]로 표현한다.

  //만약 해당 글자가 1번 이상 나올경우 +
  //만약 해당 글자가 n번 나와야한다고 지정할 경우에는 {숫자}
  //n번 이상 n번 이하는 {숫자, 숫자}가 된다.

  //str들에서 숫자로만 이뤄진 객체를 찾기 위한 정규식 표현은
  //^[0-9]+$ 혹은 ^\\d+$ 가 된다.
  
  //대문자 A부터 소문자 z까지 4개로 이뤄져 있는지 확인하려면
  //^[A-z]{4}$ 가 된다.
  
  //핸드폰 번호 확인 패턴
  //^010-[2-9]\\d{3}-\\d{4}$
  
  //이메일주소
  //alphanumeric: \\w
  
  //^\\w+@\\w+.[\\w.]+$
  
  
  
  //String pattern = 졍규식;
  
  str: <%=str.matches(pattern) %><br/>
  str2: <%=str2.matches(pattern) %><br/>
  str3: <%=str3.matches(pattern) %><br/>
  str4: <%=str4.matches(pattern) %><br/>
  str5: <%=str5.matches(pattern) %><br/>
  
  %>
</body>
</html>