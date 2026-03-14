package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import base.BasePage;

public class CheckoutPage extends BasePage {
	
	//Locators
	private By checkoutTitle = By.className("title");
	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By zipCode = By.id("postal-code");
	private By continueButton = By.id("continue");
	
	
	
	//Locators action
	public String getTitle() {
		return getText(checkoutTitle);
	}
	
	public void enterFirstname(String firstNameInput) {
		enterText(firstName, firstNameInput);
	}
	
	public void enterLastName(String lastNameInput) {
		enterText(lastName,lastNameInput);
	}
	
	public void enterZipCode(String zipCodeInput) {
		enterText(zipCode,zipCodeInput);
	}
	
	public void clickOnContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        clickElement(continueButton);

        // ✅ Espera a que la navegación se complete
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
	}
}
