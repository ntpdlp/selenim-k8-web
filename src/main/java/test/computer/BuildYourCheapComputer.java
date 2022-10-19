package test.computer;

import modules.components.computer.CheapComputerDetailEssentialComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.computer.OrderComputerFlow;
import testdata.DataObjectBuilder;
import testdata.computer.ComputerDataModel;
import url.Urls;

public class BuildYourCheapComputer extends BaseTest {

    @Test(dataProvider = "computerData")
    public void TC01_BuildYourOwnCheapComputer(ComputerDataModel computerDataModel){
        WebDriver driver = getDriver();
        driver.get(Urls.baseUrlWebDemo.concat("/build-your-cheap-own-computer"));
        OrderComputerFlow<CheapComputerDetailEssentialComponent> order = new OrderComputerFlow<>(driver,CheapComputerDetailEssentialComponent.class,computerDataModel);
        order.buildComputerAndAddtoCart();

    }

    @DataProvider
    public ComputerDataModel[] computerData(){
        String relativeFileLocation = "/src/main/java/testdata/computer/CheapComputerData.json";
        return DataObjectBuilder.buildDataObjectFrom(relativeFileLocation,ComputerDataModel[].class);
    }
}
