package com.jspDemoUtil;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		try{
			//write your tag logic
			
	  JspWriter out = pageContext.getOut();
	  out.println("<h1> Welcome to my custom tag </h1>");
	  
	   }
		catch(Exception e){
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}
	

}
