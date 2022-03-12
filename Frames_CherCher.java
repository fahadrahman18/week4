package week4.Assignments.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_CherCher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		WebElement findElement1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		
		driver.switchTo().frame(findElement1);
		
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Name Enters");  // Typing in the topic text box
		
		WebElement findElement2 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(findElement2);
		
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();  //clicking checkbox
		
		driver.switchTo().defaultContent();  //      // switch from frame to main page
		
		WebElement findElement3 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		
		driver.switchTo().frame(findElement3);
		
		//Handling dropdown below
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='col-lg-3']")); 
		
		Select handle = new Select(dropdown);
		
		handle.selectByVisibleText("Big Baby Cat");
		
		System.out.println(driver.getTitle());
		

	}

}
