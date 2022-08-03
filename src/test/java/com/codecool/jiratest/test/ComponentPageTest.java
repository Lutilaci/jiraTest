package com.codecool.jiratest.test;

import com.codecool.jiratest.page.BrowsePage;
import com.codecool.jiratest.page.ComponentPage;
import com.codecool.jiratest.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class ComponentPageTest {

    private WebDriver driver;
    private ComponentPage componentPage;
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

        componentPage = new ComponentPage(driver);
        browsePage = new BrowsePage(driver);

        login();
    }

    @AfterEach
    public void tearDown() {
        logout();
        driver.quit();
    }


    @Test
    public void createComponents(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/PP/issues/PP-400?filter=allissues");
        String header = componentPage.summaryVal.getText();
        Assertions.assertEquals(header, "TestFestTestComponent");
        componentPage.editButton.click();
        componentPage.componentTextArea.sendKeys("TestFest");
        componentPage.componentTextArea.sendKeys(Keys.RETURN);
        componentPage.editIssueSubmitButton.click();
        componentPage.popupMessage.isDisplayed();
    }
}
