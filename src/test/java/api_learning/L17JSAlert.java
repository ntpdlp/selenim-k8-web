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
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get(baseUrl.concat(jsAlertSlug));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            //JSAlert
            driver.findElement(jsAlert).click();
            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(jsAlert.getText());
            jsAlert.accept();
            Thread.sleep(1000);

            //JSConfirm
            driver.findElement(jsConfirm).click();
            Alert jsConfirm = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(jsConfirm.getText());
            jsConfirm.dismiss();
            Thread.sleep(1000);

            //JSPrompt
            driver.findElement(jsPrompt).click();
            Alert jsPrompt = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(jsPrompt.getText());
            jsPrompt.sendKeys("Hi !!");
            Thread.sleep(2000);
            jsPrompt.accept();
            System.out.println(driver.findElement(By.id("result")).getText());
            Thread.sleep(2000);


        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

}
