package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.ExpectedConditionExWaitDynamicControl;
import support.ui.ExpectedConditionExWaitMore2Tabs;
import url.Urls;

import java.time.Duration;

public class L18DynamicControls implements Urls {

    static private By checkboxFormSel = By.cssSelector("#checkbox-example");
    static private By inputFormSel = By.cssSelector("#input-example");
    public static void main(String[] args) {
       WebDriver driver = DriverFactory.getChromeDriver();

       try{
           driver.get(Urls.baseUrl.concat(dynamicControlSlug));

           //apply narrow search technique
           System.out.println("Form 1");
           WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
           WebElement checkboxElem = checkboxFormElem.findElement(By.tagName("input"));
           if(!checkboxElem.isSelected()) checkboxElem.click();
           Thread.sleep(2000);

           System.out.println("Form 2");
           WebElement inputFormElem = driver.findElement(inputFormSel);
           WebElement inputElem = inputFormElem.findElement(By.tagName("input"));
           WebElement enableButtonElem = inputFormElem.findElement(By.tagName("button"));
           if(!inputElem.isEnabled()){
               enableButtonElem.click();
               WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
               wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
           }
           inputElem.sendKeys("hello dynamic control!");
           Thread.sleep(2000);

       }catch (Exception e){
           e.printStackTrace();
       }

       driver.quit();
    }
}
