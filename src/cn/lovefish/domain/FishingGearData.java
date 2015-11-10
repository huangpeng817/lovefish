package cn.lovefish.domain;

import java.util.List;

public class FishingGearData {

	private Long Count;
	private Boolean HasElse;
	private Long PageIndex;
	private List<FishingGear> Items;
	
	public Long getCount() {
		return Count;
	}
	public void setCount(Long count) {
		Count = count;
	}
	public Boolean getHasElse() {
		return HasElse;
	}
	public void setHasElse(Boolean hasElse) {
		HasElse = hasElse;
	}
	public Long getPageIndex() {
		return PageIndex;
	}
	public void setPageIndex(Long pageIndex) {
		PageIndex = pageIndex;
	}
	public List<FishingGear> getItems() {
		return Items;
	}
	public void setItems(List<FishingGear> items) {
		Items = items;
	}
	
}
