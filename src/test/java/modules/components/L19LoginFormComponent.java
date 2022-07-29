package modules.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class L19LoginFormComponent {

    protected WebDriver driver;
    private By usernameSel = By.cssSelector("#username");
    private By passwordSel = By.cssSelector("#password");
    private By loginBtnSel = By.cssSelector("[type='submit']");

    public L19LoginFormComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void username(String username){
        driver.findElement(usernameSel).sendKeys(username);
    }

    public void password(String password){
        driver.findElement(passwordSel).sendKeys(password);
    }

    public void loginBtn(){
        driver.findElement(loginBtnSel).click();
    }
}


