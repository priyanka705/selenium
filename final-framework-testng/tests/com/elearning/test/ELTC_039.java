package com.elearning.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import Project.ElearningHomePage;
import Project.GenerateReport;


public class ELTC_039 {
	private WebDriver driver;
	private String baseUrl;
	private ElearningHomePage homePOM;
	private GenerateReport generatereport;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homePOM=new ElearningHomePage(driver);
		generatereport=new GenerateReport(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		homePOM.sendUserName("priyanka705");
		homePOM.sendPassword("Swissfranc@5901");
		homePOM.clickLoginBtn();
		generatereport.clickreporting();
		screenShot.captureScreenShot("reporting");
		generatereport.followedStudent();		
		screenShot.captureScreenShot("followedStudent");
		generatereport.clickKeyword();
		screenShot.captureScreenShot("clickKeyword");
		generatereport.searchUser();
		screenShot.captureScreenShot("searchUser");
		generatereport.userActiveAccount();
		screenShot.captureScreenShot("userActiveAccount");
		generatereport.course();
		screenShot.captureScreenShot("course_click");
		generatereport.clicklatestattempts();
		screenShot.captureScreenShot("clicklatestattempts");
		generatereport.clicksendmailcheckbox();
		screenShot.captureScreenShot("clicksendmailcheckbox");
		generatereport.clickcorrecttest();
		screenShot.captureScreenShot("clickcorrecttest");
		generatereport.clickcoursename();
		screenShot.captureScreenShot("clickcoursename");
		
	}
}
