package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        clickElement(checkoutButton);

        // ✅ Espera a que la navegación se complete
        wait.until(ExpectedConditions.urlContains("checkout-step-one"));
	}
	

}
