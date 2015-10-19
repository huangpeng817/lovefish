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
import cn.lovefish.domain.FishingPoint;
import cn.lovefish.domain.FishingPointData;
import cn.lovefish.test.HttpClientUtil;
import cn.lovefish.test.HttpEntityNullException;
import cn.lovefish.test.HttpStatusErrorException;
import cn.lovefish.util.CommonMenthodUtils;
import cn.lovefish.util.Constants;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/TestServlet")
public class TestServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;

	public String getDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String Id = request.getParameter("Id");
		
		String url = "http://120.24.159.207:8081/CMS/News/FishingPointDetail";
		Map<String, String> params = new HashMap<String, String>();
		params.put("Id", Id);
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
//		System.out.println("最初得到的json字符串为： " + jsonStrTemp);
		
		JSONObject jsonObjTemp = JSONObject.fromObject(jsonStrTemp);//将json字符串转换为json对象  
		String jsonStr = jsonObjTemp.getString("Data");
		JSONObject obj = JSONObject.fromObject(jsonStr);//将只包含Data数据的json字符串转换为json对象  
//		System.out.println("该钓点的Data数据  <------>:  " + jsonStr);
		String jsonStr1 = jsonStr.replace(" ", "");
//		System.out.println("去掉空格Data数据  <------>:  " + jsonStr1);
		
		FishingPoint fp = new FishingPoint();
		for (Iterator it = obj.keys(); it.hasNext();) { 
			String k = (String)it.next();  
		    if (k.equals("Id")) {
		    	fp.setId(Long.parseLong(obj.getString(k)));
			}
		    else if (k.equals("Name")) {
		    	fp.setName(obj.getString(k));
		    }
		    else if (k.equals("Content")) {
		    	fp.setContent(obj.getString(k));
		    }
		    else if (k.equals("LocalAdd")) {
		    	fp.setLocalAdd(obj.getString(k));
		    }
		    else if (k.equals("Lng")) {
		    	fp.setLng(obj.getString(k));
		    }
		    else if (k.equals("Lat")) {
		    	fp.setLat(obj.getString(k));
		    }
		    else if (k.equals("PublishTime")) {
		    	fp.setPublishTime(obj.getString(k));
		    }
		    else if (k.equals("PraiseCount")) {
		    	fp.setPraiseCount(Long.parseLong(obj.getString(k)));
		    }
		    else if (k.equals("Level")) {
		    	fp.setLevel(obj.getString(k));
		    }
		    else if (k.equals("CommentCount")) {
		    	fp.setCommentCount(Long.parseLong(obj.getString(k)));
		    }
		    else if (k.equals("Distance")) {
		    	fp.setDistance(obj.getString(k));
		    }
		    else if (k.equals("DetailUrl")) {
		    	fp.setDetailUrl(obj.getString(k));
		    }
		    else if (k.equals("PointType")) {
		    	fp.setPointType(obj.getString(k));
		    }
		    else if (k.equals("CashType")) {
		    	fp.setCashType(obj.getString(k));
		    }
		    else if (k.equals("FishType")) {
		    	fp.setFishType(obj.getString(k));
		    }
		    else if (k.equals("LinkName")) {
		    	fp.setLinkName(obj.getString(k));
		    }
		    else if (k.equals("LinkNum")) {
		    	fp.setLinkNum(obj.getString(k));
		    }
		    else if (k.equals("Photoes")) {
		    	String photoesTemp = obj.getString(k);
//		    	System.out.println("photoesTemp: " + photoesTemp);
		    	String photoes = photoesTemp.replace("[", "");
		    	photoes = photoes.replace("]", "");
		    	photoes = photoes.replace("\"", "");
//		    	System.out.println("去掉修饰的纯图片字符串为： " + photoes);
		    	fp.setPhotoes(photoes);
		    }
		    else if (k.equals("Video")) {
		    	fp.setVideo(Boolean.parseBoolean(obj.getString(k)));
		    }
		}
		
		request.setAttribute("fp", fp);
//		request.setAttribute("Id", Id);
		
		return "f:/test/fishingPointDetail.jsp";
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
//		System.out.println(jsonStrTemp);
		
		JSONObject jsonObjTemp = JSONObject.fromObject(jsonStrTemp);//将json字符串转换为json对象  
		String jsonStr = jsonObjTemp.getString("Data");
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);//将只包含Data数据的json字符串转换为json对象  
//		System.out.println("Data的部分数据  <------>:  " + jsonStr.substring(0, 1000));
		
		FishingPointData data = new FishingPointData();
		for (Iterator iter = jsonObj.keys(); iter.hasNext();) {
		    String key = (String)iter.next();  
		    if (key.equals("Count")) {
		    	data.setCount(Long.parseLong(jsonObj.getString(key)));
			}
		    else if (key.equals("HasElse")) {
		    	data.setHasElse(Boolean.parseBoolean(jsonObj.getString(key)));
//		    	System.out.println("HasElse?  " + Boolean.parseBoolean(jsonObj.getString(key)));
		    	request.setAttribute("HasElse", Boolean.parseBoolean(jsonObj.getString(key)));
		    }
		    else if (key.equals("PageIndex")) {
		    	data.setPageIndex(Long.parseLong(jsonObj.getString(key)));
		    }
		    else if (key.equals("Items")) {
		    	JSONArray jsonArray = jsonObj.getJSONArray(key);
		    	
		    	List<FishingPoint> list = new ArrayList<FishingPoint>();
		    	
		    	for (int i = 0; i < jsonArray.size(); i++) {
		    		JSONObject obj = (JSONObject) jsonArray.get(i);
		    		FishingPoint fp = new FishingPoint();
		    		for (Iterator it = obj.keys(); it.hasNext();) { 
		    			String k = (String)it.next();  
		    		    if (k.equals("Id")) {
		    		    	fp.setId(Long.parseLong(obj.getString(k)));
		    			}
		    		    else if (k.equals("Name")) {
		    		    	fp.setName(obj.getString(k));
		    		    }
		    		    else if (k.equals("Content")) {
		    		    	fp.setContent(obj.getString(k));
		    		    }
		    		    else if (k.equals("LocalAdd")) {
		    		    	fp.setLocalAdd(obj.getString(k));
		    		    }
		    		    else if (k.equals("Lng")) {
		    		    	fp.setLng(obj.getString(k));
		    		    }
		    		    else if (k.equals("Lat")) {
		    		    	fp.setLat(obj.getString(k));
		    		    }
		    		    else if (k.equals("PublishTime")) {
		    		    	fp.setPublishTime(obj.getString(k));
		    		    }
		    		    else if (k.equals("PraiseCount")) {
		    		    	fp.setPraiseCount(Long.parseLong(obj.getString(k)));
		    		    }
		    		    else if (k.equals("Level")) {
		    		    	fp.setLevel(obj.getString(k));
		    		    }
		    		    else if (k.equals("CommentCount")) {
		    		    	fp.setCommentCount(Long.parseLong(obj.getString(k)));
		    		    }
		    		    else if (k.equals("Distance")) {
		    		    	fp.setDistance(obj.getString(k));
		    		    }
		    		    else if (k.equals("DetailUrl")) {
		    		    	fp.setDetailUrl(obj.getString(k));
		    		    }
		    		    else if (k.equals("PointType")) {
		    		    	fp.setPointType(obj.getString(k));
		    		    }
		    		    else if (k.equals("CashType")) {
		    		    	fp.setCashType(obj.getString(k));
		    		    }
		    		    else if (k.equals("FishType")) {
		    		    	fp.setFishType(obj.getString(k));
		    		    }
		    		    else if (k.equals("LinkName")) {
		    		    	fp.setLinkName(obj.getString(k));
		    		    }
		    		    else if (k.equals("LinkNum")) {
		    		    	fp.setLinkNum(obj.getString(k));
		    		    }
		    		    else if (k.equals("Photoes")) {
		    		    	String photoesTemp = obj.getString(k);
//		    		    	if (photoesTemp.equals("[\"\"]")) {
//								photoesTemp = "[\"123456.jpg\", \"abcdef.jpg\"]";
//							}
//		    		    	System.out.println("photoesTemp: " + photoesTemp);
		    		    	String photoes = photoesTemp.replace("[", "");
		    		    	photoes = photoes.replace("]", "");
		    		    	photoes = photoes.replace("\"", "");
//		    		    	System.out.println("去掉修饰的纯图片字符串为： " + photoes);
		    		    	fp.setPhotoes(photoes);
		    		    }
//		    		    else if (k.equals("Photoes")) {
////		    		    	String[] photoes = obj.getString(k).split(",");
//		    		    	fp.setPhotoes(obj.getString(k).substring(2, obj.getString(k).length() - 2));
////		    		    	System.out.println("photoes: " + photoes[0]);
//		    		    	System.out.println("obj.getString(k).substring(2, obj.getString(k).length() - 2): " + obj.getString(k).substring(2, obj.getString(k).length() - 2));
//		    		    	System.out.println("fp.getPhotoes(): " + fp.getPhotoes());
//		    		    }
		    		    
		    		    
		    		    else if (k.equals("Video")) {
		    		    	fp.setVideo(Boolean.parseBoolean(obj.getString(k)));
		    		    }
		    		}
		    		list.add(fp);
		    	}
		    	data.setItems(list);
		    }
		}
		request.setAttribute("Items", data.getItems());
//		List<FishingPoint> fpList = data.getItems();
		
		return "f:/test/test.jsp";
		
	}
	
	
	/**
	 * 接收前端通过ajax参数的形式传递json数据并处理
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonStr = request.getParameter("jsonStr");
		System.out.println("form表单提交传递的jsonStr：\t" + jsonStr);
		
		
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);//将json字符串转换为json对象  
		FishingPointData data = new FishingPointData();
		for (Iterator iter = jsonObj.keys(); iter.hasNext();) { 
			String key = (String)iter.next();  
			if (key.equals("Count")) {
				data.setCount(Long.parseLong(jsonObj.getString(key)));
			}
			else if (key.equals("HasElse")) {
				data.setHasElse(Boolean.parseBoolean(jsonObj.getString(key)));
			}
			else if (key.equals("PageIndex")) {
				data.setPageIndex(Long.parseLong(jsonObj.getString(key)));
			}
			else if (key.equals("Items")) {
				JSONArray jsonArray = jsonObj.getJSONArray(key);
				
				List<FishingPoint> list = new ArrayList<FishingPoint>();
				
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject obj = (JSONObject) jsonArray.get(i);
					FishingPoint fp = new FishingPoint();
					for (Iterator it = obj.keys(); it.hasNext();) { 
						String k = (String)it.next();  
						if (k.equals("Id")) {
							fp.setId(Long.parseLong(obj.getString(k)));
						}
						else if (k.equals("Name")) {
							fp.setName(obj.getString(k));
						}
						else if (k.equals("Content")) {
							fp.setContent(obj.getString(k));
						}
						else if (k.equals("LocalAdd")) {
							fp.setLocalAdd(obj.getString(k));
						}
						else if (k.equals("Lng")) {
							fp.setLng(obj.getString(k));
						}
						else if (k.equals("Lat")) {
							fp.setLat(obj.getString(k));
						}
						else if (k.equals("PublishTime")) {
							fp.setPublishTime(obj.getString(k));
						}
						else if (k.equals("PraiseCount")) {
							fp.setPraiseCount(Long.parseLong(obj.getString(k)));
						}
						else if (k.equals("Level")) {
							fp.setLevel(obj.getString(k));
						}
						else if (k.equals("CommentCount")) {
							fp.setCommentCount(Long.parseLong(obj.getString(k)));
						}
						else if (k.equals("Distance")) {
							fp.setDistance(obj.getString(k));
						}
						else if (k.equals("DetailUrl")) {
							fp.setDetailUrl(obj.getString(k));
						}
						else if (k.equals("PointType")) {
							fp.setPointType(obj.getString(k));
						}
						else if (k.equals("CashType")) {
							fp.setCashType(obj.getString(k));
						}
						else if (k.equals("FishType")) {
							fp.setFishType(obj.getString(k));
						}
						else if (k.equals("LinkName")) {
							fp.setLinkName(obj.getString(k));
						}
						else if (k.equals("LinkNum")) {
							fp.setLinkNum(obj.getString(k));
						}
						else if (k.equals("Photoes")) {
							String[] photoes = obj.getString(k).split(",");
//							fp.setPhotoes(photoes);
						}
						else if (k.equals("Video")) {
							fp.setVideo(Boolean.parseBoolean(obj.getString(k)));
						}
					}
					list.add(fp);
				}
				data.setItems(list);
			}
		}
//		System.out.println(data);
//		System.out.println(data.getItems().get(3).getCommentCount());
//		System.out.println(data.getItems().get(0).getPhotoes()[0]);
		System.out.println(data.getItems().get(4));
		
		request.setAttribute("data", data);
//		request.setAttribute("Items", data.getItems());
		
		return "f:/testGetFishingPointList.jsp";
		
		
		
//		String username="zhangSan";
//		request.setAttribute("username", username);
//		return "f:/test/test.jsp";
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
