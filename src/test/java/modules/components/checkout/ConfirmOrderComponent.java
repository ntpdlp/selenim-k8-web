package modules.components.checkout;

import modules.components.Component;
import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector("#opc-confirm_order")
public class ConfirmOrderComponent extends Component {
    public ConfirmOrderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
