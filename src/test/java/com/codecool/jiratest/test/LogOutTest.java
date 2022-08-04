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
        driver.close();
        driver.quit();

    }
    @AfterAll
    public static void stopService() {
        service.stop();
    }

    @Test
    void SuccessfulLogOut(){
        //Login:
        p.userName.sendKeys("automation"+keyCode);
        p.password.sendKeys("CCAutoTest19.");
        p.logInButton.click();
        p.driver.findElement(By.xpath("//img[@alt='User profile for Auto Tester 22']")).click();
        p.driver.findElement(By.id("log_out")).click();
        p.driver.get("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");

        assertTrue(driver.findElements(By.xpath("//span[contains(.,'Auto Tester 22')]")).isEmpty());
    }
}