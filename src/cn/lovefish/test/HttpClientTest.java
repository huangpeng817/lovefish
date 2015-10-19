package cn.lovefish.test;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpClientTest {

	public static void main(String[] args) throws URISyntaxException, IOException, HttpStatusErrorException, HttpEntityNullException {
		String url = "http://app.ifishing.com.cn:8081/CMS/News/GetFishingPointList?Count=1000&Lat=29.81513065850262&Lng=121.5629947456772&PageIndex=1&RegionID=115&Sort=2&Token=1pqfosdk9e4p6qb0433qq8bi9a&DeviceNo=DeviceNo";
		String result = HttpClientUtil.get(url);
		System.out.println(result);
	}
}