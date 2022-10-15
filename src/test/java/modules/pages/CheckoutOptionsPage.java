package modules.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOptionsPage extends BasePage{

    private static final By checkoutAsGuestBtn = By.cssSelector(".checkout-as-guest-button");

    public CheckoutOptionsPage(WebDriver driver) {
        super(driver);
    }

    public void checkoutAsGuest(){
        component.findElement(checkoutAsGuestBtn).click();
    }
}
