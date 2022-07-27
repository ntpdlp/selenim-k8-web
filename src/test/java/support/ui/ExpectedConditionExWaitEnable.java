package support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExpectedConditionExWaitEnable implements ExpectedCondition<Boolean> {

    private By cssSel;

    public ExpectedConditionExWaitEnable(By cssSel) {
        this.cssSel = cssSel;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        return driver.findElement(this.cssSel).isEnabled();
    }
}
