package modules.controllers;

import driver.DriverFactory;
import modules.components.footer.*;
import modules.pages.HomePage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class TestFooterController implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            testFooterHomepage(driver);
            testFooterRegisterpage(driver);

        }catch(Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    private static void testFooterHomepage(WebDriver driver){
        driver.get(Urls.baseUrlWebDemo);
        HomePage homePage = new HomePage(driver);
        InformationColumnComponent informationColumnComp=homePage.footerComp().InformationComp();

        CustomerServiceColumnComponent customerServiceColumnComp=homePage.footerComp().CustomerServiceComp();

        MyAccountColumnComponent myAccountColumnComp=homePage.footerComp().MyAccountComp();

        FollowUsColumnComponent followUsColumnComp=homePage.footerComp().FollowUsComp();


        testFooterColumn(informationColumnComp);
        testFooterColumn(customerServiceColumnComp);
        testFooterColumn(myAccountColumnComp);
        testFooterColumn(followUsColumnComp);

    }

    private static void testFooterRegisterpage(WebDriver driver){
        driver.get(Urls.baseUrlWebDemo);

    }

    private static void testFooterColumn(FooterColumnComponent footerColumnComp){
        System.out.println(footerColumnComp.h3Elem().getText());
        footerColumnComp.linksElem().forEach( link ->{
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
