package com.codecool.jiratest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

        @FindBy(id = "login-form-username")
        public WebElement usernameField;

        @FindBy(id = "login-form-password")
        public WebElement passwordField;

        @FindBy(id = "login-form-submit")
        public WebElement logInButton;

        @FindBy(id = "header-details-user-fullname")
        public WebElement profilePicture;

        @FindBy(id = "view_profile")
        public WebElement profileButton;

        @FindBy(id = "up-user-title-name")
        public WebElement profileName;

        @FindBy(css = "p:nth-child(1)")
        public WebElement logInErrorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    }

