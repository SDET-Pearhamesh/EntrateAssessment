package Entrata.Assessment.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Entrata.Assessment.utils.Utility;

public class WatchDemoObjects {

	WebDriver driver;

	public WatchDemoObjects(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "cookie-decline")
	public WebElement declineCookies;
	
	@FindBy(id = "FirstName")
	public WebElement firstNameTextField ;
	
	@FindBy(id = "LastName")
	public WebElement lastNameTextField ;
	
	@FindBy(id = "Email")
	public WebElement emailTextField ;
	
	@FindBy(id = "Company")
	public WebElement companyTextField ;
	
	@FindBy(id = "Phone")
	public WebElement phoneNumberTextField ;
	
	@FindBy(id = "Unit_Count__c")
	public WebElement UnitCountDropdown ;
	
	@FindBy(id = "LastName")
	public WebElement lastName ;
	
	@FindBy( id = "Title")
	public WebElement jobTitleTextField ;
	
	@FindBy( id = "demoRequest")
	public WebElement IamDropdown ;
	
	@FindBy( xpath = "//button[@class='mktoButton']")
	public WebElement watchDemoButton ;
	
	@FindBy( id = "ValidMsgFirstName")
	public WebElement errorMeesageFirstname ;
	

	public void declineCookies() {
		
		declineCookies.click();
		
	}
	
    public String verifyWarningMessage() {
		
    	Utility util = new Utility();
    	util.scrollToView(firstNameTextField);
    	
    	watchDemoButton.click();
		String validationMessage = errorMeesageFirstname.getText();
		return validationMessage;	
	}
    
    public void watchDemoForm() {
    	
    	firstNameTextField.sendKeys("Test First Name");
    	lastNameTextField.sendKeys("Test lastname");
    	emailTextField.sendKeys("test@gmail.com");
    	companyTextField.sendKeys("Test Company private limited");
    	phoneNumberTextField.sendKeys("9876543210");
    	
        Select selectUnitCount = new Select(UnitCountDropdown);
        selectUnitCount.selectByVisibleText("201 - 2000");
        
        jobTitleTextField.sendKeys("Test Job Title");
    	
		Select selectUser = new Select(IamDropdown);
		selectUser.selectByVisibleText("an Owner/Operator or Property Manager");
    }
	
    
	
}
