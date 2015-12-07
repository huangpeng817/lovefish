package cn.lovefish.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class CommonMenthodUtils {

	public static String getPhotoes(String photoesTemp) {
		String photoes = photoesTemp.replace("[", "");
		photoes = photoes.replace("]", "");
		photoes = photoes.replace("\"", "");
		return photoes;
	}
	
	public static int getPc(HttpServletRequest request) {
		int pc = 1;
		String pcParam = request.getParameter("pc");
		if (pcParam != null) {
			if (!pcParam.trim().isEmpty()) {
				try {
					pc = Integer.parseInt(pcParam);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return pc;
	}
	
	public static String findRegionID(String cityName) throws IOException {
		InputStreamReader isr = new InputStreamReader(CommonMenthodUtils.class.getClassLoader().getResourceAsStream("city.plist"));
		BufferedReader br = new BufferedReader(isr);
		String s = "";
		int index = 0;
		int temp = 0;
		while ((s = br.readLine()) != null) {
			index++;
			if (s.contains(cityName)) {
				break;
			}
		}
		br.close();
		
		InputStreamReader isr1 = new InputStreamReader(CommonMenthodUtils.class.getClassLoader().getResourceAsStream("city.plist"));
		BufferedReader br1 = new BufferedReader(isr1);
		
		while ((s = br1.readLine()) != null) {
			temp++;
			if (temp == index - 7) {
				String targetLine = br1.readLine().trim();
				String[] strArray = targetLine.split(">");
				int i = strArray[1].indexOf("<");
				return strArray[1].substring(0, i);
			}
		}
		br1.close();
		return "0";
	}
	
}
