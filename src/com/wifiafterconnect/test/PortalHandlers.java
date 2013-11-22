package com.wifiafterconnect.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import android.test.mock.MockContext;

import com.wifiafterconnect.ParsedHttpInput;
import com.wifiafterconnect.WifiAuthParams;
import com.wifiafterconnect.html.HtmlPage;
import com.wifiafterconnect.test.pagetesters.CiscoSwitchUrlTester;
import com.wifiafterconnect.test.pagetesters.ColubrisTester;
import com.wifiafterconnect.test.pagetesters.GuestNet1Tester;
import com.wifiafterconnect.test.pagetesters.MikrotikTester;
import com.wifiafterconnect.test.pagetesters.NNUTester;
import com.wifiafterconnect.util.Logger;
import com.wifiafterconnect.util.Worker;

import junit.framework.TestCase;

public class PortalHandlers extends TestCase {
	
	public interface PortalPageTester {
		public String getURL();
		public String getInput();
		public void getHeaders(Map<String,String> headers);
		public WifiAuthParams getParams ();
		public String getPostURL ();
		public String getPostData ();
		public String getMetaRefresh();
	}

	public void executeTester (PortalPageTester tester) {
		Worker base = new Worker (new Logger("WiFiAfterConnect.test"), new MockContext());
		URL url = null;
		try {
			url = new URL (tester.getURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Map<String,String> headers = new HashMap<String,String>();
		tester.getHeaders(headers);
		ParsedHttpInput parsedPage = new ParsedHttpInput (base, url, tester.getInput(), headers);
		assertNotNull ("ParsedPage is null", parsedPage);
		
		for (String hk : headers.keySet()) {
				assertEquals ("Header is incorrect", headers.get(hk), parsedPage.getHttpHeader(hk));	
		}
		
		WifiAuthParams wantParams = tester.getParams();
		if (wantParams == null)
			wantParams = new WifiAuthParams();
		WifiAuthParams haveParams = parsedPage.addMissingParams(null);
		assertEquals ("Params are incorrect", WifiAuthParams.toString(wantParams), WifiAuthParams.toString(haveParams));
		if (tester.getPostURL() != null)
			assertEquals ("Post URL does not match", tester.getPostURL(), parsedPage.getFormPostURL().toString());
		else {
			HtmlPage.MetaRefresh mr = parsedPage.getMetaRefresh();
			assertEquals ("meta Refresh URL does not match", tester.getMetaRefresh(), mr == null ? "null" : mr.getURLString());
		}
		assertEquals ("Post Data does not match", tester.getPostData(), parsedPage.buildPostData(wantParams));
	}

	public void testCiscoSwitchUrl (){
		executeTester (new CiscoSwitchUrlTester());
	}
	public void testColubris (){
		executeTester (new ColubrisTester());
	}
	public void testMikrotik (){
		executeTester (new MikrotikTester());
	}
	public void testNNU (){
		executeTester (new NNUTester());
	}
	public void testGuestNet1 (){
		executeTester (new GuestNet1Tester());
	}
}
