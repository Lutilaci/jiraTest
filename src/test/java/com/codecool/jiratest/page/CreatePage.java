package com.codecool.jiratest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePage {

    @FindBy (css = "#create_link")
    public WebElement mainCreateButton;

    @FindBy (xpath = "//input[@id='project-field']")
    public WebElement projectField;

    @FindBy (id ="issuetype-field")
    public WebElement issueTypeSelector;

    @FindBy (id= "summary")
    public WebElement summaryField;

    @FindBy (css = "#create-issue-submit")
    public WebElement createIssueButton;

    @FindBy (css = ".aui-message")
    public WebElement popupMessage;

    @FindBy (xpath = "//a[@class='issue-created-key']")
    public WebElement issueCreatedPopup;

    @FindBy (xpath = "//a[contains(text(),'Issues')]")
    public WebElement issuesButton;

    @FindBy (xpath="//h1[@id='summary-val']")
    public WebElement issueHeader;

    @FindBy (xpath = "//aui-item-link[@id='create-subtask']/a/span")
    public WebElement createSubClass;


    public By searchForIssuesButton = By.cssSelector("#issues_new_search_link_lnk");
    public By searchForIssueField = By.cssSelector("#searcher-query");
    public By searchButton = By.xpath("(//button[@type='button'])[3]");
    public By moreOptionButton = By.cssSelector("#opsbar-operations_more");
    public By deleteButton = By.cssSelector("#delete-issue .trigger-label");
    public By finalDeleteButton = By.cssSelector("#delete-issue-submit");
    public By createIssueErrorMessage = By.cssSelector(".error");
    public By cancelButton = By.xpath("//button[contains(.,'Cancel')]");
    public By moreButton = By.xpath("//a[@id='opsbar-operations_more']");
    public By subTaskName = By.cssSelector(".stsummary > .issue-link");
    public By actionButton = By.xpath("//span[contains(.,'Actions')]");
    public By deleteSubTaskButton = By.xpath("//a[contains(text(),'Delete')]");
    public By finalSubTaskDeleteButton = By.xpath("//input[@id='delete-issue-submit']");
    public By issueTypeSelectorButon = By.cssSelector("#issuetype-single-select > .icon");
    public By resultPageContent = By.cssSelector(".no-results > h2");



    public CreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
