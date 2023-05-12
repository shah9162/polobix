package com.polobix.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.polobix.pageObjects.LoginPage;


public class TC_EyeButtonInLoginPage extends BaseClass {
	
	@Test
	public void loginTest() throws Exception {
		driver.get(baseURL);
		logger.info("URL is opened");
		Thread.sleep(3000);
	
		
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter userName");
		
		lp.setPassword(password);
		logger.info("Enter password");
		
		lp.eyeButton();
		logger.info("Eye button is clicked");
		Thread.sleep(3000);
		Screenshot(driver,"EyeButton_Login");

		
		lp.clickSubmit();
		logger.info("submit link is clicked");
		Thread.sleep(6000);
		
	 boolean inr= driver.findElement(By.linkText("INR")).isDisplayed();
		if (inr) {
			Assert.assertTrue(true);
			logger.info("Eye button working passed");
			}
		
		else {
		    logger.warn("Eye button working failed");
			Screenshot(driver,"LoginTest1");
			Assert.assertTrue(false);
			
		}
	
	}
	
	@Test
	public void checkLogoutAllDevices() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is opened");
		Thread.sleep(3000);
	
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter userName");
		
		lp.setPassword(password);
		logger.info("Enter password");
		
		lp.clickSubmit();
		logger.info("submit link is clicked");
	    Thread.sleep(6000);
	    lp.clicklogoutAll();
		Thread.sleep(3000);
		if(driver.getCurrentUrl().contentEquals("https://polobix.com/portal/website/web")) {
		Assert.assertTrue(true);
		
	
		logger.info("LogoutAll link passed");
	}
	else {
	    Screenshot(driver,"LogoutLink");
		logger.warn("LogoutAll failed");
		Assert.assertTrue(false);
	}
	
	
}
}
