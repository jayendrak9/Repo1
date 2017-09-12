package com.hotelogix.AutomationFramework.Pages.admin.Console;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class AddTravelAgent {

	public static String TANAme;
	//	int length;

	Properties or=GenericClass.loadOR();

	public void fn_addTADetails() throws Exception{

		TANAme=GenericClass.generateRandomString();	
		try{
			WebElement ele=GenericClass.driver.findElement(By.xpath(or.getProperty("TAName_ED")));
			GenericClass.sendKeys(ele, TANAme);

			WebElement address1=GenericClass.driver.findElement(By.xpath(or.getProperty("TAAddressline1_ED")));
			GenericClass.sendKeys(address1, GenericClass.generateRandomString());

			WebElement Address2=GenericClass.driver.findElement(By.xpath(or.getProperty("TAAddressline2_ED")));
			GenericClass.sendKeys(Address2, GenericClass.generateRandomString());

			WebElement country=GenericClass.driver.findElement(By.xpath(or.getProperty("Country_DD")));
			GenericClass.selectElement(country, "India");

			WebElement state=GenericClass.driver.findElement(By.xpath(or.getProperty("State_DD")));
			GenericClass.selectElement(state, "Uttar Pradesh");

			WebElement city=GenericClass.driver.findElement(By.xpath(or.getProperty("City_ED")));
			GenericClass.sendKeys(city, GenericClass.generateRandomString());

			WebElement zip=GenericClass.driver.findElement(By.xpath(or.getProperty("Zipcode_ED")));
			GenericClass.sendKeys(zip, "201301");

			WebElement salutation=GenericClass.driver.findElement(By.xpath(or.getProperty("Salutation_DD")));
			GenericClass.selectElement(salutation, "Mr.");

			WebElement fname=GenericClass.driver.findElement(By.xpath(or.getProperty("Firstname_ED")));
			GenericClass.sendKeys(fname, GenericClass.generateRandomString());

			WebElement lname=GenericClass.driver.findElement(By.xpath(or.getProperty("Lastname_ED")));
			GenericClass.sendKeys(lname, GenericClass.generateRandomString());

			WebElement designation=GenericClass.driver.findElement(By.xpath(or.getProperty("Designation_ED")));
			GenericClass.sendKeys(designation, GenericClass.generateRandomString());

			WebElement phoneno=GenericClass.driver.findElement(By.xpath(or.getProperty("Phoneno_ED")));
			GenericClass.sendKeys(phoneno, "1234567891");

			WebElement Email=GenericClass.driver.findElement(By.xpath(or.getProperty("Email_ED")));
			GenericClass.sendKeys(Email, GenericClass.generateRandomString()+"@gmail.com");

			WebElement mobile_Ed=GenericClass.driver.findElement(By.xpath(or.getProperty("Mobile_ED")));
			GenericClass.sendKeys(mobile_Ed, "1234567892");

			WebElement mainofcadress=GenericClass.driver.findElement(By.xpath(or.getProperty("Mainofcaddress_CB")));
			GenericClass.clickElement(mainofcadress);

			WebElement sameascontper=GenericClass.driver.findElement(By.xpath(or.getProperty("Sameascontactperson_CB")));
			GenericClass.clickElement(sameascontper);

			WebElement saveBT=GenericClass.driver.findElement(By.xpath(or.getProperty("TASavebtn_BT")));
			Thread.sleep(4000);
			GenericClass.clickElement(saveBT);
			// GenericClass.js_Click(saveBT);
			//GenericClass.fn_ActionsClick(saveBT);


		}  catch(Exception e){
			throw e;

		}



	}


}
