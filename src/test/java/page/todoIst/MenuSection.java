package page.todoIst;

import control.Label;
import org.openqa.selenium.By;

public class MenuSection {
    public boolean isSettingsDisplayed() {
        Label settingLabel = new Label(By.xpath("//div[contains(@class,'settings_avatar')]"));
        return settingLabel.isControlDisplayed();
    }
}
