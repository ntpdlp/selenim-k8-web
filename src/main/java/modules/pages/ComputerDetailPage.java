package modules.pages;

import modules.components.computer.ComputerDetailEssentialComponent;
import org.openqa.selenium.WebDriver;

public class ComputerDetailPage extends BasePage{
    public ComputerDetailPage(WebDriver driver) {
        super(driver);
    }

    public<T extends ComputerDetailEssentialComponent> T computerComp(Class<T> computerEssentialCompClass){
        return findComponent(computerEssentialCompClass,driver);
    }
}
