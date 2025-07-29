package automation.testsuite;

import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.common.commonBase;
import org.testng.annotations.*;


public class Day8_Practice extends commonBase{
    @Test
   public void getElementById()
    {
        driver = initChromeDriver(CT_PageURL.ALADA_URL);
        WebElement emailElement = driver.findElement(By.id("txtLoginUsername"));
        System.out.println("emailElement: " + emailElement);
    }

    @Test
    public void getElementByName()
    {

        driver = initChromeDriver(CT_PageURL.ALADA_URL);
        WebElement passElement = driver.findElement(By.name("txtLoginPassword"));
        System.out.println("PassElement: "+passElement);
    }

    @Test
    public void getElementByLinkText()
    {

        driver = initChromeDriver(CT_PageURL.SELECT_HUB_URL);
        WebElement textFindOut = driver.findElement(By.linkText("Find out how to automate these controls without XPath"));
        System.out.println("textFindOut: "+textFindOut);
    }

    @Test
    public void getElementByPartialLinkText()
    {
        driver = initChromeDriver(CT_PageURL.SELECT_HUB_URL);
        WebElement textCourse = driver.findElement(By.partialLinkText("A course with complex scenarios like"));
        System.out.println("textCourse: "+textCourse);
    }
}
