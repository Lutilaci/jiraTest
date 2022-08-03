package com.codecool.jiratest.test;

import com.codecool.jiratest.page.BrowsePage;
import com.codecool.jiratest.page.CaptchaPage;
import com.codecool.jiratest.page.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IssueTypesDropDownTest {
    private BrowsePage browsePage;
    WebDriver driver;
    private static CaptchaPage c;

    public void login(){
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        browsePage.username.sendKeys("automation24");
        browsePage.password.sendKeys("CCAutoTest19.");
        browsePage.loginButton.click();
    }

    @BeforeEach
    public void setUp() throws IOException {
        c = new CaptchaPage();
        c.driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        c.driver.findElement(By.id("login-form-username")).sendKeys("automation22");
        c.driver.findElement(By.id("login-form-password")).sendKeys("CCAutoTest19.");
        c.driver.findElement(By.id("login-form-submit")).click();
        c.driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        c.driver.quit();
    }

    @AfterAll
    public static void stopService() {
        c.service.stop();
    }

    @Test
    public void AviableIssues() {
        c.driver.get("https://jira-auto.codecool.metastage.net/plugins/servlet/project-config/PP/summary");

        assertFalse(c.driver.findElements(By.xpath("(//a[contains(text(),'Bug')])[2]")).isEmpty());
        assertEquals(c.driver.findElements(By.xpath("(//a[contains(text(),'Epic')])[2]")).isEmpty(), false);
        assertEquals(c.driver.findElements(By.xpath("(//a[contains(text(),'Story')])[2]")).isEmpty(), false);
        assertEquals(c.driver.findElements(By.xpath("(//a[contains(text(),'Sub-task')])[2]")).isEmpty(), false);
        assertEquals(c.driver.findElements(By.xpath("(//a[contains(text(),'Task')])[2]")).isEmpty(), false);
    }

    @Test
    public void AviableIssuesInDropDown() {
        c.driver.get("https://jira-auto.codecool.metastage.net/projects/PP?selectedItem=com.codecanvas.glass:glass");

        c.driver.findElement(By.xpath("//li[@id='glass-workflow-nav']/a/div")).click();
        assertEquals(c.driver.findElements(By.xpath("//a[contains(.,' Bug')]")).isEmpty(), false);
        assertEquals(c.driver.findElements(By.xpath("//a[contains(.,' Epic')]")).isEmpty(), false);
        assertEquals(c.driver.findElements(By.xpath("//a[contains(.,' Story')]")).isEmpty(), false);
        assertEquals(c.driver.findElements(By.xpath("//a[contains(.,' Sub-task')]")).isEmpty(), false);
        assertEquals(c.driver.findElements(By.xpath("//a[contains(.,' Task')]")).isEmpty(), false);
    }
    @Test
    public void CheckPermissionAccess()
    {
        c.driver.get("https://jira-auto.codecool.metastage.net/projects/PP?selectedItem=com.codecanvas.glass:glass");
        c.driver.findElement(By.xpath("//a[contains(.,'Permissions')]")).click();

        assertEquals(c.driver.findElements(By.cssSelector("#glass-permissions-matrix-panel .permtr:nth-child(5) > .td-icon:nth-child(3) > .glass-true-icon")).isEmpty(), false);
        c.driver.findElement(By.xpath("//a[contains(text(),'View by Permissions')]")).click();

        assertEquals(c.driver.findElements(By.xpath("//li[contains(.,'Application Access: Any logged in user')]")).isEmpty(), false);
        c.driver.findElement(By.xpath("//a[contains(.,'View by Actors')]")).click();

        assertEquals(c.driver.findElements(By.xpath("//li[contains(.,'Application Access: Any logged in user')]")).isEmpty(), false);
        assertEquals(c.driver.findElements(By.xpath("//div[@id='glass-permissions-actorview-panel']/div/table/tbody/tr[2]/td[2]")).get(0).getText().contains("Browse Projects"), true);

    }

    @Test
    public void CheckPermissionAccessWithGlassCompare() throws InterruptedException {
        c.driver.get("https://jira-auto.codecool.metastage.net/plugins/servlet/project-config/PP/permissions");

        assertEquals(c.driver.findElements(By.cssSelector(".permissions-group:nth-child(1) tr:nth-child(2) dd")).get(0).getText().contains("Any logged in user"), true);
        c.driver.findElement(By.xpath("//span[contains(.,'Glass Documentation')]")).click();
        c.driver.findElement(By.xpath("//a[contains(text(),'Permissions')]")).click();

        assertEquals(c.driver.findElements(By.cssSelector("#glass-permissions-matrix-panel .permtr:nth-child(5) > .td-icon:nth-child(3) > .glass-true-icon")).isEmpty(), false);
        //assertEquals(c.driver.findElements(By.cssSelector("#glass-permissions-matrix-panel .permtr:nth-child(2) > .td-icon:nth-child(3) > .glass-true-icon")).isEmpty(), false);
    }
}
