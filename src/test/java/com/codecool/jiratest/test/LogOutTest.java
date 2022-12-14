package com.codecool.jiratest.test;

import com.codecool.jiratest.page.LogOut;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


import java.io.IOException;

import static com.codecool.jiratest.utility.LogIn.keyCode;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogOutTest {
    private static ChromeDriverService service;
    private WebDriver driver;
    private LogOut p;

    @BeforeAll
        public static void CreateAndStartService() throws IOException {
            service = new ChromeDriverService.Builder()
                    .usingAnyFreePort()
                    .build();
            service.start();
        }

    @BeforeEach
    public void createDriver() throws IOException {
    driver = new ChromeDriver();
    p = new LogOut();
    }

    @AfterEach
    public void quitDriver() {
        p.driver.quit();
        driver.quit();

    }
//    @AfterAll
//    public static void stopService() {
//        service.stop();
//    }
//
    @Test
    void SuccessfulLogOut(){
        //Login:
        p.userName.sendKeys("automation"+keyCode);
        p.password.sendKeys("CCAutoTest19.");
        p.logInButton.click();
        p.driver.findElement(By.id("header-details-user-fullname")).click();
        p.driver.findElement(By.id("log_out")).click();
        p.driver.get("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");

        Assertions.assertEquals("Log In", p.driver.findElement(By.linkText("Log In")).getText());
    }
}