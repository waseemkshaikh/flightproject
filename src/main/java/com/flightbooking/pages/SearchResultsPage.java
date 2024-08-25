package com.flightbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;

    private By firstFlight = By.xpath("//div[@class='first-flight-result']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstFlight() {
        driver.findElement(firstFlight).click();
    }
}
