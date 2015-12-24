package cn.lovefish.web.servlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.itcast.servlet.BaseServlet;
import cn.lovefish.domain.FriendData;
import cn.lovefish.domain.UserData;
import cn.lovefish.util.CommonMenthodUtils;
import cn.lovefish.util.Constants;
import cn.lovefish.util.HttpClientUtil;
import cn.lovefish.util.HttpEntityNullException;
import cn.lovefish.util.HttpStatusErrorException;

@WebServlet("/FriendServlet")
public class FriendServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String getFriendList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String url = "http://120.24.159.207:8081/UMS/UM/GetFriendList";
		Map<String, String> params = new HashMap<String, String>();
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		String jsonStrTemp = HttpClientUtil.get(url, params);
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		String jsonStr = jsonObjTemp.getString("Data");
		FriendData data = JSON.parseObject(jsonStr, FriendData.class);
		request.setAttribute("Items", data.getItems());
		return "f:/friend/friendList.jsp";
		
	}
	
	public String getNearbyFriendList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
		
		request.setAttribute("pc", pc);
		
		String url = "http://120.24.159.207:8081/UMS/UM/GetUserListByDistince";
		Map<String, String> params = new HashMap<String, String>();
		params.put("PageIndex", pc + ""); // 当前是第几页
		params.put("Count", Constants.FRIEND_PAGE_COUNT); // 每页要显示的数量
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		 
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		String jsonStr = jsonObjTemp.getString("Data");
		UserData data = JSON.parseObject(jsonStr, UserData.class);
		request.setAttribute("HasElse", data.getHasElse());
		
		request.setAttribute("Items", data.getItems());
		return "f:/friend/nearbyFriendList.jsp";
		
	}
	
	public String GetUserListByKey(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
		
		request.setAttribute("pc", pc);
		String keyStr = request.getParameter("keyStr");
		request.setAttribute("keyStr", keyStr);
		
		String url = "http://120.24.159.207:8081/UMS/UM/GetUserListByKey";
		Map<String, String> params = new HashMap<String, String>();
		params.put("keyStr", keyStr);
		params.put("PageIndex", pc + ""); // 当前是第几页
		params.put("Count", Constants.FRIEND_PAGE_COUNT); // 每页要显示的数量
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		String jsonStr = jsonObjTemp.getString("Data");
		UserData data = JSON.parseObject(jsonStr, UserData.class);
		request.setAttribute("HasElse", data.getHasElse());
		
		request.setAttribute("Items", data.getItems());
		
		return "f:/friend/addFriend.jsp";
		
	}
	
	public String addFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String ApplyID = request.getParameter("ApplyID");
		
		String url = "http://120.24.159.207:8081/UMS/UM/TreatMentFriend";
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		params.put("ApplyID", ApplyID);
		params.put("Remarks", ""); // 好友备注（可空） String 默认值：
		
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		if (jsonStrTemp.contains("200")) {
			request.setAttribute("msg", "已发出申请");
		} else if (jsonStrTemp.contains("已经是好友")) {
			request.setAttribute("msg", "已经是好友");
		}
		System.out.println(jsonStrTemp);
		
		return "f:/friend/addFriend.jsp";
//		return GetUserListByKey(request, response);
		
	}
	

}
