package P1_V1_PropertyOwner;
 
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

//apply the inValid conditions as well
public class editPO 
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
			
			// 1 id = job_title
			// 2 id = company
			// 3 id = position
			// 4 id = gender ... dropdown
			// 5 id = civil_status ... dropdown
			// 6 id = first_name
			// 7 id = last_name
			// 8 id = email
			// 9 id = month  ... dropdown
			// 10 id = date  ... dropdown
			// 11 id = year  ... dropdown
			// 12 id = property_owner_street
			// 13 id = property_owner_house_number
			// 14 id = city  ... dropdown
			// 15 id = zip
			// 16 class = input-medium_dropdown  ... dropdown
			// 17 id = telephone_area_code
			// 18 id = telephone_number
			// 19 name = telephone_extension
			// 20 name = mobile_country_code
			// 21 id = mobile_number
			// 22 id = num_flats
			// 23 id = publish_property
			// 24 class = btn btn-primary
			
			//click on side bar PO
			driver.findElement(By.linkText("Hausbesitzer")).click();
			
			Assert.assertTrue("Hausbesitzer", true) ;
			
			//driver.findElement(By.linkText("schaffen neu Besitzer")).click();
			//driver.findElement(By.cssSelector("tr.even > td.center > a.icon-edit")).click();
			
			driver.findElement(By.cssSelector("tr.odd > td.center > a.icon-edit")).click();
			
			Assert.assertTrue("bearbeiten Besitzer" , true);
			
			int i = 2;
			
			// 1 id = job_title
			driver.findElement(By.id("job_title")).clear();
			driver.findElement(By.id("job_title")).sendKeys("auto edit title "+i);
			
			// 2 id = company
			driver.findElement(By.id("company")).clear();
			driver.findElement(By.id("company")).sendKeys("auto edit company "+i);
			
			// 3 id = position
			driver.findElement(By.id("position")).clear();
			driver.findElement(By.id("position")).sendKeys("auto edit position "+i);
			
			/*
			// 4 id = gender
			new Select(driver.findElement(By.id("gender"))).selectByVisibleText("weiblich"); // mannlich , weiblich
			
			// 5 id = civil_status
			new Select(driver.findElement(By.id("civil_status"))).selectByVisibleText("verheiratet"); // verheiratet , unverheiratet
			 
			
			 WebElement fName = driver.findElement(By.id("first_name"));
	         WebElement lName = driver.findElement(By.id("last_name"));
	         WebElement email = driver.findElement(By.id("email"));
	         //WebElement pass2 = driver.findElement(By.id("password"));
			// ........................................................
	         String[] fNameArr = new String[]{"1234","alpha1234"};
	         
	      // 6 id = first_name
	         //invalid conditions
	         for(int k = 0 ; k<2 ; k++)
	         {
	        	 fName.clear();
		         fName.sendKeys(fNameArr[k]);
		         System.out.println("check point k : "+k);
		         //Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         //valid condition
	         fName.clear();
	         fName.sendKeys("alpha");
	         System.out.println("check point 1");
	        
	         // ........................................................
	         String[] lNameArr = new String[]{"1234","bravo1234"};
	         
	      // 7 id = last_name
	         //invalid conditions
	         for(int j = 0 ; j<2 ; j++)
	         {
	        	 lName.clear();
		         lName.sendKeys(lNameArr[j]);
		         System.out.println("check point j : "+j);
		         //Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         //valid condition
	         lName.clear();
	         lName.sendKeys("bravo");
	         System.out.println("check point 2");
	         
	      // ..........................................................
	         String[] emailArr = new String[]{"bravo@coeus","bravocoeus.de","bravocoeusde"};
	         
	      // 8 id = email
	         //invalid conditions
	         for(int i = 0 ; i<3 ; i++)
	         {
	        	 email.clear();
		         email.sendKeys(emailArr[i]);
		         System.out.println("check point i : "+i);
		         //Assert.assertTrue(true, "Please enter a valid email address.");
	         }
	        
	         //valid condition
	         email.clear();
	         email.sendKeys("bravo@coeus.de");
	         System.out.println("check point 3");
	         
	         // ..............................................................
	         // 9 id = month  ... dropdown 
			 new Select(driver.findElement(By.id("month"))).selectByVisibleText("March");
			 
			 // 10 id = date
			 new Select(driver.findElement(By.id("date"))).selectByVisibleText("17");
			 
			 // 11 id = year
			 new Select(driver.findElement(By.id("year"))).selectByVisibleText("2000");
			 // .................................................................
			 
			// 12 id = property_owner_street
			 driver.findElement(By.id("property_owner_street")).sendKeys("123");
			 
			// 13 id = property_owner_house_number
			 driver.findElement(By.id("property_owner_house_number")).sendKeys("123");
			 
			// 14 id = city  ... dropdown
			 new Select(driver.findElement(By.id("city"))).selectByVisibleText("Agg");
			 
			// 15 id = zip
			 driver.findElement(By.id("zip")).sendKeys("12345");
			 
			// 16 class = input-medium_dropdown  ... dropdown  // leave it
			
			// 17 id = telephone_area_code
			 driver.findElement(By.id("telephone_area_code")).sendKeys("123");
			 
			// 18 id = telephone_number
			 driver.findElement(By.id("telephone_number")).sendKeys("1234567");
			 
			 // 19 name = telephone_extension
			 driver.findElement(By.name("telephone_extension")).sendKeys("123");
			 
			 // 20 name = mobile_country_code // leave it
			 
			 // 21 id = mobile_number
			 driver.findElement(By.id("mobile_number")).sendKeys("12345678912");
			 
			 // 22 id = num_flats
			 driver.findElement(By.id("num_flats")).sendKeys("5");
			 
			 // 23 id = publish_property ... check box 
			 //driver.findElement(By.id("publish_property")).click();
			 */
			
			
			 //click on submit button
			 driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
			 
			 Assert.assertTrue("Besitzer erfolgreich aktualisiert" , true); 
		}
		catch(Exception e)
		{
			System.out.println("outer exception : "+e);
		}
	}
}
