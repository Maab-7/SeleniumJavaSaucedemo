package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({AllureTestNg.class})
public class BaseTest {

    @BeforeMethod
    public void setUp() {

    	 // Si no se pasa parámetro, usa chrome por defecto
        String browser = System.getProperty("browser", "chrome");

        DriverManager.initDriver(browser);
        DriverManager.getDriver().get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
    	
        if (result.getStatus() == ITestResult.FAILURE) {
            attachScreenshot();
        }
        
        DriverManager.quitDriver();
    }
    
    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}