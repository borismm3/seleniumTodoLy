package testSuite.yopMail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.yopMail.*;
import session.Session;
import util.GetProperties;

public class TestBase {
    MainPage mainPage = new MainPage();
    AccountSection accountSection = new AccountSection();
    InboxHeaderSection inboxHeaderSection = new InboxHeaderSection();
    MailSection mailSection = new MailSection();
    InboxSection inboxSection = new InboxSection();
    @BeforeEach
    public void openBrowser() {
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHostYopMail());
    }

    @AfterEach
    public void closeBrowser() {
        Session.getInstance().closeSession();
    }
}
