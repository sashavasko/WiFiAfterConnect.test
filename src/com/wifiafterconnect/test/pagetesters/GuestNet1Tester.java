package com.wifiafterconnect.test.pagetesters;

import java.util.Map;

import com.wifiafterconnect.WifiAuthParams;
import com.wifiafterconnect.test.PortalHandlers.PortalPageTester;

public class GuestNet1Tester implements PortalPageTester {

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInput() {
		return "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">"+
"				<html>"+
"				<head>"+
"				<script type=\"text/javascript\">"+
"						var HotelBrand, HotelGroup, HotelId, cpUrl, ControllerType, pAction, usr, pwd, redir ;"+
"						pAction = \"http://10.0.0.1:8000/&err=\";"+
"				// Set manual variables below."+	  
"						/* Controller Types"+
"							es = \"EthoStream\""+
"							gn = \"Guestnet Gateway\""+
"							mt = \"Microtik\""+
"							nx = \"Nomadix\""+
"							vp = \"ValuePoint\""+
"						*/"+
"					// ControllerType = \"vp\";    // Set Controller Type Here"+
"						/* Hotel Brands"+
"							hi = \"Holiday Inn\""+
"							hie = \"Holiday Inn Express\""+
"							ms = \"Mainstay\""+
"							cw = \"Candlewood\""+
"							sb = \"Staybridge\""+
"							ci = \"Comfort Inn\""+
"							bw = \"Best Western\""+
"							fp = \"Four Points by Sheraton\""+
"							s8 = \"Super 8\""+
"							*/"+
"					// HotelGroup = \"tr\";    // Manually Set Hotel Group Here"+
"					// HotelBrand = \"s8\";    // Manually Set Hotel Brand Here"+
"					// HotelId = \"20177\";    // Manually Set Hotel Code Here"+
"					 // usr = \"PC103\";    // Manually Set User Here"+
"					// pwd = \"yes\";    // Only use \"yes\" or \"no\" to manually indicate that guests need a pass code."+
"						/* Use redir if you want to specify a manual redirect page."+
"							e.g. \"http://www.wiscohotels.com/wiscobaymont/index.php\")"+
"							*/"+
"					// redir = \"\";"+    
"				// Do NOT change anything below this line!"+
"						cpUrl = \"http://login.guestnetinc.com/login.php?\";"+
"							cpUrl += \"pa=\" + pAction;"+
"						if (ControllerType){"+
"							cpUrl += \"&\" + \"ct=\" + ControllerType;"+
"						}"+
"						if (HotelGroup){"+
"							cpUrl += \"&\" + \"hg=\" + HotelGroup;"+
"						}"+
"						if (HotelBrand){"+
"							cpUrl += \"&\" + \"hb=\" + HotelBrand;"+
"						}"+
"						if (HotelId){"+
"							cpUrl += \"&\" + \"id=\" + HotelId;"+
"						}"+
"						if (usr) {"+
"							cpUrl += \"&\" + \"usr=\" + usr;"+
"						}"+
"						if (pwd) {"+
"							cpUrl += \"&\" + \"pwd=\" + pwd;"+
"						}"+
"						if (redir) {"+
"							cpUrl += \"&\" + \"redir=\" + redir;"+
"						}"+
"				</script>"+
"				<title>Login</title>"+
"				<script language=\"JavaScript\">"+
"				document.write('<meta http-equiv=\"REFRESH\" content=\"0;url=' + cpUrl + '\">');"+
"				</script>"+
"				</HEAD> "+
"				<BODY>"+
"				Please wait for Login Page . . ."+ 
"				</BODY>"+
"				</HTML>";
	}

	@Override
	public void getHeaders(Map<String, String> headers) {
		headers.put("Date","Fri, 15 Nov 2013 23:46:35 GMT");
		headers.put("Transfer-Encoding","chunked");
		headers.put("Content-type","text/html");
		headers.put("Expires","0");
		headers.put("X-Android-Received-Millis","1384559194137");
		headers.put("Connection","close");
		headers.put("Server","lighttpd/1.4.29");
		headers.put("X-Android-Sent-Millis","1384559193865");
		headers.put("Pragma","no-cache");
		headers.put("Cache-Control","post-check=0, pre-check=0");
	}

	@Override
	public WifiAuthParams getParams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPostURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPostData() {
		// TODO Auto-generated method stub
		return null;
	}

}
