import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class SelIntroduction {
	public static void main(String[] args) {
		
		//Firefox launch
		//WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.geko.driver","C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		
		//Microsoft Edge launch
		//WebDriver driver = new EdgeDriver();
		//System.setProperty("webdriver.edge.driver","");
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/#/index");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		//driver.quit();
	}
}
