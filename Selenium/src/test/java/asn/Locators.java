package asn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	
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
	void testByTagName() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement textarea = driver.findElement(By.tagName("textarea"));
		Assert.assertTrue(textarea.getDomAttribute("rows").equals("3"));
	}
	
	@Test
	void testByHTMLAttributes() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		
		//BY NAME
		WebElement testByName = driver.findElement(By.name("my-text"));
		Assert.assertTrue(testByName.isEnabled());
		
		//BY ID
		WebElement textByID = driver.findElement(By.id("my-text-id"));
		Assert.assertTrue(textByID.getAttribute("type").equals("text"));
		Assert.assertTrue(textByID.getDomAttribute("type").equals("text"));
		Assert.assertTrue(textByID.getDomProperty("type").equals("text"));
		
		//BY CLASSNAME
		List <WebElement> byClassName = driver.findElements(By.className("form-control"));
		Assert.assertTrue(byClassName.size() > 1);
		Assert.assertTrue(byClassName.get(0).getAttribute("name").equals("my-text"));
	}
	
	@Test
	void testByLinkText() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement linkText = driver.findElement(By.linkText("Return to index"));
		Assert.assertTrue(linkText.getTagName().equals("a"));
		Assert.assertTrue(linkText.getCssValue("cursor").equals("pointer"));
		
		WebElement linkByPartialText = driver.findElement(By.partialLinkText("index"));
		Assert.assertTrue(linkByPartialText.getLocation().equals(linkText.getLocation()));
		Assert.assertTrue(linkByPartialText.getRect().equals(linkText.getRect()));
	}
	
	@Test
	void testByCssSelector() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement hidden = driver.findElement(By.cssSelector("input[type='hidden']"));
		Assert.assertFalse(hidden.isDisplayed());
	}
	
	@Test
	void testByCssSelectorAdvances() {
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox']:checked"));
		Assert.assertTrue(checkbox1.getAttribute("id").equals("my-check-1"));
		Assert.assertTrue(checkbox1.isSelected());
		
		WebElement checkbox2 = driver.findElement(By.cssSelector("[type='checkbox']:not(:checked)"));
		Assert.assertTrue(checkbox2.getAttribute("id").equals("my-check-2"));
		Assert.assertFalse(checkbox2.isSelected());
	}
	
	@AfterTest
	void tearDown() {
		driver.quit();
	}
}
