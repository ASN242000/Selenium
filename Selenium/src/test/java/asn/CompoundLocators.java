package asn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompoundLocators {
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
	void testByIdOrName() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement fileElement = driver.findElement(new ByIdOrName("my-file"));
		Assert.assertTrue(fileElement.getAttribute("id").isBlank());
		Assert.assertFalse(fileElement.getAttribute("name").isBlank());
	}
	
	
	@AfterTest
	void tearDown() {
		driver.quit();
	}
}
