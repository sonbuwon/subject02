package a02;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class ContentsMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContentsService service;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new ContentsService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/a02/index.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Contents contents = new Contents();
		contents.setContent(request.getParameter("content"));
		contents.setDate(LocalDateTime.now().toString());
		
		try {
			service.register(contents);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/Subject02/list");
	}
}
