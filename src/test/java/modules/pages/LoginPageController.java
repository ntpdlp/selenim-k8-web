package modules.pages;

import driver.DriverFactory;
import modules.pages.L19LoginPageVer01;
import modules.pages.L19LoginPageVer02;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginPageController implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get(Urls.baseUrl.concat(loginSlug));

            //Ver 01 : POM Page Object Module
            L19LoginPageVer01 loginPageV01 = new L19LoginPageVer01(driver);
            loginPageV01.username("user01");
            loginPageV01.password("12345");
            loginPageV01.loginBtn();
            Thread.sleep(1000);

            //Ver 02 : Apply Component concept
            L19LoginPageVer02 loginPageV02 = new L19LoginPageVer02(driver);
            loginPageV02.loginFormComp().username("user02");
            loginPageV02.loginFormComp().password("67890");
            loginPageV02.loginFormComp().loginBtn();
            Thread.sleep(1000);

        }catch(Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
