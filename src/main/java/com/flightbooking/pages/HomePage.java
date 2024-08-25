package com.flightbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.flightbooking.utils.CommonUtils;

public class HomePage {
    private WebDriver driver;

    private By logo= By.cssSelector("a[class='uitk-header-brand-logo'] img");    
    private By flightsTab = By.xpath("//a[@aria-controls='search_form_product_selector_flights']");
    private By expediaIndia=By.xpath("//a[text()='Expedia.co.in']");
    private By languageButton=By.cssSelector("button[data-context='global_navigation']:nth-child(2)");
    private By countrySelector=By.cssSelector("select[id='site-selector']");
    private By languageSelector=By.cssSelector("select[id='language-selector']");
    private By buttonSave=By.xpath("//button[contains(text(),'Save')]");
    private By oneWay=By.cssSelector("a[aria-controls='FlightSearchForm_ONE_WAY']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickFlightsTab() {
        driver.findElement(flightsTab).click();
        driver.findElement(oneWay).click();
        CommonUtils.staticWatiForMillis(1000);
        
    }
    public boolean isLogoDisplayed() {    	
    	//driver.findElement(expediaIndia).click();    	
    	return driver.findElement(logo).getAttribute("alt").equals("Expedia logo");
    }
    public void selectRegionAndLanguage(String coutnry, String lang) {
    	driver.findElement(languageButton).click();
    	
    	WebElement elementCountry= driver.findElement(countrySelector);
    	Select countrySelector=new Select(elementCountry);
    	countrySelector.selectByVisibleText(coutnry); 	
    	
    	CommonUtils.scrollToElement(driver, languageSelector);
    	WebElement elementLanguage= driver.findElement(languageSelector);
    	Select languageSelector=new Select(elementLanguage);
    	languageSelector.selectByVisibleText(lang);
    	
    	CommonUtils.scrollToElement(driver, buttonSave);
    	driver.findElement(buttonSave).click();
    	
    }
}
