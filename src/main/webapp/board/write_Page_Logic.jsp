<%@page import="java.io.PrintWriter"%>
<%@page import="connector.MySqlConnector"%>
<%@page import="java.util.Calendar"%>
<%@page import="controller.BoardController"%>
<%@page import="connector.DBConnector"%>
<%@page import="model.UserDTO"%>
<%@page import="model.BoardDTO"%>
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
  UserDTO userDTO = (UserDTO) session.getAttribute("login");
  BoardDTO boardDTO = new BoardDTO();

  if (userDTO == null) {
  	response.sendRedirect("/index.jsp");
  }

  if (request.getParameter("content") == "") {
    response.setCharacterEncoding("UTF-8");
    PrintWriter writer = response.getWriter();

    writer.println("<script type='text/javascript'>");
    writer.println("alert('제목을 입력해주세요.');");
    writer.println("history.back();");
    writer.println("</script>");
    
    writer.flush();
  } else if (request.getParameter("title") == ""){
  	response.setCharacterEncoding("UTF-8");
  	PrintWriter writer = response.getWriter();
    
    writer.println("<script type='text/javascript'>");
    writer.println("alert('내용을 작성해주세요.');");
    writer.println("history.back();");
    writer.println("</script>");
    
    writer.flush();
  } else {
    DBConnector connector = new MySqlConnector();

    BoardController boardController = new BoardController(connector);

    boardDTO.setWriterId(userDTO.getId());
    boardDTO.setContent(request.getParameter("content"));
    boardDTO.setTitle(request.getParameter("title"));
    boardDTO.setWrittenDate(Calendar.getInstance());
    boardDTO.setUpdateDate(Calendar.getInstance());
    
    boardController.insert(boardDTO);
    
  	response.sendRedirect("/board/list.jsp");
  }
  %>


</body>
</html>