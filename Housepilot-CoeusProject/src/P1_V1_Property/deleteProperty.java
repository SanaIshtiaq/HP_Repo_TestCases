package P1_V1_Property;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class deleteProperty 
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
			
			
			// "Property Management"
			driver.findElement(By.linkText("Hausverwaltung")).click();
		   
			Random rand = new Random();
			
			// .............................................................................
			new Select(driver.findElement(By.name("dyntable_length"))).selectByIndex(rand.nextInt(6));
			int listOfTR_count = 0;			
			List<WebElement> listOfTR = driver.findElements(By.xpath("//table[@id='dyntable']/tbody/tr"));		        	
		    listOfTR_count = listOfTR.size();		         
		    System.out.println("Total no of rows on the table : "+listOfTR_count);
		    // .............................................................................
		    
		    //int var2 = rand.nextInt(listOfTR_count);
		    //if(var2 == 0)
		    //{
		    //	var2 = var2+1;
		    //}	
		    int var2 = listOfTR_count -2 ;
		    
		    // xpath of delete icon
		    driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/div[3]/table/tbody/tr["+var2+"]/td[15]/a[5]")).click();
			
			driver.findElement(By.id("popup_ok")).click();
			
			//Assert.assertTrue(true, "Property Deleted Successfully");
			System.out.println("Property Deleted Successfully  !!!");
		}
		catch(Exception e)
		{
			System.out.println("ERROR in main Thread : "+e);
		}
	}

}
