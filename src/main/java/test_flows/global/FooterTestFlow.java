package test_flows.global;

import modules.components.global.TopMenuComponent;

import modules.components.global.footer.FooterColumnComponent;
import modules.components.global.footer.FooterComponent;
import modules.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import url.Urls;
import verification.Verification;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow implements Urls {

    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent(){
        BasePage basePage = new BasePage(driver);
        FooterComponent footerComp = basePage.footerComp();
        verifyFooterInformationColumn(footerComp.InformationComp());
        verifyFooterMyAccountColumn(footerComp.MyAccountComp());
        verifyFooterCustomerServiceColumn(footerComp.CustomerServiceComp());
        verifyFooterFollowUsColumn(footerComp.FollowUsComp());
    }


    public void verifyFooterFollowUsColumn(FooterColumnComponent fu) {
        List<String> linkText = Arrays.asList("Facebook","Twitter","RSS","YouTube","Google+");
        List<String> hrefs=Arrays.asList("http://www.facebook.com/nopCommerce","https://twitter.com/nopCommerce",
                "http://demowebshop.tricentis.com/news/rss/1","http://www.youtube.com/user/nopCommerce",
                "https://plus.google.com/+nopcommerce");
        verifyFooterColumn(fu,linkText,hrefs);
    }

    public void verifyFooterMyAccountColumn(FooterColumnComponent mc) {
        List<String> linkText = Arrays.asList("My account","Orders","Addresses","Shopping cart","Wishlist");
        List<String> hrefs=Arrays.asList("customer/info","customer/orders","customer/addresses","cart","wishlist");
        verifyFooterColumn(mc,linkText,hrefs);
    }

    public void verifyFooterCustomerServiceColumn(FooterColumnComponent cs) {
        List<String> linkText = Arrays.asList("Search","News","Blog","Recently viewed products","Compare products list","New products");
        List<String> hrefs=Arrays.asList("search","news","blog","recentlyviewedproducts","compareproducts","newproducts");
        verifyFooterColumn(cs,linkText,hrefs);
    }

    public void verifyFooterInformationColumn(FooterColumnComponent inf) {
        List<String> explinkText = Arrays.asList("Sitemap","Shipping & Returns","Privacy Notice","Conditions of Use","About us","Contact us");
        List<String> exphrefs= Arrays.asList("sitemap","shipping-returns","privacy-policy","conditions-of-use","about-us","contactus");
        verifyFooterColumn(inf,explinkText,exphrefs);
    }

    public void printFooterColumn(FooterColumnComponent footerColumnComp){
        System.out.println(footerColumnComp.h3Elem().getText());
        footerColumnComp.linksElem().forEach( link ->{
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }


    public void verifyFooterColumn(FooterColumnComponent footerComp, List<String> expectedLinkTexts, List<String> expectedHrefs){
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs=new ArrayList<>();

        for (WebElement link : footerComp.linksElem()) {
            actualLinkTexts.add(link.getText().trim());
            actualHrefs.add(link.getAttribute("href"));
        }

        //validate LinkTexts,Hrefs
        Verification.verifyEquals(actualLinkTexts,expectedLinkTexts,"[ERR] LinkTexts are not matching actual & expected ");
        if(footerComp.getClass().getSimpleName().trim().equals("FollowUsColumnComponent")){
            Verification.verifyEquals(actualHrefs,expectedHrefs,"[ERR] Hrefs are not matching actual & expected");
        }else{
            //Verification.verifyEquals(actualHrefs,expectedHrefs.stream().map(s->Urls.baseUrlWebDemo.concat(s)).toList(),"[ERR] Hrefs are not matching actual & expected");
        }
    }

    public void verifyProductCatFooterComponent(){
        //random pick up an item
        BasePage basePage = new BasePage(driver);
        TopMenuComponent topMenuComp =  basePage.topMenuComponent();
        List<TopMenuComponent.MainCatItemComponent> mainCatsElem = topMenuComp.mainCatItemsElem();
        if(mainCatsElem.isEmpty()){
            Assert.fail("[ERR] There is no item in top menu");
        }

        for (TopMenuComponent.MainCatItemComponent mainCatElem : mainCatsElem) {
            System.out.println(mainCatElem.catItemLinkElem().getText());
            System.out.println(mainCatElem.catItemLinkElem().getAttribute("href"));
        }


        TopMenuComponent.MainCatItemComponent randomMainItemElem = mainCatsElem.get(new SecureRandom().nextInt(mainCatsElem.size()));
        String randomCatHref = randomMainItemElem.catItemLinkElem().getAttribute("href");
        System.out.println("....pick up randomly..... : " + randomCatHref);
        Actions actions = new Actions(driver);
        actions.moveToElement(randomMainItemElem.catItemLinkElem()).perform();

        //get sublist
        List<TopMenuComponent.SubListComponent> catItemsComp = randomMainItemElem.sublistComps();
        System.out.println(catItemsComp.size());
        if(catItemsComp.isEmpty()){
            randomMainItemElem.catItemLinkElem().click();
        }else{
            int randomIndex = new SecureRandom().nextInt(catItemsComp.size());
            TopMenuComponent.SubListComponent randomCatItemComp = catItemsComp.get(randomIndex);
            randomCatHref=randomCatItemComp.getComponent().getAttribute("href");
            randomCatItemComp.getComponent().click();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(randomCatHref));

        //verify footer on the new loading page from Product Category
        verifyFooterComponent();
    }
}
