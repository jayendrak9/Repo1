package com.hotelogix.AutomationFramework.Pages.admin.PriceManager;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class ListOfFrontDeskPackages {

	Properties or=GenericClass.loadOR();

	public void Attach_package_LK() throws Exception{

		WebElement attachpackage_LK =GenericClass.driver.findElement(By.xpath(or.getProperty("Frontdesk_attachpackage_LK")));
		GenericClass.clickElement(attachpackage_LK);

	}

	public void view_all() throws InterruptedException{

		WebElement viewall=GenericClass.driver.findElement(By.xpath(or.getProperty("Listfrontdeskpkg_view_all_DD")));
		//GenericClass.selectElement(view_all_D, "All");
		GenericClass.selectElement(viewall, "All");
		GenericClass.Alert_Accept();

	}

	public void varifyaddedpkgmaster(int iTestCaseRow) throws Exception{
		try{
			Thread.sleep(2000);
			ArrayList<String> arr= new ArrayList<String>();
			int count=GenericClass.driver.findElements(By.xpath(or.getProperty("Listfrontdeskpkg_TRcount"))).size();
			for(int i=2; i<=count-3; i++){	
				String pkgData=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]/strong")).getText();
				arr.add(pkgData);
			}
			String Data=ExcelUtil.getCellData(iTestCaseRow, Constant.col_nameofthepackage);
			Assert.assertEquals(arr.contains(Data), true);
			System.out.println("package is varified");
		}catch(Exception e){
			throw e;
		}
	}


	public void fn_clickonconfigure(int iTestCaseRow) throws Exception{

		try{
			int rowcount=GenericClass.driver.findElements(By.xpath(or.getProperty("Listfrontdeskpkg_TRcount"))).size();
			String GetData=ExcelUtil.getCellData(iTestCaseRow, Constant.col_nameofthepackage);
			for(int i=2;i<=rowcount-3;i++){
				String pkgtxt=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]/strong")).getText();
				//	String GetData=ExcelUtil.getCellData(iTestCaseRow, Constant.col_nameofthepackage);
				if(pkgtxt.contains(GetData)){
					Assert.assertEquals(pkgtxt.contains(GetData), true);
					WebElement confi=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]/td[7]//a"));
					GenericClass.clickElement(confi);
					break;

				}	
			}

		}
		catch(Exception e){
			throw e;
		}

	}

	public void fn_addactivationdate(int iTestCaseRow) throws Exception{
		try{
			int count=GenericClass.driver.findElements(By.xpath(or.getProperty("Listfrontdeskpkg_TRcount"))).size();
			String pkgname=ExcelUtil.getCellData(iTestCaseRow, Constant.col_nameofthepackage);
			for(int i=2;i<=count-3;i++){
				String pkgtxt=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]/strong")).getText();
				
				if(pkgtxt.contains(pkgname)){
					WebElement addactBT=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/a"));
					GenericClass.clickElement(addactBT);
					break;
				}

			}
		}catch(Exception e){
			throw e;
		}
 
 }
	 public void varifystatusofpkg(int iTestCaseRow) throws Exception{
		 String s=null;
		 try{
			 
	    int count=GenericClass.driver.findElements(By.xpath(or.getProperty("Listfrontdeskpkg_TRcount"))).size();
	    String Data=ExcelUtil.getCellData(iTestCaseRow, Constant.col_status);
	    String nameOfPkg=ExcelUtil.getCellData(iTestCaseRow, Constant.col_nameofthepackage);
	    for(int i=2;i<=count-3;i++){
	    	String pkgtxt=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]/strong")).getText();
	     if(pkgtxt.contains(nameOfPkg) ){
	    	 Thread.sleep(2000);
	    	 s=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/img")).getAttribute("src");
	    	  Assert.assertEquals(s.endsWith(Data), true);
	    	  System.out.println("package status is on Yeeeeee");
	    	break; 
	     }
	    }
		 }catch(AssertionError e){
			 throw e;
		 }
		 catch(Exception e){
			 
			 throw e;
			 
			 
			 
		 }
		 
		 
		 
		 
		 
		 
	}


}





