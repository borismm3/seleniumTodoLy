package testSuite.yopMail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class SendMailTest extends TestBase {
    @Test
    public void verifySendMail() {
        String subjectCreated = "subject" + new Date().getTime();
        String bodyCreated = "body" + new Date().getTime();

        mainPage.addressTextBox.setText(user);
        mainPage.arrowButton.click();
        Assertions.assertTrue(accountSection.isAddressDisplayed(user), "ERROR! The login has failed");

        inboxHeaderSection.newMail.click();

        Session.getInstance().switchIFrameMail();
        mailSection.sendNewMail(user, subjectCreated, bodyCreated);
        mailSection.mailDispatchedLabel.waitControlIsNotInThePage();
        Assertions.assertTrue(mailSection.isMessageDisplayed(), "ERROR! The mail has not been dispatched");

        Session.getInstance().switchIFrameParent();
        inboxHeaderSection.refreshInbox.click();

        Session.getInstance().switchIFrameInbox();
        inboxSection.getMail(subjectCreated).waitControlIsNotInThePage();
        Assertions.assertTrue(inboxSection.isMailDisplayedInList(subjectCreated), "ERROR! The mail is not in the list");
    }
}
