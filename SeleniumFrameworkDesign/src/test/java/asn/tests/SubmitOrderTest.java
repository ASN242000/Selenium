package asn.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import asn.TestComponents.BaseTest;
import asn.pageobjects.CartPage;
import asn.pageobjects.CheckoutPage;
import asn.pageobjects.FinalOrderIDPage;
import asn.pageobjects.LandingPage;
import asn.pageobjects.OrderPage;
import asn.pageobjects.ProductCatalogue;


public class SubmitOrderTest extends BaseTest {
	@Test(dataProvider="getDataByJson", groups ="Purchase")
	public void submitOrderTest(HashMap <String,String> input) throws IOException
	{
		String country="India";
		ProductCatalogue cataloguePage = landingPage.loginApplication(input.get("email"), input.get("password"));
		cataloguePage.addProductToCart(input.get("product"));
		CartPage cart = cataloguePage.goToCartPage();
		Assert.assertTrue(cart.checkProductsInCart(input.get("product")));
		CheckoutPage checkout = cart.checkout();
		checkout.addShipppingInfoEmail(input.get("email"));
		checkout.addShippingInfoCountry(country);		
		FinalOrderIDPage orderP = checkout.placeOrder();
		Assert.assertTrue(orderP.orderConfirmation());
		System.out.println(orderP.getProductID());
		
	}
	
	@Test(dependsOnMethods= {"submitOrderTest"})
	public void orderHistoryTest() {
		String email="email242000@example.com";
		String password="Password@1";
		ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);
		OrderPage order = productCatalogue.goToOrderPage();
		Assert.assertTrue(order.checkProductsInOrders("ADIDAS ORIGINAL"));
	}
	
	@DataProvider
	public Object[][] getDataByJson() throws IOException {
		
		List<HashMap <String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\asn\\data\\PurchaseOrder.json");
		
		
		return new Object[][] { {data.get(0)}, {data.get(1)} };
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		
//		HashMap <String,String> map = new HashMap<String,String>();
//		map.put("email", "email242000@example.com");
//		map.put("password", "Password@1");
//		map.put("product", "ADIDAS ORIGINAL");
//		
//		HashMap <String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "emailgmail@example.com");
//		map1.put("password", "Password@1");
//		map1.put("product", "ZARA COAT 3");
//		
//		
//		return new Object[][] { {map},
//								{map1} };
//	}
	
	

}
