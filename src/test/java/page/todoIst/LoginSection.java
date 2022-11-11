package page.todoIst;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginSection {
    public TextBox emailTextBox = new TextBox(By.id("element-0"));
    public TextBox passwordTextBox = new TextBox(By.id("element-3"));
    public Button loginButton = new Button(By.xpath("//button[contains(@data-gtm-id,'start-email-login')]"));

    public void login(String email, String password) {
        emailTextBox.setText(email);
        passwordTextBox.setText(password);
        loginButton.click();
    }
}
