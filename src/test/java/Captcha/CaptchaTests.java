package Captcha;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CaptchaTests {
    private WebDriver driver = new ChromeDriver();
    public static ChromeDriverService service;

    @BeforeAll
    public static void CreateAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @BeforeEach
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");

    }


    @Test
    void CaptchaDisplay() throws InterruptedException, IOException {
        //Login:
        for (int i=0; i<3; i++) {
            driver.findElement(By.id("login-form-username")).sendKeys("automation22");
            driver.findElement(By.id("login-form-password")).sendKeys("aa");
            driver.findElement(By.id("login-form-submit")).click();
        }
        var t = driver.findElements(By.xpath("div[@id='captcha']/div/img"));
        assertFalse(driver.findElements(By.xpath("div[@id='captcha']/div/img")).isEmpty());
        driver.findElement(By.id("login-form-username")).sendKeys("automation22");
    }
}
