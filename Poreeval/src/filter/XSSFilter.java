package filter;

import java.io.IOException;
import java.util.regex.Pattern;

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
/**
 * Servlet Filter implementation class XSSFilter
 */
@WebFilter(urlPatterns = { "/*" })
public class XSSFilter extends BaseFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
	}

	class XSSRequestWrapper extends HttpServletRequestWrapper {

		private Pattern[] patterns = new Pattern[] {

				Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
				Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
						Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
				Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
						Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
				Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
				Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
				Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
				Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
				Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
				Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
				Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL) };

		public XSSRequestWrapper(HttpServletRequest servletRequest) {
			super(servletRequest);
		}

		@Override
		public String[] getParameterValues(String parameter) {
			String[] values = super.getParameterValues(parameter);

			if (values == null) {
				return null;
			}

			int count = values.length;
			String[] encodedValues = new String[count];
			for (int i = 0; i < count; i++) {
				encodedValues[i] = stripXSS(values[i]);
			}

			return encodedValues;
		}

		@Override
		public String getParameter(String parameter) {
			String value = super.getParameter(parameter);

			return stripXSS(value);
		}

		@Override
		public String getHeader(String name) {
			String value = super.getHeader(name);
			return stripXSS(value);
		}

		private String stripXSS(String value) {
			if (value != null) {
				value = value.replaceAll("\0", "");

				for (Pattern scriptPattern : patterns) {
					value = scriptPattern.matcher(value).replaceAll("");
				}
			}
			return value;
		}
	}
}
