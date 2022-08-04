package com.codecool.jiratest.test;

import com.codecool.jiratest.page.BrowsePage;
import com.codecool.jiratest.page.CreatePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codecool.jiratest.utility.LogIn.logIn;

public class CreatePageTest {

    private WebDriver driver;
    private CreatePage createPage;
    private BrowsePage browsePage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        browsePage = new BrowsePage(driver);
        createPage = new CreatePage(driver);
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        logIn(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // I can't create sub-task for COALA
    @Test
    public void createCOALASubTask() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-126");
        String header = createPage.issueHeader.getText();
        Assertions.assertEquals(header,"Create sub-task");
        driver.findElement(createPage.moreButton).click();
        createPage.createSubClass.click();
        createPage.summaryField.sendKeys("Sub-task test");
        createPage.createIssueButton.click();
        createPage.popupMessage.isDisplayed();
        String result = createPage.popupMessage.getText();
        Assertions.assertEquals(result, "COALA-126 has been updated.");
        String subTaskName = driver.findElement(createPage.subTaskName).getText();
        Assertions.assertEquals(subTaskName, "Sub-task test");

        // Restore
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-126");
        driver.findElement(createPage.actionButton).click();
        driver.findElement(createPage.deleteSubTaskButton).click();
        driver.findElement(createPage.finalSubTaskDeleteButton).click();
    }

    @Test
    public void createTOUCANSubTask() {
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-132");
        String header = createPage.issueHeader.getText();
        Assertions.assertEquals(header,"Create sub-task");
        driver.findElement(createPage.moreButton).click();
        createPage.createSubClass.click();
        createPage.summaryField.sendKeys("Sub-task test");
        createPage.createIssueButton.click();
        createPage.popupMessage.isDisplayed();
        String result = createPage.popupMessage.getText();
        Assertions.assertEquals(result, "TOUCAN-121 has been updated.");
        String subTaskName = driver.findElement(createPage.subTaskName).getText();
        Assertions.assertEquals(subTaskName, "Sub-task test");

        // Restore
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-121");
        driver.findElement(createPage.actionButton).click();
        driver.findElement(createPage.deleteSubTaskButton).click();
        driver.findElement(createPage.finalSubTaskDeleteButton).click();
    }

    @Test
    public void createJETISubTask() throws InterruptedException {
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-62");
        String header = createPage.issueHeader.getText();
        Assertions.assertEquals(header,"JETI Happy Path");
        driver.findElement(createPage.moreButton).click();
        createPage.createSubClass.click();
        createPage.summaryField.sendKeys("Sub-task test");
        createPage.createIssueButton.click();
        createPage.popupMessage.isDisplayed();
        String result = createPage.popupMessage.getText();
        Assertions.assertEquals(result, "JETI-62 has been updated.");
        String subTaskName = driver.findElement(createPage.subTaskName).getText();
        Assertions.assertEquals(subTaskName, "Sub-task test");

        // Restore
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-62");
        driver.findElement(createPage.actionButton).click();
        driver.findElement(createPage.deleteSubTaskButton).click();
        driver.findElement(createPage.finalSubTaskDeleteButton).click();
    }

    @Test
    public void createNewIssue() {
        createPage.mainCreateButton.click();
        clearProjectField();
        createPage.projectField.sendKeys("MTP");
        createPage.projectField.sendKeys(Keys.RETURN);
        clearIssueType();
        createPage.issueTypeSelector.sendKeys("Bug");

        createPage.issueTypeSelector.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.elementToBeClickable(
                createPage.summaryField)).sendKeys("Happy Path");
        wait.until(ExpectedConditions.elementToBeClickable(
                        createPage.createIssueButton
        )).click();
        createPage.popupMessage.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(
                        driver.findElement(By.partialLinkText("Happy Path")))).click();
        String issueName = createPage.issueHeader.getText();
        Assertions.assertEquals("Happy Path", issueName);

        // Restore
        driver.findElement(createPage.moreOptionButton).click();
        driver.findElement(createPage.deleteButton).click();
        driver.findElement(createPage.finalDeleteButton).click();
    }

    @Test
    public void createIssueWithEmptySummary(){
        createPage.mainCreateButton.click();
        createPage.createIssueButton.click();
        String errorMessage = driver.findElement(createPage.createIssueErrorMessage).getText();
        Assertions.assertEquals(errorMessage, "You must specify a summary of the issue.");
        driver.findElement(createPage.cancelButton).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void CreateIssueInCOALAProjectWithIssueTypes() {
        List<String> supposedToBe = new ArrayList<>();
        supposedToBe.add("Bug");
        supposedToBe.add("Story");
        supposedToBe.add("Task");
        List<String> issueTypes = new ArrayList<>();
        createPage.mainCreateButton.click();
        clearProjectField();
        createPage.projectField.sendKeys("COALA");
        createPage.projectField.sendKeys(Keys.RETURN);

        wait.until(ExpectedConditions.elementToBeClickable(
                        createPage.issueTypeSelector)).click();
        issueTypes.add(createPage.issueTypeSelector.getAttribute("value"));

        WebElement ul_Element = driver.findElement(createPage.issueScrollDown);
        List<WebElement> li_All = ul_Element.findElements(By.tagName("li"));

        for (WebElement webElement : li_All) {
            issueTypes.add(webElement.getText());
        }

        driver.findElement(createPage.cancelButton).click();
        Collections.sort(issueTypes);
        Assertions.assertEquals(supposedToBe, issueTypes);
    }

    @Test
    public void CreateIssueInJETIProjectWithIssueTypes() {
        List<String> supposedToBe = new ArrayList<>();
        supposedToBe.add("Bug");
        supposedToBe.add("Story");
        supposedToBe.add("Task");
        List<String> issueTypes = new ArrayList<>();
        createPage.mainCreateButton.click();
        clearProjectField();
        createPage.projectField.sendKeys("JETI");
        createPage.projectField.sendKeys(Keys.RETURN);

        wait.until(ExpectedConditions.elementToBeClickable(
                        createPage.issueTypeSelector)).click();
        issueTypes.add(createPage.issueTypeSelector.getAttribute("value"));

        WebElement ul_Element = driver.findElement(createPage.issueScrollDown);
        List<WebElement> li_All = ul_Element.findElements(By.tagName("li"));

        for (WebElement webElement : li_All) {
            issueTypes.add(webElement.getText());
        }

        driver.findElement(createPage.cancelButton).click();
        Collections.sort(issueTypes);
        Assertions.assertEquals(issueTypes, supposedToBe);
    }

    // I don't have permission to create TOUCAN project
    @Test
    public void CreateIssueInTOUCANProjectWithIssueTypes() {
        List<String> supposedToBe = new ArrayList<>();
        supposedToBe.add("Bug");
        supposedToBe.add("Story");
        supposedToBe.add("Task");
        List<String> issueTypes = new ArrayList<>();

        createPage.mainCreateButton.click();
        clearProjectField();
        createPage.projectField.sendKeys("TOUCAN");
        createPage.projectField.sendKeys(Keys.RETURN);

        wait.until(ExpectedConditions.elementToBeClickable(
                createPage.issueTypeSelector)).click();

        issueTypes.add(createPage.issueTypeSelector.getAttribute("value"));

        WebElement ul_Element = driver.findElement(createPage.issueScrollDown);
        List<WebElement> issueTyps = ul_Element.findElements(By.tagName("li"));

        for (WebElement webElement : issueTyps) {
            issueTypes.add(webElement.getText());
        }

        driver.findElement(createPage.cancelButton).click();
        Collections.sort(issueTypes);
        Assertions.assertEquals(issueTypes,supposedToBe);
    }

    @Test
    public void CancelIssueAfterFill() {
        createPage.mainCreateButton.click();
        clearProjectField();
        createPage.projectField.sendKeys("MTP");
        createPage.projectField.sendKeys(Keys.RETURN);

        clearIssueType();
        createPage.issueTypeSelector.sendKeys("Bug");
        wait.until(ExpectedConditions.elementToBeClickable(
            createPage.issueTypeSelector)).sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.elementToBeClickable(
            createPage.summaryField)).sendKeys("Issue Cancel Test");
        driver.findElement(createPage.cancelButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.elementToBeClickable(
            createPage.issuesButton)).click();
        driver.findElement(createPage.searchForIssuesButton).click();
        driver.findElement(createPage.searchForIssueField).sendKeys("Issue Cancel Test");
        driver.findElement(createPage.searchButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(createPage.resultPageContent)));
        String result = driver.findElement(createPage.resultPageContent).getText();
        Assertions.assertEquals(result, "No issues were found to match your search");
    }

    public void logout(){
        browsePage.profileAvatarButton.click();
        browsePage.logoutButton.click();
    }

    public void clearProjectField(){
        String os = System.getProperty("os.name");
        if (os.equals("Mac OS X")){
            createPage.projectField.sendKeys(Keys.COMMAND + "a");
        }else{
            createPage.projectField.sendKeys(Keys.CONTROL + "a");
        }
        createPage.projectField.sendKeys(Keys.DELETE);
    }

    public void clearIssueType(){
        String os = System.getProperty("os.name");
        wait.until(ExpectedConditions.elementToBeClickable(createPage.issueTypeSelector));
        if (os.equals("Mac OS X")){
            createPage.issueTypeSelector.sendKeys(Keys.COMMAND + "a");
        }else{
            createPage.issueTypeSelector.sendKeys(Keys.CONTROL + "a");
        }
        createPage.issueTypeSelector.sendKeys(Keys.DELETE);
    }

}
