package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectMyExt;
import url.Urls;

public class L17FrameHandling implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(baseUrl.concat(dropdownSlug));
            WebElement dropdownElem = driver.findElement(By.id("dropdown"));
            SelectMyExt optionSelect = new SelectMyExt(dropdownElem);

            optionSelect.selectByIndex(1);
            Thread.sleep(1000);

            optionSelect.selectByValue("2");
            Thread.sleep(1000);

            optionSelect.selectByVisibleText("Option 1");
            Thread.sleep(1000);

            //extension by yourself
            optionSelect.selectOption02();
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
