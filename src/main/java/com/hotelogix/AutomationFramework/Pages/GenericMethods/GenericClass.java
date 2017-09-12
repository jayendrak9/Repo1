package com.hotelogix.AutomationFramework.Pages.GenericMethods;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.AutomationFramework.Pages.Login.Login;

//import com.hms.hotelogix.automationframework.pages.Email.LoginPage.EmailAccountLoginPage;
//import com.hms.hotelogix.automationframework.pages.Frontdesk.LoginPage.FrontdeskLoginPage;
//import com.hms.hotelogix.automationframework.pages.GenericMethod.GenericClass;
//import com.hms.hotelogix.automationframework.pages.Web.WebConsole.WebReservationHomePage;
//import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;

public class GenericClass {

	public static Set<String> handles4;
	public static String Parent;
	public static String Child;
	public static int size;
	public static String scr_value="http://hotelogix.stayezee.com/images/off.GIF";
	public static int total_CB;
	public static String IndexText;

	private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int RANDOM_STRING_LENGTH =5;
	private static final String NUM_LIST = "123456789";

	public static Properties OR;

	public static WebDriver driver;

	private static EventFiringWebDriver e_driver;

	//	private static WebEventListener eventListener; 



	//public static String Currenthandle4;
	public	static String value;




	public  static String randomUniqueString()   {
		String uniqueString=null;
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
			Date date = new Date();
			uniqueString = format.format(date);

		}catch(Exception e){

			e.printStackTrace();
		}

		return uniqueString;
	}

	//	public static EmailAccountLoginPage fn_OpenEmailBox(String BrowserType, String URL) throws Exception{
	//		fn_LaunchBrowser(BrowserType);
	//		Thread.sleep(8000);
	//		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	//		driver.get(URL);
	//		Thread.sleep(9000);
	//		EmailAccountLoginPage  EALP=PageFactory.initElements(GenericClass.driver, EmailAccountLoginPage.class);
	//		return EALP;
	//	}



	public static void mouseOverElement( WebElement element) {

		Actions builder = new Actions(driver);

		builder.moveToElement(element).build().perform();

	}
	//

	public static String Alert_Accept()
	{
		Alert alert = driver.switchTo().alert();
		String str = alert.getText();
		alert.accept();
		return str;
	}

	public static String Alert_Dismiss()
	{

		Alert alert = driver.switchTo().alert();
		String str = alert.getText();
		alert.dismiss();
		return str;


	}


	public static String GenerateRandomNumber(int length){
		int RANDOM_STRING_LENGTH = length;

		{
			StringBuffer randStr=new StringBuffer();
			for(int i=0;i<RANDOM_STRING_LENGTH;i++)
			{
				int num=getRandomNumber1();
				char ch=NUM_LIST.charAt(num);
				randStr.append(ch);
			}
			return randStr.toString();
		}}

	private static int getRandomNumber1(){
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(NUM_LIST.length());
		if (randomInt - 1 == -1)
		{
			return randomInt;
		}
		else
		{
			return randomInt - 1;
		}
	}

	public static String GetSelectedValueFromDropdown(WebElement element){

		Select s=new Select(element);

		return s.getFirstSelectedOption().getText();

	}
	public static void alert_handle() throws InterruptedException{
		try{
			Alert A1 = driver.switchTo().alert();
			Reporter.log("Alert detected",true);

			String Alert1 = A1.getText();
			System.out.println("Pop_UpText :" + Alert1);



			A1.accept();
			Reporter.log("Alert accepted", true);}catch(Exception e){System.out.println(e);}

		Thread.sleep(5000);

	}

	public static String getText(WebElement element) throws InterruptedException {
		Thread.sleep(2000);
		return element.getText();
	}


	public static int GetAllIframeInPage(){

		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);
		return numberOfFrames;

	}

	/**
	 * This method for getting current window id to handle windows.
	 * @return :As it returns Window id in string format.
	 */
	public static String GetCurrentWindowID(){


		String Currenthandle4 = driver.getWindowHandle();
		//
		System.out.println("parent window id:"+Currenthandle4);

		return Currenthandle4;
	}



	/**
	 * This method removing parent window id and focusing on child window.
	 * @param ParentID : As ParentID is a Parent window id.
	 * @throws InterruptedException
	 */
	public  static void  windowHandle(String ParentID) throws InterruptedException
	{


		//.........................................Window Handling..................................................................................//

		//
		//	         String Currenthandle4 = driver.getWindowHandle();
		////
		//	          System.out.println("parent window id:"+Currenthandle4);

		//.....................................handle the child window.............................................................................//

		Set<String> handles4= driver.getWindowHandles();


		handles4.remove(ParentID);


		//performing action on child window

		driver.switchTo().window(handles4.iterator().next());

		//   Thread.sleep(3000);
		//          ABP.SaveBlockTitle("southwest");



		Thread.sleep(2000);


		//Switch back to original browser (first window)

		//  driver.switchTo().window(Currenthandle4);

	}

	public static void Switch_Parent_Window(String ParentID){

		driver.switchTo().window(ParentID);
		System.out.println("Yoo Back to Parent Window...");
	}


	public static List<WebElement> GetAllTheValueFromDropDown(WebElement ele){
		Select s=new Select(ele);

		List<WebElement> ele1=s.getOptions();

		System.out.println(ele1.size());
		return ele1;
	}

	public static void switchToWindowHandle( String titleval) throws Exception {
		try{
			Set<String> setHndlValColls=driver.getWindowHandles();
			Iterator<String>  itHandleColls= setHndlValColls.iterator();
			while(itHandleColls.hasNext()==true){
				String hndlval=itHandleColls.next();
				driver.switchTo().window(hndlval);
				String title=driver.getTitle();
				if(title.equalsIgnoreCase(titleval)){
					break;
				}
			}
		}catch(Exception e){
			throw e;
		}

	}


	public static void switchToWindowHandleByURL(String url) throws Exception {
		try{
			Set<String> setHndlValColls=driver.getWindowHandles();
			Iterator<String>  itHandleColls= setHndlValColls.iterator();
			while(itHandleColls.hasNext()==true){
				String hndlval=itHandleColls.next();
				driver.switchTo().window(hndlval);
				String URL=driver.getCurrentUrl();
				if(URL.equalsIgnoreCase(url)){
					break;
				}
			}
		}catch(Exception e){
			throw e;
		}
	}




	/**
	 * This method is used for launching the browser and launching the application URL.
	 * @param BrowserType : We will pass the browser name to this method.
	 * @param URL :We will pass the URL of application under test.
	 * @return : As it returns The AdminLogin page class to perform login action.
	 * @throws Exception : Throws Exception if any occurs.
	 */
	public static Login fn_OpenAdmin(String BrowserType, String URL) throws Exception{
		fn_LaunchBrowser(BrowserType);
		driver.manage().timeouts().pageLoadTimeout(9000, TimeUnit.SECONDS);
		//driver.manage().
		driver.navigate().to(URL);
		//driver.get(URL);
		Login ALO = PageFactory.initElements(GenericClass.driver, Login.class);
		return ALO;
	}
	//



	/**
	 * This method is used for launching the browser and launch the Web Console.
	 * @param BrowserType : As we pass browser type to this method.
	 * @param URL : As we pass the URL to this method.
	 * @return  : As it returns the WebReservationHomePage for further operations.
	 * @throws Exception
	 */
	//	public static WebReservationHomePage fn_OpenWebConsole(String BrowserType, String URL) throws Exception{
	//		fn_LaunchBrowser(BrowserType);
	//		driver.manage().timeouts().pageLoadTimeout(9000, TimeUnit.SECONDS);
	//		driver.get(URL);
	//
	//		WebReservationHomePage WRH=PageFactory.initElements(GenericClass.driver,WebReservationHomePage.class);
	//		return WRH;
	//
	//	}




	/**
	 * This method for opening frontdesk console.
	 * @param BrowserType : Its parameter in which we will pass browser name as an arguments.
	 * @param URL : Its parameter in which we will pass URL as an arguments.
	 * @return : As it returns FrontdeskLoginPage and initializes all its element.
	 * @throws Exception
	 */
	//	public static FrontdeskLoginPage fn_OpenFrontdesk(String BrowserType ,String URL ) throws Exception{
	//		fn_LaunchBrowser(BrowserType);
	//		driver.manage().timeouts().pageLoadTimeout(9000, TimeUnit.SECONDS);
	//		driver.get(URL);
	//
	//		FrontdeskLoginPage FLP = PageFactory.initElements(GenericClass.driver, FrontdeskLoginPage.class);
	//		return FLP;
	//	}

	public static String sendKeys( WebElement element,String sValue) throws Exception {
		try{
			fn_VatidateWebElement(element);
			element.clear();
			element.sendKeys(sValue);
			value=sValue;
		}catch(Exception e){
			throw e;
		}
		return value;
	}

	private static void webdriverWait(WebElement element) throws Exception {
		try{
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e){
			throw e;
		}
	}

	public static String getURL()
	{
		String url=driver.getCurrentUrl();
		return url;
	}



	/*	public static WebDriver fn_LaunchBrowser(String browserName){

	    if(browserName.equalsIgnoreCase("Firefox")==true){
	        driver=new FirefoxDriver();
	    }else if(browserName.equalsIgnoreCase("Chrome")==true){

	        System.setProperty("webdriver.chrome.driver", "F://AutomationFramework//AutomationFramework//Resources//chromedriver.exe");
	        driver=new  ChromeDriver();

	    }else if(browserName.equalsIgnoreCase("IE")==true){
	        System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
	        driver=new  InternetExplorerDriver();

	    }
	    driver.manage().timeouts().implicitlyWait(60,  TimeUnit.SECONDS);
	    return driver;
	  }*/

	public static WebDriver fn_LaunchBrowser(String BrowserType) throws Exception {
		WebDriver Driver_Object = null;
		if (BrowserType.equalsIgnoreCase("FF")
				|| BrowserType.equalsIgnoreCase("Firefox")) {
			//		    System.setProperty("webdriver.gecko.driver", ".\\Resources\\geckodriver.exe");
			//		    DesiredCapabilities capabilities =DesiredCapabilities.firefox();
			//		    capabilities.setCapability("marionette", true);
			//          capabilities.setCapability("firefox_binary", ".\\Resources\\geckodriver.exe");
			Driver_Object = new FirefoxDriver();
		} else if (BrowserType.equalsIgnoreCase("Safari")) {
			Driver_Object = new SafariDriver();
		} else if (BrowserType.equalsIgnoreCase("chrome") || BrowserType.equalsIgnoreCase("CH")) {
			System.setProperty("webdriver.chrome.driver","./Resources/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			LoggingPreferences loggingprefs = new LoggingPreferences();
			//	loggingprefs.enable(LogType.BROWSER, Level.ALL);
			capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
			capabilities.setCapability("chrome.binary", ".//Resource//chromedriver.exe");
			capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			Driver_Object = new ChromeDriver();
		} else if (BrowserType.equalsIgnoreCase("IE")|| BrowserType.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.edge.driver",".//Resources//MicrosoftWebDriver.exe");
			Driver_Object = new EdgeDriver();
			//InternetExplorerDriverService.Builder service = new InternetExplorerDriverService.Builder();
			/*service = service.withLogLevel(InternetExplorerDriverLogLevel.TRACE);
			service = service.withLogFile(new File("d:\\logs\\selenium.log"))*/
			//	DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			//	ieCapabilities.setCapability("requireWindowFocus", true);
			//.setCapability("ie.ensureCleanSession", true);
			//ieCapabilities.setCapability("nativeEvents", false);
			//			ieCapabilities.setCapability(CapabilityType.BROWSER_NAME,"Internet Explorer");
			//			ieCapabilities.setCapability(CapabilityType.VERSION, "8");
			//		ieCapabilities.setCapability("ie.forceCreateProcessApi", true);
			//			ieCapabilities.setCapability("ie.browserCommandLineSwitches","-private");

			// ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			// true);
			//Driver_Object = new InternetExplorerDriver();
			// Driver_Object = new InternetExplorerDriver();
		}
		//		else if (BrowserType.equalsIgnoreCase("remote")) {
		//			DesiredCapabilities cap = new DesiredCapabilities();
		//			cap.setBrowserName("chrome");
		//			Driver_Object = new RemoteWebDriver(new  (
		//					"http://localhost:4446/wd/hub"), cap);
		//		}
		// DO NOT DELETE IT

		/* * else if(BrowserType.equalsIgnoreCase("bmp")){ ProjectSnappyProxy
		 * objProjectSnappyProxy = ProjectSnappyProxy.getInstance();
		 * System.setProperty("webdriver.chrome.driver",
		 * ".\\Resources\\chromedriver.exe"); Driver_Object=new
		 * ChromeDriver(objProjectSnappyProxy.getProxyDesiredCapabilties(4567));
		 *
		 * }*/

		//		else {
		//
		//			logger.info("Provided Browser Type is invalid, please check");
		//		}

		Driver_Object.manage().window().maximize();
		Driver_Object.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
		Driver_Object.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		driver=Driver_Object;
		return driver;
	}


	public static WebElement clickElement( WebElement element) throws Exception{
		try{
			if(element.isDisplayed() && element.isEnabled()){
				webdriverWait(element);
				element.click();
			}
		}catch(NoSuchElementException e){
			Thread.sleep(2000);
			element.click();
		}catch(Exception e){
			throw e;
		}
		return element;
	}


	public static void js_Sendkey(WebElement element, String id){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].value='"+id+"';", element);
	}

	public static void js_Click(WebElement element){

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}



	public static boolean isEnable(String text ,WebElement element)
	{
		boolean result =element.isEnabled();

		//System.out.println(result);

		if(result == true)
		{
			System.out.println(text + "Element is Enable");
		}

		else
		{
			System.out.println(text + "Element is Disabled");
		}

		return result;

	}

	public static boolean checkElementDisplay(String str, WebElement element) throws Exception{
		try{
			boolean status = element.isDisplayed() && element.isEnabled();
			Assert.assertEquals(status, true);
			return status;
		}catch(AssertionError e){
			throw e;
		}
	}


	public static void selectElement(WebElement element, String a ) throws InterruptedException{
		Select sel = new Select(element);
		Thread.sleep(2000);
		sel.selectByVisibleText(a);
	}


	public static String selectElementByvalue(WebElement element,String b)
	{
		Select sel=new Select(element);
		sel.selectByValue(b);
		String txt=sel.getFirstSelectedOption().getText();
		return txt;
	}

	public static String SelectByIndex(WebElement ele,int ind){
		Select sel=new Select(ele);
		sel.selectByIndex(ind);
		IndexText=sel.getFirstSelectedOption().getText() ;
		return IndexText;

	}



	public static String selectValueFromDropdownUsingIndex(WebElement element, int index) throws Exception{
		String  selValue=null;
		try{
			Select s=new Select(element);
			s.selectByIndex(index);	
			selValue=s.getFirstSelectedOption().getText();

		}
		catch(Exception e){
			throw e;
		}
		return selValue;
	}

	public static List<WebElement> GetAllOptionFromDropdown(WebElement ele){

		Select s=new Select(ele);


		return s.getOptions();

	}
	public static String jvmBitVersion()
	{
		return System.getProperty("sun.arch.data.model");
	}

	//		public static void autoit(String fileToUpload, String DialogTitle) throws InterruptedException {
	//			String jacobDllVersionToUse;
	//			if (jvmBitVersion().contains("32")){
	//			jacobDllVersionToUse = "jacob-1.18-M2-x86.dll";
	//			}
	//			else {
	//			jacobDllVersionToUse = "jacob-1.18-M2-x64.dll";
	//			}
	//      File file = new File("Lib", jacobDllVersionToUse);
	////			System.out.println(LibraryLoader.JACOB_DLL_PATH+"|||||||||"+file.getAbsolutePath());
	////			System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
	////			Runtime.getRuntime().loadLibrary(LibraryLoader.JACOB_DLL_PATH);
	////			Runtime.getRuntime().loadLibrary(file.getAbsolutePath());
	////			AutoItX x = new AutoItX();
	////			x.winActivate(DialogTitle);
	////			x.winWaitActive(DialogTitle);
	////			x.ControlSetText(DialogTitle, "", "Edit1",fileToUpload) ;
	////			Thread.sleep(1000);
	////			x.controlClick(DialogTitle, "", "Button1") ;
	////			Thread.sleep(1000);
	//	}

	public static int CheckBox_Count(List<WebElement> element){

		List<WebElement> checkBoxes = element;
		for(int i=0; i<checkBoxes.size(); i++){
			checkBoxes.get(i).click();
		}
		int checkedCount=1;
		int uncheckedCount=0;
		for(int i=1 ; i<checkBoxes.size(); i++){
			if(checkBoxes.get(i).isSelected()){
				checkedCount++;
			}else{
				uncheckedCount++;
			}
		}
		return checkedCount;  //change type f method to int
	}



	public static int tr_count(List<WebElement> columnelements){
		int Total_tr=columnelements.size();
		System.out.println(Total_tr);
		return Total_tr;
	}


	public static String generateRandomString(){

		StringBuffer randStr = new StringBuffer();
		for(int i=0; i<RANDOM_STRING_LENGTH; i++){
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	private static int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}




	/** This method performs descending sorting behalf of the name.
	 *
	 * @param element : Here element is an View dropdown element.
	 * @param a : Here a is value which needs to be select from the dropdown.
	 * @param b : Its Upward arrow link .
	 * @param xpath : Here xpath is Entity name column .
	 * @throws Exception
	 */	   
	public static void sortingName_Downward(WebElement drpdwn_View,String viewDD_Value,WebElement arrow_Downward,List<WebElement> columnelements,String xpath_NameColumn) throws Exception{
		selectElement(drpdwn_View, viewDD_Value);
		GenericClass.ActionOnAlert("Accept");


		//GenericClass.clickElement(room_down);
		List<String> sortedNames = new ArrayList<String>();
		List<String> UnsortedNames = new ArrayList<String>();

		//int size=GenericClass.row_count(columnelements);
		//int size1=size-2;
		int size_value=tr_count(columnelements);
		System.out.println(size_value);
		List<WebElement> rowelement=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
		String getData;
		for(int i=0;i<size_value;i++)
		{

			getData=rowelement.get(i).getText();
			UnsortedNames.add(getData);
		}
		System.out.println(UnsortedNames);
		List<String> sortingOperation = UnsortedNames;
		//Collections.sort(sortingOperation);
		Collections.sort(sortingOperation,String.CASE_INSENSITIVE_ORDER);
		//Iterator itr = sortingOperation.iterator();
		//  while(itr.hasNext()){
		//	        System.out.println(itr.next());
		//   }
		System.out.println(sortingOperation);
		clickElement(arrow_Downward);
		List<WebElement> element1=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
		String getsorted;
		for(int j=0;j<size_value;j++)
		{
			getsorted=element1.get(j).getText();
			sortedNames.add(getsorted);
		}
		System.out.println(sortedNames);
		boolean result=sortingOperation.equals(sortedNames);
		if(result==true)
		{
			System.out.println("Ascending Sorting function passed");
		}
		else
		{
			System.out.println("Ascending Sorting function failed");
		}
	}

	/** This method performs descending sorting behalf of the name.
	 *
	 * @param element : Here element is an View dropdown element.
	 * @param a : Here a is value which needs to be select from the dropdown.
	 * @param b : Its downward arrow link .
	 * @param xpath : Here xpath is Entity name column .
	 * @throws Exception
	 */    
	/*	public static void sortingName_Downward(WebElement drpdwn_View,String viewDD_Value,WebElement arrow_Downward,List<WebElement> columnelements,String xpath_NameColumn) throws Exception{
		selectElement(drpdwn_View, viewDD_Value);
		GenericClass.ActionOnAlert("Accept");
		List<String> sortedNames = new ArrayList<String>();
		List<String> UnsortedNames = new ArrayList<String>();
		int size_value=tr_count(columnelements);
		System.out.println(size_value);
		List<WebElement> rowelement=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
		String getData;
		for(int i=0;i<=rowelement.size()-2;i++){
		  getData=rowelement.get(i).getText();
		  UnsortedNames.add(getData);
		}
		System.out.println(UnsortedNames);
		List<String> sortingOperation = UnsortedNames;
		Collections.sort(sortingOperation,String.CASE_INSENSITIVE_ORDER);
		System.out.println(sortingOperation);
		clickElement(arrow_Downward);
		List<WebElement> element1=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
		String getsorted;
		for(int j=0;j<element1.size()-1;j++){
		getsorted=element1.get(j).getText();
		sortedNames.add(getsorted);
		}
		System.out.println(sortedNames);
		boolean result=sortingOperation.equals(sortedNames);
		Assert.assertEquals(result, true);
	}*/



	/** This method performs descending sorting behalf of the name.
	 *
	 * @param element : Here element is an View dropdown element.
	 * @param a : Here a is value which needs to be select from the dropdown.
	 * @param b : Its Upward arrow link .
	 * @param xpath : Here xpath is Entity name column .
	 * @throws Exception
	 */
	public static void sortingName_Upward(WebElement drpdwn_View,String viewDD_Value,WebElement arrow_upward,List<WebElement> columnelements,String xpath_NameColumn) throws Exception
	{
		selectElement(drpdwn_View,viewDD_Value);
		GenericClass.ActionOnAlert("Accept");
		//GenericClass.clickElement(room_down);
		List<String> sortednames = new ArrayList<String>();
		List<String> Unsortednames = new ArrayList<String>();
		int size_result=GenericClass.tr_count(columnelements);
		//int size1=size-2;
		System.out.println(size_result);
		List<WebElement> rowelement=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
		String getData;
		for(int i=0;i<size_result;i++)
		{

			getData=rowelement.get(i).getText();
			Unsortednames.add(getData);
		}

		System.out.println(Unsortednames);
		List<String> sortingOperation = Unsortednames;
		Comparator mycomparator = Collections.reverseOrder();

		//System.out.println(sortingOperation);
		Collections.sort(sortingOperation,String.CASE_INSENSITIVE_ORDER);
		Collections.sort(sortingOperation,mycomparator);
		Collections.sort(sortingOperation,String.CASE_INSENSITIVE_ORDER);
		Collections.reverse(sortingOperation);
		System.out.println(sortingOperation);
		GenericClass.clickElement(arrow_upward);
		List<WebElement> element2=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
		String getsorted;
		for(int j=0;j<size_result;j++)
		{
			getsorted=element2.get(j).getText();
			sortednames.add(getsorted);
		}
		System.out.println(sortednames);
		boolean result=sortingOperation.equals(sortednames);
		if(result==true)
		{
			System.out.println("Descending Sorting function passed");
		}
		else
		{
			System.out.println("Descending Sorting function failed");
		}
	}


	/** This method performs descending sorting behalf of the name.
	 *
	 * @param element : Here element is an View dropdown element.
	 * @param a : Here a is value which needs to be select from the dropdown.
	 * @param b : Its Upward arrow link .
	 * @param xpath : Here xpath is Entity name column .
	 * @throws Exception
	 *//*
	public static void sortingName_Upward(WebElement drpdwn_View,String viewDD_Value,WebElement arrow_upward,List<WebElement> columnelements,String xpath_NameColumn) throws Exception{
	 selectElement(drpdwn_View,viewDD_Value);
	 GenericClass.ActionOnAlert("Accept");
	List<String> sortednames = new ArrayList<String>();
	List<String> Unsortednames = new ArrayList<String>();
	int size_result=GenericClass.tr_count(columnelements);
	System.out.println(size_result);
	List<WebElement> rowelement=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
	String getData;
	for(int i=0;i<=rowelement.size()-2;i++){
	  getData=rowelement.get(i).getText();
	  Unsortednames.add(getData);
	}

	System.out.println(Unsortednames);
	System.out.println(Unsortednames.size());
	List<String> sortingOperation = Unsortednames;
	Comparator mycomparator = Collections.reverseOrder();
	Collections.sort(sortingOperation,String.CASE_INSENSITIVE_ORDER);
	Collections.sort(sortingOperation,mycomparator);
	Collections.sort(sortingOperation,String.CASE_INSENSITIVE_ORDER);
	Collections.reverse(sortingOperation);
	System.out.println(sortingOperation);
	GenericClass.clickElement(arrow_upward);
	List<WebElement> element2=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
	String getsorted;
	for(int j=0;j<=element2.size()-2;j++){
	 getsorted=element2.get(j).getText();
	 sortednames.add(getsorted);
	 }
	System.out.println(sortednames);
	System.out.println(sortednames.size());
	boolean result=sortingOperation.equals(sortednames);
	Assert.assertEquals(result, true);
	}*/




	/**
	 *
	 * @param element : Here element is view drop down.
	 * @param a : Here a is drop down value to be select.
	 * @param b : Here b is image icon for Active
	 * @param click : Here click is downward sort arrow
	 * @param columnelements
	 * @param xpath : Here xpath is Entity name column
	 * @param xpath1 : Here xpath1 is Entity Status column
	 * @throws Exception
	 */
	public static void sortstatus_Downward(WebElement drpdwn_View,String viewDD_Value,WebElement img_Active,WebElement arrow_Downward,List<WebElement> columnelements,String xpath_NameColumn,String xpath1_StatusColumn) throws Exception
	{
		try
		{
			selectElement(drpdwn_View, viewDD_Value);
			GenericClass.ActionOnAlert("Accept");
			clickElement(img_Active);
			clickElement(arrow_Downward);
			int count=GenericClass.tr_count(columnelements);
			System.out.println(count);
			//int count1=count-1;
			List<WebElement> data_text=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
			List<WebElement> src1=GenericClass.driver.findElements(By.xpath(xpath1_StatusColumn));
			for(int i=0;i<count;i++)
			{
				String data=data_text.get(i).getText();
				String value=src1.get(i).getAttribute("src");
				if(value.equals(scr_value))
				{
					Assert.assertEquals(value.equals(scr_value), true);
					System.out.println("de-active room is present at the end when downward arrow is clicked,"+i+","+data+".");

				}

			}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	/**
	 *
	 * @param element : Here element is view drop down.
	 * @param a : Here a is drop down value to be select
	 * @param click : Here click is upward sort arrow
	 * @param columnelements
	 * @param xpath : Here xpath is Entity name column
	 * @param xpath1 : Here xpath1 is Entity Status column
	 * @throws Exception
	 */

	public static void sortstatus_Upward(WebElement drpdwn_View,String viewDD_Value,WebElement arrow_Upward,List<WebElement> columnelement,String xpath_NameColumn,String xpath1_StatusColumn) throws Exception
	{
		try
		{
			selectElement(drpdwn_View, viewDD_Value);
			GenericClass.ActionOnAlert("Accept");
			GenericClass.clickElement(arrow_Upward);
			int count=GenericClass.tr_count(columnelement);
			//int count1=count-1;
			System.out.println(count);
			List<WebElement> data_text=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
			List<WebElement> src1=GenericClass.driver.findElements(By.xpath(xpath1_StatusColumn));
			for(int i=0;i<count;i++)
			{
				String data=data_text.get(i).getText();
				String value=src1.get(i).getAttribute("src");
				if(value.contains(scr_value))
				{

					Assert.assertEquals(value.equals(scr_value), true);
					System.out.println("de-active room is present at the top when upward arrow is clicked,"+i+","+data+".");

				}


			}
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	/*	*//**
	 *
	 * @param element : Here element is view drop down.
	 * @param a : Here a is drop down value to be select.
	 * @param b : Here b is image icon for Active
	 * @param click : Here click is downward sort arrow
	 * @param columnelements
	 * @param xpath : Here xpath is Entity name column
	 * @param xpath1 : Here xpath1 is Entity Status column
	 * @throws Exception
	 *//*
	public static void sortstatus_Downward(WebElement drpdwn_View,String viewDD_Value,WebElement img_Active,WebElement arrow_Downward,List<WebElement> columnelements,String xpath_NameColumn,String xpath1_StatusColumn) throws Exception{
		try{
		selectElement(drpdwn_View, viewDD_Value);
		GenericClass.Alert_Accept();
		clickElement(img_Active);
		clickElement(arrow_Downward);
		int count=GenericClass.tr_count(columnelements);
		List<WebElement> data_text=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
		int val=data_text.size();
		List<WebElement> src1=GenericClass.driver.findElements(By.xpath(xpath1_StatusColumn));
		for(int i=0;i<=data_text.size()-3;i++){
		String data=data_text.get(i).getText();
		String value=src1.get(i).getAttribute("src");
		if(value.equals(scr_value)){
		System.out.println("de-active room is present at the end when downward arrow is clicked,"+i+","+data+".");
		}
		}

	}*/





	/**
	 *
	 * @param element : Here element is view drop down.
	 * @param a : Here a is drop down value to be select
	 * @param click : Here click is upward sort arrow
	 * @param columnelements
	 * @param xpath : Here xpath is Entity name column
	 * @param xpath1 : Here xpath1 is Entity Status column
	 * @throws Exception
	 *//*
public static void sortstatus_Upward(WebElement drpdwn_View,String viewDD_Value,WebElement arrow_Upward,List<WebElement> columnelement,String xpath_NameColumn,String xpath1_StatusColumn) throws Exception
{
selectElement(drpdwn_View, viewDD_Value);

GenericClass.clickElement(arrow_Upward);
int count=GenericClass.tr_count(columnelement);
//int count1=count-1;
System.out.println(count);
List<WebElement> data_text=GenericClass.driver.findElements(By.xpath(xpath_NameColumn));
List<WebElement> src1=GenericClass.driver.findElements(By.xpath(xpath1_StatusColumn));
for(int i=0;i<count;i++)
{
String data=data_text.get(i).getText();
String value=src1.get(i).getAttribute("src");
if(value.contains(scr_value))
{
System.out.println("de-active room is present at the top when upward arrow is clicked,"+i+","+data+".");

}
else
{
System.out.println("de-active room is not present at the top.");
}
}
}
	  */

	public static Properties loadOR(){
		try {
			if(OR==null){
				FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+File.separator+"OR.properties");
				OR=new Properties();
				OR.load(fis);
				return OR;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OR;
	}


	public WebElement getWebElement(String ORElementName){
		By byObj=getLocator(ORElementName);
		WebElement we=driver.findElement(byObj);
		return we;
	}

	public By getLocator(String ORElementName){
		OR=loadOR();
		String orLocatorInfo=OR.getProperty(ORElementName);
		String locatorValue=orLocatorInfo.split("##")[0];
		String locatorType=orLocatorInfo.split("##")[1];
		By byObj=null;
		if(locatorType.equalsIgnoreCase("XP")){
			byObj=By.xpath(locatorValue);
		}else if(locatorType.equalsIgnoreCase("NM")){
			byObj=By.name(locatorValue);
		}else if(locatorType.equalsIgnoreCase("ID")){
			byObj=By.id(locatorValue);
		}else if(locatorType.equalsIgnoreCase("CLS")){
			byObj=By.className(locatorValue);
		}else if(locatorType.equalsIgnoreCase("CSS")){
			byObj=By.cssSelector(locatorValue);
		}else if(locatorType.equalsIgnoreCase("LK")){
			byObj=By.linkText(locatorValue);
		}else if(locatorType.equalsIgnoreCase("PLK")){
			byObj=By.partialLinkText(locatorValue);
		}
		return byObj;
	}


	public static String ActionOnAlert(String Action){
		try{

			WebDriverWait wait = new WebDriverWait(driver, 2);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			value=alert.getText();
			if(Action.equalsIgnoreCase("Accept")){
				alert.accept();
				Thread.sleep(2000);
				System.out.println("Accepted the alert successfully.");
			}
			else if(Action.equalsIgnoreCase("Dismiss")){
				alert.dismiss();
				System.out.println("Alert is successfully Dismissed.");
			}
			else if(Action.equalsIgnoreCase("")){
				System.out.println("No Action performed");
				GenericClass.driver.close();
			}
		}catch(Throwable e){
			System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
		}

		return value;
	}




	public static void uploadImage(String imagelocation){
		try{
			//Setting clipboard with image location
			setClipboardData(imagelocation);
			//Some sleep time to detect the window popup
			Thread.sleep(500);
			//native key strokes for CTRL, V and ENTER keys
			Robot robot =  new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			//To Click on the "Open" button to upload files
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(500);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}


	public static void setClipboardData(String string) {
		//Copying the path of the file to the clipboard
		//StringSelection class used for copy and paste operations.
		StringSelection stringselect = new StringSelection(string);//Putting the path of the image to upload
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselect, null);
	}

	public static void fn_isSelected(WebElement we){
		boolean booleobj=we.isSelected();
		if(booleobj==true){
			System.out.println("It is Checked");
		}else{
			System.out.println("It is Unchcked");
		}
	}

	public static WebDriver fn_switchiframe(WebElement frameval){
		//driver.switchTo().frame("xd_frame");
		driver.switchTo().frame(frameval);
		//WebElement frm_WE=driver.findElement(By.xpath("//div[@id='login-form']/iframe"));
		//driver.switchTo().frame(frm_WE);
		//driver.findElement(By.id("Username")).sendKeys("a@b.com");


		//	driver.switchTo().defaultContent();

		return driver;
	}
	public static void  fn_Clear(WebElement we){
		we.clear();

	}
	public static WebDriver fn_defaultcontentofiframe(){
		driver.switchTo().defaultContent();
		return driver;
	}

	public static String Copy(WebElement element1)
	{
		String text = element1.getText();
		System.out.println(text);
		return text;
	}

	public static void Paste(WebElement element2, String b)
	{

		element2.getText();

		element2.sendKeys(b);
		WebElement a = element2;

		System.out.println(a);
	}
	public static boolean isEnable(WebElement element, String text){

		boolean result =element.isEnabled();
		//System.out.println(result);
		if(result == true){
			System.out.println(text + "Element is Enable");
		}
		else{
			System.out.println(text + "Element is Disabled");
		}
		return result;
	}


	/*public static FrontdeskLoginPage fn_OpenFrontdesk(String BrowserType, String URL) throws Exception{

		fn_LaunchBrowser(BrowserType);
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.get(URL);


		FrontdeskLoginPage FL=PageFactory.initElements(GenericClass.driver,FrontdeskLoginPage.class );
		return FL;

	}
	 */


	public static String DateFormatForAuditTrail() {
		SimpleDateFormat formatter=new SimpleDateFormat("MMM dd, yyyy :");
		String date=formatter.format(new Date());
		return date;

	}






	/**
	 * This method gives current date based on the number of incremental year.
	 * @param incrementalYear : This parameter is used in the year increase.
	 * @return : Returns date based on the incremented Year.
	 */
	public static String getDateByYearlyIncrement(int incrementalYear) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
		cal.getTime();
		cal.add(Calendar.YEAR, incrementalYear);
		String date=formatter.format(cal.getTime());

		return date;

	}


	/**
	 * This method for switching to the open window
	 * @param titleVal : As it needs window title in which it is going to switch.
	 */
	public static void fn_SwitchToWindow_Title( String titleVal){
		Set<String> setHndlValColls=driver.getWindowHandles();
		Iterator<String>  itHandleColls= setHndlValColls.iterator();
		while(itHandleColls.hasNext()==true){
			String hndlval=itHandleColls.next();
			System.out.println(hndlval);

			driver.switchTo().window(hndlval);

			String title=driver.getTitle();
			if(title.equalsIgnoreCase(titleVal)){
				break;
			}

		}

	}

	public static void fn_ActionsClick(WebElement we) throws Exception{
		try{
			if(we.isDisplayed() && we.isEnabled()){
				Actions actobj=new Actions(driver);
				actobj.click(we).build().perform();
			}
		}catch(NoSuchElementException e){
			Thread.sleep(2000);
			Actions actobj=new Actions(driver);
			actobj.click(we).build().perform();
		}catch(Exception e){
			throw e;
		}
	}


	private static void fn_VatidateWebElement(WebElement we) throws Exception{
		try{
			we.isDisplayed();
			we.isEnabled();
		}catch(ElementNotVisibleException e){
			Thread.sleep(4000);
			we.isDisplayed();
			we.isEnabled();
		}catch(NoSuchElementException e){
			Thread.sleep(4000);
			we.isDisplayed();
			we.isEnabled();
		}catch(Exception e){
			throw e;
		}
	}



	public static String Alert_NoAction(){
		Alert alert=driver.switchTo().alert();
		String str=alert.getText();
		alert.getText();
		return str;
	}

	public static void getscreenshot(String name) throws Exception {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Snapshot\\"+name+"."+"jpg"));
	}

	public static boolean isAlertPresent() {
		try{ 
			driver.switchTo().alert(); 
			return true; 
		} catch (NoAlertPresentException Ex) { 
			return false; 
		}  
	}

}









