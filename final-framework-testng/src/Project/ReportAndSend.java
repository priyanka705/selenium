package Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportAndSend {
private WebDriver driver; 
	
	public ReportAndSend(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(@href,'ASSNG')]")
	private WebElement course; 
		
	@FindBy(id= "toolimage_15864")	
	private WebElement reporting; 
	
	@FindBy(xpath= "//table[starts-with(@id,'users_tracking')]//tr")
	private List<WebElement> learnerlist;
	
	@FindBy(xpath="//table[contains(@class,'table-striped')]//tr")
	private List<WebElement> latestattempt;
	
	@FindBy(name="send_notification")
	private WebElement sendmailcheckbox;
	
	@FindBy(id="form-email_submit")
	private WebElement messagesent;
	
	@FindBy(xpath="//*[@class='breadcrumb']/li[1]")
	private WebElement coursenamelink;
	
	public void clickLink() {
		this.course.click();
	}
	
	public void clickreporting() {
		this.reporting.click();
	}
	
	public void clickdetails() {
		outerloop:
		for(WebElement row: learnerlist){
	        List<WebElement> Cells = row.findElements(By.tagName("td"));
	        int i=0;
	        for(WebElement Cell:Cells){
	           if(Cell.getText().equals("priya705")) {
	        	   Cells.get(15).findElement(By.tagName("a")).click();
	        	  break outerloop;
	           }
	        }
	        
		}
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
		this.sendmailcheckbox.click();
	}
	
	public void clickcorrecttest() {
		this.messagesent.click();
	}
	public void clickcoursename() {
		this.coursenamelink.click();
	}
	}
	
	
