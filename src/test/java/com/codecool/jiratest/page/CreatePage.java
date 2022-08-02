package com.codecool.jiratest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePage {

    @FindBy (css = "#create_link")
    public WebElement mainCreateButton;

    @FindBy (xpath = "//div[@id='project-single-select']/span")
    public WebElement projectSelector;

    @FindBy (xpath = "//a[contains(text(),'Main Testing Project (MTP)')]")
    public WebElement selectMTPProject;

    @FindBy (id = "project-field")
    public WebElement projectField;

    @FindBy (xpath = "//input[@id='issuetype-field']")
    public WebElement issueTypeSelector;

    @FindBy (xpath = "//div[@id='project-options']")
    public WebElement projectOptions;

    @FindBy (xpath = "//a[contains(text(),'Story')]")
    public WebElement storyIssueTypeSelector;

    @FindBy (css = "#summary")
    public WebElement summaryField;

    @FindBy (css = "#create-issue-submit")
    public WebElement createIssueButton;

    @FindBy (css = ".aui-message")
    public WebElement popupMessage;

    @FindBy (xpath = "//a[contains(text(),'Issues')]")
    public WebElement issuesButton;

    public By searchForIssuesButton = By.cssSelector("#issues_new_search_link_lnk");
    public By searchForIssueField = By.cssSelector("#searcher-query");
    public By searchButton = By.xpath("(//button[@type='button'])[3]");
    public By issueHeader = By.xpath("//h1[@id='summary-val']");
    public By moreOptionButton = By.cssSelector("#opsbar-operations_more");
    public By deleteButton = By.cssSelector("#delete-issue .trigger-label");
    public By finalDeleteButton = By.cssSelector("#delete-issue-submit");
    public By createIssueErrorMessage = By.cssSelector(".error");
    public By cancelButton = By.xpath("//button[contains(.,'Cancel')]");

    public CreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
