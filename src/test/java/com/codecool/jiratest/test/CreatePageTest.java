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

    @Test
    public void createNEwIssue() throws InterruptedException {
        JSONObject obj = new JSONObject();
        createPage.mainCreateButton.click();
        createPage.projectField.click();
//        createPage.projectField.sendKeys("LLLL");
        Select select = new Select(createPage.selectMTPProject);
        createPage.selectMTPProject.sendKeys(Keys.RETURN);


//        createPage.selectMTPProject.click();
//        createPage.issueTypeSelector.click();
//        createPage.storyIssueTypeSelector.click();
//        createPage.issueTypeSelector.("Bug");
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
    }

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
}
