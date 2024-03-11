import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,570)");
		
		WebElement table1 = driver.findElement(By.cssSelector(".left-align fieldset #product"));
		int rows = table1.findElements(By.cssSelector("tbody tr")).size();
		int columns = table1.findElements(By.cssSelector("tbody tr th")).size();
		
		System.out.println("The number of rows = "+rows);
		System.out.println("The number of columns = "+columns);
		
		String srow=table1.findElement(By.cssSelector("tbody tr:nth-child(3)")).getText();
		System.out.println(srow);
	}

}
