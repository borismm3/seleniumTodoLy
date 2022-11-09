package page.yopMail;

import control.Label;
import org.openqa.selenium.By;

public class AccountSection {
    public Label getAddress(String address) {
        Label addressLabel = new Label(By.xpath("//div[text()='" + address + "@yopmail.com']"));
        return addressLabel;
    }

}
