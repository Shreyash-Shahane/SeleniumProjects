package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopProductPage {
	public WebDriver driver ;
	
	By sizeOption = By.xpath("//select[@id='group_1']");
	By quantityIncrease = By.cssSelector(".touchspin-up");
	By quantityDecrease = By.cssSelector(".touchspin-down");
	By addToCartBtn = By.cssSelector(".add-to-cart.btn.btn-primary");
	By homepageLink = By.xpath("//span[text()='Home']");
	
	public ShopProductPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getsizeOption() {
		return driver.findElement(sizeOption);
	}
	public WebElement quantityIncrease() {
		return driver.findElement(quantityIncrease);
	}
	public WebElement quantityDecrease() {
		return driver.findElement(quantityDecrease);
	}
	public WebElement getAddToCartBtn() {
		return driver.findElement(addToCartBtn);
	}
	public WebElement getHomepageLink() {
		return driver.findElement(homepageLink);
	}
}
