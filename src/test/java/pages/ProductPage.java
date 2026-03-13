package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import base.BasePage;

public class ProductPage extends BasePage {
	
	
	//Locators
	private By productsTitle = By.className("title");
	private By cartButton = By.id("shopping_cart_container");
	
	
	//Locators action
	public String getTitle() {
		return getText(productsTitle);
	}
	
	/*public void ClickOnAddToCartButtonSelectedByName (String productName) {
		By addToCartButton = By.id("add-to-cart-" + productName.toLowerCase().replace(" ", "-"));
		clickElement(addToCartButton);
	}*/
	
	//Tarea: Mejorar el metodo ClickOnAddToCartButtonSelectedByName para esperar a que el boton sea clickeable y hacer scroll hasta el elemento antes de hacer click
	public void ClickOnAddToCartButtonSelectedByName(String productName) {

	    By addToCartButton = By.id("add-to-cart-" + productName.toLowerCase().replace(" ", "-"));

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement element = wait.until(
	        ExpectedConditions.elementToBeClickable(addToCartButton)
	    );

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	    element.click();
	}
	
	/*public String getTextRemoveButtonSelected(String productName) {
		By addToCartButton = By.id("remove-" + productName.toLowerCase().replace(" ", "-"));
		return getText(addToCartButton);
	}*/
	
	public String getTextRemoveButtonSelected(String productName) {

	    By removeButton = By.id("remove-" + productName.toLowerCase().replace(" ", "-"));

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(removeButton)
	    );

	    return element.getText();
	}
	
	public void clickOnCartButton() {
		clickElement(cartButton);
	}
	
	public String getTextItemPrice(String productName) {
		By itemPrice = By.xpath("//button[@id='add-to-cart-"+ productName.toLowerCase().replace(" ", "-") +"']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");
		return getText(itemPrice);
	}
	
	

}
