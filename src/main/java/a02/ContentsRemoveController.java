package a02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/remove")
public class ContentsRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContentsService service;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new ContentsService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("id가" + id + "에 해당하는 데이터를 삭제합니다.");
		
		try {
			service.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/Subject02/board/list");
	}
}
