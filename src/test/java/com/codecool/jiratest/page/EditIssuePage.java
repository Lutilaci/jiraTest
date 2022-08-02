package com.codecool.jiratest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditIssuePage {

    @FindBy(id = "edit-issue")
    public WebElement editButton;

    @FindBy(id = "summary")
    public WebElement summaryField;

    @FindBy(id = "summary-val")
    public WebElement summaryValue;

    @FindBy(id = "description")
    public WebElement descriptionField;

    @FindBy(id = "description-val")
    public WebElement descriptionValue;

    @FindBy(id = "edit-issue-submit")
    public WebElement editChangesButton;

    @FindBy(css = ".aui-nav-selected:nth-child(2) > .aui-button")
    public WebElement switchTextMode;

    @FindBy(css = ".aui-button-link:nth-child(3)")
    public WebElement cancelChangesButton;

    public EditIssuePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}