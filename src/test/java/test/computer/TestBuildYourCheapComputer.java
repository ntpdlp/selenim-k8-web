package test.computer;

import modules.components.computer.CheapComputerDetailEssentialComponent;
import modules.pages.BasePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.computer.OrderComputerFlow;
import testdata.DataObjectBuilder;
import testdata.computer.ComputerDataModel;
import url.Urls;

public class TestBuildYourCheapComputer extends BaseTest {

    @Test(dataProvider = "computerData")
    public void TC01_BuildYourOwnCheapComputer(ComputerDataModel computerDataModel){
        driver.get(Urls.baseUrlWebDemo.concat("/build-your-cheap-own-computer"));
        OrderComputerFlow<CheapComputerDetailEssentialComponent> order = new OrderComputerFlow<>(driver,CheapComputerDetailEssentialComponent.class,computerDataModel);
        order.buildComputerAndAddtoCart();
    }

    @DataProvider
    public ComputerDataModel[] computerData(){
        String relativeFileLocation = "/src/test/java/testdata/computer/CheapComputerData.json";
        return DataObjectBuilder.buildDataObjectFrom(relativeFileLocation,ComputerDataModel[].class);
    }
}
