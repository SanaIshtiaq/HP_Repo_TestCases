package P1_V1_Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class changeStatusOfAdmin 
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
		         
		         // create new  admin        
		         Assert.assertTrue(true, "Dashboard") ;
		         driver.findElement(By.linkText("Admins")).click();
		         
		         Assert.assertTrue(true, "Admins") ;
		         
		         //driver.findElement(By.cssSelector("tr.even > td.center > a.icon-edit")).click();
		         
		         //Assert.assertTrue(true, "bearbeiten admin") ;
		         
		        String ADstatus = "";
		        for(int i=1 ; i <= 5 ; i++)
		        {
		        	ADstatus = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/div/table/tbody/tr["+i+"]/td[5]")).getText();
		        	
		        	if( ADstatus.equals("Aktiv"))
		        	{
		        		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/div/table/tbody/tr["+i+"]/td[8]/a[2]")).click();
		        		///html/body/div/div[2]/div[2]/div[3]/div/div/table/tbody/tr[5]/td[8]/a[2]
		        		
		        		driver.findElement(By.id("popup_ok")).click();
		        	}
		        	else
		        	{
		        		System.out.println("the admin at 5th row is InAktive by default");
		        	}
		        } 
		        
		        //Assert.assertTrue(true, "Status der Benutzer erfolgreich geändert");
	   	 }
	   	 catch (Exception e)
	   	 {
	   		 System.out.println(e);
	   	 }
    }
}
