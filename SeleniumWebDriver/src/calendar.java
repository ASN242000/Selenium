import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		
		WebElement dateWidget = driver.findElement(By.xpath("//input[@id ='form-field-travel_comp_date']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateWidget);
		
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(5000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='form-field-travel_comp_date']")));
		driver.findElement(By.xpath("//input[@id ='form-field-travel_comp_date']")).click();
		
		List <WebElement> date = driver.findElements(By.cssSelector(".flatpickr-day "));
		int count = driver.findElements(By.cssSelector(".flatpickr-day ")).size();
		
		for(int i=0;i<count;i++) {
			Thread.sleep(2000);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flatpickr-day ")));
			String day = driver.findElement(By.cssSelector(".flatpickr-day ")).getText();
			if(day.equalsIgnoreCase("27")) {
				driver.findElements(By.cssSelector(".flatpickr-day ")).get(i).click();
				break;
			}
		}
	}

}
