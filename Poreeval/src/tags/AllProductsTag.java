package tags;

import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class AllProductsTag extends TagSupport{

	private static final long serialVersionUID = 1L;;
	
	private ResultSet productList;
	private String list;
	private Writer out;
	
	@Override
	public int doStartTag() throws JspException {
		list = "<ul>";
		try {
			productList.next();
			out = pageContext.getOut();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		try {
			list += "<li>" + productList.getLong(1) + productList.getString(2) 
			+ productList.getString(3) + "</li>";
			if (productList.next()) {
				return EVAL_BODY_AGAIN;
			}
			list += "</ul>";
			out.append(list).flush();
		} catch (SQLException e) {
			try {
				out.append(e.getMessage()).flush();
			} catch (IOException io) {
				io.printStackTrace();
			};
		} catch (IOException io) {
			io.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public ResultSet getProductList() {
		return productList;
	}

	public void setProductList(ResultSet productList) {
		this.productList = productList;
	}

}
