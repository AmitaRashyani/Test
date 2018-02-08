package swordRiskExam;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;




//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchElement {

	
public WebDriver driver;
	
	@BeforeTest
	public void Before(){
		
		System.setProperty("webdriver.gecko.driver", "F:\\Amita\\ERP\\Automation Testing\\Jar files\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void testSearch(){
		driver.get("http://www.sword-activerisk.com");
		
		search("Leverage","//*[@id='s']");
		
		search("Risk management","//*[@id='s']");
		search("Compability","//*[@id='s']");

		}
	
	

	
	
	
	public void search(String words,String type){
		
		// Search item 1
		
				driver.findElement(By.xpath("//*[@id='s']")).clear();
				driver.findElement(By.xpath("//*[@id='s']")).sendKeys(words);					
				driver.findElement(By.id("searchsubmit")).click();
				
				// Validation on page about search
				assertEquals("SEARCH RESULTS",driver.findElement(By.xpath("//*[@id='sub-header']/div/h1")).getText());
				
				
				}
	
	
	
		
	@AfterTest
	public void After(){
		
		driver.quit();
		
	}
		
}
