package a02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/sbwboard")
public class ContentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ContentsDAO dao;
	
	public void init(ServletConfig config) throws ServletException {
		dao = new ContentsDAO();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("do");
		String view = "";
		
		switch (action) {
		case "add":
			view = writeContent(request, response);
		break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/Subject02/a02/index.jsp").forward(request, response);
	}
	
	public String writeContent(HttpServletRequest request, HttpServletResponse response) {
		Contents cont = new Contents();
		try {
			BeanUtils.populate(cont, request.getParameterMap());
			dao.addNews(cont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/Subject02/a02/index.jsp";
	}
}
