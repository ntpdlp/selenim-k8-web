package modules.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FooterColumnComponent extends FooterComponent {

    private final static By h3Sel = By.tagName("h3");
    private final static By linksSel = By.cssSelector("li a");

    public FooterColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement h3Elem(){
        return findElement(h3Sel);
    }

    public List<WebElement> linksElem(){
        return findElements(linksSel);
    }


}
