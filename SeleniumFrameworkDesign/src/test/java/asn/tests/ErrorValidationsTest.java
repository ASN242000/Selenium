package asn.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import asn.TestComponents.BaseTest;
import asn.pageobjects.CartPage;
import asn.pageobjects.CheckoutPage;
import asn.pageobjects.FinalOrderIDPage;
import asn.pageobjects.LandingPage;
import asn.pageobjects.ProductCatalogue;


public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void submitOrderTest() throws IOException
	{
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		
		//.ng-tns-c4-8.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		//div[@aria-label='Incorrect email or password.']
		
		landingPage.loginApplication("email2000@example.com", "Password");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}

}
