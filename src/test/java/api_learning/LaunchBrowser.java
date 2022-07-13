package api_learning;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String chromeDriverPath="";

        if(OS.isFamilyMac()){
            chromeDriverPath = projectPath + "/src/test/resources/drivers/chromedriver";
        }else if (OS.isFamilyWindows()){
            chromeDriverPath = projectPath + "\\src\\test\\resources\\drivers\\chromedriver";
        }

        System.out.println(chromeDriverPath);
        if(chromeDriverPath.isEmpty()){
            throw new IllegalArgumentException("invalid OS !!");
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito"); //Incognito mode is a safe mode of opening a browser.

        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://learn.sdetpro.com");

        try{
            Thread.sleep(1000);
        }catch (Exception e){
            throw new IllegalArgumentException("exception to cover thread");
        }

        driver.quit();

    }
}
