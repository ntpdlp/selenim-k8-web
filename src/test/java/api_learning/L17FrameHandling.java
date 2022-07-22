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
            driver.get(baseUrl.concat(iframeSlug));
            WebElement iframe = driver.findElement(By.cssSelector("[id$=\"_ifr\"]"));
            driver.switchTo().frame(iframe);
            WebElement paragraphElem = driver.findElement(By.id("tinymce"));
            paragraphElem.click();
            paragraphElem.clear();
            paragraphElem.sendKeys("hello, summer !!");
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
