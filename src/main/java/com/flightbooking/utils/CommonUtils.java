package com.flightbooking.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {
	
	   // Static method to scroll to a web element using JavaScript Executor
    public static void scrollToElement(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void sendEscape(WebDriver driver) {
    	Actions actions = new Actions(driver);
        // Send the Escape key to the browser to close the popup
        actions.sendKeys(Keys.ESCAPE).perform();
    }
	public static void staticWatiForMillis(int i) {
		try {
			Thread.sleep(i);
		}
		catch(Exception e) {
			
		}
		
		
	}

}
