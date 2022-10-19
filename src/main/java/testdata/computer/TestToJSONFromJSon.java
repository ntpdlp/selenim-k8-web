package testdata.computer;

import com.google.gson.Gson;
import testdata.DataObjectBuilder;

public class TestToJSONFromJSon {


    public static void main(String[] args) {
//        exploreGsonFeatures();
        testDataBuilder();
    }

    private static void testDataBuilder() {
        String relativeFileLocation = "/src/main/java/testdata/computer/StandardComputerData.json";
        ComputerDataModel[] computers = DataObjectBuilder.buildDataObjectFrom(relativeFileLocation,ComputerDataModel[].class);
        for (ComputerDataModel computer : computers) {
            System.out.println(computer);
        }
    }

    private static void exploreGsonFeatures() {
        String JSONStrData = "  {\n" +
                "    \"processorType\": \"2.2GHz\",\n" +
                "    \"ram\": \"8GB\",\n" +
                "    \"os\": \"Ubuntu\",\n" +
                "    \"hdd\": \"400 GB\",\n" +
                "    \"software\": \"Microsoft Office\"\n" +
                "  }";
        Gson gson = new Gson();
        ComputerDataModel computer = gson.fromJson(JSONStrData,ComputerDataModel.class);
        System.out.println(computer);
    }


    //toJSON()




}
