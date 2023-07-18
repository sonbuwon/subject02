package a02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/signup")
public class ContentsSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	UserService service;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/a02/userSignUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Users user = new Users();
		user.setUid(request.getParameter("uid"));
		user.setUpw(request.getParameter("upw"));
		user.setUname(request.getParameter("uname"));
		
		try {
			service.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user.getUname() + "님 회원가입 완료");
		response.sendRedirect("/Subject02/board/login");
	}

}
