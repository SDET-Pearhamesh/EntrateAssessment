package Entrata.Assessment.pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBrokenLinks {
	
	
	WebDriver driver;
	
	List<String> brokenLinkList ;

	public HomePageBrokenLinks(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cookie-decline")
	public WebElement declineCookies;
	
	@FindBy(tagName = "a")
	public List<WebElement> AllLinks;
	
	
	public void declineCookies() {

		declineCookies.click();

	}
		
    public List<String> getBrokenLinks() {
    	
		        List<String> brokenLinks = new ArrayList<>();
		        
		        // Get all links from the page
		        List<WebElement> links = AllLinks ;
		        
		        for (WebElement link : links) {
		            String url = link.getAttribute("href");
		            
		            // Skip if URL is null or empty
		            if (url == null || url.isEmpty()) {
		                continue;
		            }
		            
		            // Handle different URL types
		            if (url.startsWith("tel:")) {
		                // Optionally validate phone number format if needed
		                continue;
		            } else if (url.startsWith("mailto:")) {
		                // Handle mailto links if needed
		                continue;
		            } else {
		                try {
		                    // Check only http/https URLs
		                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		                    connection.setRequestMethod("HEAD");
		                    connection.connect();
		                    
		                    int responseCode = connection.getResponseCode();
		                // 403 get for authorization which may fail for social media links and Any status code of 600 or higher is not a standard HTTP status code
		                    if (responseCode >= 400 && responseCode != 403 && responseCode != 405 && responseCode <= 600) {
		                        brokenLinks.add(url);
		                        System.out.println(url + " : " + responseCode);
		                    }
		                } catch (Exception e) {
		                    brokenLinks.add(url);
		                }
		            }
		        }
		        
		        return brokenLinks;
		    }
		
		
		
	}
	
	


