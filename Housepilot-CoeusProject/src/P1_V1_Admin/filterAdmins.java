package P1_V1_Admin;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

//import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//pagination not applied
public class filterAdmins 
{
	public static void main(String [] args)
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
		
		driver.findElement(By.linkText("Admins")).click();
		
		driver.findElement(By.linkText("1")).click();
		
		//find the search field on the page
		WebElement searchField = driver.findElement(By.xpath("//input[@type='text']"));
		
		searchField.sendKeys("test");
		Assert.assertTrue(true, "test gema");
		
		System.out.println("success 1 !!!");
		
		searchField.clear();
		searchField.sendKeys("gema");
		Assert.assertTrue(true, "test gema");
		
		System.out.println("success 2 !!!");
				
		//inValid condition
		searchField.clear();
		searchField.sendKeys( RandomStringUtils.randomAlphabetic(7) );
		Assert.assertTrue(true, "No matching records found");
		searchField.clear();
		
		try
		{
			//taking screen shot
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("E:\\screenshot.jpg")); 
		}
		catch(Exception e)
		{
			System.out.println("screen shot exception : "+e);
		}
		
		System.out.println("success 3 !!!");
		
		driver.findElement(By.id("dyntable_next")).click();
		System.out.println("success 4 !!!");
		
		driver.findElement(By.id("dyntable_last")).click();
		System.out.println("success 5 !!!");
		
		
		System.out.println("success end !!!");
	}
}
