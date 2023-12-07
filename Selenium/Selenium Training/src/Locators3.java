import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Parent to sibling and child traversal
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		//Above statement can be used by //header/div/button[3]/preceding-sibling::button[1] locator too.
		
		//Child to parent traversal
		driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[2]")).click();
		//System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a")).getText());
		
		
	}

}
