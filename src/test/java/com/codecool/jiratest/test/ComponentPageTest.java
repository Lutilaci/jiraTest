package com.codecool.jiratest.test;

import com.codecool.jiratest.page.BrowsePage;
import com.codecool.jiratest.page.ComponentPage;
import com.codecool.jiratest.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComponentPageTest {

    private WebDriver driver;
    private ComponentPage componentPage;
    private BrowsePage browsePage;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jira-auto.codecool.metastage.net/projects/PP/issues/PP-400?filter=allissues");

        componentPage = new ComponentPage(driver);
        browsePage = new BrowsePage(driver);

        login();
    }

    @AfterEach
    public void tearDown() {
        logout();
        driver.quit();
    }

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
}
