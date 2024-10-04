package Entrata.Assessment.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Entrata.Assessment.core.BaseClass;
import Entrata.Assessment.pageObjects.HomePageBrokenLinks;

public class BrokenLinkTest extends BaseClass{
	
	
	// Check for broken links on Entrata landing page
	@Test
    public void VerifyBrokenLinks() {
		
        HomePageBrokenLinks linkChecker = new HomePageBrokenLinks(driver);
        
        linkChecker.declineCookies();
        List<String> brokenLinks = linkChecker.getBrokenLinks();
        
        Assert.assertTrue(brokenLinks.isEmpty(), 
            "Broken links found: " + String.join(", ", brokenLinks));
    }

}
