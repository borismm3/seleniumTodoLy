package page.yopMail;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class MailSection {
    public TextBox mailToTextBox = new TextBox(By.id("msgto"));
    public TextBox subjectMailTextBox = new TextBox(By.id("msgsubject"));
    public TextBox bodyMailTextBox = new TextBox(By.id("msgbody"));
    public Button sendMailButton = new Button(By.id("msgsend"));
    public Label mailDispatchedLabel = new Label(By.id("msgpopmsg"));

    public void sendNewMail(String mailTo, String subjectMail, String bodyMail) {
        mailToTextBox.setText(mailTo);
        subjectMailTextBox.setText(subjectMail);
        bodyMailTextBox.setText(bodyMail);
        sendMailButton.click();
    }
}
