package asn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
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
	
	@Test
	void testByChained() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		List <WebElement> rowsInForm = driver.findElements(new ByChained(By.tagName("form"), By.className("row")));
		Assert.assertTrue(rowsInForm.size() == 1);
	}
	
	@Test
	void testByAll() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		List <WebElement> rowsInForm = driver.findElements(new ByAll(By.tagName("form"), By.className("row")));
		Assert.assertTrue(rowsInForm.size() == 5);
		
	}
	
	@AfterTest
	void tearDown() {
		driver.quit();
	}
}
