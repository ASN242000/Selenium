import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//TestNG is one of the testing framework
public class CheckBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.cssSelector("input[id *= 'IndArm']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id *= 'IndArm']")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("input[id *= 'IndArm']")).isEnabled());
		driver.findElement(By.cssSelector("input[id *= 'IndArm']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id *= 'IndArm']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id *= 'IndArm']")).isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		
		System.out.println(	driver.findElement(By.cssSelector("input[id *= 'IndArm']")).isEnabled());
		System.out.println(driver.findElement(By.cssSelector("input[id *= 'IndArm']")).isDisplayed());
	}

}
