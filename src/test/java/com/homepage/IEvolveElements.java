package com.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IEvolveElements {

	public WebDriver driver;
	public WebDriverWait wait;

	public IEvolveElements(WebDriver driver) {

		this.driver = driver;

	}

	By iEvolve = By.linkText("iEvolve");

	public void clickIEvolve() {

		wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
		WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(iEvolve));
		System.out.println(element4.getText());
		element4.click();
	}

}
