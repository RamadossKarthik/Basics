package com.screenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.properties.PropertyFile;
import com.google.common.io.Files;

public class Screenshot {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String icon;
	
	By iconImage = By.id(icon);
	
	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getScreenshot() throws IOException {
		
		PropertyFile.propertyDetails();
		
		wait = new WebDriverWait(driver, 30);
		
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(iconImage));

		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		BufferedImage image = ImageIO.read(ss);

		// Get the location of the element on the page.

		Point points = element1.getLocation();

		// Get the width and height of the element.

		int width = element1.getSize().getWidth();
		System.out.println(width);
		int height = element1.getSize().getHeight();
		System.out.println(height);

		// Crop to get only element screenshot	

		BufferedImage partImage = image.getSubimage(points.getX(), points.getY(), width, height);

		ImageIO.write(partImage, "png", ss);

		// Copy the image to the disk location.

		File location = new File("C:\\Users\\Karthick\\Desktop\\Selenium\\screen.png");
		Files.copy(ss,location);

		// To get the entire image and save in same location with different name.

		File screen1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File location1 = new File("C:\\Users\\Karthick\\Desktop\\Selenium\\screen1.png");
		Files.copy(screen1,location1);

	}

}
