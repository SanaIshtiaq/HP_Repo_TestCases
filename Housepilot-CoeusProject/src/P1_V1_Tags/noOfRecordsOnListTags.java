package P1_V1_Tags;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class noOfRecordsOnListTags 
{
	public static void main(String[] args) //throws Exception 
    {     
   	 	try
   	 	{  		 
	    	 WebDriver driver = new FirefoxDriver();
	         
	    	 driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login/");
	         
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         driver.manage().window().maximize(); 
	         
	         //logIn
	         WebElement id = driver.findElement(By.id("username"));
	         WebElement pass = driver.findElement(By.id("password"));
	         
	         id.clear();
	         id.sendKeys("super.admin@ferdinand.de");
	         
	         pass.clear();
	         pass.sendKeys("admin");
	         
	         driver.findElement(By.xpath("//form[@id='loginform']/p[4]/button")).click();         
	         
	         // "Action Log"
			driver.findElement(By.linkText("Tags")).click();
			 //Assert.assertTrue("Verlauf" , true);
				
			 Random rand = new Random();
				
			 String tableInfo = "";
			 tableInfo = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/div/div[3]")).getText();
			 System.out.println("table info : "+tableInfo);
				
			 int randomVal = rand.nextInt(6) ;
			 
			 new Select(driver.findElement(By.name("dyntable_length"))).selectByIndex(randomVal);

			 System.out.println("random value selected is : "+randomVal);
			 // 0 - - 10
			 // 1 - - 25
			 // 2 - - 50
			 // 3 - - 100
			 // 4 - - 200
			 // 5 - - 500
			 // 6 - - 1000
			 
			 //fetching total rows from table
			 List<WebElement> listOfTR = driver.findElements(By.xpath("//table[@id='dyntable']/tbody/tr"));
			 int listOfTR_count = listOfTR.size();
			
			 System.out.println("Total no of rows on the table : "+listOfTR_count);
			     
			 if(randomVal == 0)
			 {
			    if( listOfTR_count <= 10)
			  	{
			   		System.out.println("record should not be more than 10, it seems fine");
			    }
			 	else
			   	{
			   		return;
		    	}
			 }
		     else if(randomVal == 1)
			 {
			   	if( listOfTR_count <= 25)
		    	{
		    		System.out.println("record should not be more than 25, it seems fine");
		    	}
			   	else
			    {
			   		return;
			   	}
			 }
	         else if(randomVal == 2)
			 {
			   	if( listOfTR_count <= 50)
			   	{
			   		System.out.println("record should not be more than 50, it seems fine");
			   	}
		    	else
		    	{
		    		return;
			    }
			 }
	         else if(randomVal == 3)
		     {
		    	if( listOfTR_count <= 100)
			   	{
			    	System.out.println("record should not be more than 100, it seems fine");
			    }
			   	else
			   	{
			    	return;
			    }
			 }
			 else if(randomVal == 4)
			 {
			    if( listOfTR_count <= 200)
			   	{
			   		System.out.println("record should not be more than 200, it seems fine");
			   	}
			   	else
		    	{
		    		return;
		    	}
			 }
			 else if(randomVal == 5)
			 {
			    if( listOfTR_count <= 500)
			   	{
			   		System.out.println("record should not be more than 500, it seems fine");
			   	}
			   	else
		    	{
			   		return;
			   	}
			 }
			 else if(randomVal == 6)
			 {
			   	if( listOfTR_count <= 1000)
		    	{
			    	System.out.println("record should not be more than 1000, it seems fine");
			   	}
			   	else
			   	{
			    	return;
			   	}
			 }
   	 	}
   	 	catch(Exception e)
   	 	{
   	 		System.out.println("exception from the paginationOfActionLog !!!"+e);
   	 	}
   	 }

}
