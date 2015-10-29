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
import cn.lovefish.domain.FishingPoint;
import cn.lovefish.domain.FishingPointData;
import cn.lovefish.util.HttpClientUtil;
import cn.lovefish.util.HttpEntityNullException;
import cn.lovefish.util.HttpStatusErrorException;
import cn.lovefish.util.CommonMenthodUtils;
import cn.lovefish.util.Constants;

@WebServlet("/FishingPointServlet")
public class FishingPointServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;

	public String getDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String Id = request.getParameter("Id");
		
		String url = "http://120.24.159.207:8081/CMS/News/FishingPointDetail";
		Map<String, String> params = new HashMap<String, String>();
		params.put("Id", Id);
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		
		String jsonStr = jsonObjTemp.getString("Data");
		
		FishingPoint fp = JSON.parseObject(jsonStr, FishingPoint.class);
		String  photoesTemp = fp.getPhotoes();
		fp.setPhotoes(CommonMenthodUtils.getPhotoes(photoesTemp));
		
		request.setAttribute("fp", fp);
		
		return "f:/fishingPoint/fishingPointDetail.jsp";
	}
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		int pc = CommonMenthodUtils.getPc(request); // 获取到当前页码
		String Lat = request.getParameter("Lat");
		String Lng = request.getParameter("Lng");
		String Region = request.getParameter("Region"); // ***
//		System.out.println("百度地图API获取的当前城市： " + Region);
		String RegionID = CommonMenthodUtils.findRegionID(Region); // ***
		String condition = request.getParameter("condition"); // ***
		String Sort = ""; // 默认 = 0,人气 = 1, 距离 = 2   // ***
		if (condition.equals("默认")) {
			Sort = "0";
		} else if (condition.equals("人气")) {
			Sort = "1";
		} else if (condition.equals("距离")) {
			Sort = "2";
		}
		
		request.setAttribute("Lat", Lat);
		request.setAttribute("Lng", Lng);
		request.setAttribute("Region", Region);
		request.setAttribute("RegionID", RegionID);
		request.setAttribute("condition", condition);
		request.setAttribute("Sort", Sort);
		request.setAttribute("pc", pc);
		
		String url = "http://app.ifishing.com.cn:8081/CMS/News/GetFishingPointList";
		Map<String, String> params = new HashMap<String, String>();
		params.put("Lat", Lat);
		params.put("Lng", Lng);
		params.put("RegionID", RegionID);
		params.put("Sort", Sort);
		params.put("PageIndex", pc + ""); // 当前是第几页
		params.put("Count", Constants.FISHINGPOINT_PAGE_COUNT); // 每页要显示的数量
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		 
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		JSONObject jsonObjTemp = JSON.parseObject(jsonStrTemp);
		
		String jsonStr = jsonObjTemp.getString("Data");
		
		if (jsonStr == null) {
			return "f:/fishingPoint/fishingPointList.jsp";
		}
		
		FishingPointData data = JSON.parseObject(jsonStr, FishingPointData.class);
		
		request.setAttribute("HasElse", data.getHasElse());
		
		for (FishingPoint fp : data.getItems()) {
			String  photoesTemp = fp.getPhotoes();
			fp.setPhotoes(CommonMenthodUtils.getPhotoes(photoesTemp));
		}
		
		request.setAttribute("Items", data.getItems());
		
		return "f:/fishingPoint/fishingPointList.jsp";
		
	}
	

}
