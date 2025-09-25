package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected SHAFT.GUI.WebDriver driver;
    ChromeOptions options;


    public BasePage(SHAFT.GUI.WebDriver driver , ChromeOptions options) {
        this.driver = driver;
        this.options = options;
    }

    public P02_HotelTab switchToTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getDriver().getWindowHandles());
        driver.getDriver().switchTo().window(tabs.get(index));
        return new P02_HotelTab(driver);
    }
}
