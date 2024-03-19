package asn.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import asn.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List <WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutB;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	public boolean checkProductsInCart(String productName) {
		Boolean match = cartProducts.stream().anyMatch(cart -> cart.getText().equals(productName));
		return match;
	}
	
	public CheckoutPage checkout() {
		checkoutB.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	

}
