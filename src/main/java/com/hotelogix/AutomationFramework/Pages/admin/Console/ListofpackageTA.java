package com.hotelogix.AutomationFramework.Pages.admin.Console;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;

public class ListofpackageTA {

	Properties or=GenericClass.loadOR();

	public void fn_clickonattachpkg() throws Exception{


		WebElement Attachpkg_LK=GenericClass.driver.findElement(By.xpath(or.getProperty("ListofTAattachpkg_LK")));

		GenericClass.clickElement(Attachpkg_LK);

	}

	public void fn_TApkgview_all() throws InterruptedException {

		WebElement viewall=GenericClass.driver.findElement(By.xpath(or.getProperty("ListofpkgTA_viewall")));
		GenericClass.selectElement(viewall, "All");
		GenericClass.Alert_Accept();

	}


	public void fn_clickonconfigureLK(int iTestCaseRow) throws Exception{

		try{
			int count=GenericClass.driver.findElements(By.xpath(or.getProperty("LOPTravelagentrowcount"))).size();

			String pkgname=ExcelUtil.getCellData(iTestCaseRow, Constant.col_Nameofpkg);

			for(int i=2; i<=count-2;i++){

				String pkgtxt=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]//strong")).getText();

				if(pkgname.contains(pkgtxt)){

					WebElement con=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[8]/a"));
					GenericClass.clickElement(con);
					break;

				}


			}

		}catch(Exception e){

			throw e;

		}


	}
	
	
	

	public void clickonaddactivationdate_LK(int iTestCaseRow) throws Exception{

		int count=GenericClass.driver.findElements(By.xpath(or.getProperty("LOPTravelagentrowcount"))).size();
		String pkgname=ExcelUtil.getCellData(iTestCaseRow, Constant.col_Nameofpkg);
		for(int i=2;i<=count-2;i++){

			String pkgtxt=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]//strong")).getText();
			if(pkgname.contains(pkgtxt)){

				WebElement addactivationlk=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[7]//a"));
				GenericClass.clickElement(addactivationlk);
				break;

			}
		}


	}


	public void varifystatus(int iTestCaseRow) throws Exception{
		try{
			int count=GenericClass.driver.findElements(By.xpath(or.getProperty("LOPTravelagentrowcount"))).size();

			String status =ExcelUtil.getCellData(iTestCaseRow, Constant.col_statuss);
			String pkgname=ExcelUtil.getCellData(iTestCaseRow, Constant.col_Nameofpkg);

			for( int i=2;i<=count-2;i++){
				Thread.sleep(4000);
				String pkgtxt=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]//strong")).getText();

				if(pkgname.contains(pkgtxt)){

					String src=GenericClass.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]/img")).getAttribute("src");
					Assert.assertEquals(src.endsWith(status), true);
					System.out.println("status is varified");
					break;

				}


			}

		}   catch(Exception e){

			throw e;

		}





	}

	







}
