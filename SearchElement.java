package swordRiskExam;

import static org.testng.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
		
		List <WebElement>allImages = findAllLinks("Leverage","//*[@id='s']");    

		System.out.println("Total number of elements found " + allImages.size());

			for( WebElement element : allImages)
			{

				try

				{

					System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));


				}

				catch(Exception exp)

			{

    		System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());	    		

    	}
    }
    
    	
		
		}
	
	public void search(String words,String type){
		
		driver.findElement(By.xpath("//*[@id='s']")).clear();
		driver.findElement(By.xpath("//*[@id='s']")).sendKeys(words);					
		driver.findElement(By.id("searchsubmit")).click();
				
		// Validation on page about search
		assertEquals("SEARCH RESULTS",driver.findElement(By.xpath("//*[@id='sub-header']/div/h1")).getText());
				
	   	}					
								 
	public  List findAllLinks(String words,String type){
					
	List <WebElement> elementList = new ArrayList();
				 
	elementList = driver.findElements(By.className("search-results"));
	
	elementList.addAll(driver.findElements(By.tagName("img")));
					  
	List finalList = new ArrayList(); ;
				 
	System.out.println(elementList.size());
						
		for (WebElement element : elementList){
										  
			if(element.getAttribute("href") != null) {
				 
				elementList.add(element);
				 
			}		  
				 
		}	
	return finalList;
						
	
	}
				 
	public  String isLinkBroken(URL url) throws Exception
	 
	{
 
	//url = new URL("");
 
	String response = "";
 
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
 
		try
 
		{
 
		    connection.connect();
 
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
	public void After(){
		
		driver.quit();
		
	}
		
}
