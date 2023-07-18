package a02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/delete")
public class UsersRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService service;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String uid = request.getParameter("uid");
		
		System.out.println("uid가" + uid + "에 해당하는 데이터를 삭제합니다.");
		
		try {
			service.remove(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/Subject02/manage/user");
	}
}
