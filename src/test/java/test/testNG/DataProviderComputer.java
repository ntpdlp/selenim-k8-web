package test.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testdata.DataObjectBuilder;
import testdata.computer.ComputerDataModel;

import javax.xml.crypto.Data;

public class DataProviderComputer {

    @Test(dataProvider = "computerData")
    public void testDataProvider(ComputerDataModel[] computers){
        for (ComputerDataModel computer : computers) {
            System.out.println(computer);
        }
    }

    @DataProvider
    public ComputerDataModel[] computerData(){
        String relativeFileLocation = "/src/test/java/testdata/computer/StandardComputerData.json";
        return DataObjectBuilder.buildDataObjectFrom(relativeFileLocation,ComputerDataModel[].class);

    }


}
