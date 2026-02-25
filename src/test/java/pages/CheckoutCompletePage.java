package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class CheckoutCompletePage extends BasePage {
	
	//Locators
	private By checkoutCompleteTitle = By.className("title");
	private By checkoutCompleteMessage = By.className("complete-text");
	
	//Locators action
	public String getTitle() {
		return getText(checkoutCompleteTitle);
	}
	
	public String getCheckoutCompleteMessage() {
		return getText(checkoutCompleteMessage);
	}

}
