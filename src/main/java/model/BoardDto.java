package model;

public class BoardDto {
	private int articleNo;
	private String userId;
	private String title;
	private String content;
	private int hitCount;
	private String registerTime;
	private boolean isAnnouncement;

	public BoardDto(String userId, String title, String content) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
	
	public BoardDto(String userId, String title, String content, boolean isAnnouncement) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.isAnnouncement = isAnnouncement;
	}

	public BoardDto(int articleNo, String userId, String title, String content) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.title = title;
		this.content = content;
	}

	public BoardDto(int articleNo, String userId, String title, String content, int hitCount, boolean isAnnouncement) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.hitCount = hitCount;
		this.isAnnouncement = isAnnouncement;
	}

	public BoardDto(int articleNo, String userId, String title, String content, int hitCount, String registerTime) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.hitCount = hitCount;
		this.registerTime = registerTime;
	}
	
	public BoardDto(int articleNo, String userId, String title, String content, int hitCount, String registerTime, boolean isAnnouncement) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.hitCount = hitCount;
		this.registerTime = registerTime;
		this.isAnnouncement = isAnnouncement;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public boolean getIsAnnouncement() {
		return isAnnouncement;
	}

	public void setAnnouncement(boolean isAnnouncement) {
		this.isAnnouncement = isAnnouncement;
	}
}
