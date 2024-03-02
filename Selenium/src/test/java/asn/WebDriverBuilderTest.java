package asn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBuilderTest {
	
	WebDriver driver;
	
	@BeforeClass
	static void setUpClass() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeTest
	void setup() {
		driver = RemoteWebDriver.builder().oneOf(new ChromeOptions()).build();
	}
	
	@Test
	void testSessionId() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		SessionId sessionID = ((RemoteWebDriver) driver).getSessionId();
		Assert.assertNotNull(sessionID);
		System.out.println("The sessionIS is "+sessionID.toString());
	}
	
	@Test
	void testBasicMethods() {
		String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
		driver.get(sutUrl);
		
		Assert.assertTrue(driver.getTitle().equals("Hands-On Selenium WebDriver with Java"));
		Assert.assertTrue(driver.getCurrentUrl().equals(sutUrl));
		Assert.assertTrue(driver.getPageSource().contains("</html>"));
	}
	
	@AfterTest
	void tearDown() {
		driver.quit();
	}
}
