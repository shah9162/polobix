package com.polobix.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.polobix.pageObjects.LoginPage;
import com.polobix.pageObjects.ProfileUpdate;
import com.polobix.utilities.XLUtils;

public class TC_ProfileUpdate_001 extends BaseClass {
	
	@Test(dataProvider="ProfileUpdate" , enabled=false)
	public void Neg_Profile_Update_Test(String name, String address,String postcode, String city ,String country,String state) throws InterruptedException, IOException {
		driver.get(baseURL);
		Max();
		LoginPage lp=new LoginPage(driver);
		ProfileUpdate pu = new ProfileUpdate(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		logger.info("Login button is clicked");
		Thread.sleep(6000);
		
		pu.clicksetting();
		logger.info("setting clicked");
		
		Thread.sleep(2000);
		
		pu.enterName(name);
		logger.info("Name provided");
		pu.enterAddress(address);
		logger.info("Address provided");
		pu.enterPincode(postcode);
		logger.info("postCode provided");
		pu.enterCity(city);
		logger.info("city provided");
		pu.enterCounter(country);
		logger.info("Country provided");
		pu.enterState(state);
		logger.info("state provided");
		
		pu.clickSaveProfileButton();
		logger.info("Save profile button clicked");
		Thread.sleep(2000);
		
		
		
		if(driver.getPageSource().contains("Details Successfully Updated.")) {
			Screenshot(driver,"Negative Profile_Update");
			Assert.assertTrue(false);
			Thread.sleep(3000);
		    driver.navigate().refresh();
			logger.info("Save profile successfully updated");
		}
		else {
			Assert.assertTrue(true);
			Thread.sleep(3000);
		    logger.warn("Save profile failed");
			driver.navigate().refresh();
		}
	   
	}
	
	@Test(dataProvider="ProfileUpdate_pos")
	public void Pos_Profile_Update_Test(String name, String address,String postcode, String city ,String country,String state) throws InterruptedException, IOException {
		driver.get(baseURL);
		Max();
		LoginPage lp=new LoginPage(driver);
		ProfileUpdate pu = new ProfileUpdate(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		logger.info("Login button is clicked");
		Thread.sleep(6000);
		
		pu.clicksetting();
		logger.info("setting clicked");
		
		Thread.sleep(2000);
		
		pu.enterName(name);
		logger.info("Name provided");
		pu.enterAddress(address);
		logger.info("Address provided");
		pu.enterPincode(postcode);
		logger.info("postCode provided");
		pu.enterCity(city);
		logger.info("city provided");
		pu.enterCounter(country);
		logger.info("Country provided");
		pu.enterState(state);
		logger.info("state provided");
		
		pu.clickSaveProfileButton();
		logger.info("Save profile button clicked");
		Thread.sleep(2000);
		
		
		
		if(driver.getPageSource().contains("Details Successfully Updated.")) {
			
			Assert.assertTrue(true);
			Thread.sleep(3000);
		    driver.navigate().refresh();
			logger.info("Save profile successfully updated");
		}
		else {
			Screenshot(driver,"Negative Profile_Update");
			Thread.sleep(3000);
		    logger.warn("Save profile failed");
			driver.navigate().refresh();
			Assert.assertTrue(false);
		}
	   
	}
	

	
	
	@DataProvider(name="ProfileUpdate")
	String[][] getData() throws IOException{

		String path =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Neg_profileUpdateData");
		int colcount=XLUtils.getCellCount(path,"Neg_profileUpdateData",1);
		
		String profiledata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				profiledata[i-1][j]=XLUtils.getCellData(path,"Neg_profileUpdateData",i, j);
				
			}
		}
		return profiledata;
	}
	
	@DataProvider(name="ProfileUpdate_pos")
	String[][] POsgetData() throws IOException{

		String path =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Pos_ProfileUpdate");
		int colcount=XLUtils.getCellCount(path,"Pos_ProfileUpdate",1);
		
		String Posprofiledata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				Posprofiledata[i-1][j]=XLUtils.getCellData(path,"Pos_ProfileUpdate",i, j);
				
			}
		}
		return Posprofiledata;
	}
	
}
