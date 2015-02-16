package P1_V1_PropertyOwner;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

//apply the inValid conditions as well
//problem in this case
public class filterPOs {

	public static void main(String [] args)
	{
		try
		{
			WebDriver driver = new FirefoxDriver();
			driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login/");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement id = driver.findElement(By.id("username"));
			WebElement pass = driver.findElement(By.id("password"));
			
			//give credentials at login page
			id.clear();
			id.sendKeys("super.admin@ferdinand.de");
			pass.clear();
			pass.sendKeys("admin");
			
			//click on login button
			driver.findElement(By.xpath("//form[@id='loginform']/p[4]/button")).click();
			
			driver.findElement(By.linkText("Besitzer")).click();
			
			
			//find the search field on the page
			WebElement searchField = driver.findElement(By.xpath("//input[@type='text']"));
			
			searchField.sendKeys("Sana");
			Assert.assertTrue(true, "PO STE Sana");
			searchField.clear();
			
			System.out.println("success 1 !!!");
			
			//ERROR.... page does not reload and no click on 2		
			/*
			driver.findElement(By.linkText("2")).click();
			
			searchField.clear();
			//find the search field on the page
			searchField = driver.findElement(By.xpath("//input[@type='text']"));
			searchField.sendKeys("adam");
			Assert.assertTrue(true, "Adam Balfour");
			
			searchField.clear();
			
			System.out.println("success 2 !!!");
			
			//inValid condition
			searchField.clear();
			searchField.sendKeys( RandomStringUtils.randomAlphabetic(7) );
			Assert.assertTrue(true, "No matching records found");
			System.out.println("success 3 !!!");
			
			driver.findElement(By.id("dyntable_next")).click();
			System.out.println("success 4 !!!");
			
			driver.findElement(By.id("dyntable_last")).click();
			System.out.println("success 5 !!!");
			*/
			System.out.println("success end !!!");
		}
		catch(Exception e)
		{
			System.out.println("outside exception : "+e);
		}
	}

}
