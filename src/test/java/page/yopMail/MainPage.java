package page.yopMail;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class MainPage {
    public TextBox addressTextBox = new TextBox(By.id("login"));
    public Button arrowButton = new Button(By.xpath("//button[contains(@style,'border-radius')]"));

    public void login(String address) {
        addressTextBox.setText(address);
        arrowButton.click();
    }
}
