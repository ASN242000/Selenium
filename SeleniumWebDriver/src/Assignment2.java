import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("Jill");
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='email']")).sendKeys("Jill@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("QWERTY");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
		Select selectGender = new Select(gender);
		selectGender.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("24102000");
		driver.findElement(By.className("btn-success")).click();
		System.out.println(driver.findElement(By.tagName("strong")).getText());
		System.out.println(driver.findElement(By.className("alert-success")).getText());
	}
}
