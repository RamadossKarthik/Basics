package com.loginPage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.imageio.ImageIO;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
import com.properties.PropertyFile;

public class UltimatixLoginPage {

	// Calling the values of the respective web elements from PropertyFile.java

	public static String userID;
	public static String userPassword;
	public static String loginClick;

	// static String icon;

	// Initializing the WebDriver and WebDriver wait commands

	public WebDriver driver;
	public WebDriverWait wait;

	// creating a constructor for initializing the webDriver Instance

	public UltimatixLoginPage(WebDriver driver) {

		this.driver = driver;

	}

	/*
	 * Identifying the elements in Ultimatix login page. Substituting the values of
	 * the xpaths and other web properties using above declared variabls.
	 */

	By usernameLogin = By.xpath("//input[@id='USER']");

	By passwordLogin = By.xpath("//input[@id='PASSWORD']");

	By clicking = By.xpath(loginClick);

	// By iconImage = By.id(icon);

	public void loginPageUltimatix(String userName, String password) throws IOException, InterruptedException {

		// calling the Method in PropertyFile.java
		PropertyFile.propertyDetails();

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLogin)).sendKeys(userName);
		driver.findElement(passwordLogin).sendKeys(password);
		driver.findElement(clicking).click();

		// ********************************************************************LOG OUT
		// ACTION using WINDOW
		// HANDLE**************************************************************************************

		/*
		 * WebElement element3 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//a[@class='logoutText']")));
		 * 
		 * element3.isSelected(); element3.click();
		 * 
		 * String MainWindow=driver.getWindowHandle();
		 * 
		 * // To handle all new opened window. Set<String> s1=driver.getWindowHandles();
		 * Iterator<String> i1=s1.iterator();
		 * 
		 * while(i1.hasNext()) {
		 * 
		 * String ChildWindow=i1.next();
		 * 
		 * if(MainWindow.equalsIgnoreCase(ChildWindow)) {
		 * System.out.println("Yes, it Is working?"); // Switching to Child window
		 * driver.switchTo().window(ChildWindow);
		 * 
		 * Thread.sleep(5000); WebElement a =
		 * driver.findElement(By.xpath("//input[@id='logoutbutton']"));
		 * if(a.isDisplayed()) { System.out.println("True"); a.isSelected();
		 * a.findElement(By.xpath("//input[@id='logoutbutton']")).click(); }
		 * 
		 * } else { System.out.println("False"); } }
		 */
		
	
	
		String MainWindow=driver.getWindowHandle();
		 Set<String> s1=driver.getWindowHandles();
		 Iterator<String> i1=s1.iterator();
		 
		  while(i1.hasNext()) {
		  
		  String ChildWindow=i1.next();
		  
		  if(MainWindow.equalsIgnoreCase(ChildWindow)) {
		  System.out.println("Yes, it Is working?"); // Switching to Child window
		 driver.switchTo().window(ChildWindow);
		 
		  
		 Thread.sleep(5000); WebElement a =
		  driver.findElement(By.xpath("//input[@id='logoutbutton']"));
		  if(a.isDisplayed()) { System.out.println("True"); a.isSelected();
		  a.findElement(By.xpath("//input[@id='logoutbutton']")).click(); }
		  
		  } else { System.out.println("False"); } }
		 
	}

}
