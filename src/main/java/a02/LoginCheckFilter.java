package a02;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/board/main"})
public class LoginCheckFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;   
	
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("로그인 필터링 동작중");
		
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpResp = (HttpServletResponse)response;
		
		HttpSession session = httpReq.getSession();
		
		if(session.getAttribute("loginInfo") == null) {
			httpResp.sendRedirect("/Subject02/board/login");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
