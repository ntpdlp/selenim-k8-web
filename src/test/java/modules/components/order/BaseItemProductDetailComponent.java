package modules.components.order;

import modules.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseItemProductDetailComponent extends Component {

    private final static By barNotificationContentSel = By.cssSelector("#bar-notification");
    private final static By productPriceSel = By.cssSelector(".product-price");
    private final static By addToCartBtnSel = By.cssSelector(".add-to-cart-button");

    public BaseItemProductDetailComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public double productPrice(){
        String productPriceText = component.findElement(productPriceSel).getText().trim();
        return Double.parseDouble(productPriceText);
    }

    public void clickOnAddToCartBtn(){
        component.findElement(addToCartBtnSel).click();
    }

    public void waitUntilItemAddedToCart(){
        String successMsg = "The product has been added to your shopping cart";
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(barNotificationContentSel, successMsg));
        } catch (TimeoutException e){
            clickOnAddToCartBtn();
        }
    }
}
