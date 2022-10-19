package modules.pages;

import modules.components.checkout.*;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public BillingAddressComponent billingAddressComp(){
        return findComponent(BillingAddressComponent.class, driver);
    }

    public ShippingAddressComponent shippingAddressComp(){
        return findComponent(ShippingAddressComponent.class, driver);
    }

    public ShippingMethodComponent shippingMethodComp(){
        return findComponent(ShippingMethodComponent.class, driver);
    }

    public PaymentMethodComponent paymentMethodComp(){
        return findComponent(PaymentMethodComponent.class, driver);
    }

    public PaymentInformationComponent paymentInformationComp(){
        return findComponent(PaymentInformationComponent.class, driver);
    }

    public ConfirmOrderComponent confirmOrderComp(){
        return findComponent(ConfirmOrderComponent.class, driver);
    }
}
