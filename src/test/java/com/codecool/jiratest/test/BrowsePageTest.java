package com.codecool.jiratest.test;

import com.codecool.jiratest.page.BrowsePage;
import com.codecool.jiratest.page.LoginPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowsePageTest {
    private WebDriver driver;
    private BrowsePage browsePage;

    public void login(){
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        driver.findElement(browsePage.username).sendKeys("automation24");
        driver.findElement(browsePage.password).sendKeys("CCAutoTest19.");
        driver.findElement(browsePage.loginButton).click();
    }

    public void logout(){
        driver.findElement(browsePage.profileAvatarButton).click();
        driver.findElement(browsePage.logoutButton).click();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        browsePage = new BrowsePage(driver);

        login();
    }

    @AfterEach
    public void tearDown() {
        logout();
        driver.quit();
    }


    @Test
    public void browseProjects() {
        driver.get("https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa");
        String pageHeader = driver.findElement(browsePage.mainPAgeHeader).getText();
        Assertions.assertEquals(pageHeader, "Browse projects");
    }

    @Test
    public void openExistingProject(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/MTP/summary");
        String projectKey = driver.findElement(browsePage.projectMetaValueMTP).getText();
        Assertions.assertEquals(projectKey, "MTP");
    }

    @Test
    public void openCOALAProject(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/COALA/summary");
        String projectKey = driver.findElement(browsePage.projectMetaValueCOALA).getText();
        Assertions.assertEquals(projectKey, "COALA");
    }

    @Test
    public void openJETIProject(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/JETI/summary");
        String projectKey = driver.findElement(browsePage.projectMetaValueJETI).getText();
        Assertions.assertEquals(projectKey, "JETI");
    }

    @Test
    public void openTOUCANProject(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/TOUCAN/summary");
        String projectKey = driver.findElement(browsePage.projectMetaValueTOUCAN).getText();
        Assertions.assertEquals(projectKey, "TOUCAN");
    }

    @Test
    public void openNonExistingProject() {
        driver.get("https://jira-auto.codecool.metastage.net/projects/SOMETHING/summary");
        String errorMessage = driver.findElement(browsePage.pageError).getText();
        Assertions.assertEquals(errorMessage, "You can't view this project");
    }
}
