package Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateGroupModify {
private WebDriver driver; 
private WebDriverWait wait;
	
	public CreateGroupModify(WebDriver driver) {
		this.driver = driver; 
		wait = new WebDriverWait(driver, 60);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(@href,'ASSNG')]")
	private WebElement course; 
		
	@FindBy(id= "toolimage_15853")	
	private WebElement grouping; 
	
	@FindBy(xpath= "//*[contains(@title,'Create new group(s)')]")
	private WebElement newgroup;
	
	@FindBy(id= "create_groups_submit")
	private WebElement createGroups;
	
	@FindBy(xpath= "//input[@type='text' and @name='group_0_name']")
	private WebElement groupName;
	
	@FindBy(id= "create_groups_step2_submit")
	private WebElement groupCreate;
	
	@FindBy(xpath= "//*[contains(@title,'Group members']")
	private WebElement groupMember;
	
	@FindBy(xpath= "//table[starts-with(@id,'group_category_')]//tr")
//	@FindBy(xpath="//*[@id="group_category_05e68b3348fad9"]/tbody/tr[5]/td[5]/a[3]")
	private List<WebElement> table;
	
	@FindBy(name="group_members-f[]")
	private WebElement list;
	
	@FindBy(id="group_members_rightSelected")
	private WebElement rightarrow;
	
	@FindBy(name="submit")
	private WebElement savesettings;
	
	@FindBy(name="self_registration_allowed")
	private WebElement selfregister;
	
	@FindBy(name="self_unregistration_allowed")
	private WebElement selfunregister;
	
	@FindBy(id="group_edit_submit")
	private WebElement groupsettings;
	
	public void clickLink() {
		this.course.click();
	}
	public void clickgroups() {
		this.grouping.click();
	}
	
	public void clicknewgroup() {
		this.newgroup.click();
	}
	public void createGroups() {
		this.createGroups.click();
	}
	public void fillGroupName() {
		groupName.clear();
		groupName.sendKeys("Group_name Priya");
	}
	public void createGroupName() {
		groupCreate.click();
	}
	public void groupMember() {
		System.out.println("table size "+table.size());
		outerloop:
		for(WebElement row: table){
	        List<WebElement> Cells = row.findElements(By.tagName("td"));
	        int i=0;
	        for(WebElement Cell:Cells){
	           System.out.println(Cell.getText());
	           System.out.println("I "+i);
	           if(Cell.getText().equals("Group_name Priya")) {
	        	   System.out.println("inside"+i);
	        	   Cells.get(4).findElements(By.tagName("a")).get(2).click();
	        	  break outerloop;
	           }
	        }
	        
		}
		 System.out.println("Done");
	}
	public void groupmembers() {
		Select listmembers=new Select(driver.findElement(By.id("group_members")));
		listmembers.selectByIndex(1);
		listmembers.selectByIndex(3);
		
	}
	public void clickright() {
		this.rightarrow.click();
	}
	
	public void save() {
		this.savesettings.click();
	}
	public void editsettings() {
		System.out.println("table size "+table.size());
		outerloop:
		for(WebElement row: table){
	        List<WebElement> Cells = row.findElements(By.tagName("td"));
	        int i=0;
	        for(WebElement Cell:Cells){
	           System.out.println(Cell.getText());
	           System.out.println("I "+i);
	           if(Cell.getText().equals("Group_name Priya")) {
	        	   System.out.println("inside"+i);
	        	   Cells.get(4).findElements(By.tagName("a")).get(0).click();
	        	  break outerloop;
	           }
	        }
	        
		}
	}
	public void selfcheck() {
	this.selfregister.click();
}
	public void selfuncheck() {
	this.selfunregister.click();
}
	public void modifiedsaved() {
		this.groupsettings.click();
	}
}
