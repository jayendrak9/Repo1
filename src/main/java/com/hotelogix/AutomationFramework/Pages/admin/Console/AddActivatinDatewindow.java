package com.hotelogix.AutomationFramework.Pages.admin.Console;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class AddActivatinDatewindow {

	Properties or=GenericClass.loadOR();
	
	public void activateforever() throws Exception{
		try{
		
	    WebElement chkbox=GenericClass.driver.findElement(By.xpath(or.getProperty("ListofpkgTAddactivationdate_CB")));
		GenericClass.clickElement(chkbox);
		
		WebElement saveBT=GenericClass.driver.findElement(By.xpath(or.getProperty("Addactivationdate_BT")));
		GenericClass.clickElement(saveBT);
		GenericClass.Alert_Accept();
	
	}
		catch(Exception e){
		
		throw e;
	}
		
	}
	
}
