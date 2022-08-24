package test_flows.computer;

import modules.components.computer.ComputerDetailEssentialComponent;
import modules.pages.ComputerDetailPage;
import org.openqa.selenium.WebDriver;

public class OrderComputerFlow<T extends ComputerDetailEssentialComponent> {

    private final WebDriver driver;
    private final Class<T> computerEssentialComp;


    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComp) {
        this.driver = driver;
        this.computerEssentialComp = computerEssentialComp;
    }

    public void buildComputerAndAddtoCart(){
        ComputerDetailPage computerDetailPage = new ComputerDetailPage(driver);
        T computerComp = computerDetailPage.computerComp(computerEssentialComp);
        computerComp.selectProcessorType("2.5");
        computerComp.selectRAMType("4");
        computerComp.selectHDD("320 GB");
        computerComp.selectSoftware("Acrobat Reader");
    }
}
