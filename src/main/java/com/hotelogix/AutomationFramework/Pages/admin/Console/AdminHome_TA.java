package com.hotelogix.AutomationFramework.Pages.admin.Console;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class AdminHome_TA {

	Properties or=GenericClass.loadOR();

	public void fn_navigatetoRTA_LK() throws Exception{
		
		WebElement console=GenericClass.driver.findElement(By.xpath(or.getProperty("Adminhome_console_LK")));
		GenericClass.mouseOverElement(console);
		
		WebElement RTA_LK=GenericClass.driver.findElement(By.xpath(or.getProperty("Adminhome_RTA_LK")));
		GenericClass.clickElement(RTA_LK);
		
	}
	
	
	
	
	
	
	
	
	
	
}
