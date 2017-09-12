package com.hotelogix.AutomationFramework.Pages.admin.General;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class DefaultSettingLandingPage {

	
	public String disc;
	
	public void fn_navigatetoWebpolicydeposite(String value,int iTestCaseRow,int Col,String Filename) throws Exception{
		
		
		Properties or=GenericClass.loadOR();
		WebElement Dchange=GenericClass.driver.findElement(By.xpath(or.getProperty("Defaultsetting_change_Lk")));
		GenericClass.clickElement(Dchange);
		//WebElement ccg=GenericClass.driver.findElement(By.xpath(or.getProperty("Defaultsetting_webpolicy_edit_CCG")));
		//GenericClass.selectElement(ccg, "");
		WebElement Discountpolicybox=GenericClass.driver.findElement(By.xpath(or.getProperty("Defaultsetting_ED")));
		
		ExcelUtil.setCellData(value, iTestCaseRow, Col, Filename);		
		
		disc=ExcelUtil.getCellData(iTestCaseRow, Col);
		
		GenericClass.sendKeys(Discountpolicybox, disc);
		WebElement Dbutton=GenericClass.driver.findElement(By.xpath(or.getProperty("Defaultsetting_ok_BT")));
		GenericClass.clickElement(Dbutton);
		WebElement savechange=GenericClass.driver.findElement(By.xpath(or.getProperty("DefaultSetting_savechanges_BT")));
		GenericClass.clickElement(savechange);
				
	}
	
	
	
	public String fn_getSaveMsg(){
		Properties or=GenericClass.loadOR();
		String str=GenericClass.driver.findElement(By.xpath(or.getProperty("DefaultSetting_Msg_Text"))).getText();
		return str;
	}
}
