package Captcha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class Captcha {
WebDriver driver;

    WebElement userName;
    WebElement password;
    WebElement logInButton;
    public Captcha() {
        driver = new ChromeDriver();
        userName = driver.findElement(By.id("login-form-username"));
        password = driver.findElement(By.id("login-form-password"));
        logInButton = driver.findElement(By.id("login-form-submit"));
    }


  //  public static WebElement userName = driver.findElement(By.id("login-form-username"));
    //public static WebElement password = driver.findElement(By.id("login-form-password"));
    //public static WebElement logInButton = driver.findElement(By.id("login-form-submit"));


}
