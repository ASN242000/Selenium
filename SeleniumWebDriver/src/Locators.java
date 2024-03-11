import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("practice@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("some");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.className("error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("sample");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("practice@gmail.com");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("8976543675");
		//driver.findElement(By.xpath("//form/input[3]")).sendKeys("8976543675"); "Parent to child relationship"
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); "can be used like this also"
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("sample");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	}

}
