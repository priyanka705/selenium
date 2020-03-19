package com.elearning.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import Project.AdminAddMNU;
import Project.ElearningHomePage;
import Project.GenerateReport;

public class ELTC_067 {
	private WebDriver driver;
	private String baseUrl;
	private ElearningHomePage homePOM;
	private AdminAddMNU administration;
	private LoginDataProviders dataprovider;
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
		administration=new AdminAddMNU(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	
	@Test (dataProvider = "testData", dataProviderClass = LoginDataProviders.class)
	
	public void loginDBTest(String fieldsname,String firstname, String lastname, String email,String phonenumber,String loginname,String Password)
	{
		// login page	
					homePOM.sendUserName("admin");
					screenShot.captureScreenShot("username");
					homePOM.sendPassword("admin@123");
					screenShot.captureScreenShot("loginpassword");
					homePOM.clickLoginBtn();
					screenShot.captureScreenShot("administration");
					administration.clickaddauser();
					screenShot.captureScreenShot("adduser");
					
	// parameterization
		
		administration.sendfirstname(firstname);
		screenShot.captureScreenShot("firstname");
		administration.sendlastname(lastname);
		screenShot.captureScreenShot("lastname");
		administration.sendemail(email);
		screenShot.captureScreenShot("email");
		administration.sendphonenumber(phonenumber);
		screenShot.captureScreenShot("phonenumber");
		administration.sendlogin(loginname);
		screenShot.captureScreenShot("loginname");
		administration.sendpassword(Password);
		screenShot.captureScreenShot("Password");
		
		
		administration.sendtrainer("Trainer");
		screenShot.captureScreenShot("Trainer");
		administration.sendadd();
		administration.clickuserlist();
		screenShot.captureScreenShot("userlist");
		administration.sendsearchuser("loginname");
		screenShot.captureScreenShot("usersearch");
		administration.clicksearch();
		screenShot.captureScreenShot("listuser");
		
		
		
	}
		
}
