package asn.tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String productName = "ADIDAS ORIGINAL";
		String email="email242000@example.com";
		String password="Password@1";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating"))); -Takes longer time
		//Performance issues
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match = cartProducts.stream().anyMatch(cart -> cart.getText().equals(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//You can also sendKeys for email input using Action class
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.xpath("//div[@class ='user__name mt-5']/label/following-sibling::input")), email);
		
		
		driver.findElement(By.xpath("//div[@class ='user__name mt-5']/label/following-sibling::input")).click();
		driver.findElement(By.xpath("//div[@class ='user__name mt-5']/label/following-sibling::input")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		driver.findElement(By.xpath("//div[@class ='user__name mt-5']/label/following-sibling::input")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		
		List <WebElement> country = driver.findElements(By.cssSelector(".ta-item"));
		WebElement selectedCountry = country.stream().filter(cty -> cty.getText().equalsIgnoreCase("india")).findFirst().orElse(null);
		selectedCountry.click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		System.out.println("The Order ID is: "+driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText());
		String confirmation = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
	}

}
