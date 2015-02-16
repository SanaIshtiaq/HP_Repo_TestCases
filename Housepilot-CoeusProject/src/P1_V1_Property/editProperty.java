package P1_V1_Property;

 
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//apply the inValid conditions as well
public class editProperty 
{

	public static void main(String [] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login/");
		
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
		
		
		// "Property Management"
		driver.findElement(By.linkText("Hausverwaltung")).click();
	   
		driver.findElement(By.cssSelector("tr.even > td.center > a.icon-edit")).click();
		
		//not working ............................
		//driver.findElement(By.xpath("//table[@id='dyntable']/tbody/tr[3]/td[15]/a")).click();
		//driver.findElement(By.xpath("//table[@id='dyntable']/tr[3]/td[15]/a[@id='icon-edit']")).click();
		
		//Assert.assertTrue("bearbeiten Immobilie" , true);
		
		//property creation form starts from here
		
		// 1 id = title
				//valid condition for title
				driver.findElement(By.id("title")).clear();
			    driver.findElement(By.id("title")).sendKeys("property 2");
			    
			    // 2 id = property_desc
			    //Invalid condition for description field
			    driver.findElement(By.id("property_desc")).clear();
			    driver.findElement(By.id("property_desc")).sendKeys("300000"); // RandomStringUtils.randomAlphabetic(7) 
			    Assert.assertTrue(true, "The field can not contain numbers only");
			    System.out.println("description check point 1");
			    
			    //Valid condition for description field
			    driver.findElement(By.id("property_desc")).clear();
			    driver.findElement(By.id("property_desc")).sendKeys("300 square feet apartments");
			    
			   // 3 id = street
			   //valid condition for street || any data is valid for street
			    driver.findElement(By.id("street")).clear();
			    driver.findElement(By.id("street")).sendKeys("222");
			    
			    // 4 id = house_number
			    // .............................................................
		        String[] Arr2 = new String[]{"alpha","alpha1234","$$@@"};
		        
		        //Invalid condition for house#
		        for(int k = 0 ; k<3 ; k++)
		        {
		        	driver.findElement(By.id("house_number")).clear();
		    	    driver.findElement(By.id("house_number")).sendKeys(Arr2[k]);
			        System.out.println("check point house# : "+k);
			        Assert.assertTrue(true, "The field value must be a number");   
			    }
			    //valid condition for house#
			    driver.findElement(By.id("house_number")).clear();
			    driver.findElement(By.id("house_number")).sendKeys("444");
			    
			    /*
			    // 5 id = property_zip
			    //valid data for zip code
			    driver.findElement(By.id("property_zip")).clear();
			    driver.findElement(By.id("property_zip")).sendKeys("12345");
			    
			    // 6 id = property_state          ... dropdown
			    new Select(driver.findElement(By.id("property_state"))).selectByVisibleText("Hessen");

		 		// 7 id = property_city           ... dropdown
			    new Select(driver.findElement(By.id("property_city"))).selectByVisibleText("Biblis");
			    
			    // 8 id = property_address
			    driver.findElement(By.id("property_address")).clear();
			    driver.findElement(By.id("property_address")).sendKeys("apartment 12345");
			    
			    // 9 id = minimum_rent_per_month  ... currency
			    driver.findElement(By.id("minimum_rent_per_month")).clear();
			    driver.findElement(By.id("minimum_rent_per_month")).sendKeys("2500");
			    
			    // 10 id = maximum_rent_per_month  ... currency
			    driver.findElement(By.id("maximum_rent_per_month")).clear();
			    driver.findElement(By.id("maximum_rent_per_month")).sendKeys("5000");
			    
			    // 11 id = no_of_rooms         ... dropdown (no.s)
			    new Select(driver.findElement(By.id("no_of_rooms"))).selectByVisibleText("3.5");
			    // ................................................................................
			    
			    // 12 id = property_type           ... dropdown
			    new Select(driver.findElement(By.id("property_type"))).selectByVisibleText("Mietwohnung");
			   
			    new Select(driver.findElement(By.id("property_child_type"))).selectByIndex(3);
			    
			    // if WG selected , then a new field not displayed
			    // 13 id = property_size
		        //Invalid condition for property size
		        //for(int k = 0 ; k<3 ; k++)
		        //{
		        //	driver.findElement(By.id("property_size")).clear();
		        //	driver.findElement(By.id("property_size")).sendKeys(Arr2[k]);
		        //	System.out.println("check point property size : "+k);
		        //	Assert.assertTrue(true, "The field value must be a number");
		        //}
			    
		        // valid condition for property size
			    //driver.findElement(By.id("property_size")).clear();
			    //driver.findElement(By.id("property_size")).sendKeys("55");
			    // ..................................................................................
			    
			    // 14 id = date_picker_create_property ... calendar
			    driver.findElement(By.id("date_picker_create_property")).click();
			    driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[5]")).click();
			    	    

			    // 15 id = security_deposit ... currency
			    //Invalid condition for security deposit
		        for(int k = 0 ; k<3 ; k++)
		        {    
		    	    driver.findElement(By.id("security_deposit")).clear();
		    	    driver.findElement(By.id("security_deposit")).sendKeys(Arr2[k]);
		    	    System.out.println("check point for security deposit : "+k);
		     	    Assert.assertTrue(true,"The field value must be a number");
		        }
			    driver.findElement(By.id("security_deposit")).clear();
			    driver.findElement(By.id("security_deposit")).sendKeys("5000");
			    
			    // 16 id = utility_costs_per_month ... currency
			    driver.findElement(By.id("utility_costs_per_month")).clear();
			    driver.findElement(By.id("utility_costs_per_month")).sendKeys("2000");
			    
			    // 17 id = heating_costs_per_month ... currency
			    driver.findElement(By.id("heating_costs_per_month")).clear();
			    driver.findElement(By.id("heating_costs_per_month")).sendKeys("1000");
			    
			    // 18 id = heating_cost_included .. dropdown 
			    new Select(driver.findElement(By.id("heating_cost_included"))).selectByVisibleText("Nein");
			    
			 	// 19 id = total_rent_per_month ... auto fill
			    //login needs here
			    
			    // 20 id = living_area_approx
			    driver.findElement(By.id("living_area_approx")).clear();
			    driver.findElement(By.id("living_area_approx")).sendKeys("400");
			    
			    // 21 id = rent_per_sqm ... auto fill
			    //login needs here
			    
			    // 22 id = usable_space
			    // ..........................................................................................
			    //Invalid condition for usable space
		        for(int k = 0 ; k<3 ; k++)
		        {
		        	driver.findElement(By.id("usable_space")).clear();
		    	    driver.findElement(By.id("usable_space")).sendKeys(Arr2[k]);
		    	    System.out.println("check point for usable space : "+k);
		     	    Assert.assertTrue(true,"The field value must be a number");   
		        }
		        //valid condition for usable space, approx land area, no garage, deposit cooperative share, commision agent
			    driver.findElement(By.id("usable_space")).clear();
			    driver.findElement(By.id("usable_space")).sendKeys("25");
			
			    // 23 id = land_area_Approx ... digits
			    for(int k = 0 ; k<3 ; k++)
		        {
		        	driver.findElement(By.id("land_area_approx")).clear();
		    	    driver.findElement(By.id("land_area_approx")).sendKeys(Arr2[k]);
		    	    System.out.println("check point for land area approx : "+k);
		     	    Assert.assertTrue(true,"The field value must be a number");   
		        }
		        //valid condition for approx land area
			    driver.findElement(By.id("land_area_approx")).clear();
			    driver.findElement(By.id("land_area_approx")).sendKeys("250");
			
			    // .................................................................................
			    // 24 id = garage_parking_space ... dropdown
			    new Select(driver.findElement(By.id("garage_parking_space"))).selectByVisibleText("Garage");
			    
			    //24.1 id = no_garage_parking_space   ... digit
			    //24.2 id = rent_garage_parking_space ... currency
			    //Invalid condition for no_garage_parking_space, rent_garage_parking_space
		        for(int k = 0 ; k<3 ; k++)
		        {
		    	    driver.findElement(By.id("no_garage_parking_space")).clear();
		    	    driver.findElement(By.id("no_garage_parking_space")).sendKeys(Arr2[k]);
		    	    System.out.println("check point for no_garage_parking_space : "+k);
		     	    Assert.assertTrue(true,"The field value must be a number");
		     	    
		    	    driver.findElement(By.id("rent_garage_parking_space")).clear();
		    	    driver.findElement(By.id("rent_garage_parking_space")).sendKeys(Arr2[k]);
		    	    System.out.println("check point for approx_land_area : "+k);
		     	    Assert.assertTrue(true,"The field value must be a number");   
		        }
			    driver.findElement(By.id("no_garage_parking_space")).clear();
			    driver.findElement(By.id("no_garage_parking_space")).sendKeys("5");
			    
			    driver.findElement(By.id("rent_garage_parking_space")).clear();
			    driver.findElement(By.id("rent_garage_parking_space")).sendKeys("43");
			    
			    // .....................................................................................
			    // 25 id = property_lease_term
			    //valid data for lease term || no validation check required
			    driver.findElement(By.id("property_lease_term")).clear();
			    driver.findElement(By.id("property_lease_term")).sendKeys("testing");
			    // .....................................................................................
			 
			    // 26 id = furnishing ... dropdown
			    new Select(driver.findElement(By.id("furnishing"))).selectByIndex(2);
			    
			    // 27 id = property_condition .. dropdown
			    new Select(driver.findElement(By.id("property_condition"))).selectByIndex(3);
			    
			    // 28 id = uniform_property_renovated ... radio buttons
		    	// ............................................................................................
			    //driver.findElement(By.xpath("(//input[@id='flooring_type'])[2]")).click();
			    //driver.findElement(By.id("property_renovated")).click();
			    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div/form/div[2]/div[1]/div/span[2]/div/span/input")).click();
			    
			    // 29 id = construction_year ... dropdown
			    new Select(driver.findElement(By.id("construction_year"))).selectByVisibleText("1915");
			    
			    // 30 id = year_unknown ... checkbox
			    
			    // 31 id = total_floors ... digits
			    //valid data for total_floors
			    driver.findElement(By.id("total_floors")).clear();
			    driver.findElement(By.id("total_floors")).sendKeys("4");
			    
			    // 32 id = floor_number ... digit
			    //valid data for floor_number
			    driver.findElement(By.id("floor_number")).clear();
			    driver.findElement(By.id("floor_number")).sendKeys("3");
			    
			    // 33 id = no_of_bedrooms ... dropdown
			    new Select(driver.findElement(By.id("no_of_bedrooms"))).selectByVisibleText("5.0");
			    
			    // 34 id = no_of_toilts ... dropdown
			    new Select(driver.findElement(By.id("no_of_toilets"))).selectByVisibleText("2.0");
			    
			    // 35 id = no_of_bathrooms ... dropdown
			    new Select(driver.findElement(By.id("no_of_bathrooms"))).selectByVisibleText("1.0");
			    
			    	
			     // ............................................................................................
				 // 36 id = ceiling_height ... digit
			        //Invalid condition for ceiling height
			        for(int k = 0 ; k<3 ; k++)
			        {
			        	driver.findElement(By.id("ceiling_height")).clear();
			        	driver.findElement(By.id("ceiling_height")).sendKeys(Arr2[k]);
			        	System.out.println("check point for ceiling height : "+k);
			     	    Assert.assertTrue(true,"The field value must be a number");
			        }
			        //valid condition for ceiling height
			        driver.findElement(By.id("ceiling_height")).clear();
			    	driver.findElement(By.id("ceiling_height")).sendKeys("20");
			    // ...............................................................................................
			    	
			    // 37 id = uniform-flooring_type ... radio button
			    	new Select(driver.findElement(By.id("flooring_type"))).selectByIndex(2);

			    // ..............................................................................................
			    // 38 id = transport_distance ... digit
			    	
			    //Invalid condition for transport distance
			    for(int k = 0 ; k<3 ; k++)
			    {
			    	driver.findElement(By.id("tranport_distance")).clear();
			    	driver.findElement(By.id("tranport_distance")).sendKeys(Arr2[k]);
			    	System.out.println("check point for transport distance : "+k);
			    	Assert.assertTrue(true,"The field value must be a number");	    		    	
			    }
				driver.findElement(By.id("tranport_distance")).clear();
				driver.findElement(By.id("tranport_distance")).sendKeys("2");
					
				// ..............................................................................................
				
				// 39 id = distance_to_schools ... digit
				// 40 id = distance_to_kindergarten ... digit
				//Invalid condition for distance to school 
			    for(int k = 0 ; k<3 ; k++)
			    {
			    	driver.findElement(By.id("distance_to_schools")).clear();
			    	driver.findElement(By.id("distance_to_schools")).sendKeys(Arr2[k]);
			    	System.out.println("check point for distance to school : "+k);
			    	Assert.assertTrue(true,"The field value must be a number");
			    	
			    	driver.findElement(By.id("distance_to_kindergarten")).clear();
			    	driver.findElement(By.id("distance_to_kindergarten")).sendKeys(Arr2[k]);
			    	System.out.println("check point for transport distance : "+k);
			    	Assert.assertTrue(true,"The field value must be a number");
			    }
				driver.findElement(By.id("distance_to_schools")).clear();
				driver.findElement(By.id("distance_to_schools")).sendKeys("2");

				driver.findElement(By.id("distance_to_kindergarten")).clear();
		    	driver.findElement(By.id("distance_to_kindergarten")).sendKeys("2");   
				// ............................................................................................
		    	
		    	// 41 id = credit_report_required ... checkbox
			    driver.findElement(By.id("credit_report_required")).click();
			    
			    // 42 id = facilities_note ... textarea
			    //valid data for facilities_note
			    driver.findElement(By.id("facilities_note")).clear();
			    driver.findElement(By.id("facilities_note")).sendKeys("abc 44563");
			    
			    // 43 id = location_note ... textarea
			    //valid data for price
			    driver.findElement(By.id("location_note")).clear();
			    driver.findElement(By.id("location_note")).sendKeys("abc 44563");
			    
			    // 44 id = detailed_info_on_property ... textarea
			    //valid data for price
			    driver.findElement(By.id("detailed_info_on_property")).clear();
			    driver.findElement(By.id("detailed_info_on_property")).sendKeys("abc 44563");
			    
			    // 45 id = other_desc ... textarea
			    //valid data for price
			    driver.findElement(By.id("other_desc")).clear();
			    driver.findElement(By.id("other_desc")).sendKeys("abc 44563");
			    
			    // ............... NEW
			    driver.findElement(By.id("eligibility_to_public_housing")).click();
			    
			    // ..............................................................................................
			    
			    */
			    // 46 id = add_property_images_btn  .... button to upload images
			    /*
			    driver.findElement(By.id("add_property_images_btn")).click();
			    driver.findElement(By.id("property-image-1")).clear();
			    //driver.findElement(By.id("property-image-1")).sendKeys("C:\\Users\\coeus\\Pictures\\45.jpg");
			    driver.findElement(By.id("property-image-1")).sendKeys("Desktop\\45.jpg");
			    */
			    
			    /*
			    // 47 id = energy_certificate  ... dropdown   .. 1
			    new Select(driver.findElement(By.id("energy_certificate"))).selectByIndex(2);
			    
			    // 48 id = certificate_creation ... dropdown 2 ... depend on 1
			    new Select(driver.findElement(By.id("certificate_creation"))).selectByIndex(1);
			    
			    // 49 id = cerftificate_type ... dropdown 3 ... depend on 1
			    new Select(driver.findElement(By.id("certificate_type"))).selectByIndex(1);
			    
			    // 50 id = energy_demand ... textfield ... depend on 3
			    driver.findElement(By.id("energy_demand")).clear();
			    driver.findElement(By.id("energy_demand")).sendKeys("testing");
			    
			    // 51 id = energy_consumption ... textfield ... depend on 3
		 		
			    // 52 id = energy_carrier  ... dropdown
			    new Select(driver.findElement(By.id("energy_carrier"))).selectByVisibleText("Kohle/Koks");
			    

		 		// 53 id = heating ... dropdown
			    new Select(driver.findElement(By.id("heating"))).selectByIndex(1);
			    
		 		
		 		// 54 check boxes at last
			    driver.findElement(By.xpath("(//input[@name='meta_array[]'])[26]")).click();
			    driver.findElement(By.xpath("(//input[@name='meta_array[]'])[29]")).click();
			    driver.findElement(By.xpath("(//input[@name='meta_array[]'])[32]")).click();
			    driver.findElement(By.xpath("(//div[@id='uniform-undefined']/span)[35]")).click();
			    */
			    
			    // 55 metas  
			    //adding user defined metas
			    /*driver.findElement(By.id("other_metas_cb")).click();
			    driver.findElement(By.id("add_new_metas_input_tagsinput")).clear();
			    driver.findElement(By.id("add_new_metas_input_tagsinput")).sendKeys("auto meta 1");
			    driver.findElement(By.id("add_new_metas_input_tagsinput")).sendKeys("\n");
			    driver.findElement(By.id("add_new_metas_input_tagsinput")).click();
			    */
			    
			    // ............................................................................................
			    
			    // selection from drop downs
			    //new Select(driver.findElement(By.id("property_child_type"))).selectByVisibleText("Duplex / Maisonette");
			    
			    // .........................................................................................
			    
			    
			    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
			    
			    Assert.assertTrue(true, "Immobilie erfolgreich aktualisiert");
			    
			    System.out.println("End result !!!");
	}
}
