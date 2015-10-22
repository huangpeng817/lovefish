package cn.lovefish.util;

public class Constants {

	// 值为10时候，最后一页48页，可点击下一页，但是报错，目前数据库480条数据截至20151022
	// 应该总数据条数能被下面的常量整除就会报错，能被48整除，同样报错
	public static final String FISHINGPOINT_PAGE_COUNT = "9";
	public static final String CAREFULLYCHOSEN_PAGE_COUNT = "10";
	// 第一页返回的数据条数为Count+1,当前截至20151022数据大概242条，最后一页同样可以下一页，但是为空页面
	public static final String FRIENDCIRCLE_PAGE_COUNT = "9";
	public static final String COMMENT_PAGE_COUNT = "4";
	public static final String TOKEN = "4eifmam42ii12a21rv2tvhpsob"; // 刘手机
//	public static final String TOKEN = "1pqfosdk9e4p6qb0433qq8bi9a"; // 爱渔小二
	public static final String DEVICENO = "DeviceNo";
	public static final String 	LOGIN_LASTLOGINTYPE = "2";
	
}
