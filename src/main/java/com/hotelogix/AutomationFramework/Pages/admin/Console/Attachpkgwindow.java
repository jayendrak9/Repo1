package com.hotelogix.AutomationFramework.Pages.admin.Console;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class Attachpkgwindow {


	Properties or=GenericClass.loadOR();
	public void Attachpkg(int iTestCaseRow) throws Exception{

		
		int count=GenericClass.driver.findElements(By.xpath(or.getProperty("Attchpkgwindowrowcount"))).size();

		String pkgname=ExcelUtil.getCellData(iTestCaseRow, Constant.col_Nameofpkg);

		for(int i=2; i<=count; i++){

			String pkgtxt=GenericClass.driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[4]")).getText();

			if(pkgtxt.contains(pkgname)){

				WebElement cb=GenericClass.driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[2]//input"));
				GenericClass.clickElement(cb);
				break;

			}
                
            
		}
		WebElement BT=GenericClass.driver.findElement(By.xpath(or.getProperty("Attchpkgwindowattach_BT")));
	    
	    GenericClass.clickElement(BT);
     
	}

	
	
}
