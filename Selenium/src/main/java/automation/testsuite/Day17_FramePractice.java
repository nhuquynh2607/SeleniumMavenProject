package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class Day17_FramePractice extends commonBase {

    @BeforeMethod
    public void openBrowser()
    {
        driver = initFirefoxDriver(CT_PageURL.CODESTAR_URL_TRANGCHU);
    }

    @Test
    public void handleFrame(){
        scrollToElement(By.xpath("//h2[text()='Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp về AWS/Kiểm thử/Lập trình web']"));
        System.out.println("iframe total: "+driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(0);
        type(By.id("email"), "0987654321");
        clickByJS(By.xpath("//button[normalize-space()='Gửi ngay']"));
        assertTrue(isElementDisplay(By.id("email")));
    }
}
