package cn.lovefish.domain;

public class PraiseClassBean {

	private String UserID; // 用户编号 String
    private String HeadUrl; // 头像URL String
    private String NickName; // 昵称 String
    private String NoteName; // 备注名 String
    private String HXAccount; // 环信账号 String
    private String Rank; // 用户等级 String
    private String PraiseTime; // 点赞时间 String
    
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getHeadUrl() {
		return HeadUrl;
	}
	public void setHeadUrl(String headUrl) {
		HeadUrl = headUrl;
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
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getPraiseTime() {
		return PraiseTime;
	}
	public void setPraiseTime(String praiseTime) {
		PraiseTime = praiseTime;
	}
	@Override
	public String toString() {
		return "PraiseClassBean [UserID=" + UserID + ", HeadUrl=" + HeadUrl + ", NickName=" + NickName + ", NoteName="
				+ NoteName + ", HXAccount=" + HXAccount + ", Rank=" + Rank + ", PraiseTime=" + PraiseTime + "]";
	}
	
}
