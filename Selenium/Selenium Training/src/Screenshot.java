import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
	public static void main(String args[]) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companion/");
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("//screenshot/screen.png"));
	}
}
