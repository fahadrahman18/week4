package week4.Assignments2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa_Loreal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		//1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		
		//2) Mouseover on Brands and Search L'Oreal Paris
		WebElement brandElement = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(brandElement).perform();
		
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("(//a[contains(text(),'Paris')])[1]")).click();
		
		//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		
		String pageTitle = driver.getTitle(); //get title, verify title pending
		
		System.out.println(pageTitle);
		
		if (pageTitle.contains("L'Oreal Paris")) {
			System.out.println("Title verified");
		}
		else {
			System.out.println("Title not matched");
		}
		
		//5) Click sort By and select customer top rated
		
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		
		driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
		
		//6) Click Category and click Hair->Click haircare->Shampoo
		
		driver.findElement(By.xpath("(//span[@class='title '])[1]")).click();
		
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
		
		//7) Click->Concern->Color Protection
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
		
		//8)check whether the Filter is applied with Shampoo
		
		WebElement element = driver.findElement(By.xpath("//div[@class='css-rtde4j']"));
		String text1 = element.getText();
		
		if(text1.contains("Shampoo")) {
			System.out.println("Shampoo filter present");
		}
		else {
			System.out.println("Shampoo filter not present");
		}
		
		// 9) Click on L'Oreal Paris Colour Protect Shampoo
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("(//div[@class='css-xrzmfa'])[1]")).click();
		
		// 10) GO to the new window and select size as 175ml
		Set<String> windowSet = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowSet);
		windowList.addAll(windowSet);
		
		String navi = windowList.get(1);
		driver.switchTo().window(navi);
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='css-2t5nwu']"));
		Select choose = new Select(dropdown);
		choose.selectByVisibleText("175ml");
		
		// 11) Print the MRP of the product
		
		WebElement mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]"));
		String rate = mrp.getText();
		
		System.out.println("MRP of the product: " + rate);
		
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		
		// 13) Go to Shopping Bag 
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		
		Thread.sleep(3000);
		// 14) Print the Grand Total amount
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(frame1);
		
		
		WebElement total1 = driver.findElement(By.xpath("//div[@class='value medium-strong']"));
		String grandTotal1 = total1.getText();
		String Totalone = grandTotal1.replaceAll("\\D", "");
		System.out.println("Total 1: " + Totalone);
		
		// 15) Click Proceed
		
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		
		driver.switchTo().defaultContent();
		// 16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		// 17) Check if this grand total is the same in step 14
		
		WebElement total2 = driver.findElement(By.xpath("(//div[@class='value']/span)[2]"));
		String grandTotal2 = total2.getText();
		System.out.println("Total 2: " + grandTotal2);
		
		if(Totalone.equals(grandTotal2)) {
			System.out.println("Grand Totals verified");
		}
		else {
			System.out.println("Grand total mismatch");
		}
		
		// 18) Close all windows
		driver.quit();
			
	}

}
