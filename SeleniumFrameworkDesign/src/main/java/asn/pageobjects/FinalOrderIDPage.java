package asn.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import asn.AbstractComponents.AbstractComponent;

public class FinalOrderIDPage extends AbstractComponent{
	WebDriver driver;
	public FinalOrderIDPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="label[class='ng-star-inserted']")
	WebElement orderID;
	
	@FindBy(css=".hero-primary")
	WebElement confirmationP;
	
	public boolean orderConfirmation() {
		if(confirmationP.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."))
			return true;
		else
			return false;
	}
	
	public String getProductID() {
		return orderID.getText();
	}
}
