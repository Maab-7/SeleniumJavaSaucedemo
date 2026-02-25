package pages;

import org.openqa.selenium.By;

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
		clickElement(continueButton);
	}
	


}
