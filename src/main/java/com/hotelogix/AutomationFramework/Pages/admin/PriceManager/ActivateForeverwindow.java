package com.hotelogix.AutomationFramework.Pages.admin.PriceManager;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class ActivateForeverwindow {
	
	Properties or=GenericClass.loadOR();
	
 public void activateforever() throws Exception{
	 
	 WebElement CB=GenericClass.driver.findElement(By.xpath(or.getProperty("Activateforever_Checkbox_CB")));
	 GenericClass.clickElement(CB);
	WebElement SaveBT= GenericClass.driver.findElement(By.xpath("//input[@class='disablethis button']"));
	GenericClass.clickElement(SaveBT);
	 GenericClass.Alert_Accept();
 }

}
