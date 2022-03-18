package week4.Assignments.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//		 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		 // 2. Enter UserName and Password Using Id Locator

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		 //  3. Click on Login Button using Class Locator

		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		Thread.sleep(2000);
		
		//Navigating window  - current tab to from contact tab
		Set<String> windowHandles_set = driver.getWindowHandles();
	    List<String> windowHandles_list = new ArrayList<String>(windowHandles_set);
	    windowHandles_list.addAll(windowHandles_set);
	    
	    String str1 = windowHandles_list.get(0);
	    String str2 = windowHandles_list.get(1);
	    driver.switchTo().window(str2);
	    
		
		// 8. Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//switch back to prev window
		driver.switchTo().window(str1);
		
		//9. Click on Widget of To Contact
	    driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	   
	    //Navigating window  - current tab - To contact tab
		Set<String> windowHandles_set1 = driver.getWindowHandles();
	    List<String> windowHandles_list1 = new ArrayList<String>(windowHandles_set1);
	    windowHandles_list1.addAll(windowHandles_set1);
	    
	    String str3 = windowHandles_list1.get(0);
	    String str4 = windowHandles_list1.get(1);
	    driver.switchTo().window(str4);
		
	    //10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		driver.switchTo().window(str3); // Navigate back to prev window
		
		// 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		// 12. Accept the Alert
		driver.switchTo().alert().accept();
		
		//13. Verify the title of the page/print the title of the page
		System.out.println("Final page title is " + driver.getTitle());		
		
		

	}

}
