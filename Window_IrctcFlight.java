package week4.Assignments.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_IrctcFlight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1.Load https://www.irctc.co.in/
		driver.get("https://www.irctc.co.in/");
		
		//2. Click on OK button in the dialog  
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		//3. Click on FLIGHTS link  
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
		//4. Go to the Flights tab
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> allwindows = new ArrayList<String>(windows);
		allwindows.addAll(windows);
		
		String str1 = allwindows.get(1);
		String str2 = allwindows.get(0);
		
		driver.switchTo().window(str1); //Navigating to new window
		
		System.out.println("new tab url: " + driver.getCurrentUrl());  //get url for the new window for reference
		
		
		driver.findElement(By.xpath("//button[text()='Later']")).click();
		
		WebElement findElement = driver.findElement(By.id("dropdown10"));
		findElement.click();
		
		//5. Print the customer care email id
		WebElement findElement2 = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]"));
		System.out.println("Customer care id: " + findElement2.getText());
		
		//6. switch back to first tab and Close the First tab(Train ticket booking) alone
		
		driver.switchTo().window(str2);
		
		System.out.println("First tab url: " + driver.getCurrentUrl());
		
		driver.close();
	

	}

}
