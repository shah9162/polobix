package com.polobix.testCases;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.annotations.Test;
import com.polobix.utilities.XLUtils;

public class TC_Verify_Links extends BaseClass{
	
	@Test
	public void Response_Code_For_WebPage() throws IOException   {
		
		
		String path =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path,"responseData_Web");
		System.out.println(rownum);
		for(int i=1; i<=rownum;i++) {
			String linkUrl=XLUtils.getCellData(path, "responseData_Web",i,0);
			try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	           int http=httpURLConnect.getResponseCode();
	           String https =String.valueOf(http);
	            if(http>=400)
	            {
	            	System.out.println(linkUrl+" - "+http+" - "+httpURLConnect.getResponseMessage()+" - is a broken link");
	            	XLUtils.setCellData(path,"responseData_Web",i,1,https);
	            	XLUtils.setCellData(path,"responseData_Web",i,2,httpURLConnect.getResponseMessage());
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+http+" - "+httpURLConnect.getResponseMessage()+" - is a Active link");
	                XLUtils.setCellData(path,"responseData_Web",i,1,https);
	            	XLUtils.setCellData(path,"responseData_Web",i,2,httpURLConnect.getResponseMessage());
	            }
	        }
			catch (Exception e) {
	      }
		}
    	
		System.out.println("Links end");
	}  
	
	
	@Test
	public void Response_Code_For_LoginPage() throws IOException   {
		
		
		String path =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path,"responseData_Login");
		System.out.println(rownum);
		for(int i=1; i<=rownum;i++) {
			String linkUrl=XLUtils.getCellData(path, "responseData_Login",i,0);
			try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	           int http=httpURLConnect.getResponseCode();
	           String https =String.valueOf(http);
	            if(http>=400)
	            {
	            	System.out.println(linkUrl+" - "+http+" - "+httpURLConnect.getResponseMessage()+" - is a broken link");
	            	XLUtils.setCellData(path,"responseData_Login",i,1,https);
	            	XLUtils.setCellData(path,"responseData_Login",i,2,httpURLConnect.getResponseMessage());
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+http+" - "+httpURLConnect.getResponseMessage()+" - is a Active link");
	                XLUtils.setCellData(path,"responseData_Login",i,1,https);
	            	XLUtils.setCellData(path,"responseData_Login",i,2,httpURLConnect.getResponseMessage());
	            }
	        }
			catch (Exception e) {
	      }
		}
    	
		System.out.println("Links end");
	} 
	
	
	@Test
	public void Response_Code_For_signUpPage() throws IOException   {
		
		
		String path =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path,"responseData_signUp");
		System.out.println(rownum);
		for(int i=1; i<=rownum;i++) {
			String linkUrl=XLUtils.getCellData(path, "responseData_signUp",i,0);
			try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	           int http=httpURLConnect.getResponseCode();
	           String https =String.valueOf(http);
	            if(http>=400)
	            {
	            	System.out.println(linkUrl+" - "+http+" - "+httpURLConnect.getResponseMessage()+" - is a broken link");
	            	XLUtils.setCellData(path,"responseData_signUp",i,1,https);
	            	XLUtils.setCellData(path,"responseData_signUp",i,2,httpURLConnect.getResponseMessage());
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+http+" - "+httpURLConnect.getResponseMessage()+" - is a Active link");
	                XLUtils.setCellData(path,"responseData_signUp",i,1,https);
	            	XLUtils.setCellData(path,"responseData_signUp",i,2,httpURLConnect.getResponseMessage());
	            }
	        }
			catch (Exception e) {
	      }
		}
    	
		System.out.println("Links end");
	}
	
	
	@Test
	public void Response_Code_For_Homepage() throws IOException   {
		
		
		String path =System.getProperty("user.dir")+"/src/test/java/com/polobix/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path,"responseData_HomePage");
		System.out.println(rownum);
		for(int i=1; i<=rownum;i++) {
			String linkUrl=XLUtils.getCellData(path, "responseData_HomePage",i,0);
			try
	        {
	            URL url = new URL(linkUrl);

	            //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	            httpURLConnect.setConnectTimeout(5000);
	            httpURLConnect.connect();
	           int http=httpURLConnect.getResponseCode();
	           String https =String.valueOf(http);
	            if(http>=400)
	            {
	            	System.out.println(linkUrl+" - "+http+" - "+httpURLConnect.getResponseMessage()+" - is a broken link");
	            	XLUtils.setCellData(path,"responseData_HomePage",i,1,https);
	            	XLUtils.setCellData(path,"responseData_HomePage",i,2,httpURLConnect.getResponseMessage());
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+http+" - "+httpURLConnect.getResponseMessage()+" - is a Active link");
	                XLUtils.setCellData(path,"responseData_HomePage",i,1,https);
	            	XLUtils.setCellData(path,"responseData_HomePage",i,2,httpURLConnect.getResponseMessage());
	            }
	        }
			catch (Exception e) {
	      }
		}
    	
		System.out.println("Links end");
	}

}
