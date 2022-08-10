package test_flows.global;

import modules.components.footer.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    public void verifyFooterComponent()
    {
        System.out.println("test flow footer test");

    }

    private void verifyFooterFollowUsColumn(FooterColumnComponent fu) {
        List<String> linkText = new ArrayList<>();
        List<String> hrefs=new ArrayList<>();
        verifyFooterColumn(fu,linkText,hrefs);
    }

    private void verifyFooterMyAccountColumn(FooterColumnComponent mc) {
        List<String> linkText = new ArrayList<>();
        List<String> hrefs=new ArrayList<>();
        verifyFooterColumn(mc,linkText,hrefs);
    }

    private void verifyFooterCustomerServiceColumn(FooterColumnComponent cs) {
        List<String> linkText = new ArrayList<>();
        List<String> hrefs=new ArrayList<>();
        verifyFooterColumn(cs,linkText,hrefs);
    }

    private void verifyFooterInformationColumn(FooterColumnComponent inf) {
        List<String> explinkText = Arrays.asList("Sitemap","Shipping & Return","Privacy Notice","Conditions of Use","About us","Contact us");
        List<String> exphrefs= Arrays.asList("/sitemap","/shipping-returns","/privacy-policy","/conditions-of-use","/about-us","/contactus");
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
        //validate empty?
        if(actualLinkTexts.isEmpty() || actualHrefs.isEmpty()){
            Assert.fail("[ERR] Texts of Hyperlinks are empty in footer");
        }

        //validate LinkTexts
        Assert.assertEquals(actualLinkTexts,expectedLinkTexts,"[ERR] linkTexts are not matching actual & expected ");
        Assert.assertEquals(actualHrefs,expectedHrefs,"[ERR] Hrefs are not matching actual & expected ");
        //validate Hrefs
    }
}
