package com.polobix.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.polobix.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws Exception {
		driver.get(baseURL);
		logger.info("URL is opened");
	
		
		LoginPage lp =new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter userName");
		
		lp.setPassword(password);
		logger.info("Enter password");
		
		lp.eyeButton();

		
		lp.clickSubmit();
		Thread.sleep(6000);
		
	 boolean inr= driver.findElement(By.linkText("INR")).isDisplayed();
		if (inr) {
			Assert.assertTrue(true);
			logger.info("Login test is pass");
			}
		
		else {
		    logger.info("Login test is Failed");
			Screenshot(driver,"LoginTest1");
			Assert.assertTrue(false);
			
		}
	
	}
}
