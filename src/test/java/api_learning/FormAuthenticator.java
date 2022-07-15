package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAuthenticator {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get("https://the-internet.herokuapp.com/login");
            Thread.sleep(1000);
            driver.findElement(By.id("username")).sendKeys("QA");
            driver.findElement(By.name("password")).sendKeys("password");
            driver.findElement(By.cssSelector("[type='submit']")).click();
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
