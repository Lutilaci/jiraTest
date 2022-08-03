package com.codecool.jiratest.test;

import com.codecool.jiratest.page.BrowsePage;
import com.codecool.jiratest.page.ComponentPage;
import com.codecool.jiratest.page.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codecool.jiratest.utility.LogIn.logIn;

public class ComponentPageTest {
    private WebDriver driver;
    private ComponentPage componentPage;
    private BrowsePage browsePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        componentPage = new ComponentPage(driver);
        browsePage = new BrowsePage(driver);
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        logIn(driver);
    }

    @AfterEach
    public void tearDown() {
        logout();
        driver.quit();
    }

    @Test
    public void createComponents() {
        driver.get("https://jira-auto.codecool.metastage.net/projects/PP/issues/PP-400?filter=allissues");
        String header = componentPage.summaryVal.getText();
        Assertions.assertEquals(header, "TestFestTestComponent");
        componentPage.editButton.click();
        componentPage.componentTextArea.sendKeys("TestFest");
        componentPage.componentTextArea.sendKeys(Keys.RETURN);
        componentPage.editIssueSubmitButton.click();
        componentPage.popupMessage.isDisplayed();
        String popupMessage = componentPage.popupMessage.getText();
        Assertions.assertEquals(popupMessage, "PP-400 has been updated.");
        driver.get("https://jira-auto.codecool.metastage.net/browse/PP-400");
        String componentText = componentPage.componentText.getText();
        Assertions.assertEquals(componentText, "TestFest");
        driver.get("https://jira-auto.codecool.metastage.net/projects/PP?selectedItem=com.codecanvas.glass:glass");
        componentPage.componentButton.click();

        WebElement tableBody = componentPage.componentTableBody;
        List<WebElement> tableRows = tableBody.findElements(By.cssSelector("tr"));

        for (WebElement componentName : tableRows) {
            WebElement tableFirstColumn = componentName.findElement(By.cssSelector("td:nth-child(1)"));
            if (tableFirstColumn.getText() == "TestFest") {
                Assertions.assertEquals(tableFirstColumn.getText(), "TestFest");
            }
        }

        //Restore
        driver.get("https://jira-auto.codecool.metastage.net/projects/PP/issues/PP-400?filter=allissues");
        String checkHeader = componentPage.summaryVal.getText();
        Assertions.assertEquals(checkHeader, "TestFestTestComponent");
        componentPage.editButton.click();
        componentPage.componentTextArea.click();
        componentPage.componentTextArea.sendKeys(Keys.BACK_SPACE);
        componentPage.componentTextArea.sendKeys(Keys.BACK_SPACE);
        componentPage.editIssueSubmitButton.click();
        componentPage.popupMessage.isDisplayed();
        String popupMessage2 = componentPage.popupMessage.getText();
        Assertions.assertEquals(popupMessage2, "PP-400 has been updated.");
    }

    public void logout() {
        browsePage.profileAvatarButton.click();
        browsePage.logoutButton.click();
    }
}
