package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TEDU_PageFactory {
    private WebDriver driver;
    @FindBy(id = "UserName") WebElement txtEmail;
    @FindBy(id = "Password") WebElement txtPass;
    @FindBy(xpath = "//button[text()='Đăng nhập']") WebElement buttonDN;

    //Edit password
    @FindBy(id="onesignal-slidedown-allow-button") WebElement buttonSubcribe;
    @FindBy(id="my_account") WebElement buttonMyAccount;
    @FindBy(xpath = "//a[@title='Đổi mật khẩu']") WebElement buttonChangePass;
    @FindBy(id="OldPassword") WebElement textOldPassword;
    @FindBy(id="NewPassword") WebElement textNewPassword;
    @FindBy(id="ConfirmNewPassword") WebElement textConfirmNewPassword;
    @FindBy(xpath="//input[@value='Cập nhật']") WebElement btnCapNhat;

    //Search khóa học ASP NET
    @FindBy(xpath = "//input[@class='autosearch-input form-control']") WebElement searchBox;
    @FindBy(xpath = "//button[@class='button-search btn btn-primary']") WebElement searchButton;
    @FindBy(id = "onesignal-slidedown-cancel-button") WebElement buttonLater;


    public TEDU_PageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String email, String pass)
    {
        txtEmail.sendKeys(email);
        txtPass.sendKeys(pass);
        buttonDN.click();
    }

    public void updatePassword(String oldPass, String newPass)
    {
        buttonSubcribe.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('my_account').click();");
//        buttonMyAccount.click();
//        buttonChangePass.click();
        js.executeScript("arguments[0].click();", buttonChangePass);
        textOldPassword.sendKeys(oldPass);
        textNewPassword.sendKeys(newPass);
        textConfirmNewPassword.sendKeys(newPass);
        btnCapNhat.click();
    }

    public void searchCourse(String keyword) throws InterruptedException {

        buttonLater.click();
        searchBox.click();
        searchBox.sendKeys(keyword);
        searchButton.click();
        Thread.sleep(3000); // chờ kết quả tìm kiếm
    }

    public void search(String text) throws InterruptedException
    {
        buttonLater.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + text +"';", searchBox);
        js.executeScript("arguments[0].click();", searchButton);
        Thread.sleep(3000);
    }
}
