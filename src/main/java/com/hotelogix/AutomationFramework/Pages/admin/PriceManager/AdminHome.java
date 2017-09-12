package com.hotelogix.AutomationFramework.Pages.admin.PriceManager;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class AdminHome {

	Properties or=GenericClass.loadOR();
	public void fn_navigatetopackagemaster() throws Exception{


		Properties or=GenericClass.loadOR();

		WebElement Price_Manager=GenericClass.driver.findElement(By.xpath(or.getProperty("AH_Pricemanager_LK")));
		GenericClass.mouseOverElement(Price_Manager);
		WebElement PackageMaster = GenericClass.driver.findElement(By.xpath(or.getProperty("AH_PackageMaster_Lk")));
		GenericClass.clickElement(PackageMaster);



	}    

public void fn_navigateToFrontdeskPkg() throws Exception{
	
	WebElement Price_Manager=GenericClass.driver.findElement(By.xpath(or.getProperty("AH_Pricemanager_LK")));
	GenericClass.mouseOverElement(Price_Manager);
	 
	WebElement Frontdesk_Lnk=GenericClass.driver.findElement(By.xpath(or.getProperty("FrontDesk_LK")));
	GenericClass.clickElement(Frontdesk_Lnk);
	GenericClass.generateRandomString();
	GenericClass.randomUniqueString();
	
}

}
