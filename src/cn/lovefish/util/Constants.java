package cn.lovefish.util;

public class Constants {

	// 值为10时候，最后一页48页，可点击下一页，但是报错，目前数据库480条数据截至20151022
	// 应该总数据条数能被下面的常量整除就会报错，能被48整除，同样报错
	public static final String FISHINGPOINT_PAGE_COUNT = "9";
	public static final String CAREFULLYCHOSEN_PAGE_COUNT = "10";
	// 第一页返回的数据条数为Count+1,当前截至20151022数据大概242条，最后一页同样可以下一页，但是为空页面
	public static final String FRIENDCIRCLE_PAGE_COUNT = "9";
	public static final String FRIEND_PAGE_COUNT = "10";
	public static final String COMMENT_PAGE_COUNT = "4";
//	public static final String TOKEN = "4eifmam42ii12a21rv2tvhpsob"; // 刘手机 已经失效
//	public static final String TOKEN = "1pqfosdk9e4p6qb0433qq8bi9a"; // 爱渔小二
	// 刘手机(2015/12/24登录发现产生了变化)
//	public static final String TOKEN = "5oiav5smkpv53qpe1ji540e79v";
	// 刘手机(2015/12/30登录发现又产生了变化，但是和之前的Token一样维持所有信息不变，比如好友数量等等)
	public static final String TOKEN = "53fgvbi7qnqt696egaaopr6dco";
	public static final String DEVICENO = "DeviceNo";
	public static final String 	LOGIN_LASTLOGINTYPE = "2";
	
}
