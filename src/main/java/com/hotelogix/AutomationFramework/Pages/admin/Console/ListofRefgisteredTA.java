package com.hotelogix.AutomationFramework.Pages.admin.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class ListofRefgisteredTA {
	Properties or=GenericClass.loadOR();


	public void fn_clickonAddTA() throws Exception{

		WebElement AddTA=GenericClass.driver.findElement(By.xpath(or.getProperty("LstofTA_AddTA_LK")));
		GenericClass.clickElement(AddTA);

	}


//	public void varifyRTA(int iTestCaseRow) throws Exception{
//		try{
//			ArrayList<String> arr= new ArrayList<String>();
//			int rowcount=GenericClass.driver.findElements(By.xpath(or.getProperty("TRcount"))).size();
//			String RTA=ExcelUtil.getCellData(iTestCaseRow, Constant.col_ListofRTA);
//			for(int i=2; i<=rowcount;i++){
//
//				String TAtxt=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[4]//a")).getText();
//				arr.add(TAtxt);
//
//			}
//			Assert.assertEquals(arr.contains(RTA), true);
//
//			System.out.println("RTA varified");
//			//					break;
//
//
//		}catch(Exception e){
//			throw e;
//
//		} 
//
//	}

	
	public void varifyRTA(int iTestCaseRow) throws Exception{
		
		int rowcount=GenericClass.driver.findElements(By.xpath(or.getProperty("TRcount"))).size();
		String RTA=ExcelUtil.getCellData(iTestCaseRow, Constant.col_ListofRTA);
		for(int i=2; i<=rowcount;i++){
			
			String TAtxt=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[4]//a")).getText();
			if(TAtxt.contains(RTA)){
				
				Assert.assertEquals(TAtxt.contains(RTA), true);
				System.out.println("RTA varified");
				
				break;
			}
			
			
		}
		
		
	}
		


	public void fn_navigatetoTAPackage() throws Exception{

		WebElement pricemgr=GenericClass.driver.findElement(By.xpath(or.getProperty("Pricemgr_LK")));
		GenericClass.mouseOverElement(pricemgr);

		WebElement TApkg=GenericClass.driver.findElement(By.xpath(or.getProperty("TAPkg_LK")));
		GenericClass.clickElement(TApkg);

	}



	public void fn_viewall() throws InterruptedException{

		WebElement viewall=GenericClass.driver.findElement(By.xpath(or.getProperty("Viewall_DD")));
		GenericClass.selectElement(viewall, "All");
		GenericClass.Alert_Accept();

	}

	public void fn_clickviewpackage(int iTestCaseRow) throws Exception{

		try{
			int rowcount=GenericClass.driver.findElements(By.xpath(or.getProperty("TRcount"))).size();
			//=ExcelUtil.getCellData(iTestCaseRow, Constant.col_ListofRTA);
			String RTA=ExcelUtil.getCellData(iTestCaseRow, Constant.col_ListofRTA);
			for(int i=2; i<=rowcount;i++){

				String TAtxt=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
				if(TAtxt.contains(RTA)){
					WebElement viewpkg=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[8]/a"));
					GenericClass.clickElement(viewpkg);
					break;
				}

			}

		}catch(Exception e){
			throw e;

		}





	}



}
