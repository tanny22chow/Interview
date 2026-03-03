package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest 

{
    WebDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        String URL = "https://" + "ravindrand_dQv6wj" + ":" + "ZkcKwXKuxLRqskearE35" + "@hub.browserstack.com/wd/hub";
        MutableCapabilities capabilities = new MutableCapabilities();
        driver = new RemoteWebDriver(new URL(URL), capabilities);

    }
    @Test
    public void m1(){
        driver.navigate().to("https://medium.com/");
        System.out.println(driver.getPageSource());

    }
    @AfterTest
    public void destroy(){
        driver.quit();
    }
}
