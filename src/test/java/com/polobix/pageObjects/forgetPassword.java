package com.polobix.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class forgetPassword {
	
WebDriver ldriver;
	
	public forgetPassword(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//*[@class='cursorPointer']")
	@CacheLookup
	WebElement forgetPassword;
	
	@FindBy(name="forgot-password-email")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//button[@class='btn btn-primary w-100 mt-2']")
	@CacheLookup
	WebElement GetLink;
	
	@FindBy(xpath="//button[@class='btn btn-primary w-100']")
	@CacheLookup
	WebElement loginButton;
	
	public void clickForgetLink() {
		forgetPassword.click();
	}
	
	public void enterforgetemail(String email) {
		txtpassword.sendKeys(email);
	}
	
	public void clickGetLink() {
		GetLink.click();
	}
	
	public boolean isdisplayed() {
		try {
			loginButton.isDisplayed();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	
	}
		
	
	

}
