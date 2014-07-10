package controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class FiltrarAcesso implements Filter {

	@Override
	public void destroy() {}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();	
		
		
		if (session == null || session.getAttribute("isLogged") == null ||  session.getAttribute("isLogged").equals(false)) {
			
			System.out.println("Este recurso só pode ser acessado por um usuario logado");
			
			res.sendRedirect(req.getContextPath()+"/login.html");
			
		}
		else{
			
			System.out.println("O usuario esta logado");
			chain.doFilter(request, response);
		}			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
