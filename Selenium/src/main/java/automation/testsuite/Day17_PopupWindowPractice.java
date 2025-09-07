package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Day17_PopupWindowPractice extends commonBase {
    @BeforeMethod
    public void openBrowser()
    {
        driver = initChromeDriver(CT_PageURL.GURU99_URL);
    }

    @Test
    public void handleWindow()
    {
        String mainWindow = driver.getWindowHandle();
        click(By.xpath("//a[text()='Click Here']"));
//        assertTrue(isElementDisplay(By.xpath("//h2[contains(text(),'Enter your email address to get ')]")));
        Set<String> listWindows = driver.getWindowHandles();
        for (String window: listWindows){
            if(!mainWindow.equals(window))
            {
                driver.switchTo().window(window);
                assertTrue(isElementDisplay(By.xpath("//h2[contains(text(),'Enter your email address to get ')]")));
                type(By.name("emailid"), "testEmail@gmail.com");
                click(By.name("btnLogin"));
                assertTrue(isElementDisplay(By.xpath("//h2[text() = 'Access details to demo site.']")));
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        String curentURL = driver.getCurrentUrl();
        assertEquals(curentURL, "https://demo.guru99.com/popup.php");
    }

}

