package com.flightbooking.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.flightbooking.base.BaseTest;
import com.flightbooking.pages.FlightsPage;
import com.flightbooking.pages.HomePage;
import com.flightbooking.pages.SearchResultsPage;
import com.flightbooking.utils.CommonUtils;

import org.slf4j.spi.SLF4JServiceProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightBookingTest extends BaseTest {
	

    @Test
    public void testFlightBooking() {
        HomePage homePage = new HomePage(driver);    

        
        //Verify home page is displayed
        AssertJUnit.assertTrue(homePage.isLogoDisplayed());
        
        System.out.println("Current URL: " + homePage.getCurrentURL());
        System.out.println("Page Title: " + homePage.getTitle());
        
        homePage.selectRegionAndLanguage("India", "English");
        
        
        
        
        homePage.clickFlightsTab();

        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.enterDepartureCity("Bangalore");
        flightsPage.enterDestinationCity("Bhubaneswar");
        CommonUtils.staticWatiForMillis(1500);
        flightsPage.selectDepartureDate(1);
        flightsPage.selectTravellers(2);
        flightsPage.clickSearchButton();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.selectFirstFlight();
    }
}
