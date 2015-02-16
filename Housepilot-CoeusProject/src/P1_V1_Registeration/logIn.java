package P1_V1_Registeration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class logIn 
{
     public static void main(String[] args) //throws Exception 
     {     
    	 try
    	 {
	    	 WebDriver driver = new FirefoxDriver();
	         driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login/");
	         //driver.get("https://www.google.com.pk/");
	         
	         
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	          
	         /*
	         // ..................................................................................
	         driver.findElement(By.id("username")).clear();
	         driver.findElement(By.id("username")).sendKeys("sana.ishtiaq@coeus-solutions.de");
	         
	         driver.findElement(By.id("password")).clear();
	         driver.findElement(By.id("password")).sendKeys("ste123");
	         
	         driver.findElement(By.xpath("//form[@id='loginform']/p[4]/button")).click();
	         
	         Assert.assertTrue(true, "Incorrect information ");
	         System.out.println("success 1 !!!");
	         
	         //..................................................................................
	         driver.findElement(By.id("username")).clear();
	         driver.findElement(By.id("username")).sendKeys("super.admin@ferdinand.de");
	         
	         driver.findElement(By.id("password")).clear();
	         driver.findElement(By.id("password")).sendKeys("admin");
	         
	         driver.findElement(By.xpath("//form[@id='loginform']/p[4]/button")).click();
	         
	         Assert.assertTrue(true, "Dashboard ");
	         System.out.println("success 2 !!!");
	         
	         // verify the title of page
	         String expectedTitle = "Super admin dashboard";
	         String actualTitle = "";
	  
	         // get the actual value of the title
	         actualTitle = driver.getTitle();
	  
	  */
	         /*
	          * compare the actual title of the page witht the expected one and print
	          * the result as "Passed" or "Failed"
	          */
	         
	         /*
	         if (actualTitle.contentEquals(expectedTitle))
	         {
	             System.out.println("Test Passed!");
	         } 
	         else 
	         {
	             System.out.println("Test Failed");
	         }
	         
	         //close Firefox
	         driver.close();
	         
	         */
    	 }
    	 catch (Exception e)
    	 {
    		 System.out.println(e);
    	 }
     }
}


