package a02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/sbwboard")
public class ContentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContentsDAO dao;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new ContentsDAO();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("do");
		String view = "";

		if (action == null) {
			// 서버 처음 연동시
			getServletContext().getRequestDispatcher("/a02/index.jsp").forward(request, response);
		} else {
			switch (action) {
			case "main":
				view = reMain(request, response);
				break;
			case "list":
				view = list(request, response);
				break;
			case "add":
				view = writeContent(request, response);
				break;
			}
			getServletContext().getRequestDispatcher("/a02/" + view).forward(request, response);
		}
	}

	public String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("css", dao.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "requestList.jsp";
	}

	// 게시판에 글 작성 후 메인화면으로 돌아옴
	public String writeContent(HttpServletRequest request, HttpServletResponse response) {
		Contents cont = new Contents();
		try {
			BeanUtils.populate(cont, request.getParameterMap());
			dao.addContent(cont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index.jsp";
	}
	
	public String reMain(HttpServletRequest request, HttpServletResponse response) {
		return "index.jsp";
	}
}
