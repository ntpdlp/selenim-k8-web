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
        return findComponent(InformationColumnComponent.class,driver);
    }

    public CustomerServiceColumnComponent CustomerServiceComp(){
        return findComponent(CustomerServiceColumnComponent.class,driver);
    }

    public MyAccountColumnComponent MyAccountComp(){
        return findComponent(MyAccountColumnComponent.class,driver);
    }

    public FollowUsColumnComponent FollowUsComp(){
        return findComponent(FollowUsColumnComponent.class,driver);
    }
}
