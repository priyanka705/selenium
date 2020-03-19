package com.elearning.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import Project.AdminAddMNU;
import Project.ElearningHomePage;

public class LoginExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private ElearningHomePage homePOM;
	private AdminAddMNU administration ;
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
		administration = new AdminAddMNU(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "testData", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String fieldsname,String firstname, String lastname, String email,String phonenumber,String loginname,String Password)
	{
		homePOM.sendUserName("admin");
		homePOM.sendPassword("admin@123");
		homePOM.clickLoginBtn();
		screenShot.captureScreenShot("administration");
		administration.clickaddauser();
		screenShot.captureScreenShot("adduser");
		administration.sendfirstname(firstname);
	//	administration.captureScreenShot(fieldsname);
		administration.sendlastname(lastname);
		administration.sendemail(email);
		administration.sendphonenumber(phonenumber);
		administration.sendlogin(loginname);
		administration.sendpassword(Password);
	//	AdminAddMNU.clickLoginBtn();
		
		

	}

}