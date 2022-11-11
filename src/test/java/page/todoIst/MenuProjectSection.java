package page.todoIst;

import control.Button;
import org.openqa.selenium.By;

public class MenuProjectSection {
    public Button editProjectButton = new Button(By.xpath("//div[text()='Editar proyecto']"));
    public Button deleteProjectButton = new Button(By.xpath("//div[text()='Eliminar proyecto']"));
}
