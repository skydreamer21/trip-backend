package model;

public class SidoDto {
	private int code;
	private String name;
	
	public SidoDto(int sidoCode, String sidoName) {
		super();
		this.code = sidoCode;
		this.name = sidoName;
	}

	public int getSidoCode() {
		return code;
	}

	public void setSidoCode(int sidoCode) {
		this.code = sidoCode;
	}

	public String getSidoName() {
		return name;
	}

	public void setSidoName(String sidoName) {
		this.name = sidoName;
	}
}
