package main.java.retailstore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BillDetails {

	private final String CUSTOMER = "CUSTOMER";
	private final String GROCERIES = "GROCERIES";
	private final String DATE_FORMAT = "dd/MM/yyyy";
	private User user;
	private List<Items> itemList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	public double discountOnAmount(User user, String dateToValidate) {
		double discountAmount = 0;
		for (Items item : itemList) {
			int itemPrice = item.getItemPrice();
			if (GROCERIES.equals(item.getItemType())) {
				discountAmount = discountAmount + itemPrice;
			} else if (CUSTOMER.equals(user.getUser().getUserType())
					&& isdateBeforeTwoYearsdate(dateToValidate, DATE_FORMAT)) {
				double afterDiscount = 100 - 5;
				double amount = (afterDiscount * itemPrice) / 100;
				discountAmount = discountAmount + amount;
			} else {
				double afterDiscount = 100 - user.getUser().getDiscount();
				double amount = (afterDiscount * itemPrice) / 100;
				discountAmount = discountAmount + amount;
			}
		}

		if (discountAmount > 100) {
			int extraDisountOnEvery100Dollar = (int) (discountAmount / 100) * 5;
			return discountAmount - extraDisountOnEvery100Dollar;
		}
		return discountAmount;
	}

	public boolean isdateBeforeTwoYearsdate(String dateToValidate, String dateFromat) {
		System.out.println("date-" + dateToValidate);
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(dateToValidate);
			Calendar currentDateBefore2Year = Calendar.getInstance();
			currentDateBefore2Year.add(Calendar.YEAR, -2);
			if (date.before(currentDateBefore2Year.getTime())) {
				System.out.println("true");
				return true;
			} else {
				System.out.println("false");
				return false;
			}
		} catch (ParseException e) {
			// e.printStackTrace();
			return false;
		}
	}
}