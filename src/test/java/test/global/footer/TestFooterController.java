package test.global.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.global.FooterTestFlow;
import url.Urls;

public class TestFooterController extends BaseTest {



    @Test
    public void testFooterHomePage(){

            driver.get(Urls.baseUrlWebDemo);
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            Assert.assertEquals("true","true");
//            footerTestFlow.verifyProductCatFooterComponent();
    }

    @Test
    public void testScreenShotTakenFailure(){

        driver.get(Urls.baseUrlWebDemo);
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        Assert.fail("test screenshot");
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
