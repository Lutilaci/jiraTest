package com.codecool.jiratest.test;

import com.codecool.jiratest.page.BrowsePage;
import com.codecool.jiratest.page.CreatePage;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreatePageTest {

    private WebDriver driver;
    private CreatePage createPage;
    private BrowsePage browsePage;

    public void login(){
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        browsePage.username.sendKeys("automation24");
        browsePage.password.sendKeys("CCAutoTest19.");
        browsePage.loginButton.click();
    }

    public void logout(){
        browsePage.profileAvatarButton.click();
        browsePage.logoutButton.click();
    }

    public void clearProjectField(){
        createPage.projectField.sendKeys(Keys.CONTROL + "a");
        createPage.projectField.sendKeys(Keys.DELETE);
    }

    public void clearIssueType(){
        createPage.issueTypeSelector.sendKeys(Keys.CONTROL + "a");
        createPage.issueTypeSelector.sendKeys(Keys.DELETE);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browsePage = new BrowsePage(driver);
        createPage = new CreatePage(driver);

        login();
    }

    @AfterEach
    public void tearDown() {
//        logout();
        driver.quit();
    }

//    @Test
//    public void createCOALASubTask() throws InterruptedException {
//        driver.get("https://jira-auto.codecool.metastage.net/browse/MTP-2019");
//        String header = createPage.issueHeader.getText();
//        Assertions.assertEquals(header,"happy test");
//        driver.findElement(createPage.moreButton).click();
//        createPage.createSubClass.click();
//        createPage.summaryField.sendKeys("Sub-task test");
//        createPage.createIssueButton.click();
//        createPage.popupMessage.isDisplayed();
//        String result = createPage.popupMessage.getText();
//        Assertions.assertEquals(result, "MTP-2019 has been updated.");
//        String subTaskName = driver.findElement(createPage.subTaskName).getText();
//        Assertions.assertEquals(subTaskName, "Sub-task test");
//
//        // Restore
//        driver.get("https://jira-auto.codecool.metastage.net/browse/MTP-2019");
//        driver.findElement(createPage.actionButton).click();
//        driver.findElement(createPage.deleteSubTaskButton).click();
//        driver.findElement(createPage.finalSubTaskDeleteButton).click();
//    }

//    @Test
//    public void createTOUCANSubTask() throws InterruptedException {
//        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-121");
//        String header = createPage.issueHeader.getText();
//        Assertions.assertEquals(header,"TOUCAN Happy Path");
//        driver.findElement(createPage.moreButton).click();
//        createPage.createSubClass.click();
//        createPage.summaryField.sendKeys("Sub-task test");
//        createPage.createIssueButton.click();
//        createPage.popupMessage.isDisplayed();
//        String result = createPage.popupMessage.getText();
//        Assertions.assertEquals(result, "TOUCAN-121 has been updated.");
//        String subTaskName = driver.findElement(createPage.subTaskName).getText();
//        Assertions.assertEquals(subTaskName, "Sub-task test");
//
//        // Restore
//        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-121");
//        driver.findElement(createPage.actionButton).click();
//        driver.findElement(createPage.deleteSubTaskButton).click();
//        driver.findElement(createPage.finalSubTaskDeleteButton).click();
//    }
//
//    @Test
//    public void createJETISubTask() throws InterruptedException {
//        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-62");
//        String header = createPage.issueHeader.getText();
//        Assertions.assertEquals(header,"JETI Happy Path");
//        driver.findElement(createPage.moreButton).click();
//        createPage.createSubClass.click();
//        createPage.summaryField.sendKeys("Sub-task test");
//        createPage.createIssueButton.click();
//        createPage.popupMessage.isDisplayed();
//        String result = createPage.popupMessage.getText();
//        Assertions.assertEquals(result, "JETI-62 has been updated.");
//        String subTaskName = driver.findElement(createPage.subTaskName).getText();
//        Assertions.assertEquals(subTaskName, "Sub-task test");
//
//        // Restore
//        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-62");
//        driver.findElement(createPage.actionButton).click();
//        driver.findElement(createPage.deleteSubTaskButton).click();
//        driver.findElement(createPage.finalSubTaskDeleteButton).click();
//    }

//    @Test
//    public void createNEwIssue() throws InterruptedException {
//        createPage.mainCreateButton.click();
//        clearProjectField();
//        createPage.projectField.sendKeys("MTP");
//        createPage.projectField.sendKeys(Keys.RETURN);
//        Thread.sleep(300);
//
//        clearIssueType();
//        createPage.issueTypeSelector.sendKeys("Bug");
//        Thread.sleep(300);
//        createPage.issueTypeSelector.sendKeys(Keys.RETURN);
//        Thread.sleep(300);
//        createPage.summaryField.sendKeys("Happy Path");
//        createPage.createIssueButton.click();
//        createPage.popupMessage.isDisplayed();
//        createPage.issuesButton.click();
//        driver.findElement(createPage.searchForIssuesButton).click();
//        driver.findElement(createPage.searchForIssueField).sendKeys("Happy Path");
//        driver.findElement(createPage.searchButton).click();
//        String issueName = driver.findElement(createPage.issueHeader).getText();
//        Assertions.assertEquals(issueName, "Happy Path");
////
//        // Restore
//        driver.findElement(createPage.moreOptionButton).click();
//        driver.findElement(createPage.deleteButton).click();
//        driver.findElement(createPage.finalDeleteButton).click();
//    }

//    @Test
//    public void createIssueWithEmptySummary(){
//        createPage.mainCreateButton.click();
//        createPage.createIssueButton.click();
//        String errorMessage = driver.findElement(createPage.createIssueErrorMessage).getText();
//        Assertions.assertEquals(errorMessage, "You must specify a summary of the issue.");
//        driver.findElement(createPage.cancelButton).click();
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        driver.switchTo().alert().accept();
//    }

//    @Test
//    public void CreateIssueInCOALAProjectWithIssueTypes() throws InterruptedException {
//        createPage.mainCreateButton.click();
//        clearProjectField();
//        createPage.projectField.sendKeys("COALA");
//        createPage.projectField.sendKeys(Keys.RETURN);
//        Thread.sleep(300);
//        driver.findElement(createPage.issueTypeSelectorButon).click();
//        Thread.sleep(1000);
//    }

    @Test
    public void CancelIssueAfterFill() throws InterruptedException {
        createPage.mainCreateButton.click();
        clearProjectField();
        createPage.projectField.sendKeys("MTP");
        createPage.projectField.sendKeys(Keys.RETURN);
        Thread.sleep(300);

        clearIssueType();
        createPage.issueTypeSelector.sendKeys("Bug");
        Thread.sleep(300);
        createPage.issueTypeSelector.sendKeys(Keys.RETURN);
        Thread.sleep(300);
        createPage.summaryField.sendKeys("Issue Cancel Test");
        driver.findElement(createPage.cancelButton).click();
        Thread.sleep(300);
        driver.switchTo().alert().accept();
        Thread.sleep(300);
        createPage.issuesButton.click();
        driver.findElement(createPage.searchForIssuesButton).click();
        driver.findElement(createPage.searchForIssueField).sendKeys("Issue Cancel Test");
        driver.findElement(createPage.searchButton).click();
        Thread.sleep(300);
        String result = driver.findElement(createPage.resultPageContent).getText();
        Assertions.assertEquals(result, "No issues were found to match your search");
    }
}
