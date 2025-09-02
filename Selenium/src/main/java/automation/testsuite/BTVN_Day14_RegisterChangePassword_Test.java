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
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class BTVN_Day14_RegisterChangePassword_Test extends commonBase {

    static String baseEmailPrefix = "testBase";
    static String baseEmail ="";

    public static String generateRandomString(int length) {
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            email.append(characterSet.charAt(index));
        }

        baseEmail = baseEmailPrefix + email.toString() + "@gmail.com";
        return baseEmail;
    }

    @BeforeTest
    public void openBrowser()
    {
        driver = initFirefoxDriver(CT_PageURL.ALADA_URL_Register);
    }

    @Test(priority = 1)
    public void registerSuccessfully() throws InterruptedException{
        generateRandomString(4);
        BTVN_Day14_RegisterChangePassword_Factory factory = new BTVN_Day14_RegisterChangePassword_Factory(driver);
        factory.registerFunction("Quỳnh", baseEmail, baseEmail, "123456", "123456", "0987654321");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement khoaHocCuaToi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Khóa học của tôi'])[1]")));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    @Test (priority = 2)
    public void loginSuccessfully()
    {
        WebElement login = driver.findElement(By.xpath("//a[text()='Đăng Nhập']"));
        login.click();

        Alada_LoginLogoutPage_Factory factory = new Alada_LoginLogoutPage_Factory(driver);
        factory.loginFunction(baseEmail, "123456");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement khoaHocCuaToi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Khóa học của tôi'])[1]")));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    @Test(priority = 3)
    public void changePassword()
    {
        loginSuccessfully();
        BTVN_Day14_RegisterChangePassword_Factory factory = new BTVN_Day14_RegisterChangePassword_Factory(driver);
        factory.changePasswordFunction("1234567", "12345678", "12345678");
    }

    @Test (priority = 4)
    public void loginAgainChangePassword()
    {
        WebElement login = driver.findElement(By.xpath("//a[text()='Đăng Nhập']"));
        login.click();

        Alada_LoginLogoutPage_Factory factory = new Alada_LoginLogoutPage_Factory(driver);
        factory.loginFunction(baseEmail, "12345678");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }
}
