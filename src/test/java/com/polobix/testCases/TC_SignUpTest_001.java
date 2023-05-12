package com.polobix.testCases;


import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.polobix.pageObjects.signUp;
import com.polobix.utilities.XLUtils;

public class TC_SignUpTest_001 extends BaseClass {
	
	@Test(dataProvider="Neg_signUpData")
	public void Negative_signUpTest(String name, String email, String mobile, String password) throws InterruptedException, IOException {
		
		driver.get(signUpURL);
		Thread.sleep(2000);
		Max();
		logger.info("url is opening");
		
		signUp sp = new signUp(driver);
		
		sp.setName(name);
		logger.info("name entered");
		sp.setEmail(email);
		logger.info("email entered");
		sp.setMobile(mobile);
		logger.info("mobie number entered");
		sp.setpassword(password);
		logger.info("password enterd");
		sp.clickTermndCondition();
		Thread.sleep(2000);
		logger.info("click term and condition");
		sp.clickSignUp();
		Thread.sleep(5000);

		if(driver.getCurrentUrl().contentEquals("https://polobix.com/portal/website/web")) {
			Screenshot(driver,"Neg. signUP Failed");
        	Assert.assertTrue(false);
        	logger.info("Negative sighUp test failed");
        	driver.findElement(By.linkText("Sign Up")).click();
        	Thread.sleep(3000);
        	driver.switchTo().defaultContent();
        }
		else {
			Assert.assertTrue(true);
			logger.warn("Negative sighUp test passed");
			driver.navigate().refresh();	
		}
		
	}
	
	@Test
	public void checkEyebuttomInSignUp() throws InterruptedException, IOException {
		driver.get(signUpURL);
		Thread.sleep(2000);
		Max();
		logger.info("url is opening");
		
		signUp sp = new signUp(driver);
		sp.setName("rehan");
		logger.info("name entered");
		sp.setrandomEmail();
		logger.info("email entered");
		sp.setMobile("6000000000");
		logger.info("mobie number entered");
		sp.setpassword("Abc@1234");
		logger.info("password enterd");
		
		sp.eyeButton();
	
		
		logger.info("eyeButton is Clicked");
		sp.clickTermndCondition();
		logger.info("click term and condition");
		Screenshot(driver,"signUP_Eye-Button");
		Thread.sleep(3000);
		
		sp.clickSignUp();
		Thread.sleep(5000);
		
		if(driver.getCurrentUrl().contentEquals("https://polobix.com/portal/website/web")) {
        	Assert.assertTrue(true);
        	logger.info("signUp passed");
      
        }
		else {
			logger.warn("signup failed");
		    driver.navigate().refresh();
			Assert.assertTrue(false);
			
		}
	}
	
	
	@Test
	public void check_sign_In_Instead_Link_signUpPage() throws InterruptedException, IOException {
		driver.get(signUpURL);
		Thread.sleep(2000);
		logger.info("url is opened");
		WebElement signInInstead=driver.findElement(By.xpath("/html/body/app-root/div/app-auth-base/app-auth-sign-up/app-sign-up/div/div[3]/div[2]/div/div/div[2]/div/div[3]/p/span[2]"));
		signInInstead.click();
		Thread.sleep(2000);
		logger.info("sign in instead button clicked");
		boolean b=driver.findElement(By.xpath("//*[contains(@placeholder, 'Enter Email')]")).isDisplayed();
		if(b) {
			Assert.assertTrue(true);
			logger.info("sign in instead link in working");
		}
		else {
			Assert.assertTrue(false);
			Screenshot(driver,"Sign in instead");
			logger.warn("sign in instead link NOT working");
		}
	}
	
	
	@Test(dataProvider="Pos_signUpData")
	public void positive_signUpTest(String name, String email, String mobile, String password) throws InterruptedException, IOException {
		
		driver.get(signUpURL);
		Thread.sleep(2000);
		Max();
		logger.info("url is opening");
		
		signUp sp = new signUp(driver);
		
		sp.setName(name);
		logger.info("name entered");
		sp.setEmail(email);
		logger.info("email entered");
		sp.setMobile(mobile);
		logger.info("mobie number entered");
		sp.setpassword(password);
		logger.info("password enterd");
		sp.clickTermndCondition();
		Thread.sleep(2000);
		logger.info("click term and condition");
		sp.clickSignUp();
		Thread.sleep(5000);

		if(driver.getCurrentUrl().contentEquals("https://polobix.com/portal/website/web")) {
        	Assert.assertTrue(true);
        	logger.info("signUp passed");
        	driver.findElement(By.linkText("Sign Up")).click();
        	Thread.sleep(3000);
        	driver.switchTo().defaultContent();
        }
		else {
			logger.warn("signup failed");
			Screenshot(driver,"Pos.signUP Failed");
			
			driver.navigate().refresh();
			Assert.assertTrue(false);
			
		}
		
	}
	
	
	
	
	@DataProvider(name="Neg_signUpData")
	String[][] getData() throws IOException{

		String pata =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(pata,"Registration_neg");
		int colcount=XLUtils.getCellCount(pata,"Registration_neg",1);
		
		String signUPData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				signUPData[i-1][j]=XLUtils.getCellData(pata,"Registration_neg",i, j);
				
			}
		}
		return signUPData;
	}
	
	
	@DataProvider(name="Pos_signUpData")
	String[][] Pos_getData() throws IOException{

		String pata =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(pata,"Registration_Pos");
		int colcount=XLUtils.getCellCount(pata,"Registration_Pos",1);
		
		String signUPData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				signUPData[i-1][j]=XLUtils.getCellData(pata,"Registration_Pos",i, j);
				
			}
		}
		return signUPData;
	}
	
}
