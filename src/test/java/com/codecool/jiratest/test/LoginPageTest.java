package com.codecool.jiratest.test;

import com.codecool.jiratest.page.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codecool.jiratest.utility.LogIn.keyCode;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String username = "automation";
    private String kc = keyCode;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void LoginSuccessful(){

        loginPage.usernameField.sendKeys(username+kc);
        loginPage.passwordField.sendKeys("CCAutoTest19.");
        loginPage.logInButton.click();
        loginPage.profilePicture.click();
        loginPage.profileButton.click();
        Assertions.assertEquals("Auto Tester "+kc, loginPage.profileName.getText());
    }

    @Test
    public void LoginUnregistered(){

        loginPage.usernameField.sendKeys("edontcar1234381");
        loginPage.passwordField.sendKeys("DontCare");
        loginPage.logInButton.click();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                loginPage.logInErrorMessage.getText());
    }

    @Test
    public void LogInWrongPassword(){

        loginPage.usernameField.sendKeys(username+kc);
        loginPage.passwordField.sendKeys("wrongPW");
        loginPage.logInButton.click();
        ValidateWrongLogin();
        RestoreLogin();
    }

    @Test
    public void EmptyPassword(){

        loginPage.usernameField.sendKeys(username+kc);
        loginPage.logInButton.click();
        ValidateWrongLogin();
        RestoreLogin();
    }

    @Test
    public void EmptyData(){
        loginPage.logInButton.click();
        ValidateWrongLogin();
    }

    private void ValidateWrongLogin(){
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                loginPage.logInErrorMessage.getText());
        Assertions.assertEquals("Log In", driver.findElement(By.id("user-options")).getText());
    }

    private void RestoreLogin(){
        loginPage.usernameField.sendKeys(username+kc);
        loginPage.passwordField.sendKeys("CCAutoTest19.");
        loginPage.logInButton.click();
    }
}