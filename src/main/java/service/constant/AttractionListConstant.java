package service.constant;

public enum AttractionListConstant {
	ITEM_COUNT(10),
	PAGE_COUNT(5);
	
	private final int value;

	private AttractionListConstant(int value) {
		this.value = value;
	}
	
	public static int getTotalItemCountInNav() {
		return ITEM_COUNT.value * PAGE_COUNT.value;
	}

	public int getValue() {
		return value;
	}
}
