 
package P1_V1_Admin;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
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
	         
	         
	         // create new  admin
	         
	         Assert.assertTrue(true, "Dashboard") ;
	         driver.findElement(By.linkText("Admins")).click();
	         
	         Assert.assertTrue(true, "Admins") ;
	         
	         driver.findElement(By.linkText("schaffen neu admin")).click();//Create new admin")).click();
	         
	         // ........................................................
	         String[] NameArr = new String[]{"1234","gema1234","gema@123"};
	         
	         //invalid conditions
	         for(int k = 0 ; k<3 ; k++)
	         {
	        	 driver.findElement(By.id("first_name")).clear();
	        	 driver.findElement(By.id("first_name")).sendKeys(NameArr[k]);
		         System.out.println("check point k : "+k);
		         Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         //valid condition
	         driver.findElement(By.id("first_name")).clear();
	         driver.findElement(By.id("first_name")).sendKeys("AD auto");
	         System.out.println("check point firstname");
	         
	         // ........................................................
	         
	         //invalid conditions
	         for(int j = 0 ; j<3 ; j++)
	         {
	        	 driver.findElement(By.id("last_name")).clear();
	        	 driver.findElement(By.id("last_name")).sendKeys(NameArr[j]);
		         System.out.println("check point j : "+j);
		         Assert.assertTrue(true, "Digits are not allowed.");
	         }
	         
	         //valid condition
	         driver.findElement(By.id("last_name")).clear();
	         driver.findElement(By.id("last_name")).sendKeys(RandomStringUtils.randomAlphabetic(5));
	         System.out.println("check point lastname");
	         
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
	         Random rand = new Random();
	         
	         //RandomStringUtils.randomAlphabetic(5)
	         
	         //valid condition
	         driver.findElement(By.id("email")).clear();
	         driver.findElement(By.id("email")).sendKeys("autotest"+rand.nextInt(200)+"@coeus-solutions.de");
	         System.out.println("check point email");
	         
	         // ..............................................................
	         
	         driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	         
	         Assert.assertTrue(true, "Admin erfolgreich erstellt ");
	         
    	 }
    	 catch (Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
}


