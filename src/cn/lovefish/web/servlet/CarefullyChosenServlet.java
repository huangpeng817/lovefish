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
import cn.lovefish.domain.CarefullyChosen;
import cn.lovefish.domain.CarefullyChosenData;
import cn.lovefish.domain.CommentData;
import cn.lovefish.util.HttpClientUtil;
import cn.lovefish.util.HttpEntityNullException;
import cn.lovefish.util.HttpStatusErrorException;
import cn.lovefish.util.CommonMenthodUtils;
import cn.lovefish.util.Constants;

@WebServlet("/CarefullyChosenServlet")
public class CarefullyChosenServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	
	public String getCommentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
		request.setAttribute("pc", pc);
		
		String NewsID = request.getParameter("Id");
		request.setAttribute("Id", NewsID);
//		System.out.println("#getCommentList.NewsID: " + NewsID);
		String url = "http://120.24.159.207:8081/CMS/News/NewsCommentList";
		Map<String, String> params = new HashMap<String, String>();
		params.put("Id", NewsID);
		params.put("PageIndex", pc + "");
		params.put("Count", Constants.COMMENT_PAGE_COUNT);
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		
		String jsonStr = jsonObjTemp.getString("Data");
		
		CommentData data = JSON.parseObject(jsonStr, CommentData.class);
		
		request.setAttribute("HasElse", data.getHasElse());
		
		request.setAttribute("Items", data.getItems());
		
		return "f:/carefullyChosen/commentList.jsp";
	}
	
	public String addComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String NewsID = request.getParameter("Id");
		String Content = request.getParameter("Content");
		String url = "http://120.24.159.207:8081/CMS/News/NewsComment";
		Map<String, String> params = new HashMap<String, String>();
		params.put("NewsID", NewsID);
		params.put("Content", Content);
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		return getDetail(request, response);
	}
	
	public String addCommentUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String NewsID = request.getParameter("NewsID");
		request.setAttribute("NewsID", NewsID);
		
		return "f:/carefullyChosen/comment.jsp";
	}

	public String getDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String Id = request.getParameter("Id");
		
		String url = "http://120.24.159.207:8081/CMS/News/NewsDetail";
		Map<String, String> params = new HashMap<String, String>();
		params.put("Id", Id);
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		
		String jsonStr = jsonObjTemp.getString("Data");
		
		CarefullyChosen cc = JSON.parseObject(jsonStr, CarefullyChosen.class);
		String  photoesTemp = cc.getImgURL();
		cc.setImgURL(CommonMenthodUtils.getPhotoes(photoesTemp));
		
		request.setAttribute("cc", cc);
		
		return "f:/carefullyChosen/carefullyChosenDetail.jsp";
	}
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
		
		request.setAttribute("pc", pc);
		
		String url = "http://120.24.159.207:8081/CMS/News/CarefullyChosen";
		Map<String, String> params = new HashMap<String, String>();
		params.put("PageIndex", pc + ""); // 当前是第几页
		params.put("Count", Constants.CAREFULLYCHOSEN_PAGE_COUNT); // 每页要显示的数量
		// 此处的Category应该或者可以作为参数传递，目前是模仿手机APP中显示全部精选，可以作为下拉框或者是选项卡展示
		params.put("Category", "1"); // 精选类型(全部 = 1, 爱渔资讯 = 2,活动信息 = 3, 钓点信息 = 4,钓友圈信息 = 5) 默认值：1
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		 
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		
		String jsonStr = jsonObjTemp.getString("Data");
		
		CarefullyChosenData data = JSON.parseObject(jsonStr, CarefullyChosenData.class);
		
		request.setAttribute("HasElse", data.getHasElse());
		
		for (CarefullyChosen cc : data.getItems()) {
			String  photoesTemp = cc.getImgURL();
			cc.setImgURL(CommonMenthodUtils.getPhotoes(photoesTemp));
		}
				
		request.setAttribute("Items", data.getItems());
		
		return "f:/carefullyChosen/carefullyChosenList.jsp";
	}
	

}
