package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
    	
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    protected void enterText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.getText();
    }
    
//    protected String getText(By locator) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        return driver.findElement(locator).getText();
//    }
    
    protected void dropdownSelected(By locator, String text) {
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(text);
		
    }
}
