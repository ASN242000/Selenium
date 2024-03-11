import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set <String> tabs = driver.getWindowHandles();
		java.util.Iterator<String>count = tabs.iterator();
		
		String parentWindow = count.next();
		String childWindow = count.next();
		
		driver.switchTo().window(childWindow);
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split(" ")[1];
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(emailID);
	}

}
