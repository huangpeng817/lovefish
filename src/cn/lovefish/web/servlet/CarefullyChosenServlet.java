package cn.lovefish.web.servlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.lovefish.domain.CarefullyChosen;
import cn.lovefish.domain.CarefullyChosenData;
import cn.lovefish.domain.Comment;
import cn.lovefish.domain.CommentData;
import cn.lovefish.domain.FishingPoint;
import cn.lovefish.test.HttpClientUtil;
import cn.lovefish.test.HttpEntityNullException;
import cn.lovefish.test.HttpStatusErrorException;
import cn.lovefish.util.CommonMenthodUtils;
import cn.lovefish.util.Constants;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
//		System.out.println("评价列表json完整字符串： " + jsonStrTemp);
		
		JSONObject jsonObjTemp = JSONObject.fromObject(jsonStrTemp);//将json字符串转换为json对象  
		String jsonStr = jsonObjTemp.getString("Data");
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);//将只包含Data数据的json字符串转换为json对象  
		
		CommentData data = new CommentData();
		for (Iterator iter = jsonObj.keys(); iter.hasNext();) { 
		    String key = (String)iter.next();  
		    if (key.equals("Count")) {
		    	data.setCount(jsonObj.getString(key));
			}
		    else if (key.equals("HasElse")) {
		    	data.setHasElse(Boolean.parseBoolean(jsonObj.getString(key)));
		    	request.setAttribute("HasElse", Boolean.parseBoolean(jsonObj.getString(key)));
		    	System.out.println("HasElse? " + jsonObj.getString(key));
		    }
		    else if (key.equals("PageIndex")) {
		    	data.setPageIndex(jsonObj.getString(key));
		    }
		    else if (key.equals("Items")) {
		    	JSONArray jsonArray = jsonObj.getJSONArray(key);
		    	
		    	List<Comment> list = new ArrayList<Comment>();
		    	
		    	for (int i = 0; i < jsonArray.size(); i++) {
		    		JSONObject obj = (JSONObject) jsonArray.get(i);
		    		Comment c = new Comment();
		    		for (Iterator it = obj.keys(); it.hasNext();) { 
		    			String k = (String)it.next();  
		    		    if (k.equals("Id")) {
		    		    	c.setId(obj.getString(k));
		    			}
		    		    else if (k.equals("Content")) {
		    		    	c.setContent(obj.getString(k));
		    		    }
		    		    else if (k.equals("Publisher")) {
		    		    	c.setPublisher(obj.getString(k));
		    		    }
		    		    else if (k.equals("PublishTime")) {
		    		    	c.setPublishTime(obj.getString(k));
		    		    }
		    		    else if (k.equals("UnionID")) {
		    		    	c.setUnionID(obj.getString(k));
		    		    }
		    		    else if (k.equals("Category")) {
		    		    	c.setCategory(obj.getString(k));
		    		    }
		    		    else if (k.equals("NickName")) {
		    		    	c.setNickName(obj.getString(k));
		    		    }
		    		    else if (k.equals("CurrentHead")) {
		    		    	c.setCurrentHead(obj.getString(k));
		    		    }
		    		    else if (k.equals("HXAccount")) {
		    		    	c.setHXAccount(obj.getString(k));
		    		    }
		    		}
		    		list.add(c);
		    	}
		    	data.setItems(list);
		    }
		}
		request.setAttribute("Items", data.getItems());
		
		return "f:/carefullyChosen/commentList.jsp";
	}
	
	public String addComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String NewsID = request.getParameter("Id");
		String Content = request.getParameter("Content");
		System.out.println("#addComment.NewsID: " + NewsID);
		System.out.println("#addComment.Content: " + Content);
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
		
		JSONObject jsonObjTemp = JSONObject.fromObject(jsonStrTemp);//将json字符串转换为json对象  
		String jsonStr = jsonObjTemp.getString("Data");
		JSONObject obj = JSONObject.fromObject(jsonStr);//将只包含Data数据的json字符串转换为json对象  
		
		CarefullyChosen cc = new CarefullyChosen();
		for (Iterator it = obj.keys(); it.hasNext();) { 
			String k = (String)it.next();  
		    if (k.equals("Id")) {
		    	cc.setId(obj.getString(k));
			}
		    else if (k.equals("Category")) {
		    	cc.setCategory(obj.getString(k));
		    }
		    else if (k.equals("Title")) {
		    	cc.setTitle(obj.getString(k));
		    }
		    else if (k.equals("Content")) {
		    	cc.setContent(obj.getString(k));
		    }
		    else if (k.equals("NewSource")) {
		    	cc.setNewSource(obj.getString(k));
		    }
		    else if (k.equals("SourceUrl")) {
		    	cc.setSourceUrl(obj.getString(k));
		    }
		    else if (k.equals("Publisher")) {
		    	cc.setPublisher(obj.getString(k));
		    }
		    else if (k.equals("NickName")) {
		    	cc.setNickName(obj.getString(k));
		    }
		    else if (k.equals("PublishTime")) {
		    	cc.setPublishTime(obj.getString(k));
		    }
		    else if (k.equals("ImgURL")) {
		    	String photoesTemp = obj.getString(k);
		    	String photoes = photoesTemp.replace("[", "");
		    	photoes = photoes.replace("]", "");
		    	photoes = photoes.replace("\"", "");
		    	cc.setImgURL(photoes);
		    }
		    else if (k.equals("ImgDetail")) {
		    	cc.setImgDetail(obj.getString(k));
		    }
		    else if (k.equals("PraiseCount")) {
		    	cc.setPraiseCount(obj.getString(k));
		    }
		    else if (k.equals("CommentCount")) {
		    	cc.setCommentCount(obj.getString(k));
		    }
		    else if (k.equals("DetailUrl")) {
		    	cc.setDetailUrl(obj.getString(k));
		    }
		    else if (k.equals("CategoryTop")) {
		    	cc.setCategoryTop(obj.getString(k));
		    }
		    else if (k.equals("Video")) {
		    	cc.setVideo(Boolean.parseBoolean(obj.getString(k)));
		    }
		}
		
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
		params.put("Category", "1"); // 精选类型(全部 = 1, 爱渔资讯 = 2,活动信息 = 3, 钓点信息 = 4,钓友圈信息 = 5) 默认值：1
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		 
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		JSONObject jsonObjTemp = JSONObject.fromObject(jsonStrTemp);//将json字符串转换为json对象  
		String jsonStr = jsonObjTemp.getString("Data");
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);//将只包含Data数据的json字符串转换为json对象  
		
		CarefullyChosenData data = new CarefullyChosenData();
		for (Iterator iter = jsonObj.keys(); iter.hasNext();) { 
		    String key = (String)iter.next();  
		    if (key.equals("Count")) {
		    	data.setCount(jsonObj.getString(key));
			}
		    else if (key.equals("HasElse")) {
		    	data.setHasElse(Boolean.parseBoolean(jsonObj.getString(key)));
		    	request.setAttribute("HasElse", Boolean.parseBoolean(jsonObj.getString(key)));
		    }
		    else if (key.equals("PageIndex")) {
		    	data.setPageIndex(jsonObj.getString(key));
		    }
		    else if (key.equals("Items")) {
		    	JSONArray jsonArray = jsonObj.getJSONArray(key);
		    	
		    	List<CarefullyChosen> list = new ArrayList<CarefullyChosen>();
		    	
		    	for (int i = 0; i < jsonArray.size(); i++) {
		    		JSONObject obj = (JSONObject) jsonArray.get(i);
		    		CarefullyChosen cc = new CarefullyChosen();
		    		for (Iterator it = obj.keys(); it.hasNext();) { 
		    			String k = (String)it.next();  
		    		    if (k.equals("Id")) {
		    		    	cc.setId(obj.getString(k));
		    			}
		    		    else if (k.equals("Category")) {
		    		    	cc.setCategory(obj.getString(k));
		    		    }
		    		    else if (k.equals("Title")) {
		    		    	cc.setTitle(obj.getString(k));
		    		    }
		    		    else if (k.equals("Content")) {
		    		    	cc.setContent(obj.getString(k));
		    		    }
		    		    else if (k.equals("NewSource")) {
		    		    	cc.setNewSource(obj.getString(k));
		    		    }
		    		    else if (k.equals("SourceUrl")) {
		    		    	cc.setSourceUrl(obj.getString(k));
		    		    }
		    		    else if (k.equals("Publisher")) {
		    		    	cc.setPublisher(obj.getString(k));
		    		    }
		    		    else if (k.equals("NickName")) {
		    		    	cc.setNickName(obj.getString(k));
		    		    }
		    		    else if (k.equals("PublishTime")) {
		    		    	cc.setPublishTime(obj.getString(k));
		    		    }
		    		    else if (k.equals("ImgURL")) {
		    		    	String photoesTemp = obj.getString(k);
		    		    	String photoes = photoesTemp.replace("[", "");
		    		    	photoes = photoes.replace("]", "");
		    		    	photoes = photoes.replace("\"", "");
		    		    	cc.setImgURL(photoes);
		    		    }
		    		    else if (k.equals("ImgDetail")) {
		    		    	cc.setImgDetail(obj.getString(k));
		    		    }
		    		    else if (k.equals("PraiseCount")) {
		    		    	cc.setPraiseCount(obj.getString(k));
		    		    }
		    		    else if (k.equals("CommentCount")) {
		    		    	cc.setCommentCount(obj.getString(k));
		    		    }
		    		    else if (k.equals("DetailUrl")) {
		    		    	cc.setDetailUrl(obj.getString(k));
		    		    }
		    		    else if (k.equals("CategoryTop")) {
		    		    	cc.setCategoryTop(obj.getString(k));
		    		    }
		    		    else if (k.equals("Video")) {
		    		    	cc.setVideo(Boolean.parseBoolean(obj.getString(k)));
		    		    }
		    		}
		    		list.add(cc);
		    	}
		    	data.setItems(list);
		    }
		}
		request.setAttribute("Items", data.getItems());
		
		return "f:/carefullyChosen/carefullyChosenList.jsp";
	}
	

}
