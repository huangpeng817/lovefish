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

import com.alibaba.fastjson.JSON;

import cn.itcast.servlet.BaseServlet;
import cn.lovefish.domain.CarefullyChosen;
import cn.lovefish.domain.CarefullyChosenData;
import cn.lovefish.domain.CommClassBean;
import cn.lovefish.domain.FriendCircle;
import cn.lovefish.domain.FriendCircleData;
import cn.lovefish.domain.PraiseClassBean;
import cn.lovefish.test.HttpClientUtil;
import cn.lovefish.test.HttpEntityNullException;
import cn.lovefish.test.HttpStatusErrorException;
import cn.lovefish.util.CommonMenthodUtils;
import cn.lovefish.util.Constants;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/FriendCircleServlet")
public class FriendCircleServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

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
		
		JSONObject jsonObjTemp = JSONObject.fromObject(jsonStrTemp);//将json字符串转换为json对象  
		String jsonStr = jsonObjTemp.getString("Data");
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);//将只包含Data数据的json字符串转换为json对象  
		
		FriendCircleData data = new FriendCircleData();
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
		    	
		    	List<FriendCircle> list = new ArrayList<FriendCircle>();
		    	
		    	for (int i = 0; i < jsonArray.size(); i++) {
		    		JSONObject obj = (JSONObject) jsonArray.get(i);
		    		FriendCircle fc = new FriendCircle();
		    		for (Iterator it = obj.keys(); it.hasNext();) { 
		    			String k = (String)it.next();  
		    		    if (k.equals("Id")) {
		    		    	fc.setId(obj.getString(k));
		    			}
		    		    else if (k.equals("Content")) {
		    		    	fc.setContent(obj.getString(k));
		    		    }
		    		    else if (k.equals("Photoes")) {
		    		    	String photoesTemp = obj.getString(k);
		    		    	String photoes = photoesTemp.replace("[", "");
		    		    	photoes = photoes.replace("]", "");
		    		    	photoes = photoes.replace("\"", "");
		    		    	fc.setPhotoes(photoes);
		    		    }
		    		    else if (k.equals("Publisher")) {
		    		    	fc.setPublisher(obj.getString(k));
		    		    }
		    		    else if (k.equals("PublishTime")) {
		    		    	fc.setPublishTime(obj.getString(k));
		    		    }
		    		    else if (k.equals("Lon")) {
		    		    	fc.setLon(obj.getString(k));
		    		    }
		    		    else if (k.equals("Lat")) {
		    		    	fc.setLat(obj.getString(k));
		    		    }
		    		    else if (k.equals("HXAccount")) {
		    		    	fc.setHXAccount(obj.getString(k));
		    		    }
		    		    else if (k.equals("FriendCircleID")) {
		    		    	fc.setFriendCircleID(obj.getString(k));
		    		    }
		    		    else if (k.equals("RepGUID")) {
		    		    	fc.setRepGUID(obj.getString(k));
		    		    }
		    		    else if (k.equals("NickName")) {
		    		    	fc.setNickName(obj.getString(k));
		    		    }
		    		    else if (k.equals("Rank")) {
		    		    	fc.setRank(obj.getString(k));
		    		    }
		    		    else if (k.equals("NoteName")) {
		    		    	fc.setNoteName(obj.getString(k));
		    		    }
		    		    else if (k.equals("CurrentHead")) {
		    		    	fc.setCurrentHead(obj.getString(k));
		    		    }
		    		    else if (k.equals("LocalAdd")) {
		    		    	fc.setLocalAdd(obj.getString(k));
		    		    }
		    		    else if (k.equals("PraiseCount")) {
		    		    	fc.setPraiseCount(obj.getString(k));
		    		    }
		    		    else if (k.equals("IsAlreadyPraise")) {
		    		    	fc.setIsAlreadyPraise(obj.getString(k));
		    		    }
		    		    else if (k.equals("FCDetailUrl")) {
		    		    	fc.setFCDetailUrl(obj.getString(k));
		    		    }
		    		    else if (k.equals("CommentCount")) {
		    		    	fc.setCommentCount(obj.getString(k));
		    		    }
//		    		    else if (k.equals("praiseClassList")) {
//		    		    	fc.setPraiseClassList(obj.getString(k));
//		    		    }
//		    		    else if (k.equals("commClassList")) {
//		    		    	fc.setCommentCount(obj.getString(k));
//		    		    }
		    		}
		    		list.add(fc);
		    	}
		    	data.setItems(list);
		    }
		}
		request.setAttribute("Items", data.getItems());
		
		return "f:/friendCircle/myFriendCircleList.jsp";
		
	}
	
	public String getDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
		
		String RepGUID = request.getParameter("RepGUID");
		
		String url = "http://120.24.159.207:8081/FCS/FriendCircle/GetFriendCircleDetail";
		Map<String, String> params = new HashMap<String, String>();
		params.put("GUID", RepGUID);
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
		
		JSONObject jsonObjTemp = JSONObject.fromObject(jsonStrTemp);//将json字符串转换为json对象  
		String jsonStr = jsonObjTemp.getString("Data");
		
		FriendCircle fc = JSON.parseObject(jsonStr, FriendCircle.class);
		System.out.println("转换过来的Java对象为：\n " + fc);
		int index = fc.toString().indexOf("Photo");
		String  photoesTemp = fc.getPhotoes();
		fc.setPhotoes(CommonMenthodUtils.getPhotoes(photoesTemp));
		
		request.setAttribute("fc", fc);
		
		return "f:/friendCircle/friendCircleDetail.jsp";
	}
//	public String getDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, URISyntaxException, HttpStatusErrorException, HttpEntityNullException {
//		
//		String RepGUID = request.getParameter("RepGUID");
//		
//		String url = "http://120.24.159.207:8081/FCS/FriendCircle/GetFriendCircleDetail";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("GUID", RepGUID);
//		params.put("Token", Constants.TOKEN);
//		params.put("DeviceNo", Constants.DEVICENO);
//		String jsonStrTemp = HttpClientUtil.get(url, params); // 获取到json格式的所有字符串数据
//		
//		JSONObject jsonObjTemp = JSONObject.fromObject(jsonStrTemp);//将json字符串转换为json对象  
//		String jsonStr = jsonObjTemp.getString("Data");
//		JSONObject obj = JSONObject.fromObject(jsonStr);//将只包含Data数据的json字符串转换为json对象  
//		
//		FriendCircle fc = new FriendCircle();
//		for (Iterator it = obj.keys(); it.hasNext();) { 
//			String k = (String)it.next();  
//			if (k.equals("Id")) {
//				fc.setId(obj.getString(k));
//			}
//			else if (k.equals("Content")) {
//				fc.setContent(obj.getString(k));
//			}
//			else if (k.equals("Photoes")) {
//				String photoesTemp = obj.getString(k);
//				String photoes = photoesTemp.replace("[", "");
//				photoes = photoes.replace("]", "");
//				photoes = photoes.replace("\"", "");
//				fc.setPhotoes(photoes);
//			}
//			else if (k.equals("Publisher")) {
//				fc.setPublisher(obj.getString(k));
//			}
//			else if (k.equals("PublishTime")) {
//				fc.setPublishTime(obj.getString(k));
//			}
//			else if (k.equals("Lon")) {
//				fc.setLon(obj.getString(k));
//			}
//			else if (k.equals("Lat")) {
//				fc.setLat(obj.getString(k));
//			}
//			else if (k.equals("HXAccount")) {
//				fc.setHXAccount(obj.getString(k));
//			}
//			else if (k.equals("FriendCircleID")) {
//				fc.setFriendCircleID(obj.getString(k));
//			}
//			else if (k.equals("RepGUID")) {
//				fc.setRepGUID(obj.getString(k));
//			}
//			else if (k.equals("NickName")) {
//				fc.setNickName(obj.getString(k));
//			}
//			else if (k.equals("Rank")) {
//				fc.setRank(obj.getString(k));
//			}
//			else if (k.equals("NoteName")) {
//				fc.setNoteName(obj.getString(k));
//			}
//			else if (k.equals("CurrentHead")) {
//				fc.setCurrentHead(obj.getString(k));
//			}
//			else if (k.equals("LocalAdd")) {
//				fc.setLocalAdd(obj.getString(k));
//			}
//			else if (k.equals("PraiseCount")) {
//				fc.setPraiseCount(obj.getString(k));
//			}
//			else if (k.equals("IsAlreadyPraise")) {
//				fc.setIsAlreadyPraise(obj.getString(k));
//			}
//			else if (k.equals("FCDetailUrl")) {
//				fc.setFCDetailUrl(obj.getString(k));
//			}
//			else if (k.equals("CommentCount")) {
//				fc.setCommentCount(obj.getString(k));
//			}
//			else if (k.equals("PraiseClass")) {
//				JSONArray jsonArray = obj.getJSONArray(k);
//				
//				List<PraiseClassBean> list = new ArrayList<PraiseClassBean>();
//				
//				for (int i = 0; i < jsonArray.size(); i++) {
//					JSONObject obj1 = (JSONObject) jsonArray.get(i);
//					PraiseClassBean pc = new PraiseClassBean();
//					for (Iterator i1 = obj1.keys(); i1.hasNext();) { 
//						String k1 = (String)i1.next();  
//						if (k1.equals("UserID")) {
//							pc.setUserID(obj1.getString(k1));
//						}
//						else if (k1.equals("HeadUrl")) {
//							pc.setHeadUrl(obj1.getString(k1));
//						}
//						else if (k1.equals("NickName")) {
//							pc.setNickName(obj1.getString(k1));
//						}
//						else if (k1.equals("NoteName")) {
//							pc.setNoteName(obj1.getString(k1));
//						}
//						else if (k1.equals("HXAccount")) {
//							pc.setHXAccount(obj1.getString(k1));
//						}
//						else if (k1.equals("Rank")) {
//							pc.setRank(obj1.getString(k1));
//						}
//						else if (k1.equals("PraiseTime")) {
//							pc.setPraiseTime(obj1.getString(k1));
//						}
//					}
//					list.add(pc);
//				}
//				fc.setPraiseClass(list);
//			}
//			else if (k.equals("CommClass")) {
//				JSONArray jsonArray = obj.getJSONArray(k);
//				
//				List<CommClassBean> list = new ArrayList<CommClassBean>();
//				
//				for (int i = 0; i < jsonArray.size(); i++) {
//					JSONObject obj1 = (JSONObject) jsonArray.get(i);
//					CommClassBean cc = new CommClassBean();
//					for (Iterator i1 = obj1.keys(); i1.hasNext();) { 
//						String k1 = (String)i1.next();  
//						if (k1.equals("CommId")) {
//							cc.setCommId(obj1.getString(k1));
//						}
//						else if (k1.equals("UserID")) {
//							cc.setUserID(obj1.getString(k1));
//						}
//						else if (k1.equals("HeadUrl")) {
//							cc.setHeadUrl(obj1.getString(k1));
//						}
//						else if (k1.equals("Content")) {
//							cc.setContent(obj1.getString(k1));
//						}
//						else if (k1.equals("NickName")) {
//							cc.setNickName(obj1.getString(k1));
//						}
//						else if (k1.equals("NoteName")) {
//							cc.setNoteName(obj1.getString(k1));
//						}
//						else if (k1.equals("HXAccount")) {
//							cc.setHXAccount(obj1.getString(k1));
//						}
//						else if (k1.equals("Rank")) {
//							cc.setRank(obj1.getString(k1));
//						}
//						else if (k1.equals("CommTime")) {
//							cc.setCommTime(obj1.getString(k1));
//						}
//						else if (k1.equals("BUserID")) {
//							cc.setBUserID(obj1.getString(k1));
//						}
//						else if (k1.equals("BHeadUrl")) {
//							cc.setBHeadUrl(obj1.getString(k1));
//						}
//						else if (k1.equals("BContent")) {
//							cc.setBContent(obj1.getString(k1));
//						}
//						else if (k1.equals("BNickName")) {
//							cc.setBNickName(obj1.getString(k1));
//						}
//						else if (k1.equals("BNoteName")) {
//							cc.setBNoteName(obj1.getString(k1));
//						}
//						else if (k1.equals("BHXAccount")) {
//							cc.setBHXAccount(obj1.getString(k1));
//						}
//						else if (k1.equals("BRank")) {
//							cc.setBRank(obj1.getString(k1));
//						}
//						else if (k1.equals("BCommTime")) {
//							cc.setBCommTime(obj1.getString(k1));
//						}
//					}
//					list.add(cc);
//				}
//				fc.setCommClass(list);
//			}
//		}
//		
//		request.setAttribute("fc", fc);
//		
//		return "f:/friendCircle/friendCircleDetail.jsp";
//	}

}
