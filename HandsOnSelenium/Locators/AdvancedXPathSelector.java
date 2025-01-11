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

public class AdvancedXPathSelector {
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
		WebElement radio1 = driver.findElement(By.xpath("//input[@type='radio' and @checked]"));
		WebElement radio2 = driver.findElement(By.xpath("//input[@type = 'radio' and not(@checked)]"));
		Assert.assertEquals(radio1.getDomAttribute("id"), "my-radio-1");
		Assert.assertFalse(radio2.isSelected());
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();
	}
}
