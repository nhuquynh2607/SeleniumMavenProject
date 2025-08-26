package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.TEDU_PageFactory;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TEDU_UpdatePass_SearchASPNet_Test extends commonBase {

    TEDU_PageFactory tedu;
    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.TEDU_URL);
        tedu = new TEDU_PageFactory(driver);
    }

    @Test ()
    public void loginSuccessfully() throws InterruptedException
    {
        tedu.loginFunction("nhuquynhdt26@gmail.com", "12345678");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
    }

    @Test ()
    public void updatePassSuccessfully() throws InterruptedException
    {
        loginSuccessfully();
        tedu.updatePassword("12345678", "12345679");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed());
    }

    //Search ASP Net
    @Test
    public void searchASPNETCourseSuccessfully() throws InterruptedException {
        loginSuccessfully();
        Thread.sleep(1000);
        tedu.searchCourse("ASP Net");
        assertTrue(driver.findElement(By.xpath("//li[text()='Kết quả tìm kiếm: ASP Net']")).isDisplayed());
    }
}
