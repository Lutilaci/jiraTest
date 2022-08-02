package com.codecool.jiratest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentPage {

    @FindBy (xpath = "//h1[@id='summary-val']")
    public WebElement summaryVal;

    @FindBy (xpath = "//span[contains(.,'Edit')]")
    public WebElement editButton;

    @FindBy (css = "#components-textarea")
    public WebElement componentTextArea;

    @FindBy (css = "#edit-issue-submit")
    public WebElement editIssueSubmitButton;

    @FindBy (css = ".aui-message")
    public WebElement popupMessage;

    public ComponentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
