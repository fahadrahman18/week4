package week4.Assignments.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
//	Amazon:
//		1.Load the uRL https://www.amazon.in/
//		2.search as oneplus 9 pro 
//		3.Get the price of the first product
//		4. Print the number of customer ratings for the first displayed product
//		5. click on the stars 
//		6. Get the percentage of ratings for the 5 star.
//		7. Click the first text link of the first image
//		8. Click 'Add to Cart' button
//		9. Get the cart subtotal and verify if it is correct.

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// 1.Load the uRL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		// 2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		
		//3.Get the price of the first product
		
		WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String price1 = price.getText();
		String firstPrice = price1.replaceAll("\\D", "");
		int a = Integer.parseInt(firstPrice); // converting to int for comparision in final step
		
		System.out.println("First item price is: " + firstPrice);
		
		//4. Print the number of customer ratings for the first displayed product
		
		WebElement customers = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		String totalRatings = customers.getText();
		
		System.out.println("Number of customer ratings in first product: " + totalRatings);
		
		// 5. click on the stars 
		
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4 aok-align-bottom'])[1]")).click();
		
		
		
		//performing action classes for pause and release
		Actions builder = new Actions(driver);
		builder.pause(5).release().perform();
		
		// 6. Get the percentage of ratings for the 5 star.
		WebElement fiveStars = driver.findElement(By.xpath("(//span[@class='a-size-base']/a)[2]"));
		String percentage = fiveStars.getText();
		
		System.out.println("Number of 5 star ratings: " + percentage); //not able to percentage, text got as 5 star
		
		// 7. Click the first text link of the first image
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		
		//Navigating window
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		windows.addAll(windowHandles);
		
		String window1 = windows.get(0);
		String window2 = windows.get(1);
		
		driver.switchTo().window(window2);
		
		
		// 8. Click 'Add to Cart' button
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(8000);
		
		
		// 9. Get the cart subtotal and verify if it is correct. 
		
		WebElement subtotal = driver.findElement(By.xpath("//div[@class='a-column a-span11 a-text-left a-spacing-top-large']//span[@id='attach-accessory-cart-subtotal']"));
		
		String verifytotal = subtotal.getText();  // ?64,999.00
		String total = verifytotal.replaceAll("[^0-9.]", "");  // 64999.00
		float f=Float.parseFloat(total);  //64999.00
		int b;
		b = (int) Math.floor(f);  //64999

		
		System.out.println("First total: " + a);
		System.out.println("Final total: "  + b); 
		
		
		if (a == b) {
			System.out.println("Amount verified");
		}
		else {
			System.out.println("Amount mismatch");
		}
	
	}
	
}


