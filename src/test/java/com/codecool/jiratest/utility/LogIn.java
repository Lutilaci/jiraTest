package com.codecool.jiratest.utility;

import com.codecool.jiratest.page.LoginPage;

public class LogIn {
    LoginPage loginPage;

    private void logIn(){
        loginPage.usernameField.sendKeys("automation23");
        loginPage.passwordField.sendKeys("CCAutoTest19.");
        loginPage.logInButton.click();
    }
}
