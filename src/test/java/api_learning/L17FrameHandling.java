package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectMyExt;
import url.Urls;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class L17FrameHandling implements Urls {

    private final static int FIRST_WINDOW = 0;
    private final static int SECOND_WINDOW = 1;
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(baseUrl.concat(iframeSlug));
            switchToEmbeddedIFrame(driver);

            System.out.println("From Application: return back to default frame for other tasks ....");
            driver.switchTo().defaultContent();

            driver.findElement(By.linkText("Elemental Selenium")).click();
            List<String> windowids = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windowids.get(SECOND_WINDOW));
            Thread.sleep(2000);
            System.out.println("The second tab windows url is: " + driver.getCurrentUrl());
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    public static void switchToEmbeddedIFrame(WebDriver driver){
        WebElement iframe = driver.findElement(By.cssSelector("[id$=\"_ifr\"]"));
        driver.switchTo().frame(iframe);
        WebElement paragraphElem = driver.findElement(By.id("tinymce"));
        paragraphElem.click();
        paragraphElem.clear();
        paragraphElem.sendKeys("hello, summer !!");
    }


}
