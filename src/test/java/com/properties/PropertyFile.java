package com.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.loginPage.UltimatixLoginPage;
import com.loginPage.UltimatixLoginPageActions;
import com.screenshot.Screenshot;

public class PropertyFile {


	// Method to get the properties from the ultimatix.properties file

	public static void propertyDetails() throws FileNotFoundException {

		String propertyPath = System.getProperty("user.dir");
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream( propertyPath + "\\src\\test\\java\\com\\properties\\ultimatix.properties");

		try {
			prop.load(input);
			String userId = prop.getProperty("id");
			String userPassword = prop.getProperty("pswd");
			String loginClick = prop.getProperty("click");
			String icon = prop.getProperty("image");
			String browserName = prop.getProperty("browser");


			/*
			 The userId and userPassword are taken from Excel sheet using another class
			 UltimatixLoginPage.userID = userId;
			 UltimatixLoginPage.userPassword = userPassword;
			 */
			UltimatixLoginPageActions.browserName = browserName;
			UltimatixLoginPage.loginClick = loginClick;
			Screenshot.icon = icon;


			
		//	To validate that the values assigned in the .properties file are executed
			System.out.println(browserName);
			System.out.println(userId);
			System.out.println(userPassword);
			System.out.println(loginClick);
			 

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static void main(String[] args) throws FileNotFoundException {
		propertyDetails();
	}

}
