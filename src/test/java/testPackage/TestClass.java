package testPackage;

import com.shaft.driver.SHAFT;
import com.shaft.gui.internal.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.P01_HomePage;

public class TestClass {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    SHAFT.TestData.EXCEL excelData;
    ChromeOptions options;


    String baseUrl = "https://www.booking.com/";

    @BeforeMethod
    public void beforeMethod() {

        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");
        excelData = new  SHAFT.TestData.EXCEL("testData.xlsx");
        ChromeOptions options = new ChromeOptions();
        driver.browser().navigateToURL(baseUrl);
        options.addArguments("--disable-popup-blocking");

    }


    @Test
    public void E2eTest() throws InterruptedException {
        new P01_HomePage(driver,options).Search(excelData.getCellData("searchInput")).switchToTab(1).
                reservation().verifyHotel().verifyDates();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        /*driver.quit();*/
    }


}
