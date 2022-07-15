package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver getChromeDriver(){
        String projectPath = System.getProperty("user.dir");
        String chromeDriverPath="";

        if(OS.isFamilyMac()){
            chromeDriverPath = projectPath + "/src/test/resources/drivers/chromedriver";
        }else if (OS.isFamilyWindows()){
            chromeDriverPath = projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        }

        System.out.println(chromeDriverPath);
        if(chromeDriverPath.isEmpty()){
            throw new IllegalArgumentException("invalid OS !!");
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito"); //Incognito mode is a safe mode of opening a browser.

        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        return driver;
    }

}
