package test.computer;

import modules.components.computer.CheapComputerDetailEssentialComponent;
import modules.components.computer.OwnComputerDetailEssentialComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.computer.OrderComputerFlow;
import testdata.DataObjectBuilder;
import testdata.computer.ComputerDataModel;
import url.Urls;

public class TestBuildYourOwnComputer extends BaseTest {

    @Test(dataProvider = "computerData" )
    public void TC01_BuildYourOwnComputer(ComputerDataModel computerDataModel){
        driver.get(Urls.baseUrlWebDemo.concat("/build-your-own-computer"));
        OrderComputerFlow<OwnComputerDetailEssentialComponent> order = new OrderComputerFlow<>(driver,OwnComputerDetailEssentialComponent.class,computerDataModel);
        order.buildComputerAndAddtoCart();
    }

    @DataProvider
    public ComputerDataModel[] computerData(){
        String relativeFileLocation = "/src/test/java/testdata/computer/StandardComputerData.json";
        return DataObjectBuilder.buildDataObjectFrom(relativeFileLocation,ComputerDataModel[].class);
    }

}
