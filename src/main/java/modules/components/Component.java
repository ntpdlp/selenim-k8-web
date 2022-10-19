package modules.components;

import modules.components.anotation.ComponentCSSSelector;
import modules.components.anotation.ComponentXPathSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class   Component {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement component;

    public Component(WebDriver driver, WebElement component){
        this.driver = driver;
        this.component = component;
        this.wait = new WebDriverWait(this.driver,Duration.ofSeconds(15)); //implicit wait generally
    }

    public WebElement getComponent(){
        return component;
    }

    public WebElement findElement(By by){
        return component.findElement(by);
    }

    public List<WebElement> findElements(By by){
        return component.findElements(by);
    }

    public <T extends Component> T findComponent( Class<T> commponentClass, WebDriver driver){
        return findComponents(commponentClass,driver).get(0);
    }

    public <T extends Component> List<T> findComponents( Class<T> commponentClass, WebDriver driver){
        //get component selector
        By componentSel;
        try{
            componentSel = getCompSelector(commponentClass);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERR] The component class must have annotation");
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(componentSel));
        List<WebElement> websElem = component.findElements(componentSel);

        //Constructor
        Class<T>[] params = new Class[]{WebDriver.class,WebElement.class};
        Constructor<T> constructor;
        try {
            constructor = commponentClass.getConstructor(params);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "[ERR] component class must have constructor with params: " + Arrays.toString(params));
        }

        //convert list<WebElem> -> list<Component>
        List<T> components = websElem.stream().map(webElem ->{
            try {
                return constructor.newInstance(driver,webElem);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        return components;
    }

    private By getCompSelector(Class<? extends Component> componentClass){
        if(componentClass.isAnnotationPresent(ComponentCSSSelector.class))
            return By.cssSelector(componentClass.getAnnotation(ComponentCSSSelector.class).value());
        else if (componentClass.isAnnotationPresent(ComponentXPathSelector.class)) {
            return By.xpath(componentClass.getAnnotation(ComponentXPathSelector.class).value());
        }else{
            throw new IllegalArgumentException("Component class "+ componentClass.getSimpleName() +
                    " must have annotation: " + ComponentCSSSelector.class.getSimpleName() +
                    " or, " + ComponentXPathSelector.class.getSimpleName());
        }
    }

    public void scrollUpToElement(WebElement element){
        scrollToElement("false", element);
    }

    public void scrollDownToElement(WebElement element){
        scrollToElement("true", element);
    }

    private void scrollToElement(String position, WebElement element){
        String script = "arguments[0].scrollIntoView(placeHolder);";
        ((JavascriptExecutor) driver).executeScript(script.replace("placeHolder",position), element);
    }
}
