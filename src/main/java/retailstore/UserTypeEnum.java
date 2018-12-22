package main.java.retailstore;

public enum UserTypeEnum {
	EMPLOYEE("EMPLOYEE", 30), AFFILIATE("AFFILIATE", 10), CUSTOMER("CUSTOMER", 0);

	private String userType;
	private double discount;

	UserTypeEnum(String type, double discount) {
		this.userType = type;
		this.discount = discount;
	}

	public String getUserType() {
		return userType;
	}

	public double getDiscount() {
		return discount;
	}
}
