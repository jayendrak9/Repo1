package com.hotelogix.AutomationFramework.Pages.admin.Console;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class EditPackageDetail {
	
	Properties or=GenericClass.loadOR();

	public void clickonsavebutton() throws Exception{
		
		
		WebElement SaveBT=GenericClass.driver.findElement(By.xpath(or.getProperty("Editpkgdetailsave_bt")));
		GenericClass.clickElement(SaveBT);
		
	}
	
	
}
