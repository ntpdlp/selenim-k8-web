package modules.pages;

import modules.components.cart.CartItemRowComponent;
import modules.components.cart.TotalComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public List<CartItemRowComponent> cartItemRowComponents(){
        return findComponents(CartItemRowComponent.class, driver);
    }


    public TotalComponent totalComp(){
        return findComponent(TotalComponent.class, driver);
    }
}
