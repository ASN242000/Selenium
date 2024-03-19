package asn.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import asn.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".ng-star-inserted td:nth-child(3)")
	List <WebElement> orders;
	
	public boolean checkProductsInOrders(String productName) {
		Boolean match = orders.stream().anyMatch(cart -> cart.getText().equals(productName));
		return match;
	}
}
