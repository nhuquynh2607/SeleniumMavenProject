package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Day16_AlertPractice extends commonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(@Optional("firefox") String browser) {
        driver = setupDriver(browser);
        driver.get(CT_PageURL.ALERT_URL1);
//        driver = initEdgeDriver(CT_PageURL.MEDIAMART_URL);
    }

    @Test
    public void HandleAlertwwithOkAndCancle()
    {
        click(By.xpath("//a[text()='Alert with OK & Cancel ']"));
        click(By.xpath("//button[@class = 'btn btn-primary']"));
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Press a Button !");
        driver.switchTo().alert().accept();
        assertTrue(isElementDisplay(By.xpath("//p[text()='You pressed Ok']")));
    }

    @Test
    public void HandleAlertwithCheckbox()
    {
        click(By.xpath("//a[text()='Alert with Textbox ']"));
        click(By.xpath("//button[@class = 'btn btn-info']"));
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Please enter your name");
        driver.switchTo().alert().sendKeys("My June amazing class");
        driver.switchTo().alert().accept();
        assertTrue(isElementDisplay(By.xpath("//p[text()='Hello My June amazing class How are you today']")));
    }
}
