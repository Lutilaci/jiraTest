package com.codecool.jiratest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlassVersionPage {

    @FindBy(css = ".aui")
    public WebElement table;




    public GlassVersionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
