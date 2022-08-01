package com.codecool.jiratest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowsePage {

    public BrowsePage(WebDriver driver) {

    }

    public By username = By.cssSelector("#login-form-username");
    public By password = By.cssSelector("#login-form-password");
    public By loginButton = By.cssSelector("#login-form-submit");
    public By profileAvatarButton = By.cssSelector(".aui-avatar-small img");
    public By logoutButton = By.cssSelector("#log_out");
    public By mainPAgeHeader = By.cssSelector(".aui-page-header-main");
    public By projectMetaValueMTP = By.cssSelector(".project-meta-value:nth-child(4)");
    public By projectMetaValueCOALA = By.cssSelector(".project-meta-value:nth-child(4)");
    public By projectMetaValueJETI = By.cssSelector(".project-meta-value:nth-child(4)");
    public By projectMetaValueTOUCAN = By.cssSelector(".project-meta-value:nth-child(4)");
    public By pageError = By.cssSelector(".projects-error-page-heading");
}
