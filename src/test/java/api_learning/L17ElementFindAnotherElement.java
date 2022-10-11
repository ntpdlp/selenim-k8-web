package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.util.List;

public class L17ElementFindAnotherElement implements Urls {

    private static By figureSel = By.cssSelector(".figure");
    private static By figureLinkSel = By.cssSelector(".figcaption a");
    private static By figureLabelSel = By.cssSelector(".figcaption h5");
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        Actions actions = new Actions(driver);
        WebElement figureLink;
        WebElement figureLabel;
        try{
            driver.get(baseUrl.concat(hoverSlug));
            List<WebElement> figureElems = driver.findElements(figureSel);
            System.out.println(figureElems.size());
            for (WebElement figureElem : figureElems) {
                figureLink = figureElem.findElement(figureLinkSel);
                figureLabel = figureElem.findElement(figureLabelSel);

                actions.moveToElement(figureElem).perform();
                Thread.sleep(1000);
                System.out.println(figureLabel.getText());
            }

            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

}
