package com.hotelogix.AutomationFramework.test.admin.PriceManager.PackageMaster;


import java.util.Set;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelogix.AutomationFramework.Pages.GenericMethods.Constant;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.ExcelUtil;
import com.hotelogix.AutomationFramework.Pages.GenericMethods.GenericClass;
import com.hotelogix.AutomationFramework.Pages.Login.Login;
import com.hotelogix.AutomationFramework.Pages.admin.PriceManager.AdminHome;
import com.hotelogix.AutomationFramework.Pages.admin.PriceManager.AttachPackage;
import com.hotelogix.AutomationFramework.Pages.admin.PriceManager.EditPackageDetail;
import com.hotelogix.AutomationFramework.Pages.admin.PriceManager.ListOfFrontDeskPackages;
import com.hotelogix.AutomationFramework.Pages.admin.PriceManager.ActivateForeverwindow;
import com.hotelogix.AutomationFramework.Pages.admin.PriceManager.AddPackage;
import com.hotelogix.AutomationFramework.Pages.admin.PriceManager.PackageMasterLandingPage;

public class PackageMasterTest {

	
	private String sTestCaseName;
	private int iTestCaseRow;
   
	@BeforeMethod
	public void Login() throws Throwable{
		try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.file_PackageMaster,Constant.Sheet_PackageMaster);
			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		GenericClass.fn_OpenAdmin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Browser), ExcelUtil.getCellData(iTestCaseRow, Constant.Col_URL));
		new Login().fn_adminLogin(ExcelUtil.getCellData(iTestCaseRow, Constant.Col_HotelCode), ExcelUtil.getCellData(iTestCaseRow, Constant.Col_EmailAddressUsername), ExcelUtil.getCellData(iTestCaseRow, Constant.Col_Password));;
//		String str=GenericClass.driver.getTitle();
//		Assert.assertEquals(str, ExcelUtil.getCellData(iTestCaseRow, Constant.Col_ExpectedResult1));
		}catch(Throwable e){
			throw e;
		}
	    }	
	
	@Test
	public void fn_addPackage() throws Exception{
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1+Constant.file_PackageMaster,Constant.Sheet_PackageMaster);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		AdminHome AH=new AdminHome();
		AH.fn_navigatetopackagemaster();
		PackageMasterLandingPage PkgMaster_LP=new PackageMasterLandingPage();
		PkgMaster_LP.click_Addpackage();
		AddPackage AddPkg=new AddPackage();
		AddPkg.filldetail(iTestCaseRow);
		PkgMaster_LP.fn_viewAll();
		PkgMaster_LP.fn_verifyAddedPkg(iTestCaseRow);
		AH.fn_navigateToFrontdeskPkg();
		Thread.sleep(3000);
		ListOfFrontDeskPackages Listfrontdeskpkg=new ListOfFrontDeskPackages();
		String a=GenericClass.GetCurrentWindowID();
		Listfrontdeskpkg.Attach_package_LK();
		AttachPackage AP=new AttachPackage();
		GenericClass.windowHandle(a);
		AP.AttachMasterpkg(iTestCaseRow);
		GenericClass.Switch_Parent_Window(a);
		Listfrontdeskpkg.view_all();
		Thread.sleep(4000);
		Listfrontdeskpkg.varifyaddedpkgmaster(iTestCaseRow);
		Listfrontdeskpkg.fn_clickonconfigure(iTestCaseRow);
		EditPackageDetail EPD=new EditPackageDetail();
		EPD.clkonsavebutton();
		String b=GenericClass.GetCurrentWindowID();
		Listfrontdeskpkg.fn_addactivationdate(iTestCaseRow);
		ActivateForeverwindow Actforwin=new ActivateForeverwindow();
		GenericClass.windowHandle(b);
		Actforwin.activateforever();
		GenericClass.Switch_Parent_Window(b);
		Thread.sleep(4000);
		Listfrontdeskpkg.varifystatusofpkg(iTestCaseRow);
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
	
	
	

