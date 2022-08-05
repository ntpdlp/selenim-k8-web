package modules.pages;

import modules.components.Component;
import modules.components.footer.FooterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Component {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        super(driver,driver.findElement(By.tagName("html")));
        this.driver=driver;
    }

    public FooterComponent footerComp(){
        return findComponent(FooterComponent.class,driver);
    }
}
