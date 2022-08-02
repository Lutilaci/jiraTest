package com.codecool.jiratest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentPage {

    @FindBy (xpath = "//h1[@id='summary-val']")
    public WebElement summaryVal;

    public ComponentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
