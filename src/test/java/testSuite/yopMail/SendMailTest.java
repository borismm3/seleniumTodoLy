package testSuite.yopMail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class SendMailTest extends TestBase {
    @Test
    public void verifySendMail() throws InterruptedException {
        //String addressCreated = "boris" + new Date().getTime();
        String addressCreated = "boris2022";
        String subjectCreated = "subject" + new Date().getTime();
        String bodyCreated = "body" + new Date().getTime();

        mainPage.addressTextBox.setText(addressCreated);
        mainPage.arrowButton.click();
        Assertions.assertTrue(accountSection.getAddress(addressCreated).isControlDisplayed(), "ERROR! The login has failed");

        inboxHeaderSection.newMail.click();

        Session.getInstance().switchIFrameMail();
        mailSection.sendNewMail(addressCreated, subjectCreated, bodyCreated);
        mailSection.mailDispatchedLabel.waitControlIsNotInThePage();
        Assertions.assertTrue(mailSection.mailDispatchedLabel.isControlDisplayed(), "ERROR! The mail has not been dispatched");

        Session.getInstance().switchIFrameParent();
        inboxHeaderSection.refreshInbox.click();

        Session.getInstance().switchIFrameInbox();
        inboxSection.getMail(subjectCreated).waitControlIsNotInThePage();
        Assertions.assertTrue(inboxSection.isMailDisplayedInList(subjectCreated), "ERROR! The mail is not in the list");
    }
}
