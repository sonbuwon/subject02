package a02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/login")
public class ContentsLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/a02/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 시도....");

		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");

		try {
			Users user = userService.login(uid, upw);
			HttpSession session = request.getSession();

			session.setAttribute("loginInfo", user);
			
			response.sendRedirect("/Subject02/board/main");			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인에 실패하셨습니다.");
		}
	}
}
