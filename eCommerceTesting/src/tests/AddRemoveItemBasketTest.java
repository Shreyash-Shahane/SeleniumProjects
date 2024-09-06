package tests;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basePage;
import pageObject.HomePage;
import pageObject.ShopContentPanel;
import pageObject.ShopHomePage;
import pageObject.ShopProductPage;
import pageObject.ShopingCart;

public class AddRemoveItemBasketTest extends basePage{

	public AddRemoveItemBasketTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
    @BeforeTest
    public void setup() throws IOException {
        // Setup code here
    	driver = getDriver();
    	driver.get(getUrl());	
    }
    
    @AfterTest
    public void tearDown() {
    	//driver.close();
    	driver =null;
    }
    
    @Test
    public void AddItem() throws IOException, InterruptedException {
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
    	contentPanel.getContinueShoppingBtn().click();
    	shopProd.getHomepageLink().click();
    	shopHome.getProdTwo().click();
    	shopProd.getAddToCartBtn().click();
    	contentPanel.getProceedCheckoutBtn().click();
    	
    	Thread.sleep(5000);
    	ShopingCart shopCart = new ShopingCart(driver);
    	shopCart.getDeleteitemTwo().click();
    }
}
