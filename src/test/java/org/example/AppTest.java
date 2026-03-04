package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AppTest 

{
    WebDriver driver;
    ThreadLocal<WebDriver> thlocal;
    @BeforeMethod(enabled = true)
    public void setup() throws MalformedURLException {
        driver=new Driverfactory().getDriver();
        thlocal=new ThreadLocal<>();
        thlocal.set(driver);

    }
    @Test
    public void m1(){
        thlocal.get().navigate().to("https://medium.com/");
        System.out.println(driver.getTitle());
    }
    @AfterMethod(enabled = true)
    public void destroy(){
        thlocal.get().quit();
        thlocal.remove();
    }
}
