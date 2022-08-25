package modules.components.computer;

import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ComponentCSSSelector(".product-essential")
public class OwnComputerDetailEssentialComponent extends ComputerDetailEssentialComponent{

    private static final By productAttributeSel = By.cssSelector("select[id^=\"product_attribute\"]");
    final int PROCESSOR_DROPDOWN_INDEX = 0;
    final int RAM_DROPDOWN_INDEX = 1;


    public OwnComputerDetailEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        WebElement processorDropdownElem =
                component.findElements(productAttributeSel).get(PROCESSOR_DROPDOWN_INDEX);
        return selectOption(processorDropdownElem, type);
    }

    @Override
    public String selectRAMType(String type) {
        WebElement ramDropdownElem =
                component.findElements(productAttributeSel).get(RAM_DROPDOWN_INDEX);
        return selectOption(ramDropdownElem, type);
    }

    private String selectOption(WebElement dropdownElem, String type){
        Select select = new Select(dropdownElem);
        List<WebElement> allOptions = select.getOptions();
        String fullStrOption = null;

        for (WebElement option : allOptions) {
            String currentOptionText = option.getText();
            String optionTextWithoutSpaces = currentOptionText.trim().replace(" ", "");
            if(optionTextWithoutSpaces.startsWith(type.trim().replace(" ", ""))){
                fullStrOption = currentOptionText;
                break;
            }
        }

        if (fullStrOption == null){
            throw new RuntimeException("[ERR] The option " + type + " is not existing to select!");
        }

        select.selectByVisibleText(fullStrOption);
        return fullStrOption;
    }


}
