package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

import java.time.Duration;

public class Day12_HandleCheckbox extends commonBase {

    @Test
    public void chooseHobbies()
    {
        driver = initChromeDriver(CT_PageURL.DemoQA_URL);
        scrollToElement(By.id("userNumber"));

        WebElement sportLabel = driver.findElement(By.xpath("//label[text()='Sports']"));
        boolean isSportSeleted = sportLabel.isSelected();
        if(isSportSeleted == false)
        {
            sportLabel.click();
            System.out.println("Chẹkbox Sport has been selected");
        }
        WebElement reading = driver.findElement(By.xpath("//label[text()='Reading']"));
        if(reading.isSelected() == false)
        {
            reading.click();
            System.out.println("Chẹkbox Reading has been selected");
        }
        WebElement music = driver.findElement(By.xpath("//label[text()='Music']"));
        if(music.isSelected()==false)
        {
            music.click();
            System.out.println("Chẹkbox Music has been selected");
        }
    }
}
