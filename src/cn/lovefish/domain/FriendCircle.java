package cn.lovefish.domain;

import java.util.List;

public class FriendCircle {

	private String Id; // 朋友圈信息编号 String
    private String Content; // 内容 String
    private String Photoes; // 图片 List`1
    private String Publisher; // 发布人ID String
    private String PublishTime; // 发布时间 String
    private String Lon; // 经度 String
    private String Lat; // 纬度 String
    private String HXAccount; // 环信id String
    private String FriendCircleID; // 朋友圈信息编号 String
    private String RepGUID; // 朋友圈信息编号 String
    private String NickName; // 发布人昵称 String
    private String Rank; // 用户级别 String
    private String NoteName; // 发布人备注名 String
    private String CurrentHead; // 当前头像Url String
    private String LocalAdd; // 地址 String
    private String PraiseCount; // 点赞数 String
    private String IsAlreadyPraise; // 当前用户是否已经点赞 String
    private String FCDetailUrl; // 朋友圈详情Url String
    private String CommentCount; // 评论数 String
    private List<PraiseClassBean> PraiseClass; //点赞明细 List`1
    private List<CommClassBean> CommClass; // 评论明细 List`1
    
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getPhotoes() {
		return Photoes;
	}
	public void setPhotoes(String photoes) {
		Photoes = photoes;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublishTime() {
		return PublishTime;
	}
	public void setPublishTime(String publishTime) {
		PublishTime = publishTime;
	}
	public String getLon() {
		return Lon;
	}
	public void setLon(String lon) {
		Lon = lon;
	}
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	public String getHXAccount() {
		return HXAccount;
	}
	public void setHXAccount(String hXAccount) {
		HXAccount = hXAccount;
	}
	public String getFriendCircleID() {
		return FriendCircleID;
	}
	public void setFriendCircleID(String friendCircleID) {
		FriendCircleID = friendCircleID;
	}
	public String getRepGUID() {
		return RepGUID;
	}
	public void setRepGUID(String repGUID) {
		RepGUID = repGUID;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getNoteName() {
		return NoteName;
	}
	public void setNoteName(String noteName) {
		NoteName = noteName;
	}
	public String getCurrentHead() {
		return CurrentHead;
	}
	public void setCurrentHead(String currentHead) {
		CurrentHead = currentHead;
	}
	public String getLocalAdd() {
		return LocalAdd;
	}
	public void setLocalAdd(String localAdd) {
		LocalAdd = localAdd;
	}
	public String getPraiseCount() {
		return PraiseCount;
	}
	public void setPraiseCount(String praiseCount) {
		PraiseCount = praiseCount;
	}
	public String getIsAlreadyPraise() {
		return IsAlreadyPraise;
	}
	public void setIsAlreadyPraise(String isAlreadyPraise) {
		IsAlreadyPraise = isAlreadyPraise;
	}
	public String getFCDetailUrl() {
		return FCDetailUrl;
	}
	public void setFCDetailUrl(String fCDetailUrl) {
		FCDetailUrl = fCDetailUrl;
	}
	public String getCommentCount() {
		return CommentCount;
	}
	public void setCommentCount(String commentCount) {
		CommentCount = commentCount;
	}
	public List<CommClassBean> getCommClass() {
		return CommClass;
	}
	public void setCommClass(List<CommClassBean> commClass) {
		CommClass = commClass;
	}
	public List<PraiseClassBean> getPraiseClass() {
		return PraiseClass;
	}
	public void setPraiseClass(List<PraiseClassBean> praiseClass) {
		PraiseClass = praiseClass;
	}
	@Override
	public String toString() {
		return "FriendCircle [Id=" + Id + ", Content=" + Content + ", Photoes=" + Photoes + ", Publisher=" + Publisher
				+ ", PublishTime=" + PublishTime + ", Lon=" + Lon + ", Lat=" + Lat + ", HXAccount=" + HXAccount
				+ ", FriendCircleID=" + FriendCircleID + ", RepGUID=" + RepGUID + ", NickName=" + NickName + ", Rank="
				+ Rank + ", NoteName=" + NoteName + ", CurrentHead=" + CurrentHead + ", LocalAdd=" + LocalAdd
				+ ", PraiseCount=" + PraiseCount + ", IsAlreadyPraise=" + IsAlreadyPraise + ", FCDetailUrl="
				+ FCDetailUrl + ", CommentCount=" + CommentCount + ", PraiseClass=" + PraiseClass + ", CommClass="
				+ CommClass + "]";
	}
	
}
