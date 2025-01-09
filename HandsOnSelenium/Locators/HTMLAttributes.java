package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HTMLAttributes {
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
	public void test() {
		
		String url = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
		driver.get(url);
		//By Name
		WebElement byName = driver.findElement(By.name("my-text"));
		Assert.assertTrue(byName.isEnabled());
		
		//By ID
		WebElement byId = driver.findElement(By.id("my-text-id"));
		Assert.assertEquals(byId.getDomAttribute("type"), "text");
		Assert.assertEquals(byId.getDomProperty("type"), "text");
		
		//By classname
		List <WebElement> byClassname = driver.findElements(By.className("form-control"));
		Assert.assertTrue(byClassname.size() > 0);
		Assert.assertEquals(byClassname.get(0).getDomAttribute("name"), "my-text");
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
}
