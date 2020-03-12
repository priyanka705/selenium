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

import Project.CreateGroupModify;
import Project.ElearningHomePage;


public class ELTC_038 {

	private WebDriver driver;
	private String baseUrl;
	private ElearningHomePage homePOM;
	private CreateGroupModify groupmodify;
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
		groupmodify=new CreateGroupModify(driver);
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
		groupmodify.clickLink();
		screenShot.captureScreenShot("assignment");
		groupmodify.clickgroups();
		screenShot.captureScreenShot("groups");
		groupmodify.clicknewgroup();
		screenShot.captureScreenShot("newgroups");
		groupmodify.createGroups();
		screenShot.captureScreenShot("creategroups");
		groupmodify.fillGroupName();
		screenShot.captureScreenShot("fillgroupname");
		groupmodify.createGroupName();
		screenShot.captureScreenShot("groupname");
		groupmodify.groupMember();
		screenShot.captureScreenShot("creategroupMember");
		groupmodify.groupmembers();
		screenShot.captureScreenShot("listgroupmember");
		groupmodify.clickright();
		screenShot.captureScreenShot("selectedstudent");
		groupmodify.save();
		screenShot.captureScreenShot("savestudent");
		groupmodify.editsettings();
		screenShot.captureScreenShot("editthisgroup");
		groupmodify.selfcheck();
		screenShot.captureScreenShot("selfregister");
		groupmodify.selfuncheck();
		screenShot.captureScreenShot("unregister");
		groupmodify.modifiedsaved();
		screenShot.captureScreenShot("Group settings modified");
			}

}


