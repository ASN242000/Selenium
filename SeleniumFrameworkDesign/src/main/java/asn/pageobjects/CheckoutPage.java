package asn.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import asn.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class ='user__name mt-5']/label/following-sibling::input")
	WebElement emailC;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryC;
	
	@FindBy(css=".ta-item")
	List <WebElement> ddcountries;
	
	@FindBy(css=".action__submit")
	WebElement placeOrderC;
	
	public void addShipppingInfoEmail(String email) {
		emailC.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		emailC.sendKeys(email);
	}
	
	public void addShippingInfoCountry(String country) {
		countryC.sendKeys(country);
		WebElement selectedCountry = ddcountries.stream().filter(cty -> cty.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
		selectedCountry.click();
	}
	
	public FinalOrderIDPage placeOrder() {
		placeOrderC.click();
		FinalOrderIDPage orderP = new FinalOrderIDPage(driver);
		return orderP;
	}
}
