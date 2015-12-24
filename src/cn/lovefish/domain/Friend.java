package cn.lovefish.domain;

public class Friend {

	private String UserId; // 好友编号 String
	private String NickName; // 用户昵称 String
	private String NoteName; // 备注 String
	private String Head; // 当前头像路径 String
	private String HXAccount; // 好友环信id String
	private String Header; // 好友名称首字母 String

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
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

	public String getHead() {
		return Head;
	}

	public void setHead(String head) {
		Head = head;
	}

	public String getHXAccount() {
		return HXAccount;
	}

	public void setHXAccount(String hXAccount) {
		HXAccount = hXAccount;
	}

	public String getHeader() {
		return Header;
	}

	public void setHeader(String header) {
		Header = header;
	}

}
