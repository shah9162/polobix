package com.polobix.testCases;

import java.io.IOException;
import java.util.List;
//import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TC_VerifyLinks_001 {
	
	public static void main(String[] args) throws IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver",".//Drivers/chromedriver.exe");
    	WebDriver driver=new ChromeDriver(); 
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

//    	driver.get("https://lapurobotics.com/SignUp");
    	driver.get("https://polobix.com/portal/auth/login");
    	Thread.sleep(3000);
    	driver.findElement(By.id("login-email")).sendKeys("msd916288@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("Abc@1234");
//		driver.findElement(By.xpath("//svg[@class='feather feather-eye']")).click();
		 driver.findElement(By.id("remember-me")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary w-100']")).click();
		Thread.sleep(7000); 
    	
     	List<WebElement> links=driver.findElements(By.tagName("a"));
    	System.out.println(links.size());
        for(int i=0; i<links.size();i++) {
    		WebElement elements = links.get(i);
    		String url=elements.getAttribute("href");
    		System.out.println(url);
    		}
    	    System.out.println("Links end");
    		}
}
	


