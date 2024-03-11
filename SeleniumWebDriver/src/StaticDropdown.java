import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//dropdown for <select> tag
		driver.manage().window().maximize();
		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dp = new Select(staticDropDown);
		dp.selectByIndex(0); // Index value starts from 0
		System.out.println(dp.getFirstSelectedOption().getText());
		dp.selectByValue("AED");
		System.out.println(dp.getFirstSelectedOption().getText());
		dp.selectByVisibleText("INR");
		System.out.println(dp.getFirstSelectedOption().getText());
	}

}
