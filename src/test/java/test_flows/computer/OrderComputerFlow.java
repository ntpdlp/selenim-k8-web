package test_flows.computer;

import modules.components.cart.CartItemRowComponent;
import modules.components.cart.TotalComponent;
import modules.components.checkout.BillingAddressComponent;
import modules.components.checkout.PaymentInformationComponent;
import modules.components.checkout.PaymentMethodComponent;
import modules.components.checkout.ShippingMethodComponent;
import modules.components.computer.CheapComputerDetailEssentialComponent;
import modules.components.computer.ComputerDetailEssentialComponent;
import modules.pages.CheckOutPage;
import modules.pages.CheckoutOptionsPage;
import modules.pages.ComputerDetailPage;
import modules.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testdata.CreditCardType;
import testdata.DataObjectBuilder;
import testdata.PaymentMethod;
import testdata.computer.ComputerDataModel;
import testdata.user.UserDataModel;

import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerFlow<T extends ComputerDetailEssentialComponent> {

    private final WebDriver driver;
    private final Class<T> computerEssentialComp;
    private final ComputerDataModel computerDataModel;
    private final int quantity;
    private double totalItemPrice;
    private UserDataModel defaultCheckoutUser;
    private PaymentMethod paymentMethod;
    private CreditCardType creditCardType;


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
        computerComp.unselectDefaultOptions();
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

    public void verifyShoppingCartPage(){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        List<CartItemRowComponent> cartItemRowComps = shoppingCartPage.cartItemRowComponents();
        if(cartItemRowComps.isEmpty()){
            Assert.fail("[ERR] There is no item displayed in the shopping cart!");
        }

        double currentSubtotal = 0;
        double currentTotalUnitPrices = 0;
        for (CartItemRowComponent cartItemRowComp : cartItemRowComps) {
            currentSubtotal = currentSubtotal + cartItemRowComp.subTotal();
            currentTotalUnitPrices = currentTotalUnitPrices + (cartItemRowComp.unitPrice() * cartItemRowComp.quantity());
        }

        Assert.assertEquals(currentSubtotal, currentTotalUnitPrices,
                "[ERR] Shopping cart's sub-total is incorrect");

        TotalComponent totalComp = shoppingCartPage.totalComp();
        Map<String, Double> priceCategories = totalComp.priceCategories();
        double checkoutSubTotal = 0;
        double checkoutOtherFeesTotal = 0;
        double checkoutTotal = 0;
        for (String priceType : priceCategories.keySet()) {
            double priceValue = priceCategories.get(priceType);
            if(priceType.startsWith("Sub-Total")){
                checkoutSubTotal = priceValue;
            } else if(priceType.startsWith("Total")){
                checkoutTotal = priceValue;
            } else {
                checkoutOtherFeesTotal = checkoutOtherFeesTotal + priceValue;
            }
        }

        Assert.assertEquals(checkoutSubTotal, currentSubtotal, "[ERR] ...");
        Assert.assertEquals(checkoutTotal, (checkoutSubTotal + checkoutOtherFeesTotal), "[ERR] ...");
    }

    public void agreeTOSAndCheckout(){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.totalComp().agreeTOS();
        shoppingCartPage.totalComp().clickOnCheckOutBtn();
        new CheckoutOptionsPage(driver).checkoutAsGuest();
    }

    public void inputBillingAddress(){
        String defaultCheckoutUserJSONLoc = "/src/test/java/test_data/DefaultCheckoutUser.json";
        defaultCheckoutUser = DataObjectBuilder.buildDataObjectFrom(defaultCheckoutUserJSONLoc, UserDataModel.class);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        BillingAddressComponent billingAddressComp = checkOutPage.billingAddressComp();
        billingAddressComp.selectInputNewAddress();
        billingAddressComp.inputFirstname(defaultCheckoutUser.getFirstName());
        billingAddressComp.inputLastname(defaultCheckoutUser.getLastName());
        billingAddressComp.inputEmail(defaultCheckoutUser.getEmail());
        billingAddressComp.selectCountry(defaultCheckoutUser.getCountry());
        billingAddressComp.selectState(defaultCheckoutUser.getState());
        billingAddressComp.inputCity(defaultCheckoutUser.getCity());
        billingAddressComp.inputAdd1(defaultCheckoutUser.getAdd1());
        billingAddressComp.inputZIPCode(defaultCheckoutUser.getZipCode());
        billingAddressComp.inputPhoneNo(defaultCheckoutUser.getPhoneNum());
        billingAddressComp.clickOnContinueBtn();
    }

    public void inputShippingAddress(){
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.shippingAddressComp().clickOnContinueBtn();
    }

    public void selectShippingMethod() {
        List<String> shippingMethods = Arrays.asList("Ground", "Next Day Air", "2nd Day Air");
        String randomShippingMethod = shippingMethods.get(new SecureRandom().nextInt(shippingMethods.size()));
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        ShippingMethodComponent shippingMethodComp = checkOutPage.shippingMethodComp();
        shippingMethodComp.selectShippingMethod(randomShippingMethod).clickOnContinueButton();
    }

    public void selectPaymentMethod() {
        this.paymentMethod = PaymentMethod.COD;
    }

    public void selectPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("[ERR] Payment method can't be null!");
        }
        this.paymentMethod = paymentMethod;

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        PaymentMethodComponent paymentMethodComp = checkOutPage.paymentMethodComp();
        switch (paymentMethod) {
            case MONEY_ORDER:
                paymentMethodComp.selectCheckMoneyOrderMethod();
                break;
            case CREDIT_CARD:
                paymentMethodComp.selectCreditCardMethod();
                break;
            case PURCHASE_ORDER:
                paymentMethodComp.selectPurchaseOrderMethod();
                break;
            default:
                paymentMethodComp.selectCODMethod();
        }

        paymentMethodComp.clickOnContinueBtn();

    }

    // Test Card Number: https://www.paypalobjects.com/en_GB/vhelp/paypalmanager_help/credit_card_numbers.htm
    public void inputPaymentInfo(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        PaymentInformationComponent paymentInformationComp = checkOutPage.paymentInformationComp();

        if (this.paymentMethod.equals(PaymentMethod.PURCHASE_ORDER)) {
            // This can be dynamic as well
            paymentInformationComp.inputPurchaseNum("123456");
        } else if (this.paymentMethod.equals(PaymentMethod.CREDIT_CARD)) {
            paymentInformationComp.selectCardType(creditCardType);
            String cardHolderFirstName = this.defaultCheckoutUser.getFirstName();
            String cardHolderLastName = this.defaultCheckoutUser.getLastName();
            paymentInformationComp.inputCardHolderName(cardHolderFirstName + " " + cardHolderLastName);
            String cardNumber = creditCardType.equals(CreditCardType.VISA) ? "4012888888881881" : "6011000990139424";
            paymentInformationComp.inputCardNumber(cardNumber);

            // Select current month and next year
            Calendar calendar = new GregorianCalendar();
            paymentInformationComp.inputExpiredMonth(String.valueOf(calendar.get(Calendar.MONTH) + 1));
            paymentInformationComp.inputExpiredYear(String.valueOf(calendar.get(Calendar.YEAR) + 1));
            paymentInformationComp.inputCardCode("123");
            paymentInformationComp.clickOnContinueBtn();
        } else if(this.paymentMethod.equals(PaymentMethod.COD)){
            // TODO: add verification
            paymentInformationComp.clickOnContinueBtn();
        } else {
            // TODO: Verify Check/Money Order ...
            paymentInformationComp.clickOnContinueBtn();
        }
    }

    public void confirmOrder() {
        // TODO: Add verification methods
        new CheckOutPage(driver).confirmOrderComp().clickOnContinueBtn();

        try {
            Thread.sleep(3000);
        } catch (Exception ignored){}
    }
}
