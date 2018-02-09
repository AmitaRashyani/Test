package swordRiskExam;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.net.Urls;
import org.seleniumhq.jetty9.server.HttpConnection;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search {

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
		driver.findElement(By.xpath("//*[@id='s']")).sendKeys("Risk management");					
		driver.findElement(By.id("searchsubmit")).click();
		findAllLinks("Risk Management");
	
	
	}
	
	 public List findAllLinks(String words){
	 List <WebElement>elementList = new ArrayList();
	 
	  elementList = driver.findElements(By.xpath("//*[contains[@id= +' '+]/h3/a/time]"));

	  elementList.addAll(driver.findElements(By.xpath("//*[contains[@id= +' '+]/h3/a/time]")));

	  List <WebElement>finalList = new ArrayList(); ;

	  for (WebElement element : elementList)

	  {

		  if(element.getAttribute("href") != null)

		  {

			  finalList.add(element);

		  }		  

	  }	

	  return finalList;

}

	
	 public static <con> String isLinkBroken(Urls url) throws Exception

		{

			//url = new URL("http://www.sword-activerisk.com/?s=risk+management");

			String response = "";
			//HttpConnection connection = (HttpConnection) ((sss) url).openConnection();


			try

			{

			    ((Object) connection).connect();

			     response = connection.getResponseMessage();	        

			    connection.disconnect();

			    return response;

			}

			catch(Exception exp)

			{

				return exp.getMessage();

			}  				

		}	
		
	
	@AfterTest
	public void after(){
		driver.quit();
		
		
	}
}
	