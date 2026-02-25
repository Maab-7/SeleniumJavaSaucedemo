package pages;

import org.openqa.selenium.By;

import base.BasePage;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	
	//Web Locators
	private By usernameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");
	
	//Actions Web Locators
	@Step("Ingresamos username: {username}")
	public void enterUsername(String username) {
		enterText(usernameInput, username);
	}
	
	@Step("Ingresamos password")
	public void enterPassword(String password) {
		enterText(passwordInput, password);
	}
	
	@Step("Click en el login button")
	public void clickLoginButton() {
		clickElement(loginButton);
	}
	
	public void login(String username, String password) {
		
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

}
