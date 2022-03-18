package week4.Assignments.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3SchoolsFrame {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		WebElement findElement = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(findElement);
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		
		if(text.equals("You pressed OK!")) {
			System.out.println("Text verified");
		}
		else {
			System.out.println("Text not same");
		}
		

	}

}
