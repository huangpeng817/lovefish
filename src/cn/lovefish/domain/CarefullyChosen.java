package cn.lovefish.domain;

public class CarefullyChosen {

	private String Id; // 资讯编号 String
    private String Category; // 资讯类型(全部 = 1; 爱渔资讯 = 2;活动信息 = 3; 钓点信息 = 4;钓友圈信息 = 5) String
    private String Title; // 资讯标题 String
    private String Content; // 资讯内容 String
    // 返回的json数据中字段叫NewsSource有一个s，但是这个是API粘贴过来的，属于失误，值得注意
    private String NewSource; // 来源 String
    private String SourceUrl; // 原文链接 String
    private String Publisher; // 发布人编号 String
    private String NickName; // 发布人名称 String
    private String PublishTime; // 发布时时间 String
    private String ImgURL; // 资讯图片 List`1
    private String ImgDetail; // 图片详情（Width;Height 数组下标对应资讯图片） List`1
    private String PraiseCount; // 点赞数 String
    private String CommentCount; // 评价数 String
    private String DetailUrl; // 详情URL String
    private String CategoryTop; // 1的话返回爱渔百科，2的话返回爱渔动态 String
    private Boolean Video; // 是否是视频 Boolean
    
    public CarefullyChosen() {
    	super();
    }
    
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getNewSource() {
		return NewSource;
	}
	public void setNewSource(String newSource) {
		NewSource = newSource;
	}
	public String getSourceUrl() {
		return SourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		SourceUrl = sourceUrl;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getPublishTime() {
		return PublishTime;
	}
	public void setPublishTime(String publishTime) {
		PublishTime = publishTime;
	}
	public String getImgURL() {
		return ImgURL;
	}
	public void setImgURL(String imgURL) {
		ImgURL = imgURL;
	}
	public String getImgDetail() {
		return ImgDetail;
	}
	public void setImgDetail(String imgDetail) {
		ImgDetail = imgDetail;
	}
	public String getPraiseCount() {
		return PraiseCount;
	}
	public void setPraiseCount(String praiseCount) {
		PraiseCount = praiseCount;
	}
	public String getCommentCount() {
		return CommentCount;
	}
	public void setCommentCount(String commentCount) {
		CommentCount = commentCount;
	}
	public String getDetailUrl() {
		return DetailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		DetailUrl = detailUrl;
	}
	public String getCategoryTop() {
		if (CategoryTop.equals("1")) {
			Category = "爱渔百科";
		} else if (CategoryTop.equals("2")) {
			Category = "爱渔动态";
		}
		return CategoryTop;
	}
	public void setCategoryTop(String categoryTop) {
		CategoryTop = categoryTop;
	}
	public Boolean getVideo() {
		return Video;
	}
	public void setVideo(Boolean video) {
		Video = video;
	}

}
