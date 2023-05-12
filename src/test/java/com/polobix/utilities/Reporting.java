package com.polobix.utilities;
//listner class used to generate Extent reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

//import com.aventstack.extentreports.repoter.ExtentHtmlReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{

//	public ExtentHtmlReporter htmlRepoter;
	ExtentSparkReporter spark ;
	
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext testContext) {
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName = "Test-Report-"+timeStamp+".html";
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		try {
			spark.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent=new ExtentReports();
		
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "shahnawaz");
		spark.config().setDocumentTitle("InetBanking Test Project");//title of report
		spark.config().setReportName("Functional Test Automation Report");//name of the Report
		
//		spark.config().setTestViewChartLocation(ChartLocation.TOP);//Location of the chart
		
		spark.config().setTheme(Theme.DARK);
	}
		
		public void onTestSuccess(ITestResult tr) {
			logger=extent.createTest(tr.getName()); //create new entry in th report
			logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); //send the passed information
		
		}
		
		public void onTestFailure(ITestResult tr) {
			
			logger=extent.createTest(tr.getName()); //create new entry in th report
			logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); //send the passed information
			
			String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
			File f = new File(screenshotPath);
			
			
			if(f.exists()) {
				logger.fail("Srennshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			}
			
//			if(f.exists()) {
//				try {
//					logger.fail("Srennshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
//				}
//				catch(IOException e){
//					e.printStackTrace();
//				}
//			}
			
			
		}
		
		public void onTestskipped(ITestResult tr) {
			
			logger=extent.createTest(tr.getName()); //create new entry in th report
			logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
			
		}
		
		public void onFinish(ITestContext testContext) {
			extent.flush();
		}
		
	
}

