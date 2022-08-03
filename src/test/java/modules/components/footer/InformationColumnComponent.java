package modules.components.footer;

import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(value=".column.information")
public class InformationColumnComponent extends FooterColumnComponent {
    public InformationColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
