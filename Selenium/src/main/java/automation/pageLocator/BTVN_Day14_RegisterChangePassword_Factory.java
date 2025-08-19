package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BTVN_Day14_RegisterChangePassword_Factory {
    private WebDriver driver;

    //Register
    @FindBy (id = "txtFirstname") WebElement textName;
    @FindBy (id = "txtEmail") WebElement textEmail;
    @FindBy (id = "txtCEmail") WebElement textCEmail;
    @FindBy (id = "txtPassword") WebElement textPassword;
    @FindBy (id = "txtCPassword") WebElement textCPassword;
    @FindBy (id = "txtPhone") WebElement textPhone;
    @FindBy (xpath = "(//button[text() = 'ĐĂNG KÝ'])[3]") WebElement buttonRegister;

    //Change Password
    @FindBy(xpath = "//div[@class = 'avatar2']") WebElement imageAvatar;
    @FindBy(xpath = "//a[text() = 'Chỉnh sửa thông tin']") WebElement btnChangePassword;

    @FindBy(id = "txtpassword") WebElement textOldPassword;
    @FindBy(id = "txtnewpass") WebElement textNewPassword;
    @FindBy(id = "txtrenewpass") WebElement textNewCPassword;
    @FindBy(xpath = "//button[text()='Lưu mật khẩu mới']") WebElement buttonChangePass;

    public BTVN_Day14_RegisterChangePassword_Factory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerFunction(String name, String email, String cEmail, String pass, String cPass, String phone)
    {
        textName.sendKeys(name);
        textEmail.sendKeys(email);
        textCEmail.sendKeys(cEmail);
        textPassword.sendKeys(pass);
        textCPassword.sendKeys(cPass);
        textPhone.sendKeys(phone);
        buttonRegister.click();
    }

    public void changePasswordFunction(String oldPass, String newPass, String newCPass)
    {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//        driver.switchTo().alert().accept();
        imageAvatar.click();
        btnChangePassword.click();

        textOldPassword.sendKeys(oldPass);
        textNewPassword.sendKeys(newPass);
        textNewCPassword.sendKeys(newCPass);
        buttonChangePass.click();
    }
}

