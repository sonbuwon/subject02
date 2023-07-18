package a02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manage/user")
public class UsersListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService service;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("전체 유저 목록을 출력합니다.");
		
		try {
			List<Users> uList =  service.userAll();
			request.setAttribute("userlist", uList);
			request.getRequestDispatcher("/a02/userList.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("유저 목록을 출력하는 과정에서 오류가 발생하였습니다.");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
