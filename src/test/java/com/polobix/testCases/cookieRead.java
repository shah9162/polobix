package com.polobix.testCases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import com.polobix.pageObjects.LoginPage;

public class cookieRead extends BaseClass{
	
	@Test
	public void ReadCoockies() throws InterruptedException {
		driver.get("https://www.yatra.com/");
//		driver.get(baseURL);
//		LoginPage lp= new LoginPage(driver);
//		lp.setUserName(username);
//		lp.setPassword(password);
//		lp.clickSubmit();
		
//		    driver.findElement(By.name("username")).sendKeys("abc123");							
//	        driver.findElement(By.name("password")).sendKeys("123xyz");							
//	        driver.findElement(By.name("submit")).click();
		
		Thread.sleep(5000);
		
		File file = new File("Cookies.data");
		try {
			file .delete();
			file.createNewFile();
			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);
			
			for(Cookie ck : driver.manage().getCookies()) {
				
				Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
				Bwrite.newLine();
				Bwrite.newLine();
			}
			
			Bwrite.close();
			fileWrite.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}

}
