package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Alada_LoginLogoutPage_Factory;
import automation.pageLocator.BTVN_Day14_RegisterChangePassword_Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class BTVN_Day14_RegisterChangePassword_Test extends commonBase {
    @BeforeTest
    public void openBrowser() {
        driver = initFirefoxDriver(CT_PageURL.ALADA_URL_Register);
    }

    @Test
    public void registerSuccessfully() {
        BTVN_Day14_RegisterChangePassword_Factory factory = new BTVN_Day14_RegisterChangePassword_Factory(driver);
        factory.registerFunction("Quỳnh", "nhuquynh12@gmail.com", "nhuquynh12@gmail.com", "123456", "123456", "0987654321");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement khoaHocCuaToi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Khóa học của tôi'])[1]")));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    @Test
    public void loginSuccessfully()
    {
        WebElement login = driver.findElement(By.xpath("//a[text()='Đăng Nhập']"));
        login.click();

        Alada_LoginLogoutPage_Factory factory = new Alada_LoginLogoutPage_Factory(driver);
        factory.loginFunction("nhuquynh12@gmail.com", "123456");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    @Test
    public void changePassword()
    {
        loginSuccessfully();
        BTVN_Day14_RegisterChangePassword_Factory factory = new BTVN_Day14_RegisterChangePassword_Factory(driver);
        factory.changePasswordFunction("123456", "12345678", "12345678");
    }

    @Test
    public void loginAgainChangePassword()
    {
        WebElement login = driver.findElement(By.xpath("//a[text()='Đăng Nhập']"));
        login.click();

        Alada_LoginLogoutPage_Factory factory = new Alada_LoginLogoutPage_Factory(driver);
        factory.loginFunction("nhuquynh12@gmail.com", "12345678");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }
}
