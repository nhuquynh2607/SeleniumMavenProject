package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.BTVN_Day16_Factory;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BTVN_Day16 extends commonBase {
    BTVN_Day16_Factory btvn_day16;

    @BeforeMethod
    public void openBrowser(){
        driver = initFirefoxDriver(CT_PageURL.CRMSTAR_URL);
        btvn_day16 = new BTVN_Day16_Factory(driver);
    }

    //Bài tập 1
    @Test(priority = 1)
    public void loginSuccessfully() throws InterruptedException {
        btvn_day16.loginFunction("admin@gmail.com", "12345678");
        assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
    }

    @Test(priority = 2)
    public void addNewSuccessfully() throws InterruptedException{
        loginSuccessfully();
        Thread.sleep(3000);
        btvn_day16.AddNewFunction("KVLV0209", "KVLVSo0209");
        click(By.xpath("//button[text()='Thêm']"));
        assertTrue(isElementDisplay(By.xpath("//tr//th[text()='#']")));
        btvn_day16.search("KVLVSo0209");
    }

    @Test(priority = 3)
    public void xoaSuccessfully() throws InterruptedException{
        btvn_day16.loginFunction("admin@gmail.com", "12345678");
        click(By.xpath("//a[normalize-space(text())='Quản lý khu làm việc']"));
        btvn_day16.search("KVLVSo0209");
        btvn_day16.xoa();
        String actual = driver.switchTo().alert().getText();
        assertEquals(actual, "Bạn có thực sự muốn xóa khu vực này");
        driver.switchTo().alert().accept();
        assertTrue(isElementDisplay(By.xpath("//tr//th[text()='#']")));
    }
}
