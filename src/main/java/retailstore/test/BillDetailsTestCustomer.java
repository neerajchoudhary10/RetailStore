package main.java.retailstore.test;

import java.text.ParseException;
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

class BillDetailsTestCustomer {
	private User user;
	private BillDetails bill;
	
	@BeforeEach
	public void initInputs() {
		user = new User();
		user.setUser(UserTypeEnum.CUSTOMER);
		List<Items> itemList = new ArrayList<>();
		Items items1 = new Items();
		items1.setItemType(ItemTypeEnum.GROCERIES.getItemCategory());
		items1.setItemPrice(10);
		
		Items items2 = new Items();
		items2.setItemType(ItemTypeEnum.COSMETIC.getItemCategory());
		items2.setItemPrice(20);
		
		Items items3 = new Items();
		items3.setItemType(ItemTypeEnum.MEDICINE.getItemCategory());
		items3.setItemPrice(300);
		
		itemList.add(items1);
		itemList.add(items2);
		itemList.add(items3);
		bill = new BillDetails();
		bill.setUser(user);
		bill.setItemList(itemList);
	}

	@Test
	void discountOnAmountForUserRegBefore2Years() {
		Assertions.assertEquals(299.0,bill.discountOnAmount(user,"12/10/2016"),"Test case pass");
	}
	
	@Test
	void discountOnAmountForUserRegIn2Years() {
		Assertions.assertEquals(315.0,bill.discountOnAmount(user,"12/10/2018"),"Test case pass");
	}
	
	@Test
	void discountOnAmountFalse() {
		Assertions.assertNotEquals(316.0,bill.discountOnAmount(user,"12/10/2018"),"Test case fail");
	}
	
	@Test
	void isdateBeforeTwoYearsdate() {
		Assertions.assertTrue(bill.isdateBeforeTwoYearsdate("12/10/2016","dd/MM/yyyy"));
	}
	
	@Test
	void isdateNotBeforeTwoYearsdate() {
		Assertions.assertFalse(bill.isdateBeforeTwoYearsdate("12/10/2018","dd/MM/yyyy"));
	}
	
}
