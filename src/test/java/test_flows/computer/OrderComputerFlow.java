package test_flows.computer;

import modules.components.computer.ComputerDetailEssentialComponent;
import modules.pages.ComputerDetailPage;
import org.openqa.selenium.WebDriver;
import testdata.computer.ComputerDataModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerFlow<T extends ComputerDetailEssentialComponent> {

    private final WebDriver driver;
    private final Class<T> computerEssentialComp;
    private final ComputerDataModel computerDataModel;




    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComp,ComputerDataModel computerDataModel) {
        this.driver = driver;
        this.computerEssentialComp = computerEssentialComp;
        this.computerDataModel = computerDataModel;
    }

    public void buildComputerAndAddtoCart(){
        ComputerDetailPage computerDetailPage = new ComputerDetailPage(driver);
        T computerComp = computerDetailPage.computerComp(computerEssentialComp);
        String processorTypeStr = computerComp.selectProcessorType(computerDataModel.getProcessorType());
        double processorAdditionalPrice = extractAdditionalPrice(processorTypeStr);
        System.out.println("processorAdditionalPrice: " + processorTypeStr);

        String ramTypeStr = computerComp.selectRAMType(computerDataModel.getRam());
        double ramAdditionalPrice = extractAdditionalPrice(ramTypeStr);
        System.out.println("ramAdditionalPrice: " + ramTypeStr);

        double additionalOSPrice=0.0;
        if(computerDataModel.getOs() != null){
            String osStr = computerComp.selectOS(computerDataModel.getOs());
            additionalOSPrice = extractAdditionalPrice(osStr);
            System.out.println("additionalOSPrice: " + osStr);
        }

        computerComp.selectHDD(computerDataModel.getHdd());
        computerComp.selectSoftware(computerDataModel.getSoftware());


    }



    private double extractAdditionalPrice(String item){
        double price = 0.0;

        try{
            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(item);
            if(matcher.find()){
                price = Double.parseDouble(matcher.group(1).replaceAll("[-+]]",""));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(price);
        return price;
    }
}
