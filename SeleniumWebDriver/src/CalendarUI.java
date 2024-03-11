import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CalendarUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll = "window.scrollBy(0,500)";
		js.executeScript(scroll);
		
		
		driver.findElement(By.id("first_date_picker")).click();
		Thread.sleep(2000);
		
		List <WebElement> dates = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		int count = dates.size();
		
		String dateSelect = "1";
		
		for(int i=0;i<count;i++) {
			String day = driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText();
			if(day.equals(dateSelect)) {
				driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();
				break;
			}
		}
		
	}

}
