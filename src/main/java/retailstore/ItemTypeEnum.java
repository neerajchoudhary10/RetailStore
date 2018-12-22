package main.java.retailstore;

public enum ItemTypeEnum {
	GROCERIES("GROCERIES"), COSMETIC("COSMETIC"), MEDICINE("MEDICINE");

	private String itemCategory;

	ItemTypeEnum(String category) {
		this.itemCategory = category;
	}

	public String getItemCategory() {
		return itemCategory;
	}

}
