package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.TEDU_PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TEDU_UpdatePass_SearchASPNet_Test extends commonBase {

    TEDU_PageFactory tedu;

    @BeforeMethod
    public void openBrowser() {
        driver = initChromeDriver(CT_PageURL.TEDU_URL);
        tedu = new TEDU_PageFactory(driver);
    }

    @Test()
    public void loginSuccessfully() throws InterruptedException {
        tedu.loginFunction("nhuquynhdt26@gmail.com", "12345678");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
    }

    @Test()
    public void updatePassSuccessfully() throws InterruptedException {
        loginSuccessfully();
        tedu.updatePassword("12345678", "12345679");
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed());
    }

    //Search ASP Net
    @Test
    public void searchASPNETCourseSuccessfully() throws InterruptedException {
        loginSuccessfully();
        Thread.sleep(1000);
        tedu.searchCourse("ASP Net");
        assertTrue(driver.findElement(By.xpath("//li[text()='Kết quả tìm kiếm: ASP Net']")).isDisplayed());
    }

    @Test
    public void searchKhoaHoc() throws InterruptedException {
        loginSuccessfully();
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
        tedu.search("Web API");
        //assert: //div[@class='post-title']/h3/a hoặc //div[@class='post-content']/p chứa Web API
        List<WebElement> titleSearchResults = driver.findElements(By.xpath("//div[@class='post-title']/h3/a"));
        List<WebElement> contentSearchResults = driver.findElements(By.xpath("//div[@class='post-content']/p"));
        for (WebElement titleElement : titleSearchResults){
            String actualTitle = titleElement.getText();
             if(!actualTitle.contains("Web API"))
             {
                 for(WebElement contentElement: contentSearchResults){
                     String actualContent = contentElement.getText();
                     System.out.println("actualContent is: "+ actualContent);
                     assertTrue(actualContent.contains("Web API"));
                 }
             }
             else
                 System.out.println("actualTitle is: "+actualTitle);
                 assertTrue(actualTitle.contains("Web API"));
        }
    }
}