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

public class Leverage {

	public WebDriver driver;

	@BeforeTest
	public void before(){
		
		System.setProperty("webdriver.gecko.driver", "F:\\Amita\\ERP\\Automation Testing\\Jar files\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void test() throws InterruptedException{
		
		
		driver.get("http://www.sword-activerisk.com");
		
			
					driver.findElement(By.xpath("//*[@id='s']")).clear();
					driver.findElement(By.xpath("//*[@id='s']")).sendKeys("Leverage");					
					driver.findElement(By.id("searchsubmit")).click();

					// Validation on page about search
					assertEquals("SEARCH RESULTS",driver.findElement(By.xpath("//*[@id='sub-header']/div/h1")).getText());
		
					
					driver.findElement(By.xpath("//*[@id='post-9543']/h3/a/time")).click();
				
					driver.navigate().back();

					driver.findElement(By.xpath("//*[@id='post-9180']/h3/a/time")).click();
					driver.navigate().back();

					driver.findElement(By.xpath("//*[@id='post-8944']/h3/a/time")).click();
					driver.navigate().back();

					driver.findElement(By.xpath("//*[@id='post-8910']/h3/a/time")).click();
					driver.navigate().back();

					driver.findElement(By.xpath("//*[@id='post-8718']/h3/a/time")).click();

					driver.navigate().back();

					
					
	} 
	
	@AfterTest
	public void after(){
		driver.quit();
		
		
	}
	
}
