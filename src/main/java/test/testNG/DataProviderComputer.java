package test.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.DataObjectBuilder;
import testdata.computer.ComputerDataModel;

public class DataProviderComputer {

    @Test(dataProvider = "computerData", groups={"smoke"})
    public void testDataProvider(ComputerDataModel[] computers){
        for (ComputerDataModel computer : computers) {
            System.out.println(computer);
        }
    }

    @DataProvider
    public ComputerDataModel[] computerData(){
        String relativeFileLocation = "/src/main/java/testdata/computer/StandardComputerData.json";
        return DataObjectBuilder.buildDataObjectFrom(relativeFileLocation,ComputerDataModel[].class);

    }


}
