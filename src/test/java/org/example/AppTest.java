package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest 

{
    WebDriver driver;
    @BeforeMethod(enabled = true)
    public void setup() throws MalformedURLException {
        driver=new Driverfactory().getDriver();

    }
    @Test
    public void m1(){
        driver.navigate().to("https://medium.com/");
        System.out.println(driver.getPageSource());
    }
    @AfterMethod(enabled = true)
    public void destroy(){
        driver.quit();
    }
}
