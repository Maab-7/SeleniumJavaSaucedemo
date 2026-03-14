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
	
	//Mejora para mejorar la estabilidad del click, se espera a que el elemento sea visible y se hace scroll hasta el elemento antes de hacer click
	public void ClickOnAddToCartButtonSelectedByName(String productName) {

		    By addToCartButton = By.id("add-to-cart-" + productName.toLowerCase().replace(" ", "-"));
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    WebElement element = wait.until(
		        ExpectedConditions.elementToBeClickable(addToCartButton)
		    );

		    // ✅ En headless usar JS click que es más confiable
		    String headless = System.getProperty("headless", "false");
		    if ("true".equalsIgnoreCase(headless)) {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		    } else {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		        element.click();
		    }
		    // ✅ Esperar confirmación de que el click funcionó
		    By removeButton = By.id("remove-" + productName.toLowerCase().replace(" ", "-"));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(removeButton));
	}
	
	public String getTextRemoveButtonSelected(String productName) {

	    By removeButton = By.id("remove-" + productName.toLowerCase().replace(" ", "-"));

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(removeButton)
	    );

	    return element.getText();
	}
	
	public void clickOnCartButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(cartButton));

	    String headless = System.getProperty("headless", "false");
	    if ("true".equalsIgnoreCase(headless)) {
	        // ✅ En headless navegar directamente — el JS click no dispara la navegación
	        driver.navigate().to("https://www.saucedemo.com/cart.html");
	    } else {
	        clickElement(cartButton);
	    }

	    wait.until(ExpectedConditions.urlContains("cart"));
	}
	
	public String getTextItemPrice(String productName) {
		By itemPrice = By.xpath("//button[@id='add-to-cart-"+ productName.toLowerCase().replace(" ", "-") +"']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");
		return getText(itemPrice);
	}
	
	

}
