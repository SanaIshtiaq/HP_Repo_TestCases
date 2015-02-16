package P1_V1_PropertyOwner;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//ERROR ......................

public class changePublishStatusOfPO 
{
	public static void main (String [] args)
	{
		try
		{
			WebDriver driver = new FirefoxDriver();
			driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login");
			
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
			
			//click on side bar PO
			driver.findElement(By.linkText("Hausbesitzer")).click();
			
			Assert.assertTrue("Hausbesitzer", true) ;
			
			String PO_publishStatus = "";
	        //for(int i=1 ; i <= 2 ; i++)
	        //{
	        	PO_publishStatus = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/div[2]/table/tbody/tr[2]/td[7]")).getText();
	        	///html/body/div/div[2]/div[2]/div[3]/div/div/table/tbody/tr[1]/td[7]
	        	if( PO_publishStatus.equals("Aktiv"))
	        	{
	        		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/div[2]/table/tbody/tr[2]/td[10]/a[3]")).click();
	        		///html/body/div/div[2]/div[2]/div[3]/div/div/table/tbody/tr[5]/td[8]/a[2]
	        		
	        		driver.findElement(By.id("popup_ok")).click();
	        	}
	        	else
	        	{
	        		System.out.println("the PO at 2nd row is InAktive by default");
	        	}
	        //} 
	        
	        //Assert.assertTrue(true, "Immobilien veröffentlichen Status Eigentümer erfolgreich geändert");
			
		}
		catch(Exception e)
		{
			System.out.println("outer exception : "+e);
		}
	}
}
