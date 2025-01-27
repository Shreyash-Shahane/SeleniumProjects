package tests;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Import TestNG annotation
import base.basePage;
import pageObject.HomePage;
import pageObject.OrderFormDelivery;
import pageObject.OrderFormPayment;
import pageObject.OrderFormPersInfo;
import pageObject.OrderFormShippingMethod;
import pageObject.ShopContentPanel;
import pageObject.ShopHomePage;
import pageObject.ShopProductPage;
import pageObject.ShopingCart;

public class OrderCompleteTest extends basePage {

    public OrderCompleteTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        // Setup code here
    	driver = getDriver();
    	driver.get(getUrl());	
    }
    
    @AfterTest
    public void tearDown() {
    	driver.close();
    	driver =null;
    }
    
    @Test
    public void endToEndTest() throws InterruptedException, IOException {
    	HomePage home = new HomePage(driver);
    	home.getCookie().click();
    	home.getTestStoreLink().click();
    	ShopHomePage shopHome = new ShopHomePage(driver);
    	shopHome.getProdOne().click();
    	ShopProductPage shopProd = new ShopProductPage(driver);
    	Select option = new Select(shopProd.getsizeOption());
    	option.selectByVisibleText("M");
    	Thread.sleep(2000);
    	shopProd.quantityIncrease().click();
    	Thread.sleep(2000);
    	shopProd.getAddToCartBtn().click();
    	
    	Thread.sleep(5000);
    	//Calling Shop content panel class
    	ShopContentPanel contentPanel = new ShopContentPanel(driver);
    	
    	contentPanel.getProceedCheckoutBtn().click();
    	
    	//Calling shopping cart class
    	
    	ShopingCart shoppingCart = new ShopingCart(driver);
    	shoppingCart.getHavePromo().click();
    	shoppingCart.getPromoTextbox().sendKeys("20OFF");
    	shoppingCart.getPromoAddBtn().click();
    	Thread.sleep(5000);
    	shoppingCart.getProceedToCheckoutBtn().click();
    	
    	//Calling order form class
    	OrderFormPersInfo pInfo = new OrderFormPersInfo(driver);
    	pInfo.getGenderMr().click();
    	pInfo.getFirstNameField().sendKeys("John");
    	pInfo.getLastnameField().sendKeys("Smith");
    	pInfo.getEmailField().sendKeys("test121@gmail.com");
    	pInfo.getTermsConditionsCheckbox().click();
    	Thread.sleep(4000);
    	pInfo.getContinueBtn().click();
    	
    	//Calling Order delivery address class
    	OrderFormDelivery deliveryInfo = new OrderFormDelivery(driver);
    	deliveryInfo.getAddressField().sendKeys("Test Address");
    	deliveryInfo.getCityField().sendKeys("Arizona");
    	Select stateOption = new Select(deliveryInfo.getStateDropdown());
    	stateOption.selectByVisibleText("Alaska");
    	deliveryInfo.getPostcodeField().sendKeys("12345");
    	Select countryOption = new Select(deliveryInfo.getCountryDropdown());
    	countryOption.selectByVisibleText("United States");
    	Thread.sleep(4000);
    	deliveryInfo.getContinueBtn().click();
    	
    	//Calling Order form Shipping method
    	
    	OrderFormShippingMethod shippingMethod = new OrderFormShippingMethod(driver);
//    	shippingMethod.getDeliveryMsgTextbox().sendKeys("Test TEst Test");
    	Thread.sleep(3000);
    	shippingMethod.getContinueBtn().click();
    	
    	//Calling payment method
    	
    	OrderFormPayment paymentMethod = new OrderFormPayment(driver);
    	paymentMethod.getPayByCheckRadioBtn().click();
    	paymentMethod.getTermsConditionsCheckbox().click();
    	Thread.sleep(5000);
    	paymentMethod.getOrderBtn().click();
    }
}
