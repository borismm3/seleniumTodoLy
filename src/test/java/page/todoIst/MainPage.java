package page.todoIst;

import control.Button;
import org.openqa.selenium.By;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//ul/li/a[contains(@href,'/auth/login')]"));
}
