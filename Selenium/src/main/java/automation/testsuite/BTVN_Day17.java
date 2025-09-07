package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BTVN_Day17 extends commonBase {
    @BeforeMethod
    public void openBrowser() {
        driver = initChromeDriver(CT_PageURL.MEDIAMART_URL);
    }

    @Test
    public void closePopupMediaMart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mediaFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("easychatgpt-widget")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('easychatgpt-widget').style.display='none';");

    }

    @Test
    public void handleChatZalo() throws InterruptedException {
        closePopupMediaMart();

        System.out.println("iframe total: "+driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);

        click(By.xpath("//div[contains(@class,'za-chat__head-box')]"));
        assertTrue(isElementDisplay(By.xpath("//div[@class='box-wrapper']")));

        click(By.xpath("//div[text()='Chat nhanh']"));
        assertTrue(isElementDisplay(By.xpath("//div[@class='card__content ']")));

    }
}
