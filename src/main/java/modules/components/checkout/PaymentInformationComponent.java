package modules.components.checkout;

import modules.components.Component;
import modules.components.anotation.ComponentCSSSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import testdata.CreditCardType;

@ComponentCSSSelector("#opc-payment_info")
public class PaymentInformationComponent extends Component {

    private static final By creditCardDropdownSel = By.cssSelector("#CreditCardType");
    private static final By cardHolderNameSel = By.cssSelector("#CardholderName");
    private static final By cardNumberSel = By.cssSelector("#CardNumber");
    private static final By cardExpiredMonthDropdownSel = By.cssSelector("#ExpireMonth");
    private static final By cardExpiredYearDropdownSel = By.cssSelector("#ExpireYear");
    private static final By cardCodeSel = By.cssSelector("#CardCode");
    private static final By purchaseNumSel = By.cssSelector("#PurchaseOrderNumber");
    private static final By continueBtnSel = By.cssSelector(".payment-info-next-step-button");
    public PaymentInformationComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void selectCardType(CreditCardType creditCardType){
        if(creditCardType == null){
            throw new IllegalArgumentException("[ER] Credit card type can't be null!");
        }
        Select select = new Select(component.findElement(creditCardDropdownSel));
        switch (creditCardType){
            case VISA:
                select.selectByVisibleText("Visa");
                break;
            case AMEX:
                select.selectByVisibleText("Amex");
                break;
            case MASTER_CARD:
                select.selectByVisibleText("Master card");
                break;
            case DISCOVER:
                select.selectByVisibleText("Discover");
        }
    }

    public void inputCardHolderName(String name){
        component.findElement(cardHolderNameSel).sendKeys(name);
    }

    public void inputCardNumber(String number){
        component.findElement(cardNumberSel).sendKeys(number);
    }

    public void inputExpiredMonth(String month){
        Select select = new Select(component.findElement(cardExpiredMonthDropdownSel));
        select.selectByValue(month);
    }

    public void inputExpiredYear(String year){
        Select select = new Select(component.findElement(cardExpiredYearDropdownSel));
        select.selectByVisibleText(year);
    }

    public void inputCardCode(String code){
        component.findElement(cardCodeSel).sendKeys(code);
    }

    public void inputPurchaseNum(String number){
        component.findElement(purchaseNumSel).sendKeys(number);
    }

    public void clickOnContinueBtn(){
        WebElement continueBtn = component.findElement(continueBtnSel);
        continueBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(continueBtn));
    }

}
