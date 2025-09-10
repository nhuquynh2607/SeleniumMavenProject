package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BTVN_Day18_Bai1 extends commonBase {
    @BeforeTest
    @Parameters("browser")
    public void openBrowser(String browser)
    {
        driver = setupDriver(browser);
        driver.get(CT_PageURL.DIENMAY_URL);
    }

    @Test
    public void handleChatZalo() throws InterruptedException {
        String mainWindow = driver.getWindowHandle();

        click(By.xpath("//div[@id='zalo-vr']"));

        Set<String> listWindows = driver.getWindowHandles();
        for (String window: listWindows){
            if(!mainWindow.equals(window))
            {
                driver.switchTo().window(window);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.urlContains("zalo.me"));
                String curentURL = driver.getCurrentUrl();
                assertEquals(curentURL, "https://zalo.me/0965880198");
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        String curentURL2 = driver.getCurrentUrl();
        assertEquals(curentURL2, "https://dienmaynhapkhaugiare.com.vn/");
    }
}
