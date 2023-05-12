package com.polobix.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kyc_verification {
	
WebDriver ldriver;
	
	public kyc_verification(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//*[@id=\"settings-profile\"]/div/div/div/div[1]/div[2]/div/span")
	@CacheLookup
	WebElement verify_KYC;
	
	@FindBy(xpath="//*[@id=\"settings-profile\"]/div/div/div/div[2]/app-kyc-base/app-kyc/div/div/div/div/div[1]/div[2]/div/span")
	@CacheLookup
	WebElement pancard;
	
	@FindBy(xpath="//*[contains(@placeholder,'Enter Pan Number.')]")
	@CacheLookup
	WebElement pancardText;
	
	@FindBy(xpath="//*[@id=\"settings-profile\"]/div/div/div/div[2]/app-kyc-base/app-kyc/div/div/div/div/div[3]/div/div/span")
	@CacheLookup
	WebElement aadharFront;
	
	@FindBy(xpath="//*[contains(@placeholder,'Enter Aadhaar Number.')]")
	@CacheLookup
	WebElement aadharText;
	
	@FindBy(xpath="//*[@id=\"settings-profile\"]/div/div/div/div[2]/app-kyc-base/app-kyc/div/div/div/div/div[5]/div/div/span")
	@CacheLookup
	WebElement aadharBack;
	
	@FindBy(xpath="//*[@id=\"settings-profile\"]/div/div/div/div[2]/app-kyc-base/app-kyc/div/div/div/div/div[7]/div/div/span")
	@CacheLookup
	WebElement image;
	
	@FindBy(css="button.button[type=button]")
	@CacheLookup
	WebElement sumbmit;
	
	public void verifyKycLink() {
		verify_KYC.click();
	}
	
	public void uploadpancard() {
		pancard.click();
	}
	
	public void enterPancardNumber() {
		pancardText.clear();
		String generatedstring=	RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		String panNumber=generatedstring+generatedNumber+"M";
		pancardText.sendKeys(panNumber);
	}
	
	public void uploadAadharFront() {
		aadharFront.click();
	}
	
	public void enterAadharnumber() {
		 aadharText.clear();
		 String generatedAdharNumber = RandomStringUtils.randomNumeric(12);
		 aadharText.sendKeys(generatedAdharNumber);
	}
	
	public void uploadAadharback() {
		aadharBack.click();
	}
	
	public void uploadImage() {
		 image.click();
	}
	 public void clickSubmitButton() {
		 sumbmit.click();
	 }
	 
	 public void enterSelfPAN(String pan) {
		 pancardText.clear();;
		 pancardText.sendKeys(pan);
	 }
	 
	 public void enterSelfAADHAR(String aadhar) {
		 aadharText.clear();
		 aadharText.sendKeys(String.valueOf(aadhar));
	 }
}

