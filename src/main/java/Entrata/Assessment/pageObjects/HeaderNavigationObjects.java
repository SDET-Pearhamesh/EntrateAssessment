package Entrata.Assessment.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Entrata.Assessment.utils.Utility;

public class HeaderNavigationObjects {

	WebDriver driver;

	public HeaderNavigationObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cookie-decline")
	public WebElement declineCookies;

	@FindBy(xpath = "//div[text()='Products']")
	public WebElement ProductsHeader;
	
	@FindBy(xpath = "//div[text()='Solutions']")
	public WebElement solutionsHeader;
	
	@FindBy(xpath = "//div[text()='Resources']")
	public WebElement resourcesHeader;
	
	@FindBy(xpath = "(//a[text()='Summit'])[1]")
	public WebElement summitHeader;

	@FindBy(xpath = "(//h3[text()='Property Management'])[2]")
	public WebElement PropertyManagementH3;
	
	@FindBy(xpath = "(//h3[text()='Marketing & Leasing'])[2]")
	public WebElement MarketingLeasing;
	
	@FindBy(xpath = "(//h3[text()='Accounting'])[2]")
	public WebElement accounting;
	
	@FindBy(xpath = "(//h3[text()='Utilities'])[2]") 
	public WebElement utilities;
	
	@FindBy(xpath = "//h3[text()='All Solutions']") 
	public WebElement allSolutions;
	
	@FindBy(xpath = "//h3[text()='All Resources']") 
	public WebElement allResources;

	
	
	public void declineCookies() {

		declineCookies.click();

	}

	public String productManagementNavigation() {

		Utility util = new Utility();
		util.hoverOnElement(ProductsHeader);		
		PropertyManagementH3.click();
		String title = driver.getTitle();
		driver.navigate().back();
		
		return title;

	}

	public String marketingLeasingNavigation()  {

		Utility util = new Utility();
		util.hoverOnElement(ProductsHeader);		
		MarketingLeasing.click();
		String title = driver.getTitle();		
		driver.navigate().back();
		
		return title;

	}

	public String accountingNavigation()  {

		Utility util = new Utility();
		util.hoverOnElement(ProductsHeader);
		accounting.click();
		String title = driver.getTitle();		
		driver.navigate().back();
		
		return title;

	}

	public String utilitiesNavigation()  {

		Utility util = new Utility();
		
		util.hoverOnElement(ProductsHeader);
		utilities.click();		
		String title = driver.getTitle();
		driver.navigate().back();
	
		return title;

	}

	public String solutionsNavigation() {

		Utility util = new Utility();
		util.hoverOnElement(solutionsHeader);
		allSolutions.click();
		String title = driver.getTitle();		
		driver.navigate().back();
		
		return title;

	}
	
	public String resourcesNavigation() {

		Utility util = new Utility();
		util.hoverOnElement(resourcesHeader);
		allResources.click();
		String title = driver.getTitle();
		driver.navigate().back();
		
		return title;

	}
	
	public String summitNavigation() {

	
		summitHeader.click();
	
		Utility util = new Utility() ;
		util.switchToNewWindow("Entrata Summit 2024 | The Best Week in Multifamily Sept 23-26");
		String title = driver.getTitle();
		driver.navigate().back();
		
		return title;

	}
}
