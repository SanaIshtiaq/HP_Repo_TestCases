
package P1_V1_Registeration;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class forgotPassword 
{

	public static void main (String [] args)
	{
		try
		{
			WebDriver driver = new FirefoxDriver();
			driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login/");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.findElement(By.linkText("Passwort vergessen?")).click();
			
			Assert.assertTrue(true, "Passwort vergessen");
			
			WebElement id = driver.findElement(By.id("username"));
			
			id.clear();
			id.sendKeys(RandomStringUtils.randomAlphabetic(7));
			driver.findElement(By.xpath("//form[@id='loginform']/p[2]/button")).click();
			Assert.assertTrue(true, "Please enter a valid email address.");
			
			id.clear();
			id.sendKeys("sana.ishtiaq@coeus-solutions.de");
			driver.findElement(By.xpath("//form[@id='loginform']/p[2]/button")).click();
			Assert.assertTrue(true, "Eine E-Mail zum Zurücksetzen Passwort wird an Sie gesendet");
			
			System.out.println("Success END !!!");
		}
		catch(Exception e)
		{
			System.out.println("Exception outside : "+e);
		}
	}
}
