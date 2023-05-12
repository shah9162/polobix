package com.polobix.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signUp {
	
WebDriver ldriver;
	
	public signUp(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="register-username")
	@CacheLookup
	WebElement Name;
	
	@FindBy(id="register-email")
	@CacheLookup
	WebElement Email;
	
	@FindBy(id="register-email")
	@CacheLookup
	WebElement randomEmail;

	
	@FindBy(id="register-mobile")
	@CacheLookup
	WebElement Mobile;
	
	@FindBy(id="register-password")
	@CacheLookup
	WebElement Password;  
	
	@FindBy(id="register-privacy-policy")
	@CacheLookup
	WebElement TermsAndCondition;
	
	@FindBy(xpath="//button[@class='btn btn-primary w-100']")
	@CacheLookup
	WebElement SignUp;
	
	public void setName(String name) {
		Name.clear();
		Name.sendKeys(name);
	}
	
	public void setEmail(String email) {
		Email.clear();
		Email.sendKeys(email);
	}
	
	public void setrandomEmail() {
		randomEmail.clear();
		String generatedstring=	RandomStringUtils.randomAlphabetic(6);
		String emails=generatedstring+"@gmail.com";
		randomEmail.sendKeys(emails);
	}
	
	public void setMobile(String mobile) {
		Mobile.clear();
		Mobile.sendKeys(String.valueOf(mobile));
	}
	
	public void setpassword(String password) {
		Password.clear();
		Password.sendKeys(password);
	}
	
	public void clickTermndCondition() {
		TermsAndCondition.click();
	}
	
	public void clickSignUp() {
		SignUp.click();
	}
	
	public void eyeButton() {
		Actions action = new Actions(ldriver);
		WebElement Eye = ldriver.findElement(By.xpath("//*[local-name()='svg' and @class='feather feather-eye']"));
		action.moveToElement(Eye).click().perform();
	}
	
}
