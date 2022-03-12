package mainProjectPractice;

import java.awt.Window;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductAdd {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		String keyWord ="samsung galaxy M32";
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(keyWord);
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Samsung Galaxy M32 5G (Slate Black, 6GB RAM, 128GB')]")).click();
		String product=driver.findElement(By.xpath("//span[contains(text(),'Samsung Galaxy M32 5G (Slate Black, 6GB RAM, 128GB')]")).getText();
		System.out.println(product);
		Set<String> windows	=driver.getWindowHandles();	
	    Iterator<String> it=windows.iterator();
	    String ParentWindow=it.next();
		String ChildWindow=it.next();
		
		driver.switchTo().window(ChildWindow);
	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();
		Thread.sleep(3000);
		
		driver.close();
		driver.switchTo().window(ParentWindow);
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
		Assert.assertEquals(product, "Samsung Galaxy M32 5G (Slate Black, 6GB RAM, 128GB Storage)");
		
		
		driver.close();
	}

}
