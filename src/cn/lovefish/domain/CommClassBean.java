package cn.lovefish.domain;

public class CommClassBean {
	
	private String CommId; // 评论id String
    private String UserID; // 用户编号 String
    private String HeadUrl; // 头像URL String
    private String Content; // 内容 String
    private String NickName; // 昵称 String
    private String NoteName; // 备注名 String
    private String HXAccount; // 环信账号 String
    private String Rank; // 用户等级 String
    private String CommTime; // 评论时间 String
    private String BUserID; // 用户编号 String
    private String BHeadUrl; // 头像URL String
    private String BContent; // 内容 String
    private String BNickName; // 昵称 String
    private String BNoteName; // 备注名 String
    private String BHXAccount; // 环信账号 String
    private String BRank; // 用户等级 String
    private String BCommTime; // 评论时间 String
    
	public String getCommId() {
		return CommId;
	}
	public void setCommId(String commId) {
		CommId = commId;
	}
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
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
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
	public String getCommTime() {
		return CommTime;
	}
	public void setCommTime(String commTime) {
		CommTime = commTime;
	}
	public String getBUserID() {
		return BUserID;
	}
	public void setBUserID(String bUserID) {
		BUserID = bUserID;
	}
	public String getBHeadUrl() {
		return BHeadUrl;
	}
	public void setBHeadUrl(String bHeadUrl) {
		BHeadUrl = bHeadUrl;
	}
	public String getBContent() {
		return BContent;
	}
	public void setBContent(String bContent) {
		BContent = bContent;
	}
	public String getBNickName() {
		return BNickName;
	}
	public void setBNickName(String bNickName) {
		BNickName = bNickName;
	}
	public String getBNoteName() {
		return BNoteName;
	}
	public void setBNoteName(String bNoteName) {
		BNoteName = bNoteName;
	}
	public String getBHXAccount() {
		return BHXAccount;
	}
	public void setBHXAccount(String bHXAccount) {
		BHXAccount = bHXAccount;
	}
	public String getBRank() {
		return BRank;
	}
	public void setBRank(String bRank) {
		BRank = bRank;
	}
	public String getBCommTime() {
		return BCommTime;
	}
	public void setBCommTime(String bCommTime) {
		BCommTime = bCommTime;
	}
	@Override
	public String toString() {
		return "CommClassBean [CommId=" + CommId + ", UserID=" + UserID + ", HeadUrl=" + HeadUrl + ", Content="
				+ Content + ", NickName=" + NickName + ", NoteName=" + NoteName + ", HXAccount=" + HXAccount + ", Rank="
				+ Rank + ", CommTime=" + CommTime + ", BUserID=" + BUserID + ", BHeadUrl=" + BHeadUrl + ", BContent="
				+ BContent + ", BNickName=" + BNickName + ", BNoteName=" + BNoteName + ", BHXAccount=" + BHXAccount
				+ ", BRank=" + BRank + ", BCommTime=" + BCommTime + "]";
	}
	
}
