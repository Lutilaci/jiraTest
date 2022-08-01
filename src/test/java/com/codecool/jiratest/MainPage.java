package com.codecool.jiratest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/
public class MainPage {
    @FindBy(css = "a.wt-button_mode_primary")
    public WebElement seeAllToolsButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
