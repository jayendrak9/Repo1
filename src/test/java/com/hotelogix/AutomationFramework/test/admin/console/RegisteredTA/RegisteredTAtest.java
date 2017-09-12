package com.hotelogix.AutomationFramework.test.admin.console.RegisteredTA;

import java.util.Set;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;
import com.hotelogix.AutomationFramework.Pages.Login.Login;
import com.hotelogix.AutomationFramework.Pages.admin.Console.AddActivatinDatewindow;
import com.hotelogix.AutomationFramework.Pages.admin.Console.AddTravelAgent;
import com.hotelogix.AutomationFramework.Pages.admin.Console.AdminHome_TA;
import com.hotelogix.AutomationFramework.Pages.admin.Console.Attachpkgwindow;
import com.hotelogix.AutomationFramework.Pages.admin.Console.EditPackageDetail;
import com.hotelogix.AutomationFramework.Pages.admin.Console.ListofRefgisteredTA;
import com.hotelogix.AutomationFramework.Pages.admin.Console.ListofpackageTA;

public class RegisteredTAtest {


	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeMethod
	public void Login() throws Throwable{
		try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RegisterTA,Constant.Sheet_RegisteredTA);
			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

			GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Browser), ExcelUtil.getCellData(iTestCaseRow, Constant.Col_URL));
			new Login().fn_adminLogin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_HotelCode), ExcelUtil.getCellData(iTestCaseRow, Constant.Col_EmailAddressUsername), ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Password));;
		}catch(Throwable e){
			throw e;
		}
	}	

	@Test
	public void fn_RegisteredTA() throws Exception{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.File_RegisterTA,Constant.Sheet_RegisteredTA);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		ExcelUtil.getCellData(iTestCaseRow, Constant.Col_TestCaseName);	
		AdminHome_TA TA=new AdminHome_TA();
		TA.fn_navigatetoRTA_LK();
		ListofRefgisteredTA ListRTA=new ListofRefgisteredTA();
		ListRTA.fn_clickonAddTA();
		AddTravelAgent AddTA=new AddTravelAgent();
		AddTA.fn_addTADetails();
		ListRTA.fn_viewall();
		ListRTA.varifyRTA(iTestCaseRow);
		ListRTA.fn_navigatetoTAPackage();
		ListRTA.fn_viewall();
		ListRTA.fn_clickviewpackage(iTestCaseRow);
		ListofpackageTA TApkg=new ListofpackageTA();
		String A=GenericClass.GetCurrentWindowID();
		TApkg.fn_clickonattachpkg();
		GenericClass.windowHandle(A);
		Attachpkgwindow Apwindow=new Attachpkgwindow();
		Apwindow.Attachpkg(iTestCaseRow);
		GenericClass.Switch_Parent_Window(A);
		TApkg.fn_TApkgview_all();
		TApkg.fn_clickonconfigureLK(iTestCaseRow);
		EditPackageDetail editpkg=new EditPackageDetail();
		editpkg.clickonsavebutton();
		String b=GenericClass.GetCurrentWindowID();
		TApkg.clickonaddactivationdate_LK(iTestCaseRow);
		AddActivatinDatewindow addactwin=new AddActivatinDatewindow();
		GenericClass.windowHandle(b);
		addactwin.activateforever();
		GenericClass.Switch_Parent_Window(b);
		//TApkg.fn_TApkgview_all();
		//Thread.sleep(4000);
		TApkg.varifystatus(iTestCaseRow);
	
	}

	@AfterMethod
	public void closeApp() throws Exception{
		Set<String> handles = GenericClass.driver.getWindowHandles();
		for(String windowId: handles){
			GenericClass.driver.switchTo().window(windowId);
			GenericClass.driver.close();
		}
		ExcelUtil.CloseAllExcelReferences();
	}	
}
