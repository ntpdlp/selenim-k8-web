package test.computer;

import modules.components.computer.CheapComputerDetailEssentialComponent;
import modules.pages.BasePage;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.computer.OrderComputerFlow;
import url.Urls;

public class TestBuildYourCheapComputer extends BaseTest {

    @Test
    public void TC01_BuildYourOwnCheapComputer(){
        driver.get(Urls.baseUrlWebDemo.concat("/build-your-cheap-own-computer"));
        OrderComputerFlow<CheapComputerDetailEssentialComponent> order = new OrderComputerFlow<>(driver,CheapComputerDetailEssentialComponent.class);
        order.buildComputerAndAddtoCart();
    }
}
