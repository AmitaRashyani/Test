package swordRiskExam;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Compatibility {

	public WebDriver driver;

	@BeforeTest
	public void before(){
		
		System.setProperty("webdriver.gecko.driver", "F:\\Amita\\ERP\\Automation Testing\\Jar files\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void test() {
		
		
		driver.get("http://www.sword-activerisk.com");
		
			
					driver.findElement(By.xpath("//*[@id='s']")).clear();
					driver.findElement(By.xpath("//*[@id='s']")).sendKeys("Compatibility");					
					driver.findElement(By.id("searchsubmit")).click();

					// Validation on page about search
					assertEquals("SEARCH RESULTS",driver.findElement(By.xpath("//*[@id='sub-header']/div/h1")).getText());
		
					//assertEquals("Sorry, no results found! Please try again.",driver.findElement(By.xpath("//*[@id='internal-page-content']/div[1]/h3")).getText());
					
					//driver.findElement(By.linkText("Return to Previous Screen")).click();

					
	} 
	
	@AfterTest
	public void after(){
		driver.quit();
		
	}
}

	

