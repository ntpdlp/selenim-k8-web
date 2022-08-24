package test.computer;

import modules.components.computer.CheapComputerDetailEssentialComponent;
import modules.components.computer.OwnComputerDetailEssentialComponent;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.computer.OrderComputerFlow;
import url.Urls;

public class TestBuildYourOwnComputer extends BaseTest {

    @Test
    public void TC01_BuildYourOwnComputer(){
        driver.get(Urls.baseUrlWebDemo.concat("/build-your-own-computer"));
        OrderComputerFlow<OwnComputerDetailEssentialComponent> order = new OrderComputerFlow<>(driver,OwnComputerDetailEssentialComponent.class);
        order.buildComputerAndAddtoCart();
    }
}
