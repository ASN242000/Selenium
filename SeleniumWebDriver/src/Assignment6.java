import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		String option = driver.findElement(By.xpath("//div[@id = 'checkbox-example']//fieldset/label[3]")).getText();
		
		WebElement e = driver.findElement(By.id("dropdown-class-example"));
		
		Select s = new Select(e);
		s.selectByVisibleText(option.trim());
		
		driver.findElement(By.xpath("//input[@placeholder = 'Enter Your Name']")).sendKeys(option.trim());
		driver.findElement(By.id("alertbtn")).click();
		
		String text = driver.switchTo().alert().getText();
		
		Assert.assertTrue(text.contains(option.trim()));
		
	}

}
