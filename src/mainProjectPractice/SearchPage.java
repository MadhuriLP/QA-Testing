package mainProjectPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SearchPage {


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		
		//test case 1:Validate searching with an existing Product Name
		String keyWord ="samsung";
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(keyWord);
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		
		String resultPage = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/span[1]/div[1]/h1[1]/div[1]/div[1]/div[1]/div[1]")).getText();
		System.out.println(resultPage);
		Assert.assertEquals(resultPage, "1-16 of over 20,000 results for \"samsung\"");
	
		driver.navigate().back();
		Thread.sleep(3000);
		
		
		String key="iphone 13 pro";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13 pro");
		
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
    	String resultPage8= driver.findElement(By.xpath("//*[contains(text(),'1-1')]")).getText();
		//Assert.assertEquals(resultPage8+ "key", "1-16 of over 20,000 results for \"iphone 13 pro\"");
		System.out.println(resultPage8+key);
	
		driver.navigate().back();
		Thread.sleep(3000);
		
		//test case 2:Validate searching with a non existing Product Name
		
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("msbcbcjhdbcadbchdvc"); 
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		String resultPage1=driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[1]")).getText();
		//String resultPage1=driver.findElement(By.xpath("//span[contains(text(),'uffghfgkghghhghg')]/parent::div/child::span")).getText();
		System.out.println(resultPage1);
		System.out.println("No results for uffghfgkghghhghg."+"\n"+"Try checking your spelling or use more general terms");		                         
        Assert.assertEquals(resultPage1, "No results for msbcbcjhdbcadbchdvc." +"\n"+"Try checking your spelling or use more general terms"); 
	    driver.navigate().back();
		Thread.sleep(3000);
		
		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("msbcbcjhdbcadbchdvc"); 
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		
		//test case 3:Validate searching without providing any Product Name
		
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		
		
		//test case 4:Validate searching by providing a search criteria which results in mulitple products
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("MAC");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		String resultpage2=driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/span[1]/div[1]/h1[1]/div[1]/div[1]/div[1]/div[1]")).getText();
		System.out.println(resultpage2);
		Assert.assertEquals(resultpage2, "1-16 of over 60,000 results for \"MAC\"");
		driver.navigate().back();
		Thread.sleep(3000);
		
		//test case5:Validate all the fields in the Search functionality and Search page have placeholders 
		String name= driver.findElement(By.id("twotabsearchtextbox")).getText();
		System.out.println(name);
//		System.out.println(x);
		Thread.sleep(3000);
//		List <WebElement> values = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']"));
//		
//		for(WebElement value : values) {
//			
//			
//			String linksText = value.getText();	
//			System.out.println(linksText);
//		}
		
		//driver.close();
		

	}
}