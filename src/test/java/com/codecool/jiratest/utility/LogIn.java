package com.codecool.jiratest.utility;

import com.codecool.jiratest.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;


public class LogIn {
    public static void logIn(WebDriver driver){
        final String username = "automation";
        final String keyCode = "23";
        final String password = "CCAutoTest19.";

        driver.findElement(By.id("login-form-username")).sendKeys(username+keyCode);
        driver.findElement(By.id("login-form-password")).sendKeys(password);
        driver.findElement(By.id("login-form-submit")).click();
    }
}
