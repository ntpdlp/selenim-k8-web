package modules.components.checkout;

import modules.components.Component;
import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector("#opc-payment_method")
public class PaymentMethodComponent extends Component {
    public PaymentMethodComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
