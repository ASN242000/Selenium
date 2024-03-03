package asn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {
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
	void testRelativeLocators() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement link = driver.findElement(By.linkText("Return to index"));
		RelativeBy relativeBy = RelativeLocator.with(By.tagName("input"));
		WebElement readOnly = driver.findElement(relativeBy.above(link));
		Assert.assertTrue(readOnly.getAttribute("name").equals("my-readonly"));
	}
	
	@AfterTest
	void tearDown() {
		driver.quit();
	}
}
