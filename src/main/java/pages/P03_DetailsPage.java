package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P03_DetailsPage {
    SHAFT.GUI.WebDriver driver;

    public P03_DetailsPage(SHAFT.GUI.WebDriver driver){this.driver=driver;}

    //Locators
    By checkInDate = By.xpath("//h3[contains(.,'Check-in')]/following-sibling::div[contains(.,'Wed, Oct 1, 2025')]");
    By checkOutDate = By.xpath("//h3[contains(.,'Check-out')]/following-sibling::div[contains(.,'Tue, Oct 14, 2025')]");



    //Methods
    @Step("Assert that the chosen check-in and check-out dates are displayed correctly")
    public void verifyDates(){
        String textOfCheckInDate = driver.getDriver().findElement(checkInDate).getText();
        String textOfCheckOutDate = driver.getDriver().findElement(checkOutDate).getText();

        SHAFT.Validations.assertThat().object(textOfCheckInDate).isEqualTo("Wed, Oct 1, 2025").perform();
        SHAFT.Validations.assertThat().object(textOfCheckOutDate).isEqualTo("Tue, Oct 14, 2025").perform();
    }



}
