package com.codecool.jiratest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class CaptchaPage {

public WebDriver driver;
public static ChromeDriverService service;

    @FindBy(css = "#login-form-username")
    public WebElement username;

    @FindBy (css = "#login-form-password")
    public WebElement password;


    public CaptchaPage() throws IOException {
        service= new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        service.start();
        driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
        //Mazimize current window
        driver.manage().window().maximize();

    }
}
