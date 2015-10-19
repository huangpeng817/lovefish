package cn.lovefish.domain;

public class Comment {

	private String Id;
	private String Content;
	private String Publisher;
	private String PublishTime;
	private String UnionID;
	private String Category;
	private String NickName;
	private String CurrentHead;
	private String HXAccount;
	
	public Comment() {
		super();
	}

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

	public String getUnionID() {
		return UnionID;
	}

	public void setUnionID(String unionID) {
		UnionID = unionID;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public String getCurrentHead() {
		return CurrentHead;
	}

	public void setCurrentHead(String currentHead) {
		CurrentHead = currentHead;
	}

	public String getHXAccount() {
		return HXAccount;
	}

	public void setHXAccount(String hXAccount) {
		HXAccount = hXAccount;
	}
	
}
