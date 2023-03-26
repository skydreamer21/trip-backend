package model;

public class GugunDto {
	private int code;
	private String name;
	private int sidoCode;
	
	public GugunDto(int gugunCode, String gugunName, int sidoCode) {
		super();
		this.code = gugunCode;
		this.name = gugunName;
		this.sidoCode = sidoCode;
	}

	public int getGugunCode() {
		return code;
	}

	public void setGugunCode(int gugunCode) {
		this.code = gugunCode;
	}

	public String getGugunName() {
		return name;
	}

	public void setGugunName(String gugunName) {
		this.name = gugunName;
	}

	public int getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
}
