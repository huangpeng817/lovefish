package cn.lovefish.domain;

public class FishingGear {

	private Long Id;// 编号 String
    private String FGName;// 渔具店名称 String
    private String FGType;// 类型 String
    private String FGAddress;// 位置 String
    private String Lng;// 经度 String
    private String Lat;// 纬度 String
    private String PublishTime;// 发布时间 String
    private String FGTel;// 电话 String
    private String FGService;// 服务好坏 String
    private String Distance;// 距离 String
    private String DetailUrl;// 详情页Url String
    private String Status;// 状态 String
    private String Photoes;// 图片 List`1
    private Long Praise;// 点赞数 Int32
    private Long CommentCount;// 评论数 Int32
    private String Content;// 渔具店内容介绍 String
    private Long RegionID;// 城市ID Int64
    private String Level;// 评级 Int32
    private Boolean Video;// 是否是视频 Boolean
    
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getFGName() {
		return FGName;
	}
	public void setFGName(String fGName) {
		FGName = fGName;
	}
	public String getFGType() {
		return FGType;
	}
	public void setFGType(String fGType) {
		FGType = fGType;
	}
	public String getFGAddress() {
		return FGAddress;
	}
	public void setFGAddress(String fGAddress) {
		FGAddress = fGAddress;
	}
	public String getLng() {
		return Lng;
	}
	public void setLng(String lng) {
		Lng = lng;
	}
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	public String getPublishTime() {
		return PublishTime;
	}
	public void setPublishTime(String publishTime) {
		PublishTime = publishTime;
	}
	public String getFGTel() {
		return FGTel;
	}
	public void setFGTel(String fGTel) {
		FGTel = fGTel;
	}
	public String getFGService() {
		return FGService;
	}
	public void setFGService(String fGService) {
		FGService = fGService;
	}
	public String getDistance() {
		return Distance;
	}
	public void setDistance(String distance) {
		Distance = distance;
	}
	public String getDetailUrl() {
		return DetailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		DetailUrl = detailUrl;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPhotoes() {
		return Photoes;
	}
	public void setPhotoes(String photoes) {
		Photoes = photoes;
	}
	public Long getPraise() {
		return Praise;
	}
	public void setPraise(Long praise) {
		Praise = praise;
	}
	public Long getCommentCount() {
		return CommentCount;
	}
	public void setCommentCount(Long commentCount) {
		CommentCount = commentCount;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Long getRegionID() {
		return RegionID;
	}
	public void setRegionID(Long regionID) {
		RegionID = regionID;
	}
	public String getLevel() {
		return Level;
	}
	public void setLevel(String level) {
		Level = level;
	}
	public Boolean getVideo() {
		return Video;
	}
	public void setVideo(Boolean video) {
		Video = video;
	}
    
}
