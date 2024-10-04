package Entrata.Assessment.utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Entrata.Assessment.core.BaseClass;

public class Utility extends BaseClass {
	

	//Method to scroll to the specific web element
	public void scrollToView (WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver ; 
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
	
	// Method to hover over the particular web element.
	public void hoverOnElement (WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		 // Wait for element to be visible and get it
        WebElement elementToHover = wait.until(
            ExpectedConditions.visibilityOf(element));
        
        // Create Actions object and perform hover
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
		
	}
	
	// Switch to the new window based on its title.
	public void switchToNewWindow(String title) {
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handle : windowHandles) {
			
		    driver.switchTo().window(handle);
		    
		    // Check if this is the window you want
		    if (driver.getTitle().equals(title)) {
		        break;
		    }
		}
	}
	
	
}
