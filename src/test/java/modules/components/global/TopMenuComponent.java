package modules.components.global;

import modules.components.Component;
import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@ComponentCSSSelector(value=".top-menu")
public class TopMenuComponent extends Component {
    public TopMenuComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<MainCatItemComponent> mainCatItemsElem(){
        return findComponents(MainCatItemComponent.class,driver);
    }



    @ComponentCSSSelector(value=".top-menu > li")
    public static class MainCatItemComponent extends Component{
        public MainCatItemComponent(WebDriver driver, WebElement component) {
            super(driver, component);
        }

        public WebElement catItemLinkElem(){
            return component.findElement(By.tagName("a"));
        }

        public List<SubListComponent> sublistComps(){
            Actions actions = new Actions(driver);
            actions.moveToElement(component).perform();
            return findComponents(SubListComponent.class,driver);
        }
    }

    @ComponentCSSSelector(value=".sublist li a")
    public static class SubListComponent extends Component{

        public SubListComponent(WebDriver driver, WebElement component) {
            super(driver, component);
        }
    }





}
