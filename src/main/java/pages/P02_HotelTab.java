package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P02_HotelTab {
    SHAFT.GUI.WebDriver driver;
    public P02_HotelTab(SHAFT.GUI.WebDriver driver) {
        this.driver =driver;
    }


    By firstRowTableAccommodation = By.xpath("//tr[@data-room-table=\"1\"]");
    By selectAmount = By.xpath("//select[@data-room-id=\"bbasic_0\"]");

    By reserveBtn = By.xpath("//button[@id=\"hp_book_now_button\" and contains(.,'Reserve')]");
    By iWillReserveBtn = By.xpath("(//button[@type=\"submit\"])[3]");
    By verifyHotelName = By.xpath("//div[@data-capla-component-boundary=\"b-property-web-property-page/PropertyHeaderName\"]/h2[contains(.,'Tolip Hotel Alexandria')]");
    By divContainsHotelName = By.xpath("//div[@id=\"wrap-hotelpage-top\"]");



    public P02_HotelTab reservation() {

        driver.element().click(reserveBtn).
                and().waitUntil(d->driver.element().click(iWillReserveBtn),Duration.ofSeconds(2));

        return new P02_HotelTab(driver);


    }

    public P03_DetailsPage verifyHotel(){

        String getText = driver.getDriver().findElement(verifyHotelName).getText();
        SHAFT.Validations.assertThat().object(getText).contains("Tolip Hotel Alexandria").perform();
        driver.element().captureScreenshot(divContainsHotelName);

        return new P03_DetailsPage(driver);




    }





}
