package automation.common;

import automation.constant.CT_PageURL;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class commonBase {
    public static WebDriver driver;
    public WebDriver initChromeDriver(String Url)
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = getElementPresentDOM(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public WebElement getElementPresentDOM(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
}
