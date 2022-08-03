package com.codecool.jiratest.test;

import com.codecool.jiratest.page.EditIssuePage;
import com.codecool.jiratest.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codecool.jiratest.utility.LogIn.logIn;

public class EditIssuesProjectTest {
    private WebDriver driver;
    private EditIssuePage editIssue;
    private LoginPage loginPage;
    private WebDriverWait wait;


    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        editIssue = new EditIssuePage(driver);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void toucansEditableTest(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/TOUCAN/issues/TOUCAN-1");
        logIn(driver);
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).isDisplayed();
        driver.get("https://jira-auto.codecool.metastage.net/projects/TOUCAN/issues/TOUCAN-2");
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).isDisplayed();
        driver.get("https://jira-auto.codecool.metastage.net/projects/TOUCAN/issues/TOUCAN-3");
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).isDisplayed();
    }

    @Test
    public void koalasEditableTest(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/COALA/issues/COALA-1");
        logIn(driver);
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).isDisplayed();
        driver.get("https://jira-auto.codecool.metastage.net/projects/COALA/issues/COALA-2");
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).isDisplayed();
        driver.get("https://jira-auto.codecool.metastage.net/projects/COALA/issues/COALA-3");
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).isDisplayed();
    }

    @Test
    public void jetisEditableTest(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/JETI/issues/JETI-1");
        logIn(driver);
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).isDisplayed();
        driver.get("https://jira-auto.codecool.metastage.net/projects/JETI/issues/JETI-2");
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).isDisplayed();
        driver.get("https://jira-auto.codecool.metastage.net/projects/JETI/issues/JETI-3");
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssue.editButton)).isDisplayed();
    }

}
