package page.todoIst;

import control.Button;
import control.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class TaskSection {
    public Button addTaskButton = new Button(By.xpath("//button[contains(@class,'plus_add_button')]"));
    public Button menuTaskButton = new Button(By.xpath("//div[contains(@class,'task_list_item__actions')]/button[contains(@class,'more_actions_button')]"));
    public Label getNameProject(String nameProject) {
        return new Label(By.xpath("//h1/span[text()='" + nameProject + "']"));
    }

    public Label getNameTask(String taskName) {
        return new Label(By.xpath("//div[text()='" + taskName + "']"));
    }

    public boolean isTaskDisplayedInList(String taskName) {
        Label taskCreated = new Label(By.xpath("//div[text()='" + taskName + "']"));
        return taskCreated.isControlDisplayed();
    }
}
