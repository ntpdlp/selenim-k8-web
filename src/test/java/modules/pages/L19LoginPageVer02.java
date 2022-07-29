package modules.pages;

import modules.components.L19LoginFormComponent;
import org.openqa.selenium.WebDriver;

public class L19LoginPageVer02 {

    protected WebDriver driver;

    public L19LoginPageVer02(WebDriver driver) {
        this.driver = driver;
    }

    public L19LoginFormComponent loginFormComp(){
        return new L19LoginFormComponent(driver);
    }
}
