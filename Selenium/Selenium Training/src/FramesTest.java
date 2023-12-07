import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\AS097887\\OneDrive - Cerner Corporation\\Desktop\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");

		System.out.println(driver.findElements(By.tagName("iframe")).size()); // to find how many frame elements are
																				// present
		driver.switchTo().frame(0); // using the index

		// driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		// //using the webelement
		// driver.findElement(By.id("draggable")).click();

		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement des = driver.findElement(By.id("droppable"));

		a.dragAndDrop(source, des).build().perform();
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.id("sidebar")).getText());

	}

}
