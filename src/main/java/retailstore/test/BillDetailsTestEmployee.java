package main.java.retailstore.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.retailstore.BillDetails;
import main.java.retailstore.ItemTypeEnum;
import main.java.retailstore.Items;
import main.java.retailstore.User;
import main.java.retailstore.UserTypeEnum;

class BillDetailsTestEmployee {
	private User user;
	private BillDetails bill; 
	
	@BeforeEach
	public void initInputs() {
		user = new User();
		user.setUser(UserTypeEnum.EMPLOYEE);
		List<Items> itemList = new ArrayList<>();
		Items items1 = new Items();
		items1.setItemType(ItemTypeEnum.GROCERIES.getItemCategory());
		items1.setItemPrice(100);
		
		Items items2 = new Items();
		items2.setItemType(ItemTypeEnum.COSMETIC.getItemCategory());
		items2.setItemPrice(100);
		
		Items items3 = new Items();
		items3.setItemType(ItemTypeEnum.MEDICINE.getItemCategory());
		items3.setItemPrice(100);
		
		itemList.add(items1);
		itemList.add(items2);
		itemList.add(items3);
		bill = new BillDetails();
		bill.setUser(user);
		bill.setItemList(itemList);
	}

	@Test
	void discountOnAmount() {
		Assertions.assertEquals(230.0,bill.discountOnAmount(user,""),"Test case pass");
	}
	
	@Test
	void discountOnAmountFalse() {
		Assertions.assertNotEquals(316.0,bill.discountOnAmount(user,""),"Test case fail");
	}
}
