package base;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initDriver(String browser) {

        // ✅ Si no se pasa el parámetro, asume "false" (funciona en Eclipse sin configurar nada)
        String headlessProp = System.getProperty("headless", "false");

        // ✅ Headless automático si no hay display disponible (Linux/Jenkins sin GUI)
        boolean isHeadless = "true".equalsIgnoreCase(headlessProp)
                          || System.getenv("DISPLAY") == null;

        switch (browser.toLowerCase()) {

            case "chrome":
                //WebDriverManager.chromedriver().setup();
            	WebDriverManager.chromedriver().clearDriverCache().setup();
                ChromeOptions options = new ChromeOptions();

                if (isHeadless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu");
                }

                driver = new ChromeDriver(options);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser no soportado");
        }

        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}