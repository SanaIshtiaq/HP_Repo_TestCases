
package P1_V1_Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.InvalidSelectorException;
	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

//problem in this case
public class editAdmin 
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
	         
	         // create new  admin        
	         Assert.assertTrue(true, "Dashboard") ;
	         driver.findElement(By.linkText("Admins")).click();
	         
	         Assert.assertTrue(true, "Admins") ;
	         
	         //driver.findElement(By.xpath("class[@icon-wrench[4]]")).click();
	         //driver.findElement(By.cssSelector("#user-2 > td.center > a.icon-edit")).click();
	         driver.findElement(By.cssSelector("tr.even > td.center > a.icon-edit")).click();
	         
	         Assert.assertTrue(true, "bearbeiten admin") ;
	         
	         // ........................................................
	         String[] fNameArr = new String[]{"1234","gema1234"};
	         
	         //invalid conditions
	         for(int k = 0 ; k<2 ; k++)
	         {
	        	 driver.findElement(By.id("first_name")).clear();
	        	 driver.findElement(By.id("first_name")).sendKeys(fNameArr[k]);
		         System.out.println("check point k : "+k);
		         Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         //valid condition
	         driver.findElement(By.id("first_name")).clear();
	         driver.findElement(By.id("first_name")).sendKeys("test new Auto");
	         System.out.println("check point 1");
	         
	         // ........................................................
	         
	         String[] lNameArr = new String[]{"1234","gema1234"};
	         
	         //invalid conditions
	         for(int j = 0 ; j<2 ; j++)
	         {
	        	 driver.findElement(By.id("last_name")).clear();
	        	 driver.findElement(By.id("last_name")).sendKeys(lNameArr[j]);
		         System.out.println("check point j : "+j);
		         Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         //valid condition
	         driver.findElement(By.id("last_name")).clear();
	         driver.findElement(By.id("last_name")).sendKeys("one new Auto");
	         System.out.println("check point 2");
	         /*
	         // ..........................................................
	         String[] emailArr = new String[]{"gemacoeus.de","gema@coeus","gemacoeus"};
	         
	         //invalid conditions
	         for(int i = 0 ; i<3 ; i++)
	         {
	        	 driver.findElement(By.id("email")).clear();
		         driver.findElement(By.id("email")).sendKeys(emailArr[i]);
		         System.out.println("check point i : "+i);
		         Assert.assertTrue(true, "Please enter a valid email address.");
	         }
	        
	         //valid condition
	         driver.findElement(By.id("email")).clear();
	         driver.findElement(By.id("email")).sendKeys("gema_gema@coeus.de");
	         System.out.println("check point 3");
	         */
	         // ..............................................................
	         
	         driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	         
	         Assert.assertTrue(true, "Admin erfolgreich aktualisiert ");
    	 }
    	 catch (Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
}


