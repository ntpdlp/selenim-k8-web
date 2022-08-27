package modules.components.global.headers;

import modules.components.Component;
import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(value = ".header")
public class HeaderComponent extends Component {

    private final static By shoppingCartLinkSel = By.cssSelector("#topcartlink");

    public HeaderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickOnShoppingCartLink(){
        WebElement shoppingCartLinkElem = component.findElement(shoppingCartLinkSel);
        scrollUpToElement(shoppingCartLinkElem);
        shoppingCartLinkElem.click();
    }
}
