package test_flows.global;

import modules.components.footer.*;

public class FooterTestFlow {
    public void verifyFooterComponent(InformationColumnComponent inf, CustomerServiceColumnComponent cs, MyAccountColumnComponent mc, FollowUsColumnComponent fu)
    {
        System.out.println("test flow footer test");
        verifyFooterInformationColumn(inf);
        verifyFooterCustomerServiceColumn(cs);
        verifyFooterMyAccountColumn(mc);
        verifyFooterFollowUsColumn(fu);
    }

    private void verifyFooterFollowUsColumn(FollowUsColumnComponent fu) {
        testFooterColumn(fu);
    }

    private void verifyFooterMyAccountColumn(MyAccountColumnComponent mc) {
        testFooterColumn(mc);
    }

    private void verifyFooterCustomerServiceColumn(CustomerServiceColumnComponent cs) {
        testFooterColumn(cs);
    }

    private void verifyFooterInformationColumn(InformationColumnComponent inf) {
        testFooterColumn(inf);
    }


    public void testFooterColumn(FooterColumnComponent footerColumnComp){
        System.out.println(footerColumnComp.h3Elem().getText());
        footerColumnComp.linksElem().forEach( link ->{
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }
}
