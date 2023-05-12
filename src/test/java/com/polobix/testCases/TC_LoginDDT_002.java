package com.polobix.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.polobix.pageObjects.LoginPage;
import com.polobix.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	
    @Test(dataProvider="LoginData")
	public void positive_loginDDT(String user,String pwd) throws Exception {
    	driver.get(baseURL);
    	Thread.sleep(2000);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickSubmit();
		logger.info("clicked login button");
		
		Thread.sleep(2000);
	
		if(driver.getPageSource().contains("Logged In Successfully.")) {
			Thread.sleep(4000);
			Assert.assertTrue(true);
			logger.info("Login passed ");
			lp.clickLogout();
			lp.clickLogin();
		}
		else {
			Screenshot(driver,"Failed LoginTest");
			Thread.sleep(4000);
			logger.info("Login test is Failed");
			Assert.assertTrue(false);
			}	
	}
    
    
    @Test
    public void check_CreateAnAccount_Link_In_LoginPage() throws InterruptedException {
    	driver.get(baseURL);
    	Thread.sleep(2000);
    	logger.info("url is opened");
    	WebElement createaccontLink=driver.findElement(By.xpath("/html/body/app-root/div/app-auth-base/app-auth-login/app-login/div/div[3]/div[2]/div/div/div[2]/div/p[2]/a/span"));
    	createaccontLink.click();
    	Thread.sleep(2000);
    	logger.info("create account link clicked");
    	boolean b = driver.findElement(By.xpath("//*[contains(@placeholder, 'Enter name')]")).isDisplayed();
    	if(b) {
    		Assert.assertTrue(true);
    		logger.info("create account link is working");
    	}
    	else {
    		Assert.assertTrue(false);
    		logger.warn("create account link NOT working");
    	}
    }
    
    
    @Test(dataProvider="Neg_LoginData")
  	public void Negative_loginDDT(String user,String pwd) throws Exception {
      	driver.get(baseURL);
      	Thread.sleep(2000);
  		LoginPage lp=new LoginPage(driver);
  		lp.setUserName(user);
  		logger.info("user name provided");
  		lp.setPassword(pwd);
  		logger.info("password is provided");
  		lp.clickSubmit();
  		logger.info("clicked login button");
  		
  		Thread.sleep(2000);
  	
  		if(driver.getPageSource().contains("Logged In Successfully.")) {
  			Thread.sleep(4000);
  			Assert.assertTrue(true);
  			logger.info("Login passed ");
  			lp.clickLogout();
  			lp.clickLogin();
  		}
  		else {
  			Screenshot(driver,"Failed LoginTest");
  			Thread.sleep(4000);
  			logger.info("Login test is Failed");
  			Assert.assertTrue(false);
  			}	
  	}
	
	

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{

		String path =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Positive_LoginData");
		int colcount=XLUtils.getCellCount(path,"Positive_LoginData",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path,"Positive_LoginData",i, j);
				
			}
		}
		return logindata;
	}
	
	
	@DataProvider(name="Neg_LoginData")
	String[][] Neg_getData() throws IOException{

		String path =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Negative_LoginData ");
		int colcount=XLUtils.getCellCount(path,"Negative_LoginData ",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path,"Negative_LoginData ",i, j);
				
			}
		}
		return logindata;
	}
	

}