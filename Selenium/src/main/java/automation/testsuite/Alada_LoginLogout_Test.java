package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Alada_LoginLogoutPage_Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Alada_LoginLogout_Test extends commonBase {
    @BeforeTest
    @Parameters("browser")
    public void openBrowser(String browser)
    {
        driver = setupDriver(browser);
        driver.get(CT_PageURL.ALADA_URL);
//        driver = initFirefoxDriver(CT_PageURL.ALADA_URL);
    }

    @Test
    public void loginSuccessfully()
    {
        Alada_LoginLogoutPage_Factory factory = new Alada_LoginLogoutPage_Factory(driver);
        factory.loginFunction("quynhzui123@gmail.com", "nhuquynh2607");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    @Test
    public void logoutSuccessfully()
    {
        loginSuccessfully();
        Alada_LoginLogoutPage_Factory factory = new Alada_LoginLogoutPage_Factory(driver);
        factory.logoutFunction();
        assertTrue(driver.findElement(By.xpath("//div[@class = 'login']")).isDisplayed());

    }
}
