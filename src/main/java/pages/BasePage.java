package pages;

import com.shaft.driver.SHAFT;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected SHAFT.GUI.WebDriver driver;

    public BasePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public P02_HotelTab switchToTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getDriver().getWindowHandles());
        driver.getDriver().switchTo().window(tabs.get(index));
        return new P02_HotelTab(driver);
    }
}
