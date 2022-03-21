package week4.Assignments2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// 1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");  //get url			
		driver.manage().window().maximize();  //maximize window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit_wait
		
		// 2. Go to Mens Fashion
		driver.findElement(By.xpath("(//span[contains(text(),'Fashion')])[1]")).click();
		
		// 3. Go to Sports Shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		
		// 4. Get the count of the sports shoes
		
		WebElement element1 = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		String text1 = element1.getText();
		String count1 = text1.replaceAll("\\D","");
		
		System.out.println("Count of sport shoes: " + count1);
		
		// 5. Click Training shoes
		
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		
		//6. Sort by Low to High
		
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		//Select dropdown = new Select(element2);
		//dropdown.selectByIndex(1);
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		
		// 7. Check if the items displayed are sorted correctly
		
		// 8.Select the price range (900-1200) - Navy option not available so giving start range as 500
		
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("500");
		
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		
		// 9.Filter with color Navy 
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		driver.findElement(By.xpath("(//div[@class='sdCheckbox filters-list '])[5]")).click();
		
		// 10 verify the all applied filters  // need to check
		Thread.sleep(4000);
		// 11. Mouse Hover on first resulting Training shoes
		WebElement element3 = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(element3).pause(4).release().perform();

		// 12. click QuickView button
		driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]")).click();
		
		Thread.sleep(4000);
		
		// 13. Print the cost and the discount percentage
		WebElement element4 = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String cost = element4.getText();
		System.out.println("Cost is: " + cost);
		WebElement element5 = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String percentage = element5.getText().replaceAll("\\D", "");
		System.out.println("Discount percetage: " + percentage);
		
		Thread.sleep(3000);
		// 14. Take the snapshot of the shoes.
		
		WebElement screenelement = driver.findElement(By.xpath("(//img[@class='cloudzoom'])[1]"));
		
		File screenshot = screenelement.getScreenshotAs(OutputType.FILE);
		
        FileUtils.copyFile(screenshot, new File("./src/main/resources/Images/elementScreenshot01.jpg"));
        
        Thread.sleep(5000);
        //15. Close the current window
        
        driver.close();
        
        // 16. Close the main window
        
        driver.quit();
        	

	}

}
