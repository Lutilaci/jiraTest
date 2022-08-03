package LogOut;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogOutTest {
    private static ChromeDriverService service;
    private WebDriver driver;
    LogOut p;

    @BeforeAll
        public static void CreateAndStartService() throws IOException {
            service = new ChromeDriverService.Builder()
                    .usingAnyFreePort()
                    .build();
            service.start();

        }

        @BeforeEach
        public void createDriver() throws IOException {
            p = new LogOut();
        }

    @AfterEach
    public void quitDriver() {
        p.driver.close();
        p.driver.quit();

    }
    @AfterAll
    public static void stopService() {
        service.stop();
    }

    @Test
    void SuccessfulLogOut() throws InterruptedException, IOException {
        //Login:
        p.userName.sendKeys("automation22");
        p.password.sendKeys("CCAutoTest19.");
        p.logInButton.click();
        p.driver.findElement(By.xpath("//img[@alt='User profile for Auto Tester 22']")).click();
        p.driver.findElement(By.id("log_out")).click();

//        assertThat(p.driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).isDisplayed()).isTrue();

        p.driver.get("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");
//        assertThat(p.driver.findElement(By.xpath("//p[contains(.,'You must log in to access this page.')]")).isDisplayed()).isTrue();

        assertTrue(p.driver.findElements(By.xpath("//span[contains(.,'Auto Tester 22')]")).isEmpty());

    }
    }



