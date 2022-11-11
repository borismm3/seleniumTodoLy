package testSuite.todoIst;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoIst.*;
import session.Session;
import util.GetProperties;
import util.GetPropertiesTodoIst;

public class TestBase {
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    ProjectsSection projectsSection = new ProjectsSection();
    ProjectDataSection projectDataSection = new ProjectDataSection();
    DeleteSection deleteSection = new DeleteSection();
    MenuProjectSection menuProjectSection = new MenuProjectSection();
    TaskSection taskSection = new TaskSection();
    TaskDataSection taskDataSection = new TaskDataSection();
    MenuTaskSection menuTaskSection = new MenuTaskSection();
    MenuSection menuSection = new MenuSection();
    String user = GetPropertiesTodoIst.getInstance().getUser();
    String password = GetPropertiesTodoIst.getInstance().getPwd();

    @BeforeEach
    public void openBrowser() {
        Session.getInstance().getBrowser().get(GetPropertiesTodoIst.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser() {
        Session.getInstance().closeSession();
    }
}
