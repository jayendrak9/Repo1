package com.hotelogix.AutomationFramework.Pages.admin.PriceManager;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class AttachPackage {
	
	Properties or=GenericClass.loadOR();

	public void AttachMasterpkg(int iTestCaseRow) throws Exception{
		try{
		 
		int i;
		int rowcount=GenericClass.driver.findElements(By.xpath(or.getProperty("AttachPkg_TRcount"))).size();
		for( i=2; i<=rowcount; i++){
		String pkgtxt=GenericClass.driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+i+"]//td[4]")).getText();
		 String getdata=ExcelUtil.getCellData(iTestCaseRow, Constant.col_nameofthepackage);
		if(pkgtxt.contains(getdata)){
			Assert.assertEquals(pkgtxt.contains(getdata), true);
			WebElement CB=GenericClass.driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+i+"]//td[2]/input")) ;
			GenericClass.clickElement(CB);
			break;
		}
	     }
		 WebElement attachBT=GenericClass.driver.findElement(By.xpath(or.getProperty("attachpkg_attach_BT")));
		 GenericClass.clickElement(attachBT);
		
         }catch(Exception e){
			throw e;
		}
	}
	
	
	
	
}
