package testSuite.todoIst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CRUDProjectTest extends TestBase{
    @Test
    public void verifyCRUDProject() {
        String projectCreated = "MOJIX" + new Date().getTime();
        String projectUpdated = "QA" + new Date().getTime();
        String taskCreated = "name task " + new Date().getTime();
        String taskUpdated = "update task " + new Date().getTime();
        String descriptionCreated = "description " + new Date().getTime();
        String descriptionUpdated = "update description " + new Date().getTime();

        mainPage.loginButton.click();

        loginSection.login(user, password);
        Assertions.assertTrue(menuSection.isSettingsDisplayed(), "The loggin has failed");
        // Create project
        projectsSection.addProjectButton.click();
        projectDataSection.nameProjectTextBox.setText(projectCreated);
        projectDataSection.saveProjectButton.click();
        Assertions.assertTrue(projectsSection.isProjectDisplayedInList(projectCreated), "ERROR! The project was not created");
        // Edit project
        projectsSection.menuButton.click();
        menuProjectSection.editProjectButton.click();
        projectDataSection.nameProjectTextBox.cleanSetText(projectUpdated);
        projectDataSection.saveProjectButton.click();
        projectsSection.nameOfProject(projectUpdated).click();
        Assertions.assertTrue(projectsSection.isProjectDisplayedInList(projectUpdated), "ERROR! The project was not updated");
        // Create task
        taskSection.addTaskButton.click();
        taskDataSection.nameTaskTextBox.setText(taskCreated);
        taskDataSection.descriptionTextBox.setText(descriptionCreated);
        taskDataSection.saveTaskButton.click();
        taskDataSection.cancelTaskButton.click();
        Assertions.assertTrue(taskSection.isTaskDisplayedInList(taskCreated),"ERROR! The task was not created");
        // Update task
        taskSection.getNameTask(taskCreated).hoverElement();
        taskSection.menuTaskButton.click();
        menuTaskSection.editTaskButton.click();
        taskDataSection.nameTaskTextBox.cleanSetText(taskUpdated);
        taskDataSection.descriptionTextBox.cleanSetText(descriptionUpdated);
        taskDataSection.saveTaskButton.click();
        Assertions.assertTrue(taskSection.isTaskDisplayedInList(taskUpdated), "ERROR! The task was not updated");
        // Delete task
        taskSection.getNameTask(taskUpdated).hoverElement();
        taskSection.menuTaskButton.click();
        menuTaskSection.deleteTaskButton.click();
        deleteSection.confirmDeleteButton.click();
        Assertions.assertFalse(taskSection.isTaskDisplayedInList(taskUpdated), "ERROR! The task was not deleted");
        // Delete project
        projectsSection.menuButton.click();
        menuProjectSection.deleteProjectButton.click();
        deleteSection.confirmDeleteButton.click();
        Assertions.assertFalse(projectsSection.isProjectDisplayedInList(projectUpdated), "ERROR! The project was not deleted");
    }
}
