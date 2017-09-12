package com.hotelogix.AutomationFramework.Pages.Login;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class Admin_home_clickonDefaultSettings {

	
	
	
	
	
	public void fn_navigatetodefaultsetting() throws Exception{
		Properties or=GenericClass.loadOR();
		WebElement general=GenericClass.driver.findElement(By.xpath(or.getProperty("AH_General_LK")));
		GenericClass.mouseOverElement(general);
		
		WebElement Dsetting=GenericClass.driver.findElement(By.xpath(or.getProperty("AH_Defaultsetting_Lk")));
		GenericClass.clickElement(Dsetting);
		
	}
	
}
