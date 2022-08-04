package com.codecool.jiratest.test;

import com.codecool.jiratest.page.BrowsePage;
import org.junit.jupiter.api.*;
import static com.codecool.jiratest.utility.LogIn.logIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BrowsePageTest {
    private WebDriver driver;
    private BrowsePage browsePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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
    public void browseProjects() {
        driver.get("https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa");
        String pageHeader = driver.findElement(browsePage.mainPageHeader).getText();
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

    @Test
    public void browseIssues(){
        driver.get("https://jira-auto.codecool.metastage.net/projects/MTP/issues/MTP-2020?filter=allopenissues");
        String openIssues = driver.findElement(browsePage.subnavigatorTitle).getText();
        Assertions.assertEquals(openIssues, "All issues");
        String header = driver.findElement(browsePage.browseIssueHeader).getText();
        System.out.println(header);
        Assertions.assertEquals(header, "Happy Path");
    }

    @Test
    public void CheckTOUCANIssueWithID1(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-1");
        String issueID = driver.findElement(browsePage.issueLink).getText();
        Assertions.assertEquals(issueID, "TOUCAN-1");
    }

    @Test
    public void CheckTOUCANIssueWithID2(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-2");
        String issueID = driver.findElement(browsePage.issueLink).getText();
        Assertions.assertEquals(issueID, "TOUCAN-2");
    }

    @Test
    public void CheckTOUCANIssueWithID3(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/TOUCAN-3");
        String issueID = driver.findElement(browsePage.issueLink).getText();
        Assertions.assertEquals(issueID, "TOUCAN-3");
    }

    @Test
    public void CheckJETIIssueWithID1(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-1");
        String issueID = driver.findElement(browsePage.issueLink).getText();
        Assertions.assertEquals(issueID, "JETI-1");
    }

    @Test
    public void CheckJETIIssueWithID2(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-2");
        String issueID = driver.findElement(browsePage.issueLink).getText();
        Assertions.assertEquals(issueID, "JETI-2");
    }

    @Test
    public void CheckJETIIssueWithID3(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/JETI-3");
        String issueID = driver.findElement(browsePage.issueLink).getText();
        Assertions.assertEquals(issueID, "JETI-3");
    }

    @Test
    public void CheckCOALAIssueWithID1(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-1");
        String issueID = driver.findElement(browsePage.issueLink).getText();
        Assertions.assertEquals(issueID, "COALA-1");
    }

    @Test
    public void CheckCOALAIssueWithID2(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-2");
        String issueID = driver.findElement(browsePage.issueLink).getText();
        Assertions.assertEquals(issueID, "COALA-2");
    }

    @Test
    public void CheckCOALAIssueWithID3(){
        driver.get("https://jira-auto.codecool.metastage.net/browse/COALA-3");
        String issueID = driver.findElement(browsePage.issueLink).getText();
        Assertions.assertEquals(issueID, "COALA-3");
    }

    public void logout(){
        browsePage.profileAvatarButton.click();
        browsePage.logoutButton.click();
    }
}
