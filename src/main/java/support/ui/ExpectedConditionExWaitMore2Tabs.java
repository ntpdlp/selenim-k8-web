package support.ui;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ExpectedConditionExWaitMore2Tabs implements ExpectedCondition<Boolean> {

    private By cssSel;

    public ExpectedConditionExWaitMore2Tabs(By cssSel) {
        this.cssSel = cssSel;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        return driver.findElement(this.cssSel).getText().isEmpty();
    }
}
