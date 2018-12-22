package main.java.retailstore;

import java.util.ArrayList;
import java.util.List;

public class CalculateDiscount {

	public static void main(String[] args) {
		User user = new User(); 
		user.setUser(UserTypeEnum.AFFILIATE);
		List<Items> itemList = new ArrayList<>();

		Items items1 = new Items();
		items1.setItemType(ItemTypeEnum.GROCERIES.getItemCategory());
		items1.setItemPrice(200);
		
		Items items2 = new Items();
		items2.setItemType(ItemTypeEnum.COSMETIC.getItemCategory());
		items2.setItemPrice(200);
		
		Items items3 = new Items();
		items3.setItemType(ItemTypeEnum.MEDICINE.getItemCategory());
		items3.setItemPrice(200);
		
		itemList.add(items1);
		itemList.add(items2);
		itemList.add(items3);
		BillDetails bill = new BillDetails();
		bill.setUser(user);
		bill.setItemList(itemList);

		double finalAmount = bill.discountOnAmount(user, "12/10/2018");
		System.out.println("Discount finalAmount:-> " + finalAmount);
	}

}
