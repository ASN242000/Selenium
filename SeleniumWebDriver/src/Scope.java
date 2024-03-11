import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//1.Give the counts of links
		//2.Count of footer section
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerdriver = driver.findElement(By.xpath("//div[@id = 'gf-BIG']")); //limiting webdriver scope
		
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
				
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++) {
			
			String clickonlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			Thread.sleep(5000);
		}
			
		Set <String> tabs = driver.getWindowHandles();
		Iterator <String> iterate = tabs.iterator();
	
		while(iterate.hasNext()) {
				
			driver.switchTo().window(iterate.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
