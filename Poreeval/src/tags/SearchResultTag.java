package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class SearchResultTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	
	public int doStartTag() {
		try {
			pageContext.getOut().append(getSearchResult());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}


	private String getSearchResult() {
		String searchResult = "";
		return searchResult;
	}
}
