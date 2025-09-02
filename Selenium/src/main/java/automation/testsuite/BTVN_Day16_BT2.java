package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.BTVN_Day16_Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BTVN_Day16_BT2 extends commonBase {
    //Bài tập 2

    @BeforeMethod
    public void openBrowser(){
        driver = initFirefoxDriver(CT_PageURL.SELENIUMPRACTICE_URL);
    }

    @Test
    public void tryItSuccessfully() throws InterruptedException
    {
        click(By.xpath("//button[text()='Try it']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.alertIsPresent());
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Welcome to Selenium WebDriver Tutorials");
        driver.switchTo().alert().accept();
        assertTrue(isElementDisplay(By.xpath("//div[@class='post-body entry-content']")));
    }
}
