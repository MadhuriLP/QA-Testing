package mainProjectPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.linkText("Sign in")).click();;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'ap_email')]")).sendKeys("madhurileo18@gmail.com");
		driver.findElement(By.xpath("//input[contains(@id,'continue')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'ap_password')]")).sendKeys("Madhuri@18");
		driver.findElement(By.xpath("//input[contains(@id,'signInSubmit')]")).click();
		
		String result10=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).getText();
		System.out.println(result10);
		Assert.assertEquals(result10, "Hello, Priya");
		
		
		
		driver.quit();

	}

}
