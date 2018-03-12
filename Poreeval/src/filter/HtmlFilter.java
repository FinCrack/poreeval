package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/*
 * @author Jannik Bukowski, 235502
 */

@WebFilter(urlPatterns = { "/*"})
public class HtmlFilter extends BaseFilter implements Filter {


	@Override
	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		chain.doFilter(new HtmlRequestWrapper((HttpServletRequest) request), res);
		
	}
	
	class HtmlRequestWrapper extends HttpServletRequestWrapper {
		
		public HtmlRequestWrapper(HttpServletRequest request) {
			super(request);
		}
	public String getParameter(String text) {
			return super.getParameter(text) == null ? " " : super.getParameter(text).replaceAll("<(.|/n)*?>", "");
		}
	
	}
	
		
	

}
