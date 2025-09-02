package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Day16_AlertPractice2 extends commonBase {
    @BeforeMethod
    public void openBrowser(){
        driver = initChromeDriver(CT_PageURL.ALERT_URL2);
    }

    @Test
    public void deleteCustomer() throws InterruptedException{
        type(By.name("cusid"), "123");
        click(By.name("submit"));
        String acutual1 = driver.switchTo().alert().getText();
        assertEquals(acutual1, "Do you really want to delete this Customer?");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        String actual2 = driver.switchTo().alert().getText();
        assertEquals(actual2,"Customer Successfully Delete!");
        driver.switchTo().alert().accept();
    }
}
