package Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenerateReport {
private WebDriver driver; 
private WebDriverWait wait;
	
	public GenerateReport(WebDriver driver) {
		this.driver = driver; 
		wait = new WebDriverWait(driver, 60);
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(xpath="//*[contains(@title,'Reporting')]")	
	private WebElement reporting; 
	@FindBy(xpath="//div[contains(@class,'card-title')]")
	private List<WebElement> followedStudent; 
	
	@FindBy(id="search_user_keyword")
	private WebElement clickKeyword; 
	
	@FindBy(id="search_user_submit")
	private WebElement searchUser; 
	
	@FindBy(xpath= "//table[starts-with(@id,'tracking_student')]//tr")
	private List<WebElement> userActiveAccount;
	
	@FindBy(xpath="//table[contains(@class,'table-striped')]//tr[1]//td[7]")
	private WebElement course;
	
	@FindBy(xpath="//table[contains(@class,'table-striped')]//tr")
	private List<WebElement> latestattempt;
	
	@FindBy(name="send_notification")
	private WebElement sendmailcheckbox;
	
	@FindBy(id="form-email_submit")
	private WebElement messagesent;
	
	@FindBy(xpath="//*[@class='breadcrumb']/li[1]")
	private WebElement coursenamelink;
	
	public void clickreporting() {
		this.reporting.click();
	}
	
	public void followedStudent() {
		this.followedStudent.get(0).click();
	}
	
	public void clickKeyword() {
		this.clickKeyword.sendKeys("Priya");
	}
	public void searchUser() {
		this.searchUser.click();
	}
	
	public void userActiveAccount() {
		System.out.println("table size "+userActiveAccount.size());
		outerloop:
		for(WebElement row: userActiveAccount){
	        List<WebElement> Cells = row.findElements(By.tagName("td"));
	        int i=0;
	        for(WebElement Cell:Cells){
	           System.out.println(Cell.getText());
	           System.out.println("I "+i);
	           if(Cell.getText().equals("Priya")) {
	        	   System.out.println("inside"+i);
	        	   Cells.get(4).findElements(By.tagName("a")).get(0).click();
	        	  break outerloop;
	           }
	        }
	        
		}
		 System.out.println("Done");
	}
	public void course() {
		this.course.findElement(By.tagName("a")).click();
	}
	public void clicklatestattempts() {
		outerloop:
		for(WebElement row: latestattempt){
	        List<WebElement> Cells = row.findElements(By.tagName("td"));
	        int i=0;
	        for(WebElement Cell:Cells){
	           if(Cell.getText().equals("IQ test")) {
	        	   Cells.get(4).findElement(By.tagName("a")).click();
	        	  break outerloop;
	           }
	        }
	        
		}
	}
	
	public void clicksendmailcheckbox() {
		this.sendmailcheckbox.click();
		
	}
	public void clickcorrecttest() {
		wait.until(ExpectedConditions.elementToBeClickable(this.messagesent));
		this.messagesent.click();
	}
	public void clickcoursename() {
		this.coursenamelink.click();
	}
}
