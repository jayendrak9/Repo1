package com.hotelogix.AutomationFramework.Pages.admin.PriceManager;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class AddPackage {

	public static String pkgname;

	public void filldetail(int iTestCaseRow) throws Exception{

		Properties or=GenericClass.loadOR();

		WebElement Namethepackage=GenericClass.driver.findElement(By.xpath(or.getProperty("Addpkg_Namethepackage_ED")));
		String Str=ExcelUtil.getCellData(iTestCaseRow, Constant.col_nameofthepackage);
		//pkgname=GenericClass.generateRandomString();
		GenericClass.sendKeys(Namethepackage, Str);
		
		WebElement Shortname=GenericClass.driver.findElement(By.xpath(or.getProperty("Addpkg_Shortname_ED")));
		String Getdata=ExcelUtil.getCellData(iTestCaseRow, Constant.col_Shortname);
		//String shornm=GenericClass.generateRandomString();
		GenericClass.sendKeys(Shortname, Getdata);

		WebElement LengthofStay=GenericClass.driver.findElement(By.xpath(or.getProperty("Addpkg_Lengthofstay_ED")));
		String LOS =ExcelUtil.getCellData(iTestCaseRow, Constant.col_lengthofstay);
		GenericClass.sendKeys(LengthofStay, LOS);

		WebElement Description=GenericClass.driver.findElement(By.xpath(or.getProperty("Addpkg_Description_ED")));
		String Descrip=ExcelUtil.getCellData(iTestCaseRow, Constant.col_Description);
		GenericClass.sendKeys(Description, Descrip);
		
		WebElement Save_Bt=GenericClass.driver.findElement(By.xpath(or.getProperty("Addpkg_Save_BT")));
		GenericClass.clickElement(Save_Bt);

	}





}
