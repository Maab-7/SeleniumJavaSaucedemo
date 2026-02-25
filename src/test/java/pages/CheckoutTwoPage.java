package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class CheckoutTwoPage extends BasePage {
	
	//Locators
	private By checkoutTwoTitle = By.className("title");
	private By finishButton = By.id("finish");
	private By itemName = By.className("inventory_item_name");
	private By itemPrice = By.className("inventory_item_price");
	private By totalPrice = By.className("summary_total_label");
	
	//Locators action
	public String getTitle() {
		return getText(checkoutTwoTitle);
	}
	
	public void clickOnFinish() {
		clickElement(finishButton);
	}
	
	public String getItemName() {
		return getText(itemName);
	}
	
	public String getItemPrice() {
		return getText(itemPrice);
	}

	public String getTotalPrice() {
		return getText(totalPrice);
	}
		
}
