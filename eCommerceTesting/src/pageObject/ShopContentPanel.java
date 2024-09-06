package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopContentPanel {
	public WebDriver driver ;
	
	By continueShoppingBtn = By.xpath("//button[contains(.,'Continue')]");
	By proceedCheckoutBtn = By.xpath("(//a[@class='btn btn-primary'])[2]");
	
	public ShopContentPanel(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getContinueShoppingBtn() {
		return driver.findElement(continueShoppingBtn);
	}
	public WebElement getProceedCheckoutBtn() {
		return driver.findElement(proceedCheckoutBtn);
	}
}
