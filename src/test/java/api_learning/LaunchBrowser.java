package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class LaunchBrowser {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get("https://learn.sdetpro.com");
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
