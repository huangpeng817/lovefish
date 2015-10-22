package cn.lovefish.domain;

import java.util.List;

public class FishingPointData {
	private Long Count;
	private Boolean HasElse;
	private Long PageIndex;
	private List<FishingPoint> Items;
	
	public FishingPointData() {
		super();
	}
	
	// ----
	public Long getCount() {
		return Count;
	}
	public void setCount(Long count) {
		Count = count;
	}
	public Long getPageIndex() {
		return PageIndex;
	}
	public void setPageIndex(Long pageIndex) {
		PageIndex = pageIndex;
	}
	public List<FishingPoint> getItems() {
		return Items;
	}
	public void setItems(List<FishingPoint> items) {
		this.Items = items;
	}

	public Boolean getHasElse() {
		return HasElse;
	}

	public void setHasElse(Boolean hasElse) {
		HasElse = hasElse;
	}

}
