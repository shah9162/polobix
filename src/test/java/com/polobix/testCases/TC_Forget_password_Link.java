package com.polobix.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.polobix.pageObjects.forgetPassword;

public class TC_Forget_password_Link extends BaseClass {
	@Test
	public void ForgetPassword_Test() throws InterruptedException, IOException {
		forgetPassword fp= new forgetPassword(driver);
		driver.get(baseURL);
		logger.info("ulr is opened");
		fp.clickForgetLink();
		logger.info("Forget password link clicked");
		fp.enterforgetemail("msd916288@gmail.com");
		logger.info("foget password email is provided");
		fp.clickGetLink();
		logger.info("Get link is clecked");
		Thread.sleep(3000);
		Screenshot(driver,"Forget_Password_image");
		Thread.sleep(5000);
	boolean check=fp.isdisplayed();
	if(check) {
		Assert.assertTrue(true);
		logger.info("Forget password passed");
	}
	else {
	    logger.info("Forget password failed");
	    Assert.assertTrue(false);
		
	}
		
	}
	
}
