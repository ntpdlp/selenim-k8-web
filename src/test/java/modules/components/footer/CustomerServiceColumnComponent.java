package modules.components.footer;

import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(value=".column.customer-service")
public class CustomerServiceColumnComponent extends FooterColumnComponent {
    public CustomerServiceColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
