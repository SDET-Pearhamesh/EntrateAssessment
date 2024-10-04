package Entrata.Assessment.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectMangerSignIn {

	WebDriver driver;

	public ProjectMangerSignIn(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cookie-decline")
	public WebElement declineCookies;

	@FindBy(xpath = "//a[@class='signin-button white-nav']")
	public WebElement SignInButton;
	
	@FindBy(xpath = "//*[@class='button hover_black new-button w-inline-block']")
	public WebElement PMSigninButton;
	
	@FindBy(id = "entrata-username")
	public WebElement UserName;
	
	@FindBy(id = "entrata-password")
	public WebElement Password;
	
	
	public void declineCookies() {

		declineCookies.click();

	}
	
	public String PropertyManagerLoginPage() {
		
		SignInButton.click();
		declineCookies.click();
		String title = driver.getTitle();
		PMSigninButton.click();
		
		return title;
		
	}
	
	public String ProjectMangerSignin() {
		
		String title = driver.getTitle();
		UserName.sendKeys("TestUsername1234");
		Password.sendKeys("Password1234");
		
		return title;
	}
	
	

}
