package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class P01_HomePage extends BasePage {

    public P01_HomePage(SHAFT.GUI.WebDriver driver , ChromeOptions options) {
        super(driver, options);
    }
    //Locators
    By searchInput = By.xpath("//input[@name=\"ss\"]");
    By selectSearchResult = By.xpath("(//ul[@role=\"group\"]/li)[4]");
    By dateBtn = By.xpath("//div[@class=\"ed9f289288\"]/button");
    By checkInDate = By.xpath("//span[@aria-label='We 1 October 2025']");
    By checkOutDate = By.xpath("//span[@aria-label='Tu 14 October 2025']");
    By searchBtn = By.xpath("//button[@type=\"submit\"]");
    By loadMoreBtn = By.xpath("//button[@type=\"button\"]/span[contains(.,'Load more results')]");
    By seeAvailabilityBtn = By.xpath("(//a[contains(@href,'ttps://www.booking.com/hotel/eg/royal-tulip-alexandria.html?label=gen173nr')])[6]");



    //Methods
    @Step("Search about Alexandria with date from 1 to 14 octobers and click see Availability")
    public P01_HomePage Search(String search)  {

         WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(1));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-overlay")));

        driver.element().waitUntil(d ->driver.element().type(searchInput,search), Duration.ofSeconds(2)).
                and().waitUntil(d -> driver.element().click(selectSearchResult), Duration.ofSeconds(2)).
                and().waitUntil(d ->driver.element().clickAndHold(dateBtn),Duration.ofSeconds(5)).
                and().waitUntil(d->driver.element().click(checkInDate),Duration.ofSeconds(2)).
                and().waitUntil(d->driver.element().click(checkOutDate),Duration.ofSeconds(2)).
                and().click(searchBtn).
                and().waitUntil(d->driver.element().scrollToElement(loadMoreBtn),Duration.ofSeconds(5)).
               and().waitUntil(d->driver.element().click(loadMoreBtn),Duration.ofSeconds(2)).
                and().waitUntil(d->driver.element().scrollToElement(seeAvailabilityBtn),Duration.ofSeconds(5)).
                and().waitUntil(d->driver.element().click(seeAvailabilityBtn),Duration.ofSeconds(2));



        return new P01_HomePage(driver, options);

    }


}
