package Entrata.Assessment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Entrata.Assessment.core.BaseClass;
import Entrata.Assessment.pageObjects.HeaderNavigationObjects;

public class HeaderNavigationTests extends BaseClass {

	
	// Test the navigation functionality of the Major Header menu elements and verify with their titles
	// Implemented verification points for each page navigation.
	@Test(priority = 3)
	public void verifyHeaderNavigations1()  {

		HeaderNavigationObjects nav = new HeaderNavigationObjects(driver);

		nav.declineCookies();
		Assert.assertEquals(nav.productManagementNavigation(), "The Ultimate Property Management software for your business.");;
		Assert.assertEquals(nav.marketingLeasingNavigation(), "Entrata Marketing & Leasing Products for your property management needs");

	}

	@Test(priority = 4)
	public void verifyHeaderNavigations2()  {
		
		HeaderNavigationObjects nav = new HeaderNavigationObjects(driver);
		
		nav.declineCookies();
		Assert.assertEquals(nav.accountingNavigation(), "Accounting Solutions for Real Estate Property Management");
		Assert.assertEquals(nav.utilitiesNavigation(), "Recapture utility expenses for your property | Entrata Utilities");
    
	}
	
	@Test(priority = 5)
	public void verifyHeaderNavigations3() throws InterruptedException {
		
		HeaderNavigationObjects nav = new HeaderNavigationObjects(driver);
		
		nav.declineCookies();
		Assert.assertEquals(nav.solutionsNavigation(), "Entrata Solutions Overview - Everything Entrata");
		nav.declineCookies();
		Assert.assertEquals(nav.resourcesNavigation(), "Helpful Resources for the Multifamily Industry" );
		Assert.assertEquals(nav.summitNavigation(), "Entrata Summit 2024 | The Best Week in Multifamily Sept 23-26") ;
	}

}
