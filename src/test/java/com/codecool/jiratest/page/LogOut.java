package com.codecool.jiratest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class LogOut {
    public WebDriver driver;
    public static ChromeDriverService service;
    public WebElement userName;
    public WebElement password;
    public WebElement logInButton;

    public LogOut() throws IOException {

        service= new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        service.start();
        driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());

        driver.manage().window().maximize();
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");

        userName = driver.findElement(By.id("login-form-username"));
        password = driver.findElement(By.id("login-form-password"));
        logInButton = driver.findElement(By.id("login-form-submit"));



    }
}
