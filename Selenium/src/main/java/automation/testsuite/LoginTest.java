package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class LoginTest extends commonBase {
@BeforeMethod
    public void openChromeBrowser()
    {
    driver = initChromeDriver(CT_PageURL.ALADA_URL);
    }
       //case 1: Login thành công
    @Test
    public void loginSuccessfully()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("quynhzui123@gmail.com", "nhuquynh2607");
        WebElement khoaHocCuaToi = driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]"));
        assertTrue(khoaHocCuaToi.isDisplayed());
    }

    //case 2: Email chưa được đăng ký
    @Test
    public void FailEmail()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("quynhzui12@gmail.com", "nhuquynh2607");
        WebElement emailIncorrect = driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']"));
        assertTrue(emailIncorrect.isDisplayed());
    }

    //case 3: Mật khẩu không đúng
    @Test
    public void FailPassword()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("quynhzui123@gmail.com", "nhuquynh26");
        WebElement passwordIncorrect = driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']"));
        assertTrue(passwordIncorrect.isDisplayed());
    }

    //case 4: Để trống Email và Password
    @Test
    public void FailBlankEmaiPass()
    {
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("", "");
        WebElement emailBlank = driver.findElement(By.xpath("//label[text()='Vui lòng nhập email']"));
        assertTrue(emailBlank.isDisplayed());
        WebElement passwordBlank = driver.findElement(By.xpath("//label[text()= 'Vui lòng nhập mật khẩu']"));
        assertTrue(passwordBlank.isDisplayed());
    }
}
