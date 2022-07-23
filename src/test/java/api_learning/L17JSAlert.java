package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;
import java.util.List;

public class L17JSAlert implements Urls {

    private static By jsAlert = By.cssSelector("[onclick=\"jsAlert()\"]");
    private static By jsConfirm = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private static By jsPrompt = By.cssSelector("[onclick=\"jsPrompt()\"]");

    //waiting time
    private static final int MILLION_SECONDS = 2000;
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get(baseUrl.concat(jsAlertSlug));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            //JSAlert
            navigateJSAlert(driver,wait, jsAlert ,true);
            Thread.sleep(MILLION_SECONDS);

            //JSConfirm
            navigateJSAlert(driver,wait, jsConfirm ,true);
            Thread.sleep(MILLION_SECONDS);

            //JSPrompt
            navigateJSAlertAndProvidePrompt(driver,wait,jsPrompt,true);
            Thread.sleep(MILLION_SECONDS);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    public static Alert getJSAlert(WebDriver driver, WebDriverWait wait, By bySelector) throws InterruptedException {

        Alert jsAlert=null;
        try{
            driver.findElement(bySelector).click();
            jsAlert = wait.until(ExpectedConditions.alertIsPresent());
            Thread.sleep(MILLION_SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsAlert;
    }

    public static void navigateJSAlert(WebDriver driver, WebDriverWait wait, By bySelector, boolean isAccept){
        try{
            Alert jsAlert = getJSAlert(driver,wait,bySelector);
            System.out.println(jsAlert.getText());
            if(isAccept){
                jsAlert.accept();
            }else{
                jsAlert.dismiss();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void navigateJSAlertAndProvidePrompt(WebDriver driver, WebDriverWait wait, By bySelector,boolean isAccept){

        try{
            Alert jsAlert = getJSAlert(driver,wait,bySelector);
            jsAlert.sendKeys("Hi There!! million times");
            Thread.sleep(MILLION_SECONDS);
            if(isAccept){
                jsAlert.accept();
            }else{
                jsAlert.dismiss();
            }
            System.out.println(driver.findElement(By.id("result")).getText());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
