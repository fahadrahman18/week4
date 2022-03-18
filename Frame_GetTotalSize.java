package week4.Assignments.day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
		
		int count = 0;
		//find the Elements by tagname - iframe and store it as a List
		List<WebElement> outerframe = driver.findElements(By.tagName("iframe"));
		count = count + outerframe.size();

		
		for (int i = 0; i < outerframe.size(); i++) {
			
			driver.switchTo().frame(i);
			List<WebElement> innerframe = driver.findElements(By.tagName("iframe"));
			count = count + innerframe.size();
			driver.switchTo().defaultContent();
		}
		
		System.out.println("Total frames: " + count);

	}

}
