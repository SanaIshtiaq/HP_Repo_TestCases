 
package P1_V2_Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
/*
 * pre-requisite : login_1
 * result : pass
 */
public class createAdmin 
{
     public static void main(String[] args) //throws Exception 
     {     
    	 try
    	 {
    		 
	    	 WebDriver driver = new FirefoxDriver();
	         
	    	 driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login/");
	         
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	         
	         //logIn
	         WebElement id = driver.findElement(By.id("username"));
	         WebElement pass = driver.findElement(By.id("password"));
	         
	         id.clear();
	         id.sendKeys("super.admin@ferdinand.de");
	         
	         pass.clear();
	         pass.sendKeys("admin");
	         
	         driver.findElement(By.xpath("//form[@id='loginform']/p[4]/button")).click();
	         
	         /*
	         // create new  admin
	         
	         Assert.assertTrue(true, "Dashboard") ;
	         driver.findElement(By.linkText("Admins")).click();
	         
	         Assert.assertTrue(true, "Admins") ;
	         
	         driver.findElement(By.linkText("schaffen neu admin")).click();//Create new admin")).click();
	         
	         
	         WebElement fName = driver.findElement(By.id("first_name"));
	         WebElement lName = driver.findElement(By.id("last_name"));
	         WebElement email = driver.findElement(By.id("email"));
	         
	         // ........................................................
	         String[] fNameArr = new String[]{"1234","gema1234"};
	         
	         //invalid conditions
	         for(int k = 0 ; k<2 ; k++)
	         {
	        	 email.clear();
		         email.sendKeys(fNameArr[k]);
		         System.out.println("check point k : "+k);
		         Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         //valid condition
	         fName.clear();
	         fName.sendKeys("testO");
	         System.out.println("check point 1");
	         
	         // ........................................................
	         String[] lNameArr = new String[]{"1234","gema1234"};
	         
	         
	         //invalid conditions
	         for(int j = 0 ; j<2 ; j++)
	         {
	        	 email.clear();
		         email.sendKeys(lNameArr[j]);
		         System.out.println("check point j : "+j);
		         Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         //valid condition
	         lName.clear();
	         lName.sendKeys("gemaO");
	         System.out.println("check point 2");
	         
	         // ..........................................................
	         String[] emailArr = new String[]{"gemacoeus.de","gema@coeus","gemacoeus"};
	         
	         //invalid conditions
	         for(int i = 0 ; i<3 ; i++)
	         {
	        	 email.clear();
		         email.sendKeys(emailArr[i]);
		         System.out.println("check point i : "+i);
		         Assert.assertTrue(true, "Please enter a valid email address.");
	         }
	        
	         //valid condition
	         email.clear();
	         email.sendKeys("gemaO_gemaO@coeus.de");
	         System.out.println("check point 3");
	         
	         // ..............................................................
	         //Assert.assertTrue(true, "Admin erfolgreich erstellt ");
	         
	         driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	         
	         */
    	 }
    	 catch (Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
}


