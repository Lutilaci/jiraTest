package com.codecool.jiratest.test;

import com.codecool.jiratest.page.EditIssuePage;
import com.codecool.jiratest.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.codecool.jiratest.utility.LogIn.logIn;

public class EditIssuePageTest {
    private WebDriver driver;
    private EditIssuePage editIssue;
    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jira-auto.codecool.metastage.net/projects/MTP/issues/MTP-2020?filter=allopenissues");
        editIssue = new EditIssuePage(driver);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        logIn(driver);
    }

    @AfterEach
    public void tearDown(){
//        driver.quit();
    }

    @Test
    public void editExistingIssue() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.summaryField)).clear();
        editIssue.summaryField.sendKeys("Happy Path Edit");
        editIssue.updateButton.click();

        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOf(editIssue.summaryValue));
        Assertions.assertEquals("Happy Path Edit",editIssue.summaryValue.getText());

        editIssue.editButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.summaryField)).clear();
        editIssue.summaryField.sendKeys("Happy Path");
        editIssue.summaryField.submit();
    }

    @Test
    public void addField() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.switchTextMode)).click();
        editIssue.descriptionField.clear();
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.descriptionField)).sendKeys("new description");
        editIssue.updateButton.click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(editIssue.descriptionValue));
        Assertions.assertEquals("new description",editIssue.descriptionValue.getText());
        editIssue.editButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.switchTextMode)).click();
        editIssue.descriptionField.clear();
        editIssue.updateButton.click();
    }

    @Test
    public void cancelEdit(){
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.summaryField)).clear();
        editIssue.summaryField.sendKeys("Happy Cancel");
        editIssue.cancelChangesButton.click();
        driver.switchTo().alert().accept();
        Assertions.assertEquals("Happy Path",editIssue.summaryValue.getText());
    }
}
