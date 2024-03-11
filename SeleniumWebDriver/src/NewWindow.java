import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set <String> handles=driver.getWindowHandles();
		Iterator <String> i = handles.iterator();
		
		String parentID = i.next();
		String childID = i.next();
		
		driver.switchTo().window(childID);
		driver.get("https://courses.rahulshettyacademy.com/courses/");
		
		String course = driver.findElements(By.xpath("//div[@class='course-listing-title']")).get(0).getText();
		System.out.println(course);
		
		driver.switchTo().window(parentID);
		
		
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
		name.sendKeys(course);
		//Partial Screenshot
		File file = name.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("E:\\sample.png"));
		
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		driver.quit();
		
	}

}
