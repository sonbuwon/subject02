package a02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/search")
public class ContentsSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContentsService service;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new ContentsService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String what = request.getParameter("what");
		
		System.out.println("검색된 목록을 출력합니다.");
		
		try {
			List<Contents> sList = service.searchList(what);
			request.setAttribute("list", sList);
			request.getRequestDispatcher("/a02/requestList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
