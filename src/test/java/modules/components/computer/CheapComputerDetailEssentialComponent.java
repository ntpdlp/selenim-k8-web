package modules.components.computer;

import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCSSSelector(".product-essential")
public class CheapComputerDetailEssentialComponent extends ComputerDetailEssentialComponent{
    public CheapComputerDetailEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        return selectOption(type);
    }

    @Override
    public String selectRAMType(String type) {
        return selectOption(type);
    }
}
