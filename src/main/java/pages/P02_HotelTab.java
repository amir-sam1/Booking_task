package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P02_HotelTab {
    SHAFT.GUI.WebDriver driver;
    public P02_HotelTab(SHAFT.GUI.WebDriver driver) {
        this.driver =driver;
    }


    By selectAmount = By.xpath("(//th[contains(.,'Select amount')]/following::select)[1]");
    By selectBed = By.xpath("(//div[@class=\"rt-bed-type-select\"])[1]/input");
    By iWillReserveBtn = By.xpath("(//button[@type=\"submit\"])[3]");
    By verifyHotelName = By.xpath("//div[@data-capla-component-boundary=\"b-property-web-property-page/PropertyHeaderName\"]/h2[contains(.,'Tolip Hotel Alexandria')]");
    By divContainsHotelName = By.xpath("//div[@id=\"wrap-hotelpage-top\"]");


    @Step("Select the bed and amount and click I’ll reserve button to navigate to the confirmation page")
    public P02_HotelTab reservation() {

        driver.element().waitUntil(d->driver.element().scrollToElement(selectBed),Duration.ofSeconds(2));
        driver.element().click(selectBed).
                and().select(selectAmount,"1").
                and().click(iWillReserveBtn);


        return new P02_HotelTab(driver);


    }

    @Step("assert that the name of the hotel is shown in the box")
    public P03_DetailsPage verifyHotel(){

        String getText = driver.getDriver().findElement(verifyHotelName).getText();
        SHAFT.Validations.assertThat().object(getText).contains("Tolip Hotel Alexandria").perform();
        driver.element().captureScreenshot(divContainsHotelName);

        return new P03_DetailsPage(driver);




    }





}
