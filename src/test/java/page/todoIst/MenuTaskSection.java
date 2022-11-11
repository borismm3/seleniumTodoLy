package page.todoIst;

import control.Button;
import org.openqa.selenium.By;

public class MenuTaskSection {
    public Button editTaskButton = new Button(By.xpath("//li[contains(@data-action-hint,'task-overflow-menu-edit')]"));
    public Button deleteTaskButton = new Button(By.xpath("//div[text()='Eliminar tarea']"));
}
