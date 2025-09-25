package testPackage;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.chrome.ChromeOptions;
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


    @Test(description = "E2E scenario from search to reservation")
    public void E2eTest()  {
        new P01_HomePage(driver,options).Search(excelData.getCellData("searchInput")).switchToTab(1).
                verifyHotel().reservation().verifyDates();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
