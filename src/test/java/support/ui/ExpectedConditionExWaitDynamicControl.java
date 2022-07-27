package support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExpectedConditionExWaitDynamicControl implements ExpectedCondition<Boolean> {

    private By cssSel;

    public ExpectedConditionExWaitDynamicControl(By cssSel) {
        this.cssSel = cssSel;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        return driver.findElement(this.cssSel).isEnabled();
    }
}
