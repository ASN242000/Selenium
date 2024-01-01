import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//input[@id = 'autocomplete']")).sendKeys("Ind");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id = 'autocomplete']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@id = 'autocomplete']")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath("//input[@id = 'autocomplete']")).sendKeys(Keys.ENTER);
		//System.out.println(driver.findElement(By.xpath("//input[@id = 'autocomplete']")).getAttribute("value"));
		
		//to get value from input box using JavaScriptExecutor
		JavascriptExecutor js =(JavascriptExecutor)driver;
		String val = "return document.getElementById('autocomplete').value;";
		String s =(String)js.executeScript(val);
		System.out.println(s);
	}

}
