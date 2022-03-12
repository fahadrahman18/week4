package week4.Assignments.day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_GetTotalSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://leafground.com/pages/frame.html");
		
		//find the Elements by tagname - iframe and store it as a List
		List<WebElement> iframeelements = driver.findElements(By.tagName("iframe"));
		
		//Get the size of the list. (This gives the count of the frames visible to the main page)
		System.out.println("Total number of visible frames in the page: " + iframeelements.size());

	}

}
