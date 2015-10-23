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
import cn.lovefish.domain.FriendCircle;
import cn.lovefish.domain.FriendCircleData;
import cn.lovefish.util.HttpClientUtil;
import cn.lovefish.util.HttpEntityNullException;
import cn.lovefish.util.HttpStatusErrorException;
import cn.lovefish.util.CommonMenthodUtils;
import cn.lovefish.util.Constants;

@WebServlet("/FriendCircleServlet")
public class FriendCircleServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 发布钓友圈，暂未实现上传图片
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws HttpStatusErrorException
	 * @throws HttpEntityNullException
	 */
	public String addDynamic(HttpServletRequest request, HttpServletResponse response) throws ServletException, URISyntaxException, IOException, HttpStatusErrorException, HttpEntityNullException {
		
		
//		String upload = request.getParameter("upload");
//		System.out.println(upload);
		
		
		String localAdd = request.getParameter("localAdd");
		String IsAdv = request.getParameter("IsAdv"); // 值为0 或者 1，默认值为0，表示不上传足迹
		String content = request.getParameter("content");
		String lat = request.getParameter("Lat");
		String lon = request.getParameter("Lng");
		
		String url = "http://120.24.159.207:8081/FCS/FriendCircle/SendFriendCircle";
		Map<String, String> params = new HashMap<String, String>();
		params.put("content", content); 
		params.put("localAdd", localAdd); 
		params.put("lon", lon); 
		params.put("lat", lat); 
		params.put("IsAdv", IsAdv); 
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		
		HttpClientUtil.get(url, params);
		
		return getFriendCircleList(request, response);
	}
	
	public String addDynamicUI(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		return "f:/friendCircle/sendDynamic.jsp";
	}
	
	/**
	 * 点击朋友圈列表的头像（获取环信Id），显示该用户的所有所发过的朋友圈说说
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws HttpStatusErrorException
	 * @throws HttpEntityNullException
	 */
	public String getFriendCircleListByUserID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
		String UserID = request.getParameter("UserID"); // 环信Id
		
		request.setAttribute("pc", pc);
		
		String url = "http://120.24.159.207:8081/FCS/FriendCircle/GetMyFriendCircleList";
//		String url = "http://120.24.159.207:8081/FCS/FriendCircle/GetMyFriendCircleListHasLon"; // 返回都是“爱鱼小二”一条数据
		Map<String, String> params = new HashMap<String, String>();
		params.put("UserID", UserID); // 暂时的UserID是死数据
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		
		String jsonStr = jsonObjTemp.getString("Data");
		
		FriendCircleData data = JSON.parseObject(jsonStr, FriendCircleData.class);
		
		request.setAttribute("HasElse", data.getHasElse());
		
		for (FriendCircle fc : data.getItems()) {
			String  photoesTemp = fc.getPhotoes();
			fc.setPhotoes(CommonMenthodUtils.getPhotoes(photoesTemp));
		}
		
		request.setAttribute("Items", data.getItems());
		
		return "f:/friendCircle/friendCircleList.jsp";
		
	}
	
	/**
	 * 返回“钓友动态”,即只有是好友关系和自己的朋友圈说说
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws HttpStatusErrorException
	 * @throws HttpEntityNullException
	 */
	public String getMyFriendDynamicList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
		
		request.setAttribute("pc", pc);
		
		String url = "http://120.24.159.207:8081/FCS/FriendCircle/GetFriendCircleList";
		Map<String, String> params = new HashMap<String, String>();
		params.put("PageIndex", pc + ""); // 当前是第几页
		params.put("Count", Constants.FRIENDCIRCLE_PAGE_COUNT); // 每页要显示的数量
		params.put("Type", "2"); // Type 类型：1全部，2好友和我发布的朋友圈 Int32 默认值：1
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		 
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		// --------------------------------------------------------------
		
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		
		String jsonStr = jsonObjTemp.getString("Data");
		
		FriendCircleData data = JSON.parseObject(jsonStr, FriendCircleData.class);
		
		request.setAttribute("HasElse", data.getHasElse());
		
		for (FriendCircle fc : data.getItems()) {
			String  photoesTemp = fc.getPhotoes();
			fc.setPhotoes(CommonMenthodUtils.getPhotoes(photoesTemp));
		}
		
		request.setAttribute("Items", data.getItems());
		
		return "f:/friendCircle/friendCircleList.jsp";
		
	}
	
	/**
	 * 获取朋友圈的所有信息，包括非好友的说说，任何Token返回的数据都是一样（即任意用户登录的结果都是一样的）
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws HttpStatusErrorException
	 * @throws HttpEntityNullException
	 */
	public String getFriendCircleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
		
		request.setAttribute("pc", pc);
		
		String url = "http://120.24.159.207:8081/FCS/FriendCircle/GetFriendCircleList";
		Map<String, String> params = new HashMap<String, String>();
		params.put("PageIndex", pc + ""); // 当前是第几页
		params.put("Count", Constants.FRIENDCIRCLE_PAGE_COUNT); // 每页要显示的数量
		params.put("Type", "1"); // Type 类型：1全部，2好友和我发布的朋友圈 Int32 默认值：1
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		 
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		// --------------------------------------------------------------
		
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		
		String jsonStr = jsonObjTemp.getString("Data");
		
		FriendCircleData data = JSON.parseObject(jsonStr, FriendCircleData.class);
		
		request.setAttribute("HasElse", data.getHasElse());
		
		for (FriendCircle fc : data.getItems()) {
			String  photoesTemp = fc.getPhotoes();
			fc.setPhotoes(CommonMenthodUtils.getPhotoes(photoesTemp));
		}
		
		request.setAttribute("Items", data.getItems());
		
		return "f:/friendCircle/friendCircleList.jsp";
		
	}
	
	/**
	 * 获取朋友圈详情页面
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws HttpStatusErrorException
	 * @throws HttpEntityNullException
	 */
	public String getDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String RepGUID = request.getParameter("RepGUID");
		
		String url = "http://120.24.159.207:8081/FCS/FriendCircle/GetFriendCircleDetail";
		Map<String, String> params = new HashMap<String, String>();
		params.put("GUID", RepGUID);
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		
		String jsonStr = jsonObjTemp.getString("Data");
		
		FriendCircle fc = JSON.parseObject(jsonStr, FriendCircle.class);
//		System.out.println("转换过来的Java对象为：\n " + fc);
		String  photoesTemp = fc.getPhotoes();
		fc.setPhotoes(CommonMenthodUtils.getPhotoes(photoesTemp));
		
		request.setAttribute("fc", fc);
		
		return "f:/friendCircle/friendCircleDetail.jsp";
	}

}
