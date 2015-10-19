package cn.lovefish.domain;

import java.util.List;

public class CarefullyChosenData {

	private String Count;
	private Boolean HasElse;
	private String PageIndex;
	private List<CarefullyChosen> Items;

	public CarefullyChosenData() {
		super();
	}

	public String getCount() {
		return Count;
	}

	public void setCount(String count) {
		Count = count;
	}

	public String getPageIndex() {
		return PageIndex;
	}

	public void setPageIndex(String pageIndex) {
		PageIndex = pageIndex;
	}

	public List<CarefullyChosen> getItems() {
		return Items;
	}

	public void setItems(List<CarefullyChosen> items) {
		Items = items;
	}

	public Boolean getHasElse() {
		return HasElse;
	}

	public void setHasElse(Boolean hasElse) {
		HasElse = hasElse;
	}
	
}
