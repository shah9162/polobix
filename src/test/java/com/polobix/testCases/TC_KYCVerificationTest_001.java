package com.polobix.testCases;

import java.io.IOException;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.polobix.pageObjects.LoginPage;
import com.polobix.pageObjects.ProfileUpdate;
import com.polobix.pageObjects.kyc_verification;

public class TC_KYCVerificationTest_001 extends BaseClass {
	
	
	@Test
	public void Negative_KYCVerification_Test001() throws InterruptedException, FindFailed, IOException{
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened");
		Max();
		
		kyc_verification kv = new kyc_verification(driver);
		LoginPage lp=new LoginPage(driver);
		ProfileUpdate pu = new ProfileUpdate(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		logger.info("clicked login button");
		
		Thread.sleep(6000);
		
		pu.clicksetting();
		logger.info("setting clicked");
		Thread.sleep(2000);
	
		kv.verifyKycLink();
		logger.info("verify link is clicked");
		Thread.sleep(2000);
		
		kv.uploadpancard();
		logger.info("upload pancard link is clicked");
		UploadImage("pancard.jpg");
		
		 
		kv.uploadAadharFront();
	    logger.info("upload aadhar front is clicked");
	    UploadImage("AadharFront.jpg");
	    
	     kv.uploadAadharback();
	    logger.info("upload aadhar back is clicked");
	    UploadImage("AadharBack.jpg");
	    
	     kv.uploadImage();
	    logger.info("upload image is clicked");
	    UploadImage("Image.png");
	  
	     kv.enterSelfPAN("IJCPS8682G");
	    logger.info("pan number entered");
	  
	    kv.enterSelfAADHAR("868570604120");
	    logger.info("Aadhar entered");
	    Thread.sleep(10000);
	    
	    
         kv.clickSubmitButton();
	    logger.info("submit button is clicked");
	    Thread.sleep(3000);
	    
	    if(driver.getPageSource().contains("KYC verification is in progress !!!")) {
	    	Screenshot(driver,"Kyc failed");
	    	Assert.assertTrue(false);
	    	logger.info("KYC test failed");
	    }
	    else {
	    	
	    	Assert.assertTrue(true);
	    	logger.info("kyc Not passed ");
	    }
	   
	}
	
	

	@Test
	public void Negative_KYCVerification_Test002() throws InterruptedException, FindFailed, IOException{
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened");
		Max();
		
		kyc_verification kv = new kyc_verification(driver);
		LoginPage lp=new LoginPage(driver);
		ProfileUpdate pu = new ProfileUpdate(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		logger.info("clicked login button");
		
		Thread.sleep(6000);
		
		pu.clicksetting();
		logger.info("setting clicked");
		Thread.sleep(2000);
	
		kv.verifyKycLink();
		logger.info("verify link is clicked");
		Thread.sleep(2000);
		
		kv.uploadpancard();
		logger.info("upload pancard link is clicked");
		UploadImage("pancard.jpg");
		
		 
		kv.uploadAadharFront();
	    logger.info("upload aadhar front is clicked");
	    UploadImage("AadharFront.jpg");
	    
	     kv.uploadAadharback();
	    logger.info("upload aadhar back is clicked");
	   UploadImage("AadharBack.jpg");
	    
	     kv.uploadImage();
	    logger.info("upload image is clicked");
	   UploadImage("Image01.png");
	
	    kv.enterSelfPAN("IJCPS86822");
	    logger.info("pan number entered");
	  
	    kv.enterSelfAADHAR("868570604asd");
	    logger.info("Aadhar entered");
	    Thread.sleep(10000);
	    
	    
         kv.clickSubmitButton();
	    logger.info("submit button is clicked");
	    Thread.sleep(3000);
	    
	    if(driver.getPageSource().contains("KYC verification is in progress !!!")) {
	    	Screenshot(driver,"Kyc failed");
	    	Assert.assertTrue(false);
	    	logger.info("KYC test failed");
	    }
	    else {
	    	
	    	Assert.assertTrue(true);
	    	logger.info("kyc Not passed ");
	    }
	   
	}
	
	
	
	@Test
	public void Positive_KYCVerification_Test() throws InterruptedException, FindFailed, IOException{
		driver.get(baseURL);
		Thread.sleep(3000);
		logger.info("URL is opened");
		Max();
		
		kyc_verification kv = new kyc_verification(driver);
		LoginPage lp=new LoginPage(driver);
		ProfileUpdate pu = new ProfileUpdate(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		logger.info("clicked login button");
		
		Thread.sleep(6000);
		
		pu.clicksetting();
		logger.info("setting clicked");
		Thread.sleep(2000);
	
		kv.verifyKycLink();
		logger.info("verify link is clicked");
		Thread.sleep(2000);
		
		kv.uploadpancard();
		logger.info("upload pancard link is clicked");
		UploadImage("pancard.jpg");
		
		 
		kv.uploadAadharFront();
	    logger.info("upload aadhar front is clicked");
	    UploadImage("AadharFront.jpg");
	    
	     kv.uploadAadharback();
	    logger.info("upload aadhar back is clicked");
	    UploadImage("AadharBack.jpg");
	    
	     kv.uploadImage();
	    logger.info("upload image is clicked");
	    UploadImage("Image01.png");
	   
	    
	     kv.enterSelfPAN("IJCPS8682k");
	    logger.info("pan number entered");
	  
	    kv.enterSelfAADHAR("868570604121");
	    logger.info("Aadhar entered");
	    Thread.sleep(10000);
	    
	    
         kv.clickSubmitButton();
	    logger.info("submit button is clicked");
	    Thread.sleep(3000);
	    
	    if(driver.getPageSource().contains("KYC verification is in progress !!!")) {
	    	Assert.assertTrue(true);
	    	logger.info("kyc updated successfully");
	    }
	    else {
	    	Screenshot(driver,"Kyc failed");
	    	Assert.assertTrue(false);
	    	logger.info("kyc update failed");
	    }
	   
	}
	
}
