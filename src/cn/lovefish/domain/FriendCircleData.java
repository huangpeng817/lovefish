package cn.lovefish.domain;

import java.util.List;

public class FriendCircleData {

	private String Count;
	private Boolean HasElse;
	private String PageIndex;
	private List<FriendCircle> Items;
	
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	public Boolean getHasElse() {
		return HasElse;
	}
	public void setHasElse(Boolean hasElse) {
		HasElse = hasElse;
	}
	public String getPageIndex() {
		return PageIndex;
	}
	public void setPageIndex(String pageIndex) {
		PageIndex = pageIndex;
	}
	public List<FriendCircle> getItems() {
		return Items;
	}
	public void setItems(List<FriendCircle> items) {
		Items = items;
	}
	
}
