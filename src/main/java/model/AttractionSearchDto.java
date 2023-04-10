package model;

public class AttractionSearchDto {
	private int sidoCode;
	private int gugunCode;
	private int contentTypeId;
	private String keyword;
	
	public AttractionSearchDto(int sidoCode, int gugunCode, int contentType, String keyword) {
		super();
		this.sidoCode = sidoCode;
		this.gugunCode = gugunCode;
		this.contentTypeId = contentType;
		this.keyword = keyword;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}

	public int getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}

	public int getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
