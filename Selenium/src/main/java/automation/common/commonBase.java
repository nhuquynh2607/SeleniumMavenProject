package automation.common;

import automation.constant.CT_PageURL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class commonBase {
    public static WebDriver driver;
    public WebDriver initChromeDriver(String Url)
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }
}
