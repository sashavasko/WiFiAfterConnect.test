package com.wifiafterconnect.test.html;

import junit.framework.TestCase;
import com.wifiafterconnect.html.HtmlInput;

public class HtmlInputTests extends TestCase {

	public void testURLEncoder (){
		HtmlInput i = new HtmlInput ("ctl00$ContentPlaceHolder1$submit", "submit", " ");
		StringBuilder postData = new StringBuilder();
		i.formatPostData(postData);
		assertEquals ("&ctl00%24ContentPlaceHolder1%24submit=+", postData.toString());
	}
}
