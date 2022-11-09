package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

public class BasicSelenium {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        // implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // page load wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("http://todo.ly/");
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void verifyCRUDProject() throws InterruptedException {

        // login
        driver.findElement(By.xpath("//img[contains(@src,'pagelogin')]")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("boris@gmail.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("123456");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        //Thread.sleep(1000);
        // Explicit Wait
        //WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")));
        FluentWait fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15))
                        .pollingEvery(Duration.ofSeconds(100))
                                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")));

        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
                , "ERROR login was incorrect");

        // create
        String nameProject = "Mojix" + new Date().getTime();
        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        driver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(1000);
        int actualResult = driver.findElements(By.xpath(" //td[text()='" + nameProject + "'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                , "ERROR The project was not created");

        nameProject = "Update" + new Date().getTime();
        // update
        driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
        driver.findElement(By.xpath("//ul[@id=\"projectContextMenu\"]//a[text()='Edit']")).click();
        driver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).clear();
        driver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).sendKeys(nameProject);
        driver.findElement(By.xpath("//td/div/img[@id='ItemEditSubmit']")).click();
        Thread.sleep(1000);
        actualResult = driver.findElements(By.xpath(" //td[text()='" + nameProject + "'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                , "ERROR The project was not updated");

        //create task
        String nameTask = "TaskMojix" + new Date().getTime();
        driver.findElement(By.id("NewItemContentInput")).sendKeys(nameTask);
        driver.findElement(By.id("NewItemAddButton")).click();
        Thread.sleep(2000);
        int currentTask = driver.findElements(By.xpath("//div[contains(@class,'ItemContentDiv') and text()='" + nameTask + "']")).size();
        Assertions.assertTrue(currentTask >= 1, "ERROR The task was not created");

        //update task
        driver.findElement(By.xpath("//div[contains(@class,'ItemContentDiv') and text()='" + nameTask + "']")).click();
        driver.findElement(By.xpath("//textarea[contains(@id,'ItemEditTextbox')]")).clear();
        nameTask = "UpdateTask" + new Date().getTime();
        driver.findElement(By.xpath("//textarea[contains(@id,'ItemEditTextbox')]")).sendKeys(nameTask);
        driver.findElement(By.xpath("//textarea[contains(@id,'ItemEditTextbox')]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElements(By.xpath("//div[contains(@class,'ItemContentDiv') and text()='" + nameTask + "']")).size();
        Assertions.assertTrue(currentTask >= 1, "ERROR The task was not updated");

        //delete task
        driver.findElement(By.xpath("//img[contains(@style,'inline')]")).click();
        driver.findElement(By.xpath("//ul[contains(@id,'itemContextMenu')]//li[contains(@class,'delete')]/a")).click();
        Thread.sleep(2000);
        currentTask = driver.findElements(By.xpath("div[contains(@class,'ItemContentDiv') and text()='" + nameTask + "']")).size();
        Assertions.assertTrue(currentTask == 0, "ERROR The project was not removed");

        // delete
        driver.findElement(By.xpath("//td[text()='" + nameProject + "']")).click();
        driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
        driver.findElement(By.id("ProjShareMenuDel")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        actualResult = driver.findElements(By.xpath(" //td[text()='" + nameProject + "'] ")).size();
        Assertions.assertTrue(actualResult == 0
                , "ERROR The project was not removed");
    }
}
