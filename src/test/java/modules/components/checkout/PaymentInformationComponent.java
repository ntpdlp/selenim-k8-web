package modules.components.checkout;

import modules.components.Component;
import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector("#opc-payment_info")
public class PaymentInformationComponent extends Component {
    public PaymentInformationComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
