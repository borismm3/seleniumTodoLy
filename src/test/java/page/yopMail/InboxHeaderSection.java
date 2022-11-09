package page.yopMail;

import control.Button;
import org.openqa.selenium.By;

public class InboxHeaderSection {
    public Button newMail = new Button(By.id("newmail"));
    public Button refreshInbox = new Button(By.id("refresh"));
}
