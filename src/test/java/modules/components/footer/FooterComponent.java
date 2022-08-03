package modules.components.footer;

import modules.components.Component;
import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(value=".footer")
public class FooterComponent extends Component {
    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public InformationColumnComponent InformationComp(){
        return new InformationColumnComponent(driver,component);
    }

    public CustomerServiceColumnComponent CustomerServiceComp(){
        return new CustomerServiceColumnComponent(driver,component);
    }

    public MyAccountColumnComponent MyAccountComp(){
        return new MyAccountColumnComponent(driver,component);
    }

    public FollowUsColumnComponent FollowUsComp(){
        return new FollowUsColumnComponent(driver,component);
    }
}
