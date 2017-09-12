package com.hotelogix.AutomationFramework.Pages.admin.PriceManager;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class PackageMasterLandingPage {

	Properties or=GenericClass.loadOR();
	public void  click_Addpackage() throws Exception{

		WebElement Add_Package=GenericClass.driver.findElement(By.xpath(or.getProperty("PackageMaster_AddPackage_LK")));

		GenericClass.clickElement(Add_Package);

	}

	public void fn_viewAll() throws InterruptedException{


		WebElement ele=GenericClass.driver.findElement(By.xpath(or.getProperty("pkgMaster_viewall_DD")));
		GenericClass.selectElement(ele, "All");
		GenericClass.Alert_Accept();
	}


	public void fn_verifyAddedPkg(int iTestCaseRow) throws Exception{
		try{
		int count=GenericClass.driver.findElements(By.xpath(or.getProperty("PkgMaster_TRCount"))).size();
		for(int i=2;i<=count;i++){
			String data=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]/strong")).getText();
			if(data.contains(ExcelUtil.getCellData(iTestCaseRow, Constant.col_nameofthepackage))){
				Assert.assertEquals(data.contains(ExcelUtil.getCellData(iTestCaseRow, Constant.col_nameofthepackage)), true);
				System.out.println("Verified");
				break;
			}
		}
		}catch(Exception e){
			throw e;
		}

	}


}

