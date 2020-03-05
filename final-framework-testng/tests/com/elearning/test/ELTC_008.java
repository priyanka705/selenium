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

import Project.Createacourse;
import Project.ElearningHomePage;
import Project.MessageUpdate;

public class ELTC_008 {
	
	private WebDriver driver;
	private String baseUrl;
	private ElearningHomePage homePOM;
	private MessageUpdate messageUpdate;
	//private MessageUpdate image;
	//private MessageUpdate icon;
	//private MessageUpdate title;
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
		messageUpdate=new MessageUpdate(driver);
	//	image=new MessageUpdate(driver);
	//	icon=new MessageUpdate(driver);
	//	title=new MessageUpdate(driver);
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
	public void validLoginTest() {
		homePOM.sendUserName("priyanka705");
		homePOM.sendPassword("Swissfranc@5901");
		homePOM.clickLoginBtn();
		screenShot.captureScreenShot("MyCourses");
		messageUpdate.clickLink();
		screenShot.captureScreenShot("Description");
		messageUpdate.clickImage();
		screenShot.captureScreenShot("Image");
		messageUpdate.clickIcon();
		screenShot.captureScreenShot("Icon");
		messageUpdate.enterTitle();
		screenShot.captureScreenShot("Title");
		messageUpdate.enterContaint();
		screenShot.captureScreenShot("Containt");
		messageUpdate.saveDescription();
		screenShot.captureScreenShot("Save");
		
		
		
	
	}
	

}
