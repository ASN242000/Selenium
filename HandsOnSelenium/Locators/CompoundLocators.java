package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompoundLocators {
WebDriver driver;
	
	@BeforeTest
	void setupClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");
		
	}
	
	@BeforeMethod
	void setup() {
		driver = new ChromeDriver();
	}
	
	@Test
	public void testByIdOrName() {
		
		String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
		driver.get(url);
		WebElement fileElement = driver.findElement(new ByIdOrName("my-file"));
		Assert.assertNull(fileElement.getDomAttribute("id"));
		Assert.assertNotNull(fileElement.getDomAttribute("name"));
	}
	
	@Test
	void testByChained() {
		String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
		driver.get(url);
		List <WebElement> rowsInForm = driver.findElements(new ByChained(By.tagName("form"), By.className("row")));
		Assert.assertEquals(rowsInForm.size(), 1);
	}
	
	@Test
	void testByAll() {
		String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
		driver.get(url);
		List <WebElement> rowsInForm = driver.findElements(new ByAll(By.tagName("form"), By.className("row")));
		Assert.assertEquals(rowsInForm.size(), 5);
		
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
}
