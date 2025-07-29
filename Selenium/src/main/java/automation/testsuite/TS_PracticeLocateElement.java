package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TS_PracticeLocateElement extends commonBase {
    @Test
    public void getElementByUserEmail()
    {
        driver = initChromeDriver(CT_PageURL.SELECT_HUB_URL);
        WebElement userEmailElement = driver.findElement(By.name("email"));
        System.out.println("userEmailElement: " + userEmailElement);
    }

    @Test
    public void getElementByPassword()
    {
        driver = initChromeDriver(CT_PageURL.SELECT_HUB_URL);
        WebElement passwordElement = driver.findElement(By.id("pass"));
        System.out.println("passwordElement: " + passwordElement);
    }

    @Test
    public void getElementByCompany()
    {
        driver = initChromeDriver(CT_PageURL.SELECT_HUB_URL);
        WebElement companyElement = driver.findElement(By.name("company"));
        System.out.println("companyElement: " + companyElement);
    }

    @Test
    public void getElementByMobileNumber()
    {
        driver = initChromeDriver(CT_PageURL.SELECT_HUB_URL);
        WebElement mobileNumberElement = driver.findElement(By.name("mobile number"));
        System.out.println("mobileNumberElement: " + mobileNumberElement);
    }

    //Bài tập 2
    @Test
    public void getElementByName()
    {
        driver = initChromeDriver(CT_PageURL.SE_WEB_API_URL);
        WebElement nameElement = driver.findElement(By.id("name"));
        System.out.println("nameElement: " + nameElement);
    }

    @Test
    public void getElementByAddress()
    {
        driver = initChromeDriver(CT_PageURL.SE_WEB_API_URL);
        WebElement addressElement = driver.findElement(By.id("address"));
        System.out.println("addressElement: " + addressElement);
    }

    @Test
    public void getElementByEmail()
    {
        driver = initChromeDriver(CT_PageURL.SE_WEB_API_URL);
        WebElement emailElement = driver.findElement(By.id("email"));
        System.out.println("emailElement: " + emailElement);
    }

    @Test
    public void getElementByPasswordForm()
    {
        driver = initChromeDriver(CT_PageURL.SE_WEB_API_URL);
        WebElement passwordFormElement = driver.findElement(By.id("password"));
        System.out.println("passwordElement: " + passwordFormElement);
    }
}
