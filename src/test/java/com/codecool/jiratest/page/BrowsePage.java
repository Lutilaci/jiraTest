package com.codecool.jiratest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowsePage {

    @FindBy (css = "#login-form-username")
    public WebElement username;

    @FindBy (css = "#login-form-password")
    public WebElement password;

    @FindBy (css = "#login-form-submit")
    public WebElement loginButton;

    @FindBy (css = ".aui-avatar-small img")
    public WebElement profileAvatarButton;

    @FindBy (css = "#log_out")
    public WebElement logoutButton;

    public By mainPageHeader = By.cssSelector(".aui-page-header-main");
    public By projectMetaValueMTP = By.cssSelector(".project-meta-value:nth-child(4)");
    public By projectMetaValueCOALA = By.cssSelector(".project-meta-value:nth-child(4)");
    public By projectMetaValueJETI = By.cssSelector(".project-meta-value:nth-child(4)");
    public By projectMetaValueTOUCAN = By.cssSelector(".project-meta-value:nth-child(4)");
    public By pageError = By.cssSelector(".projects-error-page-heading");
    public By subnavigatorTitle = By.cssSelector(".subnavigator-title");
    public By browseIssueHeader = By.cssSelector("#summary-val");
    public By issueLink = By.cssSelector(".issue-link");


    public BrowsePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
