package modules.components.checkout;

import modules.components.Component;
import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ComponentCSSSelector("#opc-shipping_method")
public class ShippingMethodComponent extends Component {

    private static final By continueBtnSel = By.cssSelector(".shipping-method-next-step-button");

    public ShippingMethodComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public ShippingMethodComponent selectShippingMethod(String method){
        component
                .findElement(By.xpath("//label[contains(text(), \"" + method + "\")]"))
                .click();
        return this;
    }

    public void clickOnContinueButton(){
        WebElement continueBtn = component.findElement(continueBtnSel);
        continueBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(continueBtn));
    }

}
