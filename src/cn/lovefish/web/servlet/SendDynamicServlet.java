package cn.lovefish.web.servlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.lovefish.util.Constants;
import cn.lovefish.util.HttpClientUtil;
import cn.lovefish.util.HttpEntityNullException;
import cn.lovefish.util.HttpStatusErrorException;

@WebServlet("/SendDynamicServlet")
public class SendDynamicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		String localAdd = "";
		String IsAdv = "";
		String content = "";
		String lat = "";
		String lon = "";
		
		String photo = "";
		
//		System.out.println("localAdd: " + localAdd);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> list = sfu.parseRequest(request); //Lat Lng photo localAdd IsAdv content
			for (FileItem fi : list) {
				String fieldName = fi.getFieldName();
//				System.out.println(fi.getFieldName());
				if (fieldName.equals("Lat")) {
					lat = fi.getString("UTF-8");
				} else if (fieldName.equals("Lng")) {
					lon = fi.getString("UTF-8");
				} else if (fieldName.equals("localAdd")) {
					localAdd = fi.getString("UTF-8");
				} else if (fieldName.equals("IsAdv")) {
					IsAdv = fi.getString("UTF-8");
				} else if (fieldName.equals("content")) {
					content = fi.getString("UTF-8");
				} else if (fieldName.equals("photo")) {
					photo = fi.getString("UTF-8");
				}
			}
			System.out.println(lat + " -- " + lon + " -- " + localAdd + " -- " + IsAdv + " -- " + content);
		} catch (FileUploadException e) {
			throw new RuntimeException(e);
		}
		
		String url = "http://120.24.159.207:8081/FCS/FriendCircle/SendFriendCircle";
		Map<String, String> params = new HashMap<String, String>();
		params.put("content", content); 
		params.put("localAdd", localAdd); 
		params.put("lon", lon); 
		params.put("lat", lat); 
		params.put("IsAdv", IsAdv); 
		params.put("photo", photo); 
		params.put("Token", Constants.TOKEN);
		params.put("DeviceNo", Constants.DEVICENO);
		
		try {
			HttpClientUtil.get(url, params);
		} catch (URISyntaxException | HttpStatusErrorException | HttpEntityNullException e) {
			throw new RuntimeException(e);
		}
		
//		return getFriendCircleList(request, response);
	}

}
