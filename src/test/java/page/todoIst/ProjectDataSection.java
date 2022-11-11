package page.todoIst;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class ProjectDataSection {
    public TextBox nameProjectTextBox = new TextBox(By.id("edit_project_modal_field_name"));
    public Button saveProjectButton = new Button(By.xpath("//button[contains(@class,'ist_button ist_button_red')]"));
}
