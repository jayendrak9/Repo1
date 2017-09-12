package com.hotelogix.AutomationFramework.Pages.admin.PriceManager;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class EditPackageDetail {

	
	Properties or=GenericClass.loadOR();
	
	public void clkonsavebutton() throws Exception{
		try{
		WebElement save_BT=GenericClass.driver.findElement(By.xpath(or.getProperty("EditpkgDetail_savebutton_BT")));
		GenericClass.clickElement(save_BT);
		}catch(Exception e){
			throw e;
		}
	}
	
	
}
