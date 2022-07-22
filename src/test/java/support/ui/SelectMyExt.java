package support.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectMyExt extends Select {

    private final String OPTION_02 = "Option 2";
    public SelectMyExt(WebElement element) {
        super(element);
    }

    public void selectOption02(){
        System.out.println("Hi there, this is an EXTENSION method by user !!!");
        this.selectByVisibleText(OPTION_02);
    }
}
