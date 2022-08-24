package test;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeTest
    public void startTest(){
        driver = DriverFactory.getChromeDriver();
    }

    @AfterTest
    public void cleanupTest(){
        driver.quit();
    }

    @AfterMethod
    public void captureScreenShot(ITestResult testResult){
        //1.get TCName then create TCName + yyyy-mm-dd-hr-mn-ss.png
        String testcaseName = testResult.getName();
        Calendar calendar = new GregorianCalendar();
        int yr = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH) + 1;
        int dd = calendar.get(Calendar.DATE);
        int hr = calendar.get(Calendar.HOUR);
        int mn = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);
        String screenshot = testcaseName + "-" + yr + mm + dd + "-" + hr + mn + ss + ".png";

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File fileScreenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            String fileLocation = System.getProperty("user.dir") + "/reports/" + screenshot;
            FileUtils.copyFile(fileScreenShot,new File(fileLocation));

            Path content = Paths.get(fileLocation);
            try (InputStream is = Files.newInputStream(content)) {
                Allure.addAttachment(testcaseName, is);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
