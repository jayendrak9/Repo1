package com.hotelogix.AutomationFramework.Pages.Login;

import java.util.Properties;

import org.openqa.selenium.By;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class Login {

	public void fn_adminLogin(String hotelid, String username, String password) throws Exception {
		try{
			Properties or=GenericClass.loadOR();
			//ExcelUtil.setExcelFile(Path, SheetName);();
			GenericClass.driver.findElement(By.xpath(or.getProperty("AL_HotelID_ED"))).sendKeys(hotelid);
			GenericClass.driver.findElement(By.xpath(or.getProperty("AL_HotelUser_ED"))).sendKeys(username);
			GenericClass.driver.findElement(By.xpath(or.getProperty("AL_HotelPassword_ED"))).sendKeys(password);
			GenericClass.driver.findElement(By.xpath(or.getProperty("AL_Login_BT"))).click();
		}catch(Exception e){
			throw e;
		}
	}

	
	
}
