package model;

public class BoardDto {
	private int articleNo;
	private String title;
	private String userId;
	private int hitCount;
	
	public BoardDto(int articleNo, String title, String userId, int hitCount) {
		super();
		this.articleNo = articleNo;
		this.title = title;
		this.userId = userId;
		this.hitCount = hitCount;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
}
