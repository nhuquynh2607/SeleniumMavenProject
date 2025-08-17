package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Day13_BTVN_LoginPage extends commonBase {

    @BeforeMethod
    public void openFirefoxBroswer()
    {
        driver = initFirefoxDriver(CT_PageURL.CODE_STAR_URL);
    }
    //case 1: Login thành công
    @Test
    public void loginSuccessfully()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunctionBTVN("admin@gmail.com", "12345678");
        WebElement quanLyNguoiDung = driver.findElement(By.xpath("//a[@class='navbar-brand']//p"));
        assertTrue(quanLyNguoiDung.isDisplayed());
    }

    //case 2: Email sai
    @Test
    public void FailEmail()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunctionBTVN("admin123@gmail.com", "12345678");
        WebElement emailError = driver.findElement(By.xpath("//span[@class='fl-message']"));
        assertFalse(emailError.isDisplayed());
    }

    //case 3: Mật khẩu sai
    @Test
    public void FailPassword()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunctionBTVN("admin@gmail.com", "123456");
        WebElement passwordError = driver.findElement(By.xpath("//span[@class='fl-message']"));
        assertFalse(passwordError.isDisplayed());
    }

    //case 4: Email và Password đều sai
    @Test
    public void FailEmaiPassError()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunctionBTVN("admin123@gmail.com", "123456");
        WebElement email_passError = driver.findElement(By.xpath("//span[@class='fl-message']"));
        assertFalse(email_passError.isDisplayed());
    }

    //case 5: Logout thành công
    @Test
    public void logoutPage() {
        //Đăng nhập vào hệ thống
        LoginPage login = new LoginPage(driver);
        login.LoginFunctionBTVN("admin@gmail.com", "12345678");

        //Đợi 10s đóng thông báo đăng nhập thành công
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-title")));

        //Trỏ đến menu của user
        WebElement userMenu = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        userMenu.click();

        //Click nút đăng xuất
        WebElement logoutButton = driver.findElement(By.xpath("//button[@class='dropdown-item']"));
        logoutButton.click();

        //click chọn đồng ý trên popup xác nhận đăng xuất
        WebElement clickAccept = driver.findElement(By.xpath("//button[@form = 'logout']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickAccept);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickAccept);

        //Quay trở lại màn hình login
        WebElement loginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        assertTrue(loginPage.isDisplayed());
    }

}
