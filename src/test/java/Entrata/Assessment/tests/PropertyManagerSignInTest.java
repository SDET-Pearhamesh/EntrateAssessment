package Entrata.Assessment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Entrata.Assessment.core.BaseClass;
import Entrata.Assessment.pageObjects.ProjectMangerSignIn;

public class PropertyManagerSignInTest extends BaseClass {
	
	
	//Test the Property manager signup process up to the point of submission.
	@Test(priority = 2)
	public void PropertyManagerSignIn() {
		
		ProjectMangerSignIn dj = new ProjectMangerSignIn(driver);
		
		dj.declineCookies();
		
		String title1 = dj.PropertyManagerLoginPage();
		Assert.assertEquals(title1, "Entrata Sign In"); // Validate the page title upon navigation to the new page.
		
		String title2 = dj.ProjectMangerSignin();
		Assert.assertEquals(title2, "Sso Login"); //Validate the page title upon navigation to the new page.

}

}
