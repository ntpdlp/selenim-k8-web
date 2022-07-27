package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.ExpectedConditionExWaitEnable;
import url.Urls;

import java.time.Duration;

public class L18JSExecutor implements Urls {

    public static void main(String[] args) {
       WebDriver driver = DriverFactory.getChromeDriver();

       try{
           driver.get(Urls.baseUrl.concat(floatMenuSlug));
           JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

           //scroll down
           jsExecutor.executeAsyncScript("window.scrollTo(0, document.body.scrollHeight);");
           Thread.sleep(1000);

           //scroll up : error
           jsExecutor.executeAsyncScript("window.scrollTo(document.body.scrollHeight,0);");
           Thread.sleep(1000);

       }catch (Exception e){
           e.printStackTrace();
       }

       driver.quit();
    }
}
