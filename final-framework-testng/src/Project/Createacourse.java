package Project;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.*;

public class Createacourse {
private WebDriver driver; 
	
	public Createacourse(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(@href,'add_course')]")
	private WebElement createcourse; 
	
		public void clickLink() {
		this.createcourse.click();
	}
@FindAll
({
	@FindBy(xpath="//input[@type= 'text' and @id='title']"),
    @FindBy(xpath = "//button[@id='advanced_params']"),
    @FindBy(id = "add_course_category_code"),
    @FindBy(id = "add_course_course_language"),
    @FindBy(xpath="//input[@type= 'text' and @id='add_course_wanted_code']"),
    @FindBy(xpath = "//button[@id='add_course_submit']")    
})

private List<WebElement> MultipleInputElements;
//private WebElement courseName;

public void getMultipleInputElements() {
	
	Iterator<WebElement> iter = MultipleInputElements.iterator();

	while(iter.hasNext()) {
	    WebElement we = iter.next();
	 //   System.out.println(we.toString().contains("@id='title'"));
	    if(we.toString().contains("@id='title'")) {
	   // 	System.out.println("1");
	    	we.sendKeys("SELENIUM2");
	    }
	    if(we.toString().contains("@id='advanced_params'")) {
	  //  	System.out.println("2");
	    	we.click();
	    }
	    if(we.toString().contains("add_course_category_code")) {
	 //   	System.out.println("3");
	    //	we.click();
	    	Select sel=new Select(we);
	    //	sel.selectByValue("Selenium (AUTOMATIONTEST)");
	    	 //                  Selenium (AUTOMATIONTEST)
	    	sel.selectByIndex(20);
	    }
	    if(we.toString().contains("add_course_course_language")) {
	  //  	System.out.println("4");
	    //	we.click();
	    	Select sel=new Select(we);
	    	sel.selectByIndex(5);
	    }
	    if(we.toString().contains("@id='add_course_wanted_code'")) {
	   // 	System.out.println("5");
	    	we.sendKeys("SE2");
	    }
	   
	    if(we.toString().contains("@id='add_course_submit'")) {
	//    	System.out.println("6");
	    	we.click();
	    }
	   // System.out.println(we.getText());
	   
	}

	
	 // return MultipleInputElements;
	}
@FindAll
({

	@FindBy(xpath="//a[contains(@href,'course_home')]"),
	@FindBy(xpath="//iframe[contains(@title,'Rich Text Editor, intro_content')]"),
	@FindBy(id = "introduction_text_intro_cmdUpdate")
	 
	
})

private List<WebElement> addIntro;
public void addIntroDetail() {
//	addIntro.get(0).click();
	//WaitTool.waitForElementPresent(driver, By.xpath("//iframe[contains(@title,'Rich Text Editor, scDescription_0')]"), 10);

  //  WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, scDescription_0')]"));

    
	int count=0;
	Iterator<WebElement> iter = addIntro.iterator();
	
	while(iter.hasNext()) {
		 WebElement we = iter.next();
		 if(we.toString().contains("'course_home'")){
			 if(count<1)
			 we.click();
			 count++;
		 }
		 if(we.toString().contains("Rich Text Editor, intro_content")) {
			 driver.switchTo().frame(we);
			 WebElement editable = driver.switchTo().activeElement();
			 editable.sendKeys("this is an selenium course");
			 driver.switchTo().defaultContent();
		 }
		 if(we.toString().contains("introduction_text_intro_cmdUpdate")) {
			 we.click();
		 }
		
	}
	
}
@FindAll
({
	//@FindBy(xpath="//a[contains(@title,'My courses')]"),
	@FindBy(xpath="//a[contains(@href,'http://elearningm1.upskills.in/courses/ASSNG/index.php?id_session=0')]"),
	@FindBy(xpath="//a[contains(@title,'Add an introduction text')]"),
	@FindBy(xpath="//iframe[contains(@title,'Rich Text Editor, intro_content')]"),
	@FindBy(id = "introduction_text_intro_cmdUpdate")
	
	 
	
})

private List<WebElement> addDirectIntro;
public void addIntroDirectDetail() {
	    
	int count=0;
	int count1=0;
	int count2=0;
	Iterator<WebElement> iter = addDirectIntro.iterator();
	
	while(iter.hasNext()) {
		 WebElement we = iter.next();
		 System.out.println(we.toString());
		/* if(we.toString().contains("'My courses'"));{	
			 System.out.println("click my course");
			 if(count<1) {
			 we.click();
			 count++;
			 }
		 }
		 */
		 if(we.toString().contains("'http://elearningm1.upskills.in/courses/ASSNG/index.php?id_session=0'")) {
			 System.out.println("inside href"+count1);
			 if(count1<1) {		  
			 we.click();
			 count1++;
			 }
		 }
		 if(we.toString().contains("Add an introduction text")){
			 System.out.println("icon");
			 if(count2<1)
			 we.click();
			 count2++;
		 }
		 if(we.toString().contains("Rich Text Editor, intro_content")) {
			 System.out.println("iframe");
			 driver.switchTo().frame(we);
			 WebElement editable = driver.switchTo().activeElement();
			 editable.sendKeys("this is an selenium course");
			 driver.switchTo().defaultContent();
		 }
		 if(we.toString().contains("introduction_text_intro_cmdUpdate")) {
			 we.click();
		 }
		 
		
	}
	
}
@FindBy(xpath="//a[contains(@title,'Add an introduction text')]")
private WebElement cliclkIcon; 

public void clickIcon() {
this.cliclkIcon.click();
}
@FindAll
({

	@FindBy(xpath="//iframe[contains(@title,'Rich Text Editor, intro_content')]"),
	@FindBy(id = "introduction_text_intro_cmdUpdate")
	 
	
})
private List<WebElement> addTextElement;
public void addText() {
Iterator<WebElement> iter = addTextElement.iterator();
	
	while(iter.hasNext()) {
		 WebElement we = iter.next();
		 System.out.println(we.toString());
		 if(we.toString().contains("Rich Text Editor, intro_content")) {
			 System.out.println("iframe");
			 driver.switchTo().frame(we);
			 WebElement editable = driver.switchTo().activeElement();
			 editable.sendKeys("this is an selenium course");
			 driver.switchTo().defaultContent();
		 }
		 if(we.toString().contains("introduction_text_intro_cmdUpdate")) {
			 we.click();
		 }
	}
}
}
