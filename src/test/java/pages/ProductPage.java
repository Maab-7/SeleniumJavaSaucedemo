package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class ProductPage extends BasePage {
	
	
	//Locators
	private By productsTitle = By.className("title");
	private By cartButton = By.id("shopping_cart_container");
	
	
	//Locators action
	public String getTitle() {
		return getText(productsTitle);
	}
	
	public void ClickOnAddToCartButtonSelectedByName (String productName) {
		By addToCartButton = By.id("add-to-cart-" + productName.toLowerCase().replace(" ", "-"));
		clickElement(addToCartButton);
	}
	
	public String getTextRemoveButtonSelected(String productName) {
		By addToCartButton = By.id("remove-" + productName.toLowerCase().replace(" ", "-"));
		return getText(addToCartButton);
	}
	
	public void clickOnCartButton() {
		clickElement(cartButton);
	}
	
	public String getTextItemPrice(String productName) {
		By itemPrice = By.xpath("//button[@id='add-to-cart-"+ productName.toLowerCase().replace(" ", "-") +"']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");
		return getText(itemPrice);
	}
	
	

}
