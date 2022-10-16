package modules.components.checkout;

import modules.components.Component;
import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ComponentCSSSelector("#opc-payment_method")
public class PaymentMethodComponent extends Component {

    public final static By codSel = By.cssSelector("[value='Payments.CashOnDelivery']");
    public final static By checkMoneyOrderSel = By.cssSelector("[value='Payments.CheckMoneyOrder']");
    public final static By creditCardSel = By.cssSelector("[value='Payments.Manual']");
    public final static By purchaseOrderSel = By.cssSelector("[value='Payments.PurchaseOrder']");
    public final static By continueBtnSel = By.cssSelector(".payment-method-next-step-button");

    public PaymentMethodComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void selectCODMethod(){
        component.findElement(codSel).click();
    }

    public void selectCheckMoneyOrderMethod(){
        component.findElement(checkMoneyOrderSel).click();
    }

    public void selectCreditCardMethod(){
        component.findElement(creditCardSel).click();
    }

    public void selectPurchaseOrderMethod(){
        component.findElement(purchaseOrderSel).click();
    }

    public void clickOnContinueBtn(){
        WebElement continueBtn = component.findElement(continueBtnSel);
        continueBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(continueBtn));
    }
}
