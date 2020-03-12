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
import Project.ReportAndSend;
import Project.UnsubsribeUser;

public class ELTC_037 {
	private WebDriver driver;
	private String baseUrl;
	private ElearningHomePage homePOM;
	private ReportAndSend reportandsend;
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
		reportandsend=new ReportAndSend(driver);
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
		screenShot.captureScreenShot("MyCourses");
		reportandsend.clickLink();
		screenShot.captureScreenShot("assignment");
		reportandsend.clickreporting();
		screenShot.captureScreenShot("report");
		reportandsend.clickdetails();
		screenShot.captureScreenShot("arrow");
		reportandsend.clicklatestattempts();
		screenShot.captureScreenShot("iconlatest");
		reportandsend.clicksendmailcheckbox();
		screenShot.captureScreenShot("Email checkbox");
		Thread.sleep(2000);
		reportandsend.clickcorrecttest();
		screenShot.captureScreenShot("message sent");
		reportandsend.clickcoursename();
		screenShot.captureScreenShot("coursepage");
	}
}
