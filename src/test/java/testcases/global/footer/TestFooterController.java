package testcases.global.footer;

import driver.DriverFactory;
import modules.components.global.footer.CustomerServiceColumnComponent;
import modules.components.global.footer.FollowUsColumnComponent;
import modules.components.global.footer.InformationColumnComponent;
import modules.components.global.footer.MyAccountColumnComponent;
import modules.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_flows.global.FooterTestFlow;
import url.Urls;

public class TestFooterController {

//    @BeforeTest
//    public void setup(){
//        WebDriver driver = DriverFactory.getChromeDriver();
//    }

    @Test
    public void testFooterHomePage(){
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(Urls.baseUrlWebDemo);
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyProductCatFooterComponent();

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }

//    @Test
//    public void testFooterRegisterPage(){
//        String actualResult = "actual";
//        String expectedResult = "expected";
//        Assert.assertEquals(actualResult,expectedResult,"[ERR] register message is incorrect");
//
//    }
//
//    @Test
//    public void testFooterCategoryPage(){
//
//    }
//
//    @Test
//    public void testFooterLoginPage(){
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(1,1);
//        softAssert.assertEquals(3,3);
//        softAssert.assertAll();
//
//    }


}
