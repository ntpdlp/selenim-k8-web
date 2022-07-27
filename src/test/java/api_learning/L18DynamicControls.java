package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.ExpectedConditionExWaitMore2Tabs;
import url.Urls;

import java.time.Duration;

public class L18DynamicControls implements Urls {

    static private By taolaoSel = By.cssSelector("#nofoundID");
    public static void main(String[] args) {
       WebDriver driver = DriverFactory.getChromeDriver();

       try{
           driver.get(Urls.baseUrl.concat(loginSlug));

           //explicitwait
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(taolaoSel));
           wait.until(new ExpectedConditionExWaitMore2Tabs(taolaoSel));
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
