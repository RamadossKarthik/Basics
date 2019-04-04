package com.ievolve;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import junit.framework.Assert;

public class IEvolveHomePortal {

	public WebDriver driver;
	public WebDriverWait wait;
	public WebDriverWait waits;

	By portalName = By.xpath("//ng-include/div/div[1]/div[2]/h4[@class='panelheading']");

	By portal_Supervisor_Admin = By.xpath("//ng-include/div/div[3]/div[2]/button[@class='landingpagebutton center-block btn btn-primary']");

	// 6 matching nodes for the sliding images in IEvolve
	By slideImages = By.xpath("//body/div[3]//div[@id='indexpagecolor']//div[@class='carousel-inner']/div[@active='slide.active']");

	public IEvolveHomePortal(WebDriver driver) {

		this.driver = driver;

	}

	public void clickPortal() {

		String portalNameText = driver.findElement(portalName).getText();
		System.out.println(portalNameText);
		Assert.assertEquals("Supervisor/Admin Portal", portalNameText);

		// clicking on the respective portal
		driver.findElement(portal_Supervisor_Admin).click();
	}

	public void ImageValidation() throws InterruptedException {

		Thread.sleep(5000);

		String MainWindow=driver.getWindowHandle();
		System.out.println("Main window is : " +MainWindow);

		// To handle all new opened window.		

		Set<String> s1=driver.getWindowHandles();		
		Iterator<String> i1=s1.iterator();		

		while(i1.hasNext())			
		{	

			String ChildWindow=i1.next();		

			if(!MainWindow.equalsIgnoreCase(ChildWindow))			
			{    		
				System.out.println("Child Window is :"+ ChildWindow);

				// Switching to Child window
				driver.switchTo().window(ChildWindow);

				waits = new WebDriverWait(driver, 60);

				Thread.sleep(30000);

				System.out.println(driver.getTitle());

				List<WebElement> images = waits.until(ExpectedConditions.presenceOfAllElementsLocatedBy(slideImages));

				for(int i=0;i<images.size();i++) {


					WebElement imageLoaded = images.get(i);

					System.out.println(imageLoaded);

					String imageXpath = imageLoaded.getAttribute("class");

					Thread.sleep(2000);
					if(imageXpath.equalsIgnoreCase("item ng-scope active"))
					{
						System.out.println(i);
						System.out.println("The image loaded is :"+ i);
					}


				}


			}	

		}


	}


}
