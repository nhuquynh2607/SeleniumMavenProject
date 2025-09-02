package automation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BTVN_Day16_Factory {
    private WebDriver driver;

    //Login
    @FindBy(id = "email") WebElement txtEmail;
    @FindBy(id = "password") WebElement txtPass;
    @FindBy(xpath = "//button[text()='Đăng nhập']") WebElement buttonDN;

    //Thêm KLV
    @FindBy(xpath = "//a[normalize-space(text())='Quản lý khu làm việc']") WebElement buttonQl_KLV;
    @FindBy(xpath = "//button[text()='Thêm mới']") WebElement buttonThemMoi;
    @FindBy(name = "work_areas_code") WebElement inputMa;
    @FindBy(name = "name") WebElement inputTen;
    @FindBy(xpath = "//button[text()='Lưu']") WebElement btnLuu;

    //Search
    @FindBy(xpath = "//input[@placeholder='Nhập từ khóa cần tìm kiếm']") WebElement searchBox;
    @FindBy(xpath = "//button[text()='Tìm kiếm']") WebElement searchButton;

    //Xóa KLV
    @FindBy(xpath = "//a[normalize-space(text())='Xóa']") WebElement buttonXoa;

    public BTVN_Day16_Factory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String email, String pass)
    {
        txtEmail.sendKeys(email);
        txtPass.sendKeys(pass);
        buttonDN.click();
    }

    public void AddNewFunction(String ma, String ten)
    {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", buttonQl_KLV);
//        js.executeScript("arguments[0].click();", buttonThemMoi);
        buttonQl_KLV.click();
        buttonThemMoi.click();
        inputMa.sendKeys(ma);
        inputTen.sendKeys(ten);
        btnLuu.click();
//        js.executeScript("arguments[0].click();", btnLuu);
    }

    public void search(String text) throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + text +"';", searchBox);
        js.executeScript("arguments[0].click();", searchButton);
        Thread.sleep(3000);
    }

    public void xoa() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonXoa);
    }
}
