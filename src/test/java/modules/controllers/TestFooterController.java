package modules.controllers;

import driver.DriverFactory;
import modules.components.footer.*;
import modules.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import url.Urls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFooterController implements Urls {




//    @BeforeTest
//    public void setup(){
//        WebDriver driver = DriverFactory.getChromeDriver();
//    }

    @Test
    public void testFooterHomePage(){
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(Urls.baseUrlWebDemo);
        try{
            HomePage homePage = new HomePage(driver);
            InformationColumnComponent informationColumnComp=homePage.footerComp().InformationComp();
            CustomerServiceColumnComponent customerServiceColumnComp=homePage.footerComp().CustomerServiceComp();
            MyAccountColumnComponent myAccountColumnComp=homePage.footerComp().MyAccountComp();
            FollowUsColumnComponent followUsColumnComp=homePage.footerComp().FollowUsComp();

            testFooterColumn(informationColumnComp);
            testFooterColumn(customerServiceColumnComp);
            testFooterColumn(myAccountColumnComp);
            testFooterColumn(followUsColumnComp);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();

    }

    @Test
    public void testFooterRegisterPage(){
        String actualResult = "actual";
        String expectedResult = "expected";
        Assert.assertEquals(actualResult,expectedResult,"[ERR] register message is incorrect");

    }

    @Test(dependsOnMethods = {"testFooterLoginPage"})
    public void testFooterCategoryPage(){


    }

    @Test
    public void testFooterLoginPage(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1,3);
        softAssert.assertEquals(3,3);
        softAssert.assertEquals(true,false);
        softAssert.assertAll();
        System.out.println("hello");

    }

    private static void testFooterColumn(FooterColumnComponent footerColumnComp){
        System.out.println(footerColumnComp.h3Elem().getText());
        footerColumnComp.linksElem().forEach( link ->{
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
