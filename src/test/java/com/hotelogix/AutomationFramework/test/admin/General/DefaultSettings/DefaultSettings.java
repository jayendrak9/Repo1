package com.hotelogix.AutomationFramework.test.admin.General.DefaultSettings;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.hms.hotelogix.automationframework.pages.admin.HomePage.AdminHome;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;
import com.hotelogix.AutomationFramework.Pages.Login.Login;
import com.hotelogix.AutomationFramework.Pages.Login.Admin_home_clickonDefaultSettings;
import com.hotelogix.AutomationFramework.Pages.admin.General.DefaultSettingLandingPage;

//import org.testng.Reporter;

public class DefaultSettings {
	
	
	public WebDriver driver;
	
	private String sTestCaseName;
	private int iTestCaseRow;


	
	@BeforeClass
	public void Login() throws Throwable{
		try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DefaultSettings,Constant.Sheet_DefaultSettings);
			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Browser), ExcelUtil.getCellData(iTestCaseRow, Constant.Col_URL));
		new Login().fn_adminLogin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_HotelCode), ExcelUtil.getCellData(iTestCaseRow, Constant.Col_EmailAddressUsername), ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Password));;
		String str=GenericClass.driver.getTitle();
		Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, Constant.col_ExpectedResult1));
		}catch(Throwable e){
			throw e;
		}
	    }	

	@Test
	public void fn_DefaultSetting() throws Exception{
		try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_DefaultSettings,Constant.Sheet_DefaultSettings);
			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			new Admin_home_clickonDefaultSettings().fn_navigatetodefaultsetting();
			new DefaultSettingLandingPage().fn_navigatetoWebpolicydeposite("30",iTestCaseRow,Constant.Col_DiscountPolicy,Constant.File_DefaultSettings);
		    String str=new DefaultSettingLandingPage().fn_getSaveMsg();
		    System.out.println(str);
		    System.out.println(ExcelUtil.getCellData(iTestCaseRow, Constant.col_ExpectedResult1));
		   Assert.assertEquals(str,ExcelUtil.getCellData(iTestCaseRow, Constant.col_ExpectedResult1));
		   
		}catch(Exception e){
			throw e;
		}
		
		
	}
}



