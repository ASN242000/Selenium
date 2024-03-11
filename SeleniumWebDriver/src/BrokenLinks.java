import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Broken URL
		//Step 1: Get all the URLs tied to the links using Selenium
		//Java methods will call the URLs and get the status codes
		//If status code is greater than 400 then the URL is not working -> Link which tied to URL is broken
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List <WebElement> links = driver.findElements(By.cssSelector("li[class= \"gf-li\"] a"));
		SoftAssert a = new SoftAssert();
		
		
		for(WebElement link : links) {
			
			String url = link.getAttribute("href");
			HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			//System.out.println(""+code);
			
			a.assertTrue(respCode<400, "The link with name "+link.getText()+" is broken with error code "+respCode);
			
//			if (respCode>400) {
//				System.out.println("The link with name "+link.getText()+" is broken with error code "+respCode);
//				Assert.assertTrue(false);
//			}
			
		}
		a.assertAll();
		
		
		
		
		
		
		
		
		
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		String url = driver.findElement(By.cssSelector("a[href *= 'brokenlink']")).getAttribute("href");
//		
//		HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
//		conn.setRequestMethod("HEAD");
//		conn.connect();
//		int code = conn.getResponseCode();
//		System.out.println(""+code);
	}

}
