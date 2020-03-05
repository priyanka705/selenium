package com.elearning.test;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	import Project.Createacourse;
	import Project.ElearningHomePage;


	public class ELTC_007 {

		private WebDriver driver;
		private String baseUrl;
		private ElearningHomePage homePOM;
		private Createacourse createcourse;
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
			createcourse=new Createacourse(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		@Test
		public void validLoginTest() {
			homePOM.sendUserName("priyanka705");
			homePOM.sendPassword("Swissfranc@5901");
			homePOM.clickLoginBtn();
			createcourse.clickLink();
			createcourse.getMultipleInputElements();
			//createcourse.addIntroDetail();
		//	createcourse.addIntroDirectDetail();
			createcourse.clickIcon();
			createcourse.addText();
			screenShot.captureScreenShot("First");
		}
		
		}



