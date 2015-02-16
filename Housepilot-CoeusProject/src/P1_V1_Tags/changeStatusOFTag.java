package P1_V1_Tags;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class changeStatusOFTag 
{
	public static void main(String [] args)
	{
		try
		{
			WebDriver driver = new FirefoxDriver();
			driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login/");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize(); 
			
			
			WebElement id = driver.findElement(By.id("username"));
			WebElement pass = driver.findElement(By.id("password"));
			
			//give credentials at login page
			id.clear();
			id.sendKeys("super.admin@ferdinand.de");
			pass.clear();
			pass.sendKeys("admin");
			
			//click on login button
			driver.findElement(By.xpath("//form[@id='loginform']/p[4]/button")).click();
			
			
			// Tags
			driver.findElement(By.linkText("Tags")).click();
		   
			Random rand = new Random();
			
			// .............................................................................
			new Select(driver.findElement(By.name("dyntable_length"))).selectByIndex(rand.nextInt(6));
			int listOfTR_count = 0;			
			List<WebElement> listOfTR = driver.findElements(By.xpath("//table[@id='dyntable']/tbody/tr"));		        	
		    listOfTR_count = listOfTR.size();		         
		    System.out.println("Total no of rows on the table : "+listOfTR_count);
		    // .............................................................................
		    
		    // status of tag before click on wrench
		    String statusVar1 = driver.findElement(By.cssSelector("tbody > tr.odd > td.sorting_2")).getText();
		    System.out.println(" statusVar1 : "+statusVar1);
		    
		    //click on wrench icon to change status
		    driver.findElement(By.cssSelector("tbody > tr.odd > td.center > a.icon-wrench")).click();
		    driver.findElement(By.id("popup_ok")).click();
		    
		    //status of tag after click on wrench
		    String statusVar2 = driver.findElement(By.cssSelector("tbody > tr.odd > td.sorting_2")).getText();
		    System.out.println(" statusVar2 : "+statusVar2);
		    
		    if ( statusVar1.equals("Aktiv"))
		    {
		    	if( statusVar2.equals("Inaktiv") )
		    	{
		    		System.out.println("<change status of tag> functionality working perfectly !!! PASS ");
		    	}
		    	else
		    	{
		    		System.out.println("<change status of tag> have some issue !!! FAIL ");
		    	}
		    }
		    else if ( statusVar1.equals("Inaktiv"))
		    {
		    	if( statusVar2.equals("Aktiv") )
		    	{
		    		System.out.println("<change status of tag> functionality working perfectly !!! PASS ");
		    	}
		    	else
		    	{
		    		System.out.println("<change status of tag> have some issue !!! FAIL ");
		    	}
		    }
		    else
	    	{
	    		System.out.println("<change status of tag> have some issue !!! FAIL ");
	    	}
		    
			//Assert.assertTrue(true, "Status der Immobilie erfolgreich geändert");
		}
		catch(Exception e)
		{
			System.out.println("ERROR in main Thread : "+e);
		}
	}
}
