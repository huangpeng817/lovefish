package cn.lovefish.domain;

import java.util.List;

public class FishingPointData {
	private Long Count;
	private boolean HasElse;
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
	public boolean isHasElse() {
		return HasElse;
	}
	public void setHasElse(boolean hasElse) {
		HasElse = hasElse;
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

	@Override
	public String toString() {
		return "FishingPointData的toString方法： [Count=" + Count + ", HasElse=" + HasElse + ", PageIndex=" + PageIndex + "]";
	}
	
	
}
