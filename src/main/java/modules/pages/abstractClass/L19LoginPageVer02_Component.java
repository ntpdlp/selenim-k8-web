package modules.pages.abstractClass;

import modules.components.anotation.LoginFormComponent;
import org.openqa.selenium.WebDriver;

public class L19LoginPageVer02_Component {

    protected WebDriver driver;

    public L19LoginPageVer02_Component(WebDriver driver) {
        this.driver = driver;
    }

    public LoginFormComponent loginFormComp(){
        return new LoginFormComponent(driver);
    }
}
