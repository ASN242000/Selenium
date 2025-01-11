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

public class AdvancedCSSSelector {
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
		WebElement checkbox1 = driver.findElement(By.cssSelector("input[type=\"checkbox\"]:checked"));
		Assert.assertEquals(checkbox1.getDomAttribute("class"), "form-check-input");
		Assert.assertTrue(checkbox1.isSelected());
		
		WebElement checkbox2 = driver.findElement(By.cssSelector("input[type=\"checkbox\"]:not(:checked)"));
		Assert.assertEquals(checkbox2.getDomAttribute("id"), "my-check-2");
		Assert.assertFalse(checkbox2.isSelected());
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
}
