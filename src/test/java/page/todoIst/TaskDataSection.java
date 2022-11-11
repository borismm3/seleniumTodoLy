package page.todoIst;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class TaskDataSection {
    public Label nameTaskLabel = new Label(By.xpath("//div[contains(@class,'public-DraftEditorPlaceholder-root')]"));
    public TextBox nameTaskTextBox = new TextBox(By.xpath("//div[contains(@class,'public-DraftStyleDefault-block')]/span"));//
    public TextBox descriptionTextBox = new TextBox(By.xpath("//div/textarea[contains(@style,'important')]"));
    public Button saveTaskButton = new Button(By.xpath("//button[contains(@data-testid,'task-editor-submit-button')]"));
    public Button cancelTaskButton = new Button(By.xpath("//button/span[text()='Cancelar']"));

    public TextBox nameTaskEditTextBox = new TextBox(By.xpath("//div[contains(@class,'public-DraftStyleDefault-block')]/span/span"));
}
