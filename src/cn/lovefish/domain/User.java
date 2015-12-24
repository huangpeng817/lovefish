package cn.lovefish.domain;

public class User {

	private String UserId;// 用户id String
    private String UserName;// 用户名 String
    private String NickName;// 昵称 String
    private String NoteName;// 备注名 String
    private String HXAccount;// 环信id String
    private Boolean IsFriend;// 是否为好友 Boolean
    private int Gender;// 性别 （男-1 女-2 未设置（保密）-0） Int32
    private String Region;// 地区 String
    private int RegionId;// 地区Id Int64
    private String MobilePhone;// 手机号 String
    private String Rank;// 等级 String
    private String Head;// 头像路径 String
    private String WallPaper;// 墙纸路径 String
    private String Dinstince;// 距离 String
    private String Signature;// 个性签名 String
    private String UserEmail;// 用户邮箱 String
    private int UserEmailVer;// 用户邮箱是否验证 Int32
    private int Score;// 积分 Int32
    private int Experience;// 积分 Int32
    private int FriendCircles;// 钓友圈数量 Int64
    private int Friends;// 好友数 Int64
    
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getNoteName() {
		return NoteName;
	}
	public void setNoteName(String noteName) {
		NoteName = noteName;
	}
	public String getHXAccount() {
		return HXAccount;
	}
	public void setHXAccount(String hXAccount) {
		HXAccount = hXAccount;
	}
	public Boolean getIsFriend() {
		return IsFriend;
	}
	public void setIsFriend(Boolean isFriend) {
		IsFriend = isFriend;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public int getRegionId() {
		return RegionId;
	}
	public void setRegionId(int regionId) {
		RegionId = regionId;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getHead() {
		return Head;
	}
	public void setHead(String head) {
		Head = head;
	}
	public String getWallPaper() {
		return WallPaper;
	}
	public void setWallPaper(String wallPaper) {
		WallPaper = wallPaper;
	}
	public String getDinstince() {
		return Dinstince;
	}
	public void setDinstince(String dinstince) {
		Dinstince = dinstince;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public int getUserEmailVer() {
		return UserEmailVer;
	}
	public void setUserEmailVer(int userEmailVer) {
		UserEmailVer = userEmailVer;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public int getExperience() {
		return Experience;
	}
	public void setExperience(int experience) {
		Experience = experience;
	}
	public int getFriendCircles() {
		return FriendCircles;
	}
	public void setFriendCircles(int friendCircles) {
		FriendCircles = friendCircles;
	}
	public int getFriends() {
		return Friends;
	}
	public void setFriends(int friends) {
		Friends = friends;
	}
	
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", NickName=" + NickName + ", NoteName=" + NoteName + ", HXAccount=" + HXAccount + ", IsFriend=" + IsFriend + ", Gender=" + Gender + ", Region=" + Region + ", RegionId="
				+ RegionId + ", MobilePhone=" + MobilePhone + ", Rank=" + Rank + ", Head=" + Head + ", WallPaper=" + WallPaper + ", Dinstince=" + Dinstince + ", Signature=" + Signature + ", UserEmail=" + UserEmail + ", UserEmailVer="
				+ UserEmailVer + ", Score=" + Score + ", Experience=" + Experience + ", FriendCircles=" + FriendCircles + ", Friends=" + Friends + "]";
	}
    
}
