package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class Day12_RadioButton extends commonBase {
    @Test
    public void checkMale() {
        driver = initChromeDriver(CT_PageURL.DemoQA_URL);
        scrollToElement(By.id("userNumber"));

        WebElement radioMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        boolean rdoMale = radioMale.isSelected();
        //1. Kiểm tra giá trị mặc định
        assertEquals(rdoMale, false);
        //2. Click Male
        if (radioMale.isEnabled() == true) {
            radioMale.click();
            System.out.println("Radio male was clicked");
        }
    }

        @Test
        public void checkFeMale()
        {
            driver = initChromeDriver(CT_PageURL.DemoQA_URL);
            scrollToElement(By.id("userNumber"));

            WebElement radioFeMale = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
            boolean rdoFeMale = radioFeMale.isSelected();
            //1. Kiểm tra giá trị mặc định
            assertEquals(rdoFeMale, false);
            //2. Click Male
            if(radioFeMale.isEnabled()==true)
            {
                radioFeMale.click();
                System.out.println("Radio female was clicked");
            }

    }

    @Test
    public void checkOther()
    {
        driver = initChromeDriver(CT_PageURL.DemoQA_URL);
        scrollToElement(By.id("userNumber"));

        WebElement radioOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        boolean rdoOther = radioOther.isSelected();
        //1. Kiểm tra giá trị mặc định
        assertEquals(rdoOther, false);
        //2. Click Male
        if(radioOther.isEnabled()==true)
        {
            radioOther.click();
            System.out.println("Radio other was clicked");
        }

    }

    @AfterMethod
    public void closeBroswer()
    {
        driver.close();
    }
}
