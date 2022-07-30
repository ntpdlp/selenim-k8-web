package modules.pages;

import modules.components.anotation.LoginFormComponent;
import org.openqa.selenium.WebDriver;

public class L19LoginPageVer02 {

    protected WebDriver driver;

    public L19LoginPageVer02(WebDriver driver) {
        this.driver = driver;
    }

    public LoginFormComponent loginFormComp(){
        return new LoginFormComponent(driver);
    }
}
