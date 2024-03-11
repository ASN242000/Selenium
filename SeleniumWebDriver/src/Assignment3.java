import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));
		driver.findElement(By.cssSelector("#okayBtn")).click();
		WebElement dropDown = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
		Select dp = new Select(dropDown);
		dp.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='ProtoCommerce']")));
		String itemsNeeded[] = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		addItemsToCart(driver, itemsNeeded);
		driver.findElement(By.xpath("//li[@class='nav-item active']/a")).click();

	}

	public static void addItemsToCart(WebDriver driver, String itemsNeeded[]) {
		List<String> orders = Arrays.asList(itemsNeeded);
		List<WebElement> productName = driver.findElements(By.xpath("//h4[@class='card-title']/a"));
		for (int i = 0; i < orders.size(); i++) {
			String name = productName.get(i).getText();
			if (orders.contains(name))
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
		}
	}

}
