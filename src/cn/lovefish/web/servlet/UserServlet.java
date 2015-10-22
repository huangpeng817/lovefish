package cn.lovefish.web.servlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import cn.itcast.servlet.BaseServlet;
import cn.lovefish.util.HttpClientUtil;
import cn.lovefish.util.HttpEntityNullException;
import cn.lovefish.util.HttpStatusErrorException;
import cn.lovefish.util.Constants;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;

	public String loginByMobile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String UserName = request.getParameter("MobilePhone");
		String Pwd = request.getParameter("Pwd");
		String md5Digest = DigestUtils.md5Hex(Pwd);
		String url = "http://120.24.159.207:8081/UMS/UM/mLogin";
		Map<String, String> params = new HashMap<String, String>();
		params.put("UserName", UserName);
		params.put("Pwd", md5Digest);
		params.put("DeviceNo", "DeviceNo");
		params.put("LastLoginType", Constants.LOGIN_LASTLOGINTYPE);
		// 当执行成功json返回如下形式，说明该手机号注册成功，不能再次注册，考虑下一步的登录功能，密码为123456
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		System.out.println("收到json数据： " + jsonStrTemp);
		
		return null;
	}
	
	public String reigsterByMobile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String MobilePhone = request.getParameter("MobilePhone");
		String Password = request.getParameter("Password");
		String VCode = request.getParameter("VCode");
//		System.out.println("MobilePhone: " + MobilePhone);
//		System.out.println("Password: " + Password);
//		System.out.println("VCode: " + VCode);
		
		String url = "http://120.24.159.207:8081/UMS/UM/ReigsterByMobile";
		// MobilePhone=13908094173&Password=123&DeviceNo=DeviceNo&LoginType=weixin&VCode=1234
		Map<String, String> params = new HashMap<String, String>();
		params.put("MobilePhone", MobilePhone);
		params.put("Password", Password);
		params.put("VCode", VCode);
		params.put("DeviceNo", "DeviceNo");
		params.put("LoginType", "weixin");
		// 当执行成功json返回如下形式，说明该手机号注册成功，不能再次注册，考虑下一步的登录功能，密码为123456
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		/**
		 
		 {
    		"Code": "200",
    		"Message": null,
    		"Data": {
        		"UserId": "283",
        		"Time": "2015-10-15 19:57:36",
        		"Token": "5evpit5dpnql2o0rlj0722iv7o",
        		"HX_Account": "",
        		"NickName": "用户9417"
    	 	},
    		"SubCode": null
		 }
		 
		 */
		System.out.println("收到json数据： " + jsonStrTemp);
		
		return null;
	}

}
