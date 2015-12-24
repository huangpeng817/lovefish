package cn.lovefish.domain;

import java.util.List;

public class FriendData {

	private String UserID; // 用户编号 String
	private String Count; // 数量 String
	private List<Friend> Friends; // 好友列表 List`1
	private List<Friend> Items; // 好友列表2 List`1

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getCount() {
		return Count;
	}

	public void setCount(String count) {
		Count = count;
	}

	public List<Friend> getFriends() {
		return Friends;
	}

	public void setFriends(List<Friend> friends) {
		Friends = friends;
	}

	public List<Friend> getItems() {
		return Items;
	}

	public void setItems(List<Friend> items) {
		Items = items;
	}

}
