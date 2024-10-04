package Entrata.Assessment.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Entrata.Assessment.core.BaseClass;
import Entrata.Assessment.pageObjects.WatchDemoObjects;

public class WatchDemoTest extends BaseClass {
	
	//Test the watch demo form filling process up to the point of submission.
	@Test(priority = 1)
	public void verifyWatchDemoForm() {
		
		WatchDemoObjects dj = new WatchDemoObjects(driver);
		
		dj.declineCookies();
		
		String message = dj.verifyWarningMessage();
		Assert.assertEquals(message, "This field is required."); // Validating the error message for the mandatory first name field.
		
	    dj.watchDemoForm(); 

}
}