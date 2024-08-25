package com.flightbooking.base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.flightbooking.utils.CommonUtils;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://www.expedia.co.in/");
        CommonUtils.sendEscape(driver);
        CommonUtils.staticWatiForMillis(2000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {        	
        	//ScreenshotUtil.takeScreenshot(driver, "final_screenshot");        	
            driver.quit();
        }
    }
}
