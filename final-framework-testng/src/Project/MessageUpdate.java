package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageUpdate {
	
private WebDriver driver; 
	
	public MessageUpdate(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(@href,'SE1')]")
	private WebElement course; 
	
	@FindBy(id="toolimage_15915")
	private WebElement image;
	
	@FindBy(xpath="//*[contains(@title,'Description')]")
	private WebElement icon;
	
	@FindBy(id="course_description_title")	
	private WebElement title;
	
	@FindBy(xpath="//iframe[contains(@title,'Rich Text Editor, contentDescription')]")
	private WebElement containt;
	
	@FindBy(xpath = "//button[@id='course_description_submit']")  
	private WebElement save;
	
	
		public void clickLink() {
		this.course.click();
	}
		public void clickImage() {
			this.image.click();
		}
		
		public void clickIcon() {
			this.icon.click();
		}
		public void enterTitle() {
			this.title.clear();
			this.title.sendKeys("selenium course for beginners");
		}
		
		public void enterContaint() {
			
			 driver.switchTo().frame(containt);
			 WebElement editable = driver.switchTo().activeElement();
			 editable.clear();
			 editable.sendKeys("selenium course for beginners");
			 driver.switchTo().defaultContent();
		}
		public void saveDescription() {
			save.click();
		}
}
