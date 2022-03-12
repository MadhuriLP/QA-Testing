package mainProjectPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)", "");
		
		WebElement footer= driver.findElement(By.xpath("//div[@id='navFooter']"));
		List<WebElement> links=footer.findElements(By.tagName("a"));
		int count =links.size();
		System.out.println(count);
		Assert.assertEquals(count, 55);
		for(int i=1;i<links.size();i++) {
			
			String linkNames = links.get(i).getText();
			System.out.println(linkNames);
			
		}
		
		
		driver.quit();
		

	}

}
