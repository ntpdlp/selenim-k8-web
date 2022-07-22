package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class L17ElementFindAnotherElement implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(baseUrl.concat(iframeSlug));
            WebElement iframe = driver.findElement(By.cssSelector("[id$=\"_ifr\"]"));
            switchToEmbeddedIframe(driver,iframe);
            returnBackDefaultFrame(driver);
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    public static void switchToEmbeddedIframe(WebDriver driver, WebElement iframe){
        driver.switchTo().frame(iframe);
        WebElement paragraphElem = driver.findElement(By.id("tinymce"));
        paragraphElem.click();
        paragraphElem.clear();
        paragraphElem.sendKeys("hello, summer !!");
    }

    public static void returnBackDefaultFrame(WebDriver driver){
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        System.out.println(driver.getCurrentUrl());
    }
}
