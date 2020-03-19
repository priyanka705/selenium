package Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddMNU {
private WebDriver driver; 
private WebDriverWait wait;
	
	public AdminAddMNU(WebDriver driver) {
		this.driver = driver; 
		wait = new WebDriverWait(driver,60);
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='tabs-1']/div/div[2]/div[2]/ul/li[2]/a")
	private WebElement adduser; 
	
	@FindBy(id="firstname")
	private WebElement firstname;
	
	@FindBy(id="lastname")
	private WebElement lastname;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(id="username")
	private WebElement Login;
	
	@FindBy(name="password[password]")
	private WebElement Password;
	
	@FindBy(xpath="//button[@data-id='status_select']")	
	private WebElement profiler;
	
	@FindBy(xpath="(//div[@class='bs-searchbox']/input)[1]")	
	private WebElement profileInput;
	
	@FindBy(xpath="//a[contains(@class,'active')]")	
	private WebElement profileInput1;
		
	@FindBy(xpath="//*[@id='qf_group_1-group']/div[1]/button[2]")
	private WebElement submitplus; 
	
	@FindBy(xpath="//*[@class='breadcrumb']/li[2]")
	private WebElement userlist; 
	
	@FindBy(id="search_simple_keyword")	
	private WebElement searchuser;
	
	@FindBy(id="search_simple_submit")	
	private WebElement showuser;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void clickaddauser() {
		this.adduser.click();
	}
	public void sendfirstname(String firstname) {
		this.firstname.clear(); 
		this.firstname.sendKeys(firstname); 
	}
	public void sendlastname(String lastname) {
		this.lastname.clear(); 
		this.lastname.sendKeys(lastname); 
	}
		public void sendemail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	public void sendphonenumber(String phonenumber) {
		this.phone.clear(); 
		this.phone.sendKeys(phonenumber); 

	}
	public void sendlogin(String loginname) {
		this.Login.clear(); 
		this.Login.sendKeys(loginname); 
	}
	public void sendpassword(String Password) {
		this.Password.clear(); 
		this.Password.sendKeys(Password); 
	}
	public void sendtrainer(String Trainer) {	
		this.profiler.click();
		this.profileInput.sendKeys(Trainer);
		this.profileInput1.click();
	}
	public void sendadd() {
		this.submitplus.click();
	}
	public void clickuserlist() {
		this.userlist.click();
	}
	public void sendsearchuser(String LoginName) {	
		this.searchuser.click();
		this.searchuser.sendKeys(LoginName);

	}
	public void clicksearch() {
		this.showuser.click();
	}
}
