package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class BTVN_day18_Bai2 extends commonBase {
    @BeforeTest
    @Parameters("browser")
    public void openBrowser(String browser)
    {
        driver = setupDriver(browser);
        driver.get(CT_PageURL.BEPANTOAN_URL);
    }

    @Test
    public void handleChatZalo() throws InterruptedException {
        String mainWindow = driver.getWindowHandle();

        click(By.xpath("//div[@class='hidden md:grid grid-cols-3 justify-center gap-x-[12px] z-[100] fixed left-1/2 transform -translate-x-1/2 bottom-0 md:w-[600px] w-full']//a[2]"));

        Set<String> listWindows = driver.getWindowHandles();
        for (String window: listWindows){
            if(!mainWindow.equals(window))
            {
                driver.switchTo().window(window);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.urlContains("zalo.me"));
                String curentURL = driver.getCurrentUrl();
                assertEquals(curentURL, "https://zalo.me/0912331335");
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        String curentURL2 = driver.getCurrentUrl();
        assertEquals(curentURL2, "https://bepantoan.vn/");
    }
}
