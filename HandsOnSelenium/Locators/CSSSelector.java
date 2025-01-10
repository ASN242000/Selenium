package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CSSSelector {
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
		WebElement hidden = driver.findElement(By.cssSelector("input[type='hidden']"));
		Assert.assertFalse(hidden.isDisplayed());
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
}
