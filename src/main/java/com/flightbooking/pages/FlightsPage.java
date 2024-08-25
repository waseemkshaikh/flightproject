package com.flightbooking.pages;

import com.flightbooking.utils.CommonUtils;
import com.flightbooking.utils.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightsPage {
	private WebDriver driver;

	private By departureCity = By.cssSelector("button[aria-label='Leaving from']");
	private By destinationCity = By.cssSelector("button[aria-label='Going to']");
	private By departureDate = By.cssSelector("button[data-testid='uitk-date-selector-input1-default']");
	private By searchButton = By.id("search_button");
	private By calendarDatePickerDoneButton = By.cssSelector("[data-stid='apply-date-selector']");
	private By travellersSelectionDone=By.id("travelers_selector_done_button");
	private By adults= By.cssSelector("button[data-stid='open-room-picker']");
	private By elementNoOfAdults=By.xpath("(//span[text()='Adults']/..//button[@class='uitk-layout-flex-item uitk-step-input-touch-target'])[2]");
	

	public FlightsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterDepartureCity(String city) {
		driver.findElement(departureCity).click();
		driver.findElement(By.id("origin_select")).sendKeys(city);
		String departureCity = String.format(
				"(//button[contains(@aria-label,'%s') and @data-stid='origin_select-result-item-button'])[1]", city);
		driver.findElement(By.xpath(departureCity)).click();
	}

	public void enterDestinationCity(String city) {
		driver.findElement(destinationCity).click();
		driver.findElement(By.id("destination_select")).sendKeys(city);
		String selectedCity = String.format(
				"(//button[contains(@aria-label,'%s') and @data-stid='destination_select-result-item-button'])[1]",
				city);
		driver.findElement(By.xpath(selectedCity)).click();
	}

	public void selectDepartureDate(int monthsAfter) {
		String date = DateUtil.getFutureDate(monthsAfter);
		String dateFuture=date.split(" ")[0].trim();
		String monthFuture=date.split(" ")[1].trim();		
		
		WebElement elementDepartureDate=driver.findElement(departureDate);
		elementDepartureDate.click();
		
		CommonUtils.staticWatiForMillis(1500);
		String calendarDesiredDate=String.format("//span[contains(text(),'%s')]/parent::div[contains(@class,'left') or contains(@class,'right')]//*[text()='%s']",monthFuture,dateFuture);
		driver.findElement(By.xpath(calendarDesiredDate)).click();		
		driver.findElement(calendarDatePickerDoneButton).click();
	}

	public void selectTravellers(int noOfAdults) {
		driver.findElement(adults).click();
		WebElement element=driver.findElement(elementNoOfAdults);
		for(int i=1;i<=noOfAdults-1;i++) {
			element.click();
		}
		CommonUtils.staticWatiForMillis(500);
		driver.findElement(travellersSelectionDone).click();
	}

	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}
}
