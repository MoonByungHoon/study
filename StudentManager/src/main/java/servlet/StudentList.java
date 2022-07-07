package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import connector.DBConnector;
import connector.MySqlConnector;
import controller.StudentController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentDTO;

//서블릿은 사용자가 입력한 주소와 연결할 클래스를 어노테이션을 통해서 연결한다.
//어노테이션이란 @로 시작하는 특수한 명령어로써
//문법적 에러를 체크하는 것부터 해당 클래스에 특수한 성격을 부여하는 것까지
//다양한 명령어가 존재한다.
//여기서 사용할 어노테이션은 @WebServlet 어노테이션이 된다.
//어노테이션 뒤에는 ; 이 필요없다.

@WebServlet("/student/list.do")
public class StudentList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DBConnector connector = new MySqlConnector();
		StudentController controller = new StudentController(connector);

		ArrayList<StudentDTO> list = controller.selectAll();

		resp.setContentType("text/html;UTF-8");

		PrintWriter out = resp.getWriter();
		out.println("<html><head>");
		out.println("<style> table { border: 2px solid black } </style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>" + "<th>번호</th>" + "<th>이름</th>" + "<th colspan='2'>수정 / 삭제</th>" + "<tr>");

		for (StudentDTO s : list) {
			out.println("<tr><td>" + "<a href = '/student/selectOne.do?id=" + s.getId() + "'>" + s.getId() + "</a>" + "</td>"
					+ "<td>" + s.getName() + "</td>" + "<td>" + "수정" + "</td>" + "<td>" + "삭제" + "</td></tr>");
		}

		out.println("</table>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPost(req, resp);
	}

}
