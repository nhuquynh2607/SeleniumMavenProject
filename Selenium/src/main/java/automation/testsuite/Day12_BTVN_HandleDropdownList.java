package automation.testsuite;

import automation.common.commonBase;
import automation.constant.CT_PageURL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Day12_BTVN_HandleDropdownList extends commonBase {
    @Test
    public void handelDropdownlist() {
        driver = initChromeDriver(CT_PageURL.GLOBALS_URL);
        WebElement countryDropdown = driver.findElement(By.xpath("//p//select"));
        Select selectCountry = new Select(countryDropdown);

        selectCountry.selectByVisibleText("Viet Nam");
        String actualText1 = selectCountry.getFirstSelectedOption().getText();
        assertEquals(actualText1, "Viet Nam");

    }
}
