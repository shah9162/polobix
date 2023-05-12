package com.polobix.testCases;


import java.io.File;
import java.io.IOException;
import java.util.Date;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.polobix.utilities.XLUtils;




public class xl_DataDriven1 {
	static WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void TearDown() {
		System.out.println("Data driven testing completed");
		
		driver.close();
		driver.quit();
	}
	

@Test
	public void SignUpTest() throws InterruptedException, IOException {
		
		driver.get("https://polobix.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(2000);
		
		
		
	
		
		String path = "C:\\File\\Book1.xlsx";
		int noOfRows=XLUtils.getRowCount(path,"Sheet1");
		System.out.println("No of records in the excel file:" +noOfRows);
		
		for(int row = 1; row<=noOfRows ; row++) {
			
            String Name= XLUtils.getCellData(path,"Sheet1",row,0);
			String Email= XLUtils.getCellData(path,"Sheet1",row,1);
            String Mobile= XLUtils.getCellData(path,"Sheet1",row,2);
			String password= XLUtils.getCellData(path,"Sheet1",row,3);
			
			
			
			WebElement userName = driver.findElement(By.id("register-username"));
			userName.clear();
			userName.sendKeys(Name);
			
			WebElement EmailId = driver.findElement(By.id("register-email"));
			EmailId.clear();
			EmailId.sendKeys(Email);
			
	    	WebElement mb=driver.findElement(By.id("register-mobile"));
		    mb.clear();
		    mb.sendKeys(String.valueOf(Mobile));
			
			
		
			WebElement pass = driver.findElement(By.id("register-password"));
			pass.clear();
			pass.sendKeys(password);
			
			
			driver.findElement(By.id("register-privacy-policy")).click();
		
			
			driver.findElement(By.xpath("//button[@class='btn btn-primary w-100']")).click(); 
			Thread.sleep(2000);
			
			if(driver.getPageSource().contains("Thanks for signing up, verify your E-Mail, we have sent a verification link on your registered mailID")) {
				Thread.sleep(6000);
				System.out.println("Registration completed for "+row + "-Records");
				XLUtils.setCellData(path,"Sheet1",row, 4,"passed");
				
			}
			else {
				
				System.out.println("Registration failed for "+row + "-records");
				XLUtils.setCellData(path,"Sheet1",row, 4,"failed");
				
				
				Thread.sleep(6000);
				driver.findElement(By.linkText("Login")).click();
			}
			driver.findElement(By.linkText("Sign Up")).click();

			
		
		}
		
	
		

	
	}

}