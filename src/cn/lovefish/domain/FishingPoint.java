package cn.lovefish.domain;

public class FishingPoint {
	private Long Id;
	private String Name;
	private String Content;
	private String LocalAdd;
	private String Lng;
	private String Lat;
	private String PublishTime;
	private Long PraiseCount;
	private String Level;
	private Long CommentCount;
	private String Distance;
	private String DetailUrl;
	private String PointType; 
	private String CashType;
	private String FishType;
	private String LinkName; 
	private String LinkNum; 
	private String Photoes;
	private boolean Video;
	
	public FishingPoint() {
		super();
	}
	
	// ----
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLocalAdd() {
		return LocalAdd;
	}
	public void setLocalAdd(String localAdd) {
		LocalAdd = localAdd;
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
	public Long getPraiseCount() {
		return PraiseCount;
	}
	public void setPraiseCount(Long praiseCount) {
		PraiseCount = praiseCount;
	}
	public Long getCommentCount() {
		return CommentCount;
	}
	public void setCommentCount(Long commentCount) {
		CommentCount = commentCount;
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
	public boolean isVideo() {
		return Video;
	}
	public void setVideo(boolean video) {
		Video = video;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		Level = level;
	}

	public String getPointType() {
		return PointType;
	}

	public void setPointType(String pointType) {
		PointType = pointType;
	}

	public String getCashType() {
		return CashType;
	}

	public void setCashType(String cashType) {
		CashType = cashType;
	}

	public String getFishType() {
		return FishType;
	}

	public void setFishType(String fishType) {
		FishType = fishType;
	}

	public String getLinkName() {
		return LinkName;
	}

	public void setLinkName(String linkName) {
		LinkName = linkName;
	}

	public String getLinkNum() {
		return LinkNum;
	}

	public void setLinkNum(String linkNum) {
		LinkNum = linkNum;
	}

	public String getPhotoes() {
		return Photoes;
	}

	public void setPhotoes(String photoes) {
		Photoes = photoes;
	}

}
