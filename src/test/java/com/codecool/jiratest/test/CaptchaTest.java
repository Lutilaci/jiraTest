package com.codecool.jiratest.test;

import com.codecool.jiratest.page.CaptchaPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaptchaTest {

    private static CaptchaPage c;
    public static void logInWithPass(String pass)
    {
        c.driver.findElement(By.id("login-form-username")).sendKeys("automation22");
        c.driver.findElement(By.id("login-form-password")).sendKeys(pass);
        c.driver.findElement(By.id("login-form-submit")).click();
    }


    @BeforeEach
    public void login() throws IOException {
        c = new CaptchaPage();
        c.driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        c.driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        c.driver.quit();
    }

    @AfterAll
    public static void stopService() {
        c.service.stop();
    }


    @Test
    public void CheckCaptcha() {
        for (int i = 0; i<3; i++)
        {
            logInWithPass("CCAaa.");
        }
        assertEquals(c.driver.findElements(By.xpath("//div[@id='captcha']/div/img")).isEmpty(), false);
    }

    @Test
    public void CaptchaLoginWrongCaptcha() throws InterruptedException {

        for (int i = 0; i<3; i++)
        {
            logInWithPass("CCAaa.");
        }

        logInWithPass("CCAutoTest19.");
        assertEquals(c.driver.findElements(By.xpath("//div[@id='captcha']/div/img")).isEmpty(), false);
    }
}