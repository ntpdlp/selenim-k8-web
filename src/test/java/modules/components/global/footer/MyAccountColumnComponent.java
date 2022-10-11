package modules.components.global.footer;

import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(value=".column.my-account")
public class MyAccountColumnComponent extends FooterColumnComponent {
    public MyAccountColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
