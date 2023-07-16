package a02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ContentsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContentsService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new ContentsService();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("전체 목록을 출력합니다.");
		
		try {
			List<Contents> cList = service.listAll();
			request.setAttribute("list", cList);
			request.getRequestDispatcher("/a02/requestList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
