import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortingJavaStreams {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();
		
		//capture all the WebElements to a list
		
		List <WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//Capture text of all the WebElements - Original list
		
		List <String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		//Sort the original list - Sorted list
		
		List <String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//Compare original and sorted list
		
		Assert.assertEquals(originalList, sortedList);
		
		//Scan the name column with getText -> Rice -> print the price of Rice
		
		List<String> price;
		
		//Pagination
		
		do {
			List <WebElement> rows = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if(price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label ='Next']")).click();
			}
		}while(price.size() < 1);
		
			
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		
		String pricevalue = s.findElement(By.xpath("following::td[1]")).getText();
		return pricevalue;
	}

}
