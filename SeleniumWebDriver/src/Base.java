import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //implicit wait depricated.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8)); //explicit wait 
		
		driver.manage().window().maximize();
		String orders[] = {"Cucumber", "Carrot", "Tomato"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver, orders);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode"))); //explicit wait
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo"))); //explicit wait
		
		Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(), "Code applied ..!");
		
	}
	public static void addItems(WebDriver driver, String[] orders) {
		List <WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		List <String> ordersList = Arrays.asList(orders);
		int j=0;
		
		for(int i=0;i<items.size();i++) {
			String name = items.get(i).getText();
			String productName = name.split("-")[0].trim();
			if (ordersList.contains(productName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j==ordersList.size()) // if(j==orders.length)
					break;
			}
			
		}
	}

}
