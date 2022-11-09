package page.yopMail;

import control.Label;
import org.openqa.selenium.By;

public class InboxSection {
    public boolean isMailDisplayedInList(String subjectMail) {
        Label subjectMailLabel = new Label(By.xpath("//div[text()='" + subjectMail + "']"));
        return subjectMailLabel.isControlDisplayed();
    }
    public Label getMail(String subjectMail) {
        return new Label(By.xpath("//div[text()='" + subjectMail + "']"));
    }
}
