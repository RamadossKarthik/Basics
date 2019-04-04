package com.loginPage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.homepage.IEvolveElements;
import com.ievolve.IEvolveHomePortal;
import com.properties.PropertyFile;
import com.screenshot.Screenshot;
import com.utiltities.ExcelData;



public class UltimatixLoginPageActions {

	public static String browserName = null;	
	public static WebDriver driver;

	//*****************************************************************************************************************************************************************************************************
	
	// Starting up the browser
	@BeforeTest 
	public void setUps() throws FileNotFoundException {


		PropertyFile.propertyDetails();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\JAVA\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://auth.ultimatix.net/utxLogin/login?TYPE=33554432&REALMOID=06-45402d83-8994-41d4-9e1e-60a2815da6a3&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-EdbHMX6T%2bWb8DN7DVmL5sbY%2bn%2b30S7n%2fgIBptYa9dLbudResX4AYm9ObPeNozoDH&TARGET=-SM-HTTPS%3a%2f%2fwww%2eultimatix%2enet%2fultimatixPortalWeb%2fUTXPortalRedirect%3fTARGET%3dhttps-%3A-%2F-%2Fwww%2eultimatix%2enet-%2F");
		}
		
	}

	//*************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************
	
	// CLosing up the browser
	@AfterTest
	public void tearDown() {

		//driver.close();

	}

	
	//*************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************
	
	// Calling the method from UltimatixLoginPage class.
	@Test(dataProvider = "testdata")
	public void methodUltimatixLogin(String username, String password) throws IOException, InterruptedException {

		UltimatixLoginPage  candy = new UltimatixLoginPage(driver);
		candy.loginPageUltimatix(username, password);
		System.out.println(username + " | " + password);
		
	}

	//*************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************
	
	@Test
	public void callingScreenshotCalss() throws IOException {
		
		Screenshot ss = new Screenshot(driver);
		ss.getScreenshot();
	}
	
	
	
	//*************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************

	@Test
	public void iEvolveActions() throws InterruptedException {
		
		IEvolveElements candy2 = new IEvolveElements(driver);
		candy2.clickIEvolve();
		Thread.sleep(3000);
		IEvolveHomePortal portal = new IEvolveHomePortal(driver);
		portal.clickPortal();
	
		portal.ImageValidation();
		
	}
	
	//*************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************
	@DataProvider(name = "testdata")
	public Object[][] getData() {
		
		String excelPath = "C:\\\\Users\\\\Karthick\\\\eclipse-workspace\\\\com.ultimatix.automation\\\\Excel\\\\Inform.xlsx";
		
		Object credentials[][] =dataInfo(excelPath, "Sheet1");
		
		return credentials;
		
	}
	
	public Object[][] dataInfo(String excelPath, String sheetName) {
		
		ExcelData data = new ExcelData(excelPath, sheetName);
		int totalRows = data.getRowDetails();
		int totalCols = data.getColumnDetails();
		
		
		Object credentials[][] =  new Object[totalRows-1][totalCols];
		for(int i=1; i<totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				
				String stringData = data.getStringData(i, j);
				System.out.print(stringData + " | ");
				credentials[i-1][j] = stringData;
			}
			System.out.println();
		}
		return credentials;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
