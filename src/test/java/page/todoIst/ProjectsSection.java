package page.todoIst;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class ProjectsSection {
    public Button addProjectButton = new Button(By.xpath("//button[contains(@aria-label,'proyecto')]"));
    public Button menuButton = new Button(By.xpath("//button[contains(@aria-label,'acciones')]"));

    public Button nameOfProject(String nameProject) {
        return new Button(By.xpath("//a/span[text()='" + nameProject + "']"));
    }

    public boolean isProjectDisplayedInList(String nameProject) {
        Label projectCreated = new Label(By.xpath("//a/span[text()='" + nameProject + "']"));
        return projectCreated.isControlDisplayed();
    }
}
