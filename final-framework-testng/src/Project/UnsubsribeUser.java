package Project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnsubsribeUser {
	
private WebDriver driver; 
	
	public UnsubsribeUser(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath= "//*[contains(@title,'SELENIUM2')]")
	private WebElement selectCourse; 
	
	//@FindBy(xpath= "//a[contains(@title,'Users')]")
	@FindBy(id= "toolimage_16044")	
	private WebElement selectUsers; 
	
	@FindBy(xpath= "//input[@type='checkbox']")
	private WebElement selectCheckBox; 
	@FindBy(xpath= "//*[contains(@title,'Unsubscribe')]")
	private WebElement unsubscribe;
	 
	
	public void selectCourse() {
		selectCourse.click();
	}
	public void selectUsers() {
		selectUsers.click();
	}
	public void selectCheckBox() {
		selectCheckBox.click();
	}
	public void unscubscribeUser() {
		unsubscribe.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	

}
