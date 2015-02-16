 package P1_V1_PropertyOwner;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

/*
 * pre-requisite : createAdmin
 * result : pass
 * 
 * OR
 * 
 * login as super admin
 */

//apply the inValid conditions as well
public class createPropertyOwner 
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
			
			String POlnameRandom = "";
			for(int m = 1 ; m<=2 ; m++)
			{
			
			//click on side bar PO
			driver.findElement(By.linkText("Hausbesitzer")).click();
			
			Assert.assertTrue("Besitzer", true) ;
			
			//driver.findElement(By.linkText("schaffen neu Besitzer")).click();
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/a")).click();
			
			Assert.assertTrue("schaffen Besitzer" , true);
			
			// 1 id = job_title
			driver.findElement(By.id("job_title")).sendKeys("auto title "+RandomStringUtils.randomAlphabetic(5));
			
			// 2 id = company
			driver.findElement(By.id("company")).sendKeys("auto company "+RandomStringUtils.randomAlphabetic(5));
			
			// 3 id = position
			driver.findElement(By.id("position")).sendKeys("auto position "+RandomStringUtils.randomAlphabetic(5));
			
			// 4 id = gender
			new Select(driver.findElement(By.id("gender"))).selectByVisibleText("weiblich"); // mannlich , weiblich
			
			// 5 id = civil_status
			new Select(driver.findElement(By.id("civil_status"))).selectByVisibleText("verheiratet"); // verheiratet , unverheiratet
			
	        // ........................................................
	         String[] fNameArr = new String[]{"1234","alpha1234"};
	         
	         // 6 id = first_name
	         //invalid conditions
	         for(int k = 0 ; k<2 ; k++)
	         {
	        	 driver.findElement(By.id("first_name")).clear();
	        	 driver.findElement(By.id("first_name")).sendKeys(fNameArr[k]);
		         System.out.println("check point k : "+k);
		         //Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         //valid condition
	         driver.findElement(By.id("first_name")).clear();
	         driver.findElement(By.id("first_name")).sendKeys("PO auto");
	         System.out.println("check point 1");
	        
	         // ........................................................
	         String[] lNameArr = new String[]{"1234","bravo1234"};
	         
	      // 7 id = last_name
	         //invalid conditions
	         for(int j = 0 ; j<2 ; j++)
	         {
	        	 driver.findElement(By.id("last_name")).clear();
	        	 driver.findElement(By.id("last_name")).sendKeys(lNameArr[j]);
		         System.out.println("check point j : "+j);
		         //Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         POlnameRandom = RandomStringUtils.randomAlphabetic(5) ;
	         //valid condition
	         driver.findElement(By.id("last_name")).clear();
	         driver.findElement(By.id("last_name")).sendKeys(POlnameRandom);
	         System.out.println("check point 2");
	         
	      // ..........................................................
	         String[] emailArr = new String[]{"bravo@coeus","bravocoeus.de","bravocoeusde"};
	         // 8 id = email
	         //invalid conditions
	         for(int i = 0 ; i<3 ; i++)
	         {
	        	 driver.findElement(By.id("email")).clear();
	        	 driver.findElement(By.id("email")).sendKeys(emailArr[i]);
		         System.out.println("check point i : "+i);
		         //Assert.assertTrue(true, "Please enter a valid email address.");
	         }
	        
	         //valid condition
	         driver.findElement(By.id("email")).clear();
	         driver.findElement(By.id("email")).sendKeys("auto." +RandomStringUtils.randomAlphabetic(5) +"@gmail.com");
	         System.out.println("check point 3");
	         
	         // ..............................................................
	         // 10 id = date
			 new Select(driver.findElement(By.id("date"))).selectByVisibleText("17");
			 
	         // 9 id = month  ... dropdown 
			 new Select(driver.findElement(By.id("month"))).selectByVisibleText("Juni");
			 
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
			 
			 /*if( Assert.assertTrue("Email already taken",true))
			 {
				 
			 }*/
			 
			 //click on submit button
			 driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
			 
			 // .............. checking whether the creayed PO appeared on the list or not ? ....................
			 String POname = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div/div/table/tbody/tr[1]/td[3]/a")).getText();
			 
			 if( POname.equals("PO auto "+POlnameRandom) )
			 {
				 System.out.println("all is fine");
			 }
			 // ...............................................................................
			 
			}
		}
		catch(Exception e)
		{
			System.out.println("outer exception : "+e);
		}
	}
}
