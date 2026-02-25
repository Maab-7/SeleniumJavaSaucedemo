package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class CartPage extends BasePage {
	
	//Locators
	private By cartTitle = By.className("title");
	private By itemPrice = By.className("inventory_item_price");
	private By itemName = By.className("inventory_item_name");
	private By checkoutButton = By.id("checkout");
	
	
	
	//Locators action
	public String getTitle() {
			return getText(cartTitle);
	}
	
	public String getCartItemPrice() {
		return getText(itemPrice);
	}
	
	public String getCartItemName() {
		return getText(itemName);
	}
	
	public void clickOnCheckout() {
		clickElement(checkoutButton);
	}
	

}
