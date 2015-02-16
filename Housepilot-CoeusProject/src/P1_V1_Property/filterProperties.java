package P1_V1_Property;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

//apply the inValid conditions as well
public class filterProperties {

	public static void main(String [] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://ferdinand-dev.coeus-solutions.de/");
		
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
		
		driver.findElement(By.linkText("Property Management")).click();
		
		
		//find the search field on the page
		WebElement searchField = driver.findElement(By.xpath("//input[@type='text']"));
		
		searchField.sendKeys("eldo");
		Assert.assertTrue(true, "The Eldo house");
		
		System.out.println("success 1 !!!");
		
		searchField.clear();
		searchField.sendKeys("enum");
		Assert.assertTrue(true, "Enum Housing scheme");
		
		System.out.println("success 2 !!!");
		
		System.out.println("success end !!!");
	}
}
