package modules.pages;

import modules.components.Component;
import modules.components.global.footer.FooterComponent;
import modules.components.global.TopMenuComponent;
import modules.components.global.headers.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Component {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        super(driver,driver.findElement(By.tagName("html")));
        this.driver=driver;
    }

    public HeaderComponent headerComp(){
        return findComponent(HeaderComponent.class,driver);
    }

    public TopMenuComponent topMenuComponent(){
        return findComponent(TopMenuComponent.class,driver);
    }

    public FooterComponent footerComp(){
        return findComponent(FooterComponent.class,driver);
    }

}
