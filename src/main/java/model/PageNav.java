package model;

import service.constant.AttractionListConstant;

public class PageNav {
	private int pageCount;
	private int itemCount;
	private int startPage;
	private int pageNo;
	private int maxPage;
	private boolean hasPrevNav;
	private boolean hasNextNav;
	
	public PageNav(int pageCount, int itemCount, int startPage, int pageNo, boolean hasPrevNav, boolean hasNextNav) {
		super();
		this.pageCount = pageCount;
		this.itemCount = itemCount;
		this.startPage = startPage;
		this.pageNo = pageNo;
		this.hasPrevNav = hasPrevNav;
		this.hasNextNav = hasNextNav;
		this.maxPage = AttractionListConstant.PAGE_COUNT.getValue();
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public boolean isHasPrevNav() {
		return hasPrevNav;
	}

	public void setHasPrevNav(boolean hasPrevNav) {
		this.hasPrevNav = hasPrevNav;
	}

	public boolean isHasNextNav() {
		return hasNextNav;
	}

	public void setHasNextNav(boolean hasNextNav) {
		this.hasNextNav = hasNextNav;
	}

}
