package modules.components.computer;

import modules.components.order.BaseItemProductDetailComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ComputerDetailEssentialComponent extends BaseItemProductDetailComponent {

    private final static By allOptionsSel = By.cssSelector(".option-list input");

    public ComputerDetailEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public abstract String selectProcessorType(String type);
    public abstract String selectRAMType(String type);

    public void unselectDefaultOptions(){
        List<WebElement> allOptionsElem = component.findElements(allOptionsSel);
        allOptionsElem.forEach(option -> {
            if(option.getAttribute("checked") !=null){
                option.click();
            }
        });
    }

    //HDD, OS, Software
    public String selectHDD(String type){
        return selectOption(type);
    }

    public String selectOS(String type){
        return selectOption(type);
    }

    public String selectSoftware(String type){
        return selectOption(type);
    }


    protected String selectOption(String type){
        String optionSelStr = "//label[contains(text(),'placeHolder')]";
        By optionSel = By.xpath(optionSelStr.replace("placeHolder",type));

        WebElement optionElem = null;

        try{
            optionElem = component.findElement(optionSel);
        }catch (Exception ignore){}

        if(optionElem!=null){
            optionElem.click();
        }else{
            throw new RuntimeException("[ERR] no element found.");
        }

        return optionElem.getText();
    }

}
