package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopingCart {
	public WebDriver driver;
	By havePromo = By.xpath("//a[normalize-space()='Have a promo code?']");
	By promoTextbox = By.xpath("//input[@placeholder='Promo code']");
	By promoAddBtn = By.xpath("//span[normalize-space()='Add']");
	By proceedToCheckoutBtn = By.xpath("//a[normalize-space()='Proceed to checkout']");
	By deleteItemOne = By.xpath("(//i[@class='material-icons float-xs-left'])[1]");
	By deleteItemTwo = By.xpath("(//i[@class='material-icons float-xs-left'])[2]");
	By totalValue = By.cssSelector(".cart-total .value");
	
	public ShopingCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getHavePromo() {
		return driver.findElement(havePromo);
	}
	public WebElement getPromoTextbox() {
		return driver.findElement(promoTextbox);
	}
	public WebElement getPromoAddBtn() {
		return driver.findElement(promoAddBtn);
	}
	public WebElement getProceedToCheckoutBtn() {
		return driver.findElement(proceedToCheckoutBtn);
	}
	public WebElement getDeleteitemOne() {
		return driver.findElement(deleteItemOne);
	}
	public WebElement getDeleteitemTwo() {
		return driver.findElement(deleteItemTwo);
	}
	public WebElement getTotalValue() {
		return driver.findElement(totalValue);
	}
}
