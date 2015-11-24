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
import cn.lovefish.util.CommonMenthodUtils;
import cn.lovefish.util.Constants;
import cn.lovefish.util.HttpClientUtil;
import cn.lovefish.util.HttpEntityNullException;
import cn.lovefish.util.HttpStatusErrorException;

@WebServlet("/EncyclopediaServlet")
public class EncyclopediaServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String initLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		String tabIndex = request.getParameter("tabIndex");
		request.setAttribute("tabIndex", tabIndex);
		System.out.println(tabIndex);
		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
		request.setAttribute("pc", pc);
		
		String url = "http://120.24.159.207:8081/CMS/News/NewsList";
		Map<String, String> params = new HashMap<String, String>();
		params.put("PageIndex", pc + ""); // 当前是第几页
		params.put("Count", Constants.CAREFULLYCHOSEN_PAGE_COUNT); // 每页要显示的数量
//		params.put("Category", "2"); // Category 资讯类型(教程经验 = 2,装备评测 = 3,食渔汇 = 4,国际新闻= 5,国内新闻= 6,国际赛事 = 7,国内赛事 = 8) Int32 默认值：6
		if (tabIndex.equals("1")) {
			params.put("Category", "2"); 
		} else if (tabIndex.equals("2")) {
			params.put("Category", "3"); 
		} else {
			params.put("Category", "4"); 
		}
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		 
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		String jsonStr = jsonObjTemp.getString("Data");
		
		CarefullyChosenData data = JSON.parseObject(jsonStr, CarefullyChosenData.class);
		
		request.setAttribute("HasElse", data.getHasElse());
		
		for (CarefullyChosen jcjy : data.getItems()) {
			String  photoesTemp = jcjy.getImgURL();
			jcjy.setImgURL(CommonMenthodUtils.getPhotoes(photoesTemp));
		}
				
		request.setAttribute("Items", data.getItems());
		
		return "f:/encyclopedia/encyclopediaList.jsp";
	}
	
//	public String getZBPCList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
//		String tabIndex = request.getParameter("tabIndex");
//		System.out.println(tabIndex);
//		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
//		request.setAttribute("pc", pc);
//		
//		String url = "http://120.24.159.207:8081/CMS/News/NewsList";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("PageIndex", pc + "");
//		params.put("Count", Constants.CAREFULLYCHOSEN_PAGE_COUNT);
//		params.put("Category", "3"); // Category 资讯类型(教程经验 = 2,装备评测 = 3,食渔汇 = 4,国际新闻= 5,国内新闻= 6,国际赛事 = 7,国内赛事 = 8) Int32 默认值：6
//		params.put("Token", Constants.TOKEN);
//		params.put("DeviceNo", Constants.DEVICENO);
//		
//		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
//		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
//		String jsonStr = jsonObjTemp.getString("Data");
//		
//		CarefullyChosenData data = JSON.parseObject(jsonStr, CarefullyChosenData.class);
//		
//		request.setAttribute("HasElse", data.getHasElse());
//		
//		for (CarefullyChosen zbpc : data.getItems()) {
//			String  photoesTemp = zbpc.getImgURL();
//			zbpc.setImgURL(CommonMenthodUtils.getPhotoes(photoesTemp));
//		}
//		
//		request.setAttribute("Items", data.getItems());
//		
//		return "f:/encyclopedia/encyclopediaList.jsp";
//	}
//	
//	public String getSYHList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
//		String tabIndex = request.getParameter("tabIndex");
//		System.out.println(tabIndex);
//		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
//		request.setAttribute("pc", pc);
//		
//		String url = "http://120.24.159.207:8081/CMS/News/NewsList";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("PageIndex", pc + "");
//		params.put("Count", Constants.CAREFULLYCHOSEN_PAGE_COUNT);
//		params.put("Category", "4"); // Category 资讯类型(教程经验 = 2,装备评测 = 3,食渔汇 = 4,国际新闻= 5,国内新闻= 6,国际赛事 = 7,国内赛事 = 8) Int32 默认值：6
//		params.put("Token", Constants.TOKEN);
//		params.put("DeviceNo", Constants.DEVICENO);
//		
//		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
//		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
//		String jsonStr = jsonObjTemp.getString("Data");
//		
//		CarefullyChosenData data = JSON.parseObject(jsonStr, CarefullyChosenData.class);
//		
//		request.setAttribute("HasElse", data.getHasElse());
//		
//		for (CarefullyChosen zbpc : data.getItems()) {
//			String  photoesTemp = zbpc.getImgURL();
//			zbpc.setImgURL(CommonMenthodUtils.getPhotoes(photoesTemp));
//		}
//		
//		request.setAttribute("Items", data.getItems());
//		
//		return "f:/encyclopedia/encyclopediaList.jsp";
//	}

}
