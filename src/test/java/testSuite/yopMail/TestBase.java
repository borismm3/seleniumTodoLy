package testSuite.yopMail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.yopMail.*;
import session.Session;
import util.GetProperties;
import util.GetPropertiesYopMail;

public class TestBase {
    MainPage mainPage = new MainPage();
    AccountSection accountSection = new AccountSection();
    InboxHeaderSection inboxHeaderSection = new InboxHeaderSection();
    MailSection mailSection = new MailSection();
    InboxSection inboxSection = new InboxSection();
    String user = GetPropertiesYopMail.getInstance().getUser();
    @BeforeEach
    public void openBrowser() {
        Session.getInstance().getBrowser().get(GetPropertiesYopMail.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser() {
        Session.getInstance().closeSession();
    }
}
