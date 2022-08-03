package com.codecool.jiratest.test;

import com.codecool.jiratest.page.EditIssuePage;
import com.codecool.jiratest.page.GlassVersionPage;
import com.codecool.jiratest.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GlassVersionPageTest {
    private WebDriver driver;
    private GlassVersionPage glassVerPage;
    private LoginPage loginPage;
    private EditIssuePage editIssuePage;
    private WebDriverWait wait;


    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        glassVerPage = new GlassVersionPage(driver);
        loginPage = new LoginPage(driver);
        editIssuePage = new EditIssuePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void IssueToVersion() throws InterruptedException {
        driver.get("https://jira-auto.codecool.metastage.net/browse/PP-124");
        logIn();
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssuePage.editButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssuePage.fixVersionsField)).sendKeys("fefe");
        editIssuePage.updateButton.click();

        Thread.sleep(1000);
        driver.get("https://jira-auto.codecool.metastage.net/projects/PP/versions/10594");

        List<WebElement> elements = glassVerPage.table.findElements(By.cssSelector(".issue-summary"));

        boolean flag = false;
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
            if (elements.get(i).getText().equals("REST API create issue")){
                flag=true;
            }
        }
                Assertions.assertTrue(flag, "Element is found");

        driver.get("https://jira-auto.codecool.metastage.net/browse/PP-124");
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssuePage.editButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                editIssuePage.fixVersionDelete)).click();
        editIssuePage.updateButton.click();

    }

    @Test
    public void VersionIssueProgress() throws InterruptedException {
        driver.get("https://jira-auto.codecool.metastage.net/projects/PP?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page&status=no-filter&contains=fefe");
        logIn();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.cssSelector("#versions-table > tbody.items.ui-sortable > tr > td.dynamic-table__actions > div > a > span")))).click();
        driver.findElement(By.linkText("Release")).click();
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.id("project-config-version-release-form-submit")))).click();
        Thread.sleep(500);
        driver.get("https://jira-auto.codecool.metastage.net/projects/PP?selectedItem=com.codecanvas.glass:glass");
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.id("aui-uid-2"))
        )).click();
        Assertions.assertEquals("RELEASED",driver.findElement(By.cssSelector("#versions-table > tbody > tr:nth-child(2) > td.versions-table__status > div > span")).getText());

        driver.get("https://jira-auto.codecool.metastage.net/projects/PP?selectedItem=com.atlassian.jira.jira-projects-plugin:release-page&status=no-filter&contains=fefe");
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.cssSelector("#versions-table > tbody.items.ui-sortable > tr > td.dynamic-table__actions > div > a > span")))).click();
        driver.findElement(By.linkText("Unrelease")).click();
    }


    private void logIn(){
        loginPage.usernameField.sendKeys("automation23");
        loginPage.passwordField.sendKeys("CCAutoTest19.");
        loginPage.logInButton.click();
    }
}
