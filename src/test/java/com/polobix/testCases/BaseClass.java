package com.polobix.testCases;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.polobix.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	



	public void Screenshot(WebDriver driver,String login) throws IOException {
		
		Date currentdate = new Date();
		String exactdate = currentdate.toString().replace(" ","-").replace(":","-");
		
		File screenshotFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(".//Screenshots/"+ login +exactdate +".png"));
		System.out.println("screen shot is taken");
		
	}
	
	
	public boolean isAlertPresent() {  //user defined method created to check alert present or not
		try {
			driver.switchTo().alert();
			return true;	
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void Max() {
		driver.manage().window().maximize();
		
	}
	
	
	public void UploadImage(String name) throws InterruptedException , FindFailed{
		String ImageFilepath="C:\\Test_Data\\";
		String InputFilepath="C:\\Test_Data\\";
		
		Screen s = new Screen();
		
		Pattern FileInputTextBox= new Pattern(ImageFilepath+"FileTestBox.PNG");
		Pattern OpenButton= new Pattern(ImageFilepath+"OpenButton.PNG");
		Thread.sleep(3000);
		
		s.wait(FileInputTextBox,10);
		s.type(FileInputTextBox,InputFilepath+name);
		s.click(OpenButton);
		
	}
	
	public void dropdown(WebElement dropDown,String str) {
		Select drop = new Select(dropDown);
		drop.selectByVisibleText(str);
		}
	
	public void checkImageStatus(String str) {

		driver.get(str);
		List<WebElement> links=driver.findElements(By.tagName("img"));
		System.out.println(links.size());

		
		try {
			for(int i=0;i<links.size();i++) {
				WebElement elements = links.get(i);
	    		String image=elements.getAttribute("src");
	    		URL url = new URL(image);
	    		HttpURLConnection httpURLConnect= (HttpURLConnection)url.openConnection();
	    		httpURLConnect.setConnectTimeout(5000);
	    		httpURLConnect.connect();
	    		
	    		int ResposeCode= httpURLConnect.getResponseCode();
	    		if(ResposeCode>=400) {
	    			System.out.println(image+" - "+ResposeCode+" - "+httpURLConnect.getResponseMessage()+" - is Broken image");
	    		}
	    		else {
	    			System.out.println(image+" - "+ResposeCode+" - "+httpURLConnect.getResponseMessage()+" - is active image");
	    		}
			}
		}
		catch(Exception e) {
			
		}
	}

	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getapplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getpassword();
	public String signUpURL= readconfig.grtsignUpURL();
	public static WebDriver driver; 
	
	 public static Logger logger;
    
   
    
    @Parameters("browser")
	@BeforeTest
	public void setUp(String br) {
//		public void setUp(String br) {
//    	System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
//    	 driver=new ChromeDriver(); 
    	
    	logger=Logger.getLogger("polobix");
		PropertyConfigurator.configure("log4j.properties");
		
    	
		if(br.toLowerCase().equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			WebDriverManager.chromedriver().setup();
	        driver=new ChromeDriver();	
	        logger.info("Chrome driver lounch successfully");
	     }
		else if(br.toLowerCase().equals("firefox")) {
//			System.setProperty("webdriver.geco.driver",readconfig.)
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("firefox driver lounch successfully");
		}
		else if(br.toLowerCase().equals("edge")) {
//			System.setProperty("webdriver.ie.driver",readconfig.)
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("edge driver lounch successfully");
			logger.info("log edge driver lounch successfully");
			System.out.println("edge driver lounch successfully");
       }
//		else if(br.toLowerCase().equals("ie")) {
//			WebDriverManager.iedriver().setup();
//			driver=new InternetExplorerDriver();
//		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		
	@AfterTest
	public void tearDown() {
//		driver.quit();
	}
}
