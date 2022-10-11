package test_flows.computer;

import modules.components.computer.CheapComputerDetailEssentialComponent;
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
    private final int quantity;
    private double totalItemPrice;




    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComp,ComputerDataModel computerDataModel) {
        this.driver = driver;
        this.computerEssentialComp = computerEssentialComp;
        this.computerDataModel = computerDataModel;
        this.quantity=1;
    }

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComp,ComputerDataModel computerDataModel, int quality) {
        this.driver = driver;
        this.computerEssentialComp = computerEssentialComp;
        this.computerDataModel = computerDataModel;
        this.quantity=quality;
    }

    public void buildComputerAndAddtoCart(){
        ComputerDetailPage computerDetailPage = new ComputerDetailPage(driver);
        T computerComp = computerDetailPage.computerComp(computerEssentialComp);
        String processorTypeStr = computerComp.selectProcessorType(computerDataModel.getProcessorType());
        double additionalPriceProcessor = extractAdditionalPrice(processorTypeStr);

        String ramTypeStr = computerComp.selectRAMType(computerDataModel.getRam());
        double additionalPriceRam = extractAdditionalPrice(ramTypeStr);

        double additionalPriceOs=0.0;
        if(computerDataModel.getOs() != null){
            String osStr = computerComp.selectOS(computerDataModel.getOs());
            additionalPriceOs = extractAdditionalPrice(osStr);
        }

        String hddStr =  computerComp.selectHDD(computerDataModel.getHdd());
        double additionalPriceHDD = extractAdditionalPrice(hddStr);

        String softwareStr = computerComp.selectSoftware(computerDataModel.getSoftware());
        double additionalPriceSoftware = extractAdditionalPrice(softwareStr);

        //calculate sum of Additional prices
        double basePrice = computerComp.productPrice();
        double additionalPrices =
                additionalPriceProcessor + additionalPriceRam + additionalPriceOs + additionalPriceHDD + additionalPriceSoftware;
        this.totalItemPrice = (basePrice + additionalPrices)*this.quantity;

        //click on Add To Cart
        computerComp.clickOnAddToCartBtn();
        computerComp.waitUntilItemAddedToCart();

        //navigate to Shopping Cart
        computerDetailPage.headerComp().clickOnShoppingCartLink();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
            throw new RuntimeException(ignored);
        }


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
